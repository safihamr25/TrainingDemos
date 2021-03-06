package com.example.demo;

import java.util.List;

public interface ContactData {
	
	public List<Contact> getAllContacts();
	public Contact getContactById(int id);
	public Contact addContact(Contact contact);
	public Contact updateContact(Contact contact);
	public int deleteContact(int id);
}
