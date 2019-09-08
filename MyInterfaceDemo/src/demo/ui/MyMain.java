package demo.ui;

import demo.business.*;
import demo.dao.*;
import demo.dto.*;

import java.util.List;
import java.util.Scanner;

public class MyMain {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyContacts busContacts = new MyContacts(new TestContacts());
////		ContactOperations co = new MYSQLContacts() ;
////		co.allContacts();
//		List<Contact> contacts = busContacts.allContacts();
//		for(Contact contact : contacts) {
//			System.out.println(contact);
//		}

		// TODO Auto-generated method stub
		String option = "";
		Scanner sc = new Scanner(System.in);
		while (!option.toUpperCase().equals("Q")) {
			System.out.println("Enter an option: \n(a) All Contacts\n(b) Add contact\n"
					+ "(c) Update contact\n(d) Delete contact\n(q) Quit");
			option = sc.nextLine();
			switch (option.toUpperCase()) {
			case "A":
				allContacts();
				break;
			case "B":
				addContact();
				break;
			case "C":
				updateContact();
				break;
			case "D":
				deleteContact();
				break;
			}
		}
		System.out.println("Bye :)");

	}

	private static void allContacts() {
		MyContacts busContacts = new MyContacts(new MYSQLContacts());
		List<Contact> contacts = busContacts.allContacts();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	
	private static void addContact() {
		MyContacts Contact = new MyContacts(new MYSQLContacts());
		System.out.println("Enter the contact Name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter the contact Phone: ");
		String phone = sc.nextLine();
		Contact.addContact(new Contact(10,name,phone));
	}
	private static void updateContact() {
		MyContacts Contact = new MyContacts(new MYSQLContacts());
		System.out.println("Enter the contact Id: ");
		Scanner sc = new Scanner(System.in);
		int id =Integer.parseInt(sc.nextLine());
		System.out.println("Enter the contact Phone to be updated: ");
		String phone = sc.nextLine();
		System.out.println("Enter the contact name: ");
		String name = sc.nextLine();
		Contact.updateContact(new Contact(id,name,phone));
	}
	private static void deleteContact() {
		Scanner sc = new Scanner(System.in);
		MyContacts busContact = new MyContacts(new MYSQLContacts());
		System.out.println("Enter the contact id: ");
		int id = Integer.parseInt(sc.nextLine());
		Contact contact = busContact.getContact(id);
		System.out.println("Delete " + contact + " y/n");
		String response = sc.nextLine();
		if(response.toUpperCase().equals("Y")) {
//			busContact.deleteContact(id);
			busContact.deleteContact(contact);
			System.out.println("Contact deleted");
		}
		else {
			System.out.println("Contact not deleted");
		}
	}
}
