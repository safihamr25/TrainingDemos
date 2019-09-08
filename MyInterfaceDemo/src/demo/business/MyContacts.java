package demo.business;
import demo.dao.*;
import demo.dto.*;
import java.util.List;

public class MyContacts {
	private ContactOperations operations;
	public MyContacts(ContactOperations operations) {
		this.operations = operations;
	}
	public List<Contact> allContacts(){
		return operations.allContacts();
	}
	public void addContact(Contact contact){
		operations.addContact(contact);
	}
	public void updateContact(Contact contact){
		operations.updateContact(contact);
	}
	public Contact getContact(int id) {
		return operations.getContact(id);
	}
	
	public void deleteContact(int id) {
		operations.deleteContact(id);
	}
	
	public void deleteContact(Contact contact) {
		operations.deleteContact(contact);
	}
	
	
}
