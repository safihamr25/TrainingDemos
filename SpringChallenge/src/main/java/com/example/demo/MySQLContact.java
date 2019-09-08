package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;



@Repository
public class MySQLContact implements ContactData{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Contact> getAllContacts() {
		String sql = "SELECT * FROM Contact";
		return template.query(sql, new ContactRowMapper());
	}

	@Override
	public Contact getContactById(int id) {
		String sql = "SELECT * FROM contact WHERE id=?";
        return template.queryForObject(sql, new ContactRowMapper(),id);
	}

	@Override
	public Contact addContact(Contact contact) {
		String sql = "INSERT INTO contact(id,first_name,last_name,phone,countryid) " +
				"VALUES(?,?,?,?,1)";
		template.update(sql,contact.getId(),contact.getFirst_name(),contact.getLast_name(),contact.getPhone());
		return contact;
	}

	@Override
	public Contact updateContact(Contact contact) {
		String sql = "UPDATE contact SET first_name = ?, last_name = ?, phone = ? " +
				"WHERE id = ?";
		template.update(sql,contact.getFirst_name(),contact.getLast_name(),contact.getPhone(),contact.getId());
		return contact;
	}

	@Override
	public int deleteContact(int id) {
		String sql = "DELETE FROM contact WHERE id = ?";
		template.update(sql,id);
		return id;
	}

}

class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Contact(rs.getInt("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("phone"));
	}
}
