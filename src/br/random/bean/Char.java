package br.random.bean;

import java.util.ArrayList;
import java.util.List;

import br.random.dao.DatabaseHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Char {
	protected int charid;
	protected int userid;
	protected String name;
	
	public void setCharid(int charid) { this.charid = charid; }
	public void setUserid(int userid) { this.userid = userid; }
	public void setName(String name) { this.name = name; }
	public int getCharid() { return charid; }
	public int getUserid() { return userid; }
	public String getName() { return name; }
	public static List<Char> getByUserAndSystem(Context context, int id, String system) {
		List<Char> list = new ArrayList<Char>();
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		try {
		    Cursor cursor = db.rawQuery("SELECT idchar, charname FROM tbchar_"+system+" WHERE iduser = ?", new String[] { ""+id });
		    while (cursor.moveToNext()) {
				Char c = new Char();
				c.setCharid(cursor.getInt(0));
				c.setUserid(id);
				c.setName(cursor.getString(1));
				list.add(c);
		    }
		} catch (Exception e) {
			
		}
		db.close();
		return list;
	}
	public static Char getByUserAndCampaign(Context context, int userid, int campaignid) {
		Char ret;
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT idchar, charname FROM tbprofile_campaign WHERE iduser = ? AND idcampaign = ?", new String[] { ""+userid, ""+campaignid });
		if (cursor.moveToNext()) {
			ret = new Char();
			ret.setCharid(cursor.getInt(0));
			ret.setUserid(userid);
			ret.setName(cursor.getString(1));
	    } else {
	    	ret = null;
	    }
		db.close();
		return ret;
	}
}
