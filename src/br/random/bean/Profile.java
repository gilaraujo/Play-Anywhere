package br.random.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.random.dao.DatabaseHelper;
import br.random.util.*;

import java.util.*;

public class Profile {
	private int userid;
	private String name;
	private String birthdate;
	private String city;
	private String nickname;
	private String password;
	private int experience;
	private float evaluation;
	private List<ContactInfo> contacts;
	private List<String> systems;
	private List<Campaign> campaigns;
	private String fbid;
	
	public int getUserId() { return userid; }
	public String getName() { return name; }
	public String getBirthdate() { return birthdate; }
	public String getCity() { return city; }
	public String getNickname() { return nickname; }
	public String getPassword() { return password; }
	public int getExperience() { return experience; }
	public float getEvaluation() { return evaluation; }
	public List<ContactInfo> getContacts() { return contacts; }
	public List<String> getSystems() { return systems; }
	public List<Campaign> getCampaigns() { return campaigns; }
	public String getFbid() { return fbid; }
	
	public void setUserId(int userid) { this.userid = userid; }
	public void setName(String name) { this.name = name; }
	public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
	public void setCity(String city) { this.city = city; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setPassword(String password) { this.password = password; }
	public void setExperience(int experience) { this.experience = experience; }
	public void setEvaluation(float evaluation) { this.evaluation = evaluation; }
	public void setContacts(List<ContactInfo> contacts) { this.contacts = contacts; }
	public void setSystems(List<String> systems) { this.systems = systems; }
	public void setCampaigns(List<Campaign> campaigns) { this.campaigns = campaigns; }
	public void setFbid(String fbid) { this.fbid = fbid; }
	
	public Profile() {
		contacts = new ArrayList<ContactInfo>();
		systems = new ArrayList<String>();
		campaigns = new ArrayList<Campaign>();
	}
	
	public int save(Context context) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("name", name);
		cv.put("birthdate", birthdate);
		cv.put("city",city);
		cv.put("nickname", nickname);
		cv.put("password",password);
		cv.put("experience",0);
		cv.put("evaluation",0);
		cv.put("fbid", fbid);
        long ret = db.insert("tbprofile","iduser",cv);
        if (ret != -1) {
        	userid = (int)ret;
        	for (int i=0; i<contacts.size(); i++) {
        		ContentValues contact = new ContentValues();
        		contact.put("iduser", ret);
        		contact.put("type", contacts.get(i).getKey().ordinal());
        		contact.put("contact", contacts.get(i).getValue());
        		db.insert("tbcontact", null, contact);
        	}
        	for (int i=0; i<systems.size(); i++) {
        		ContentValues system = new ContentValues();
        		system.put("iduser", ret);
        		system.put("system", systems.get(i));
        		db.insert("tbsystem", null, system);
        	}
        }
    	db.close();
        return (int)(ret != -1 ? ret : 0);
	}
	public static Profile getByNickAndPass(Context context, String nick, String pass) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT iduser, name, birthdate, city, experience, evaluation, fbid FROM tbprofile WHERE nickname = ? AND password = ?", new String[] { nick, pass });
        Profile ret = new Profile();
		if (cursor.moveToNext()) {
			ret.setUserId(cursor.getInt(0));
			ret.setName(cursor.getString(1));
			ret.setBirthdate(cursor.getString(2));
			ret.setCity(cursor.getString(3));
			ret.setNickname(nick);
			ret.setPassword(pass);
			ret.setExperience(cursor.getInt(4));
			ret.setEvaluation(cursor.getFloat(5));
			ret.setFbid(cursor.getString(6));
			Cursor contacts = db.rawQuery("SELECT type, contact FROM tbcontact where iduser = ?", new String[] { ""+ret.getUserId() });
			while (contacts.moveToNext()) {
				ret.getContacts().add(new ContactInfo(contacts.getInt(0),contacts.getString(1)));
			}
			Cursor systems = db.rawQuery("SELECT system FROM tbsystem WHERE iduser = ?", new String[] { ""+ret.getUserId() });
			while (systems.moveToNext()) {
				ret.getSystems().add(systems.getString(0));
			}
			Cursor campaigns = db.rawQuery("SELECT c.idcampaign _id, c.master, c.name, c.system, p.nickname FROM tbprofile_campaign pc, tbcampaign c, tbprofile p WHERE p.iduser = c.master AND pc.iduser = ? AND pc.idcampaign = c.idcampaign", new String[] { ""+ret.getUserId() });
			while (campaigns.moveToNext()) {
				ret.getCampaigns().add(new Campaign(campaigns.getInt(0),campaigns.getInt(1),campaigns.getString(2),campaigns.getString(3),campaigns.getString(4)));
			}
		} else {
			ret = null;
		}
		db.close();
		return ret;
	}
	public static Profile getByFbid(Context context, String id) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT iduser, name, birthdate, city, nickname, password, experience, evaluation FROM tbprofile WHERE fbid = ?", new String[] { ""+id });
        Profile ret = new Profile();
		if (cursor.moveToNext()) {
			ret.setUserId(cursor.getInt(0));
			ret.setName(cursor.getString(1));
			ret.setBirthdate(cursor.getString(2));
			ret.setCity(cursor.getString(3));
			ret.setNickname(cursor.getString(4));
			ret.setPassword(cursor.getString(5));
			ret.setExperience(cursor.getInt(6));
			ret.setEvaluation(cursor.getFloat(7));
			ret.setFbid(id);
			Cursor contacts = db.rawQuery("SELECT type, contact FROM tbcontact where iduser = ?", new String[] { ""+ret.getUserId() });
			while (contacts.moveToNext()) {
				ret.getContacts().add(new ContactInfo(contacts.getInt(0),contacts.getString(1)));
			}
			Cursor systems = db.rawQuery("SELECT system FROM tbsystem WHERE iduser = ?", new String[] { ""+ret.getUserId() });
			while (systems.moveToNext()) {
				ret.getSystems().add(systems.getString(0));
			}
			Cursor campaigns = db.rawQuery("SELECT c.idcampaign _id, c.master, c.name, c.system, p.nickname FROM tbprofile_campaign pc, tbcampaign c, tbprofile p WHERE p.iduser = c.master AND pc.iduser = ? AND pc.idcampaign = c.idcampaign", new String[] { ""+ret.getUserId() });
			while (campaigns.moveToNext()) {
				ret.getCampaigns().add(new Campaign(campaigns.getInt(0),campaigns.getInt(1),campaigns.getString(2),campaigns.getString(3),campaigns.getString(4)));
			}
		} else {
			ret = null;
		}
		db.close();
		return ret;
	}
}
