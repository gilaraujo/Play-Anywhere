package br.random.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.random.bean.Profile;
import br.random.dao.DatabaseHelper;

public class Singleton {
	
	private static Singleton instance;
	private Profile user;
	
	public static Singleton getInstance(Context context) {
		if (instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public void setUser(Profile user) {
		this.user = user;
	}
	
	public Profile getUser() {
		return this.user;
	}
	
}
