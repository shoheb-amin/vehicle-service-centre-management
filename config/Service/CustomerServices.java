package ServiceCentre.config.Service;

import ServiceCentre.config.DbConfig;
import ServiceCentre.config.entity.Customer;

import java.sql.*;
import java.util.*;
import java.util.List;

public class CustomerServices {
    public int addCustomer(Customer customer)throws Exception{
        //Gets a database connection using  DbConfig class.
        Connection conn=DbConfig.getConnection();

        //Creates a PreparedStatement
        //? are placeholders to safely insert values (prevents SQL Injection)-->
        //SQL Injection is a security attack where a hacker inserts malicious
        // SQL code into an input field to manipulate or destroy a database.
        //It is a flag (a constant) that tells Java:
        //
        //“Hey database, after INSERT, please give me the auto-generated ID.”
        PreparedStatement psrt=conn.prepareStatement("INSERT INTO customer(USER_NAME,CONTACT)VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
        psrt.setString(1, customer.getUSER_NAME());
        psrt.setString(2,customer.getCONTACT());
        psrt.executeUpdate();
        ResultSet rs = psrt.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        psrt.close();
        conn.close();
        return id;
    }
    //This method fetches all customers from the database and returns them as a List<Customer>.
    public List<Customer> getAllCustomer() throws Exception{
        //Creates an empty list to store customers
        List<Customer>list=new ArrayList<>();
        //CREATE database connection
        Connection conn=DbConfig.getConnection();

        //Creates a Statement object
        //Used when no parameters are required in SQL
        Statement st=conn.createStatement();

        //Executes SELECT query
        //ResultSet stores returned rows from database
        ResultSet rs=st.executeQuery("Select * from customer");

        //Loops through each row in the result set
        while(rs.next()){
            list.add(new Customer(rs.getInt("id"),rs.getString("USER_NAME"),rs.getString("Contact")));
        }
        rs.close();
        st.close();
        conn.close();
        return list;

    }
}
