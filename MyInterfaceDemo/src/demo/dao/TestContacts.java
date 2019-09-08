package demo.dao;

import java.util.ArrayList;
import java.util.List;

import demo.dto.Contact;

public class TestContacts implements ContactOperations{

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> allContacts() {
		// TODO Auto-generated method stub
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact(1,"Aishu","91 12343546"));
		contacts.add(new Contact(2,"Safiha","91 187843546"));
		contacts.add(new Contact(3,"Roshan","81 187843877"));
		contacts.add(new Contact(4,"Saranya","81 187847534"));
		contacts.add(new Contact(5,"Virat","71 187847534"));
		contacts.add(new Contact(6,"Dhoni","99 187847534"));
		return contacts;
	}

	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub
		
	}

}
