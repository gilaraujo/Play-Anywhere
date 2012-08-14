package br.random.bean;

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
}
