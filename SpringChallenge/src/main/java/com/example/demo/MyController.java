package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	ContactRepository contactrepo;
	
	@RequestMapping(method=RequestMethod.GET, value="/contact")
	public List<Contact> getAllContacts() {
		return 	contactrepo.getAllContacts();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/contact/{id}")
	public Contact getContact(@PathVariable int id) {
		return contactrepo.getContactById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/contact") 
	   public Contact addContact(@RequestBody Contact contact) {
			return contactrepo.addContact(contact);
		}
	@RequestMapping(method=RequestMethod.PUT, value="/contact") 
	   public Contact updateContact(@RequestBody Contact contact) {
			return contactrepo.updateContact(contact);
		}
	@RequestMapping(method=RequestMethod.DELETE, value="/contact/{id}") 
	   public int deleteContact(@PathVariable int id) {
			return contactrepo.deleteContact(id);
		}
}
