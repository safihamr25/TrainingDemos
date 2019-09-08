package demo.dao;

import java.util.ArrayList;
import java.util.List;

import demo.dto.Contact;
import java.sql.*;

public class MYSQLContacts implements ContactOperations {

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		Contact contact = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        Connection cn = null;
        try {
            cn = DriverManager.getConnection
            		("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
        } catch (SQLException e) {
            System.out.println("Error connecting to a database: " + e);
        }
        ResultSet rs = null;
        try {
            // Execute a SQL query
            PreparedStatement st = cn.prepareStatement
            		("SELECT id, name, phone FROM Contact WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            // Process the results of the query, one row at a time
            if (rs.next()) {
            	int cid = rs.getInt("id");
                String name = rs.getString("name"); // Or 1
                String phone = rs.getString("phone"); // Or 2
                contact = new Contact(cid,name,phone);
            }    
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e);
        }finally {
        	try {
				if(!cn.isClosed()) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		return contact;
	}

	@Override
	public List<Contact> allContacts() {
		// TODO Auto-generated method stub
		List<Contact> contacts = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver: " + e);
		}

		// Connect to a database
		Connection cnEmps = null;
		try {
			cnEmps = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false", "root",
					"c0nygre");
		} catch (SQLException e) {
			System.out.println("Error connecting to a database: " + e);
		}

		ResultSet rsEmps = null;
		try {
			// Execute a SQL query
			Statement st = cnEmps.createStatement();
			rsEmps = st.executeQuery("SELECT id, name, phone FROM Contact");

			// Process the results of the query, one row at a time
			while (rsEmps.next() != false) {
				int id = Integer.parseInt(rsEmps.getString("id"));
				String name = rsEmps.getString("name");
				String phone = rsEmps.getString("phone");
//				System.out.println("First name: " + name + " Last Name : " + lname);

				// String name = rsEmps.getString("Name");
				// BigDecimal salary = rsEmps.getBigDecimal("Salary");
				System.out.println("id: "+id+"name: "+name+" phone:" +phone);
				contacts.add(new Contact(id,name,phone));

			}

		} catch (SQLException e) {
			System.out.println("Error executing query: " + e);
		}
		return contacts;
	}

	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		Connection cn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
            PreparedStatement ps = cn.prepareStatement("INSERT INTO contact (Name, Phone) VALUES (?, ?)");

            // Insert some rows
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error loading JDBC driver: " + e);
        } finally {
        	try {
				if(!cn.isClosed()) {
					cn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}

	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		Connection cn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
            PreparedStatement ps = cn.prepareStatement("UPDATE CONTACT SET PHONE = ? WHERE ID = ?");

            // Insert some rows
            ps.setString(1, contact.getPhone());
            ps.setInt(2, contact.getId());
            int rows = ps.executeUpdate();
            System.out.println("&&&&&&&&&rows updated&&&&&&&& "+ rows);
          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error loading JDBC driver: " + e);
        } finally {
        	try {
				if(!cn.isClosed()) {
					cn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}

	@Override
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		Connection cn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
            PreparedStatement ps = cn.prepareStatement("DELETE FROM CONTACT WHERE ID = ?");

            // Insert some rows
            ps.setInt(1, contact.getId());
            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error loading JDBC driver: " + e);
        } finally {
        	try {
				if(!cn.isClosed()) {
					cn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	@Override
	public void deleteContact(int id) {
		Connection cn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection
            		("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
            PreparedStatement ps = cn.prepareStatement
            		("DELETE FROM  Contact WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error details: " + e);
        } finally {
        	try {
				if(!cn.isClosed()) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
	}

}
