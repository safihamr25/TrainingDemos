package demo.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DataBean {

    public List<String> getCategories(){
        List<String> categories = new ArrayList<>();
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind" +
            		"?useSSL=false&serverTimezone=UTC",
            		"root","c0nygre");
            ResultSet rs = null;
            // Execute a SQL query
            Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT CategoryName FROM Categories");
            while (rs.next()) {
                categories.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e);
        } catch (ClassNotFoundException e) {
        	System.out.println("Error loading driver: " + e);
        } finally {
        	if(cn != null) {
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
        return categories;
    }
}