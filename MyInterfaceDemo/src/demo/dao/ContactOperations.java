package demo.dao;

import demo.dto.Contact;
import java.util.List;

public interface ContactOperations {
	public Contact getContact(int id);
	public List<Contact> allContacts();
	public void addContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
	public void deleteContact(int id);
}
