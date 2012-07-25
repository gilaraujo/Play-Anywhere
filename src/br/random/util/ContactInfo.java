package br.random.util;

public class ContactInfo {
	private Contacts key;
	private String value;
	public ContactInfo(int key, String value) {
		this.key = Contacts.values()[key];; this.value = value;
	}
	public Contacts getKey() { return this.key; }
	public String getValue() { return this.value; }
}
