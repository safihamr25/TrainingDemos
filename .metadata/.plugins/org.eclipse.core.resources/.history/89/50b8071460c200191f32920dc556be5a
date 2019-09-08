package com.example.demo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.business.*;

@Repository
public class MySQLJDBC implements ProductData{
	public List<Product> listProducts(){
		List<Product> products = new ArrayList<>();
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");ClassNotFoundException for Class.forName
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT id, name, price, p.categoryid, categoryname FROM theproducts p "
					+ " JOIN categories c ON p.categoryid = c.categoryid ORDER BY id");
			// Process the results of the query, one row at a time
			while (rs.next()) { 
				products.add(new Product(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getInt("categoryid"),
						rs.getString("categoryname")));
			}
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try{
					if(!cn.isClosed()){
						cn.close();
					}
				}
				catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		return products;
	}

	@Override
	public List<Category> listCategories() {
		// TODO Auto-generated method stub
			List<Category> categories = new ArrayList<>();
			Connection cn = null;
			ResultSet rs = null;
			try{
				Driver d = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(d);
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
				Statement st = cn.createStatement();
				rs = st.executeQuery("SELECT CategoryID, CategoryName FROM Categories");
				// Process the results of the query, one row at a time
				while (rs.next()) { 
					categories.add(new Category(rs.getInt(1),rs.getString(2)));
				}
			}
			catch(SQLException ex){
				System.out.println(ex.getMessage());
			}
			finally{
				if(cn != null){
					try{
						if(!cn.isClosed()){
							cn.close();
						}
					}
					catch(SQLException ex){
						System.out.println(ex.getMessage());
					}
				}
			}
			return categories;
	}

	@Override
	public int addProduct(Product p) {
		int rows = 0;
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre")) {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO theproducts(id,name," +
						"price,categoryid) VALUES(?,?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getCategoryid());
			rows = ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return rows;
	}
}
