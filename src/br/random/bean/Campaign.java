package br.random.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.random.dao.DatabaseHelper;
import br.random.util.*;
import java.util.*;

public class Campaign {
	private int campaignid;
	private int master;
	private String mastername;
	private String name;
	private String system;
	private List<Scenario> scenarios;
	private List<Quest> quests;
	
	public int getCampaignId() { return campaignid; }
	public int getMaster() { return master; }
	public String getMasterName() { return mastername; }
	public String getName() { return name; }
	public String getSystem() { return system; }
	public List<Scenario> getScenarios() { return scenarios; }
	public List<Quest> getQuests() { return quests; }
	
	public void setCampaignId(int campaignid) { this.campaignid = campaignid; }
	public void setMaster(int master) { this.master = master; }
	public void setMasterName(String mastername) { this.mastername = mastername; }
	public void setName(String name) { this.name = name; }
	public void setSystem(String system) { this.system = system; }
	public void setScenarios(List<Scenario> scenarios) { this.scenarios = scenarios; }
	public void setQuests(List<Quest> quests) { this.quests = quests; }
	
	public Campaign() {
		scenarios = new ArrayList<Scenario>();
	}
	public Campaign(int campaignid, int master, String name, String system) {
		this.campaignid = campaignid;
		this.master = master;
		this.name = name;
		this.system = system;
		scenarios = new ArrayList<Scenario>();
	}
	
	public int save(Context context) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("master", master);
		cv.put("name", name);
		cv.put("system",system);
        long ret = db.insert("tbcampaign","idcampaign",cv);
    	db.close();
        return (int)(ret != -1 ? ret : 0);
	}
	public static Campaign getById(Context context, int id) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT master, name, system FROM tbcampaign WHERE idcampaign = ?", new String[] { ""+id });
        Campaign ret = new Campaign();
		if (cursor.moveToNext()) {
			ret.setMaster(cursor.getInt(0));
			ret.setName(cursor.getString(1));
			ret.setSystem(cursor.getString(2));
			ret.setCampaignId(id);
			Cursor cursor2 = db.rawQuery("SELECT nickname FROM tbprofile WHERE iduser = ?", new String[] { ""+ret.getMaster() });
			if (cursor2.moveToNext()) {
				ret.setMasterName(cursor2.getString(0));
			}
			ret.setScenarios(Scenario.getByCampaignId(context, id));
			ret.setQuests(Quest.getByCampaignId(context, id));
		} else {
			ret = null;
		}
		db.close();
		return ret;
	}
}
