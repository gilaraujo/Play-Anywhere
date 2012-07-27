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
		quests = new ArrayList<Quest>();
	}
	public Campaign(int campaignid, int master, String name, String system, String mastername) {
		this.campaignid = campaignid;
		this.master = master;
		this.name = name;
		this.system = system;
		this.mastername = mastername;
		scenarios = new ArrayList<Scenario>();
		quests = new ArrayList<Quest>();
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
	public static List<Campaign> getByCriteria(Context context, String system, String master, String name) {
		List<Campaign> ret = new ArrayList<Campaign>();
		
		List<String> params = new ArrayList<String>();
		String query = "SELECT c.idcampaign, p.iduser master, p.nickname mastername, c.name, c.system FROM tbcampaign c, tbprofile p WHERE p.iduser = c.master";
		if (!system.equals("Selecione")) params.add("c.system = \""+system+"\"");
		if (!master.equals("")) params.add("p.nickname like \"%"+master+"%\"");
		if (!name.equals("")) params.add("c.name like \"%"+name+"%\"");
		if (params.size() > 0) {
			query += " AND (";
			for (int i=0; i<params.size() - 1; i++) query += params.get(i) + " OR ";
			query += params.get(params.size() - 1) + ")";
		}
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] { });
        while (cursor.moveToNext()) {
        	Campaign c = new Campaign();
        	c.setCampaignId(cursor.getInt(0));
        	c.setMaster(cursor.getInt(1));
        	c.setMasterName(cursor.getString(2));
        	c.setName(cursor.getString(3));
        	c.setSystem(cursor.getString(4));
        	ret.add(c);
        }
        db.close();
		return ret;
	}
}
