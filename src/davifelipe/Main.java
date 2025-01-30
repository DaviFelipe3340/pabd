package davifelipe;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        
        Customer c = new Customer(2,"Lucas","Antony","lucantony@gmail.com",10,1);
        CustomerDAO dao = new CustomerDAO();
        
        //dao.insertCustomer(c);
        //dao.updateCustomer(c, 608);
        dao.deleteCustomer(608);
        dao.showCustomers();

        
        
    }

}