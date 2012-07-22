package br.random;

public class Singleton {
	
	private static Singleton instance;
	private String userId;  
	
	public static Singleton getInstance() {
		if (instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
}
