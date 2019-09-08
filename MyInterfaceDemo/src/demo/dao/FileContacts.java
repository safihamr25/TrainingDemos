package demo.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.dto.Contact;


public class FileContacts implements ContactOperations {

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> allContacts() {
		// TODO Auto-generated method stub
//		List<Contact> contacts = new ArrayList<>();
//		contacts.add(new Contact(1,"Aishu","91 12343546"));
//		contacts.add(new Contact(2,"Safiha","91 187843546"));
//		return contacts;

		final String CUSTOMERS_FILE_NAME = "contacts.txt";
		
		// Create a collection, ready to hold Customer objects created from file.
		List<Contact> contacts = new ArrayList<Contact>();

		BufferedReader in = null;

		try {

			// Create a BufferedReader.
			in = new BufferedReader(new FileReader("c:\\data\\" + CUSTOMERS_FILE_NAME));

			// Read all lines from file (each line holds data for one customer).
			String line;
			while ((line = in.readLine()) != null) {

				// Split the line at tab characters, to get at each piece of data separately.
				String[] columns = line.split(",");

				int id = Integer.parseInt(columns[0]);
				String name = columns[1];
				String phone = columns[2];

				// Create a new Customer object from the data, and insert it into the
				// collection.
				Contact cust = new Contact(id, name, phone);
				contacts.add(cust);
			}
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
				}
			}
		}

		System.out.println("\nCustomers read from text file:");
		for (Contact cust : contacts) {
			System.out.printf("\t%d %s %s\n", cust.getId(), cust.getName(), cust.getPhone());
		}
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
