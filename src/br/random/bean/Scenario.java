package br.random.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.random.dao.DatabaseHelper;
import br.random.util.*;
import java.util.*;

public class Scenario {
	private int campaignid;
	private String name;
	private String description;
	
	public int getCampaignId() { return campaignid; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	
	public void setCampaignId(int campaignid) { this.campaignid = campaignid; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	
	public Scenario() {

	}
	public Scenario(int campaignid, String name, String description) {
		this.campaignid = campaignid;
		this.name = name;
		this.description = description;
	}
	
	public int save(Context context) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("idcampaign", campaignid);
		cv.put("name", name);
		cv.put("description", description);
        long ret = db.insert("tbscenario",null,cv);
    	db.close();
        return (int)(ret != -1 ? ret : 0);
	}
	public static List<Scenario> getByCampaignId(Context context, int id) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name, description FROM tbscenario WHERE idcampaign = ?", new String[] { ""+id });
        List<Scenario> ret = new ArrayList<Scenario>();
		while (cursor.moveToNext()) {
			ret.add(new Scenario(id,cursor.getString(0),cursor.getString(1)));
		}
		db.close();
		return ret;
	}
}
