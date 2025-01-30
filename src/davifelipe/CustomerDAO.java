package davifelipe;

import java.sql.*;

public class CustomerDAO {

    private Connection con;

    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Connection OK!");

    }

    public void insertCustomer(Customer c) throws SQLException {
        String insert = "insert into Customer (store_id, first_name, last_name, email, address_id, active) "
                + "values"
                + "(?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(insert);
        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());

        pst.execute();
        pst.close();
    }

    public void deleteCustomer(int id) throws SQLException {
        String del = "delete from customer "
                + "where customer_id ="+id;
        
        PreparedStatement pst = con.prepareStatement(del);
        pst.execute();
        pst.close();
    }

    public void updateCustomer(Customer c,int id) throws SQLException {
        String update = "update customer "
                + "set store_id =?,  first_name =?, last_name=? , email=?, address_id =?, active=? "
                + "where customer_id = " +id;

        PreparedStatement pst = con.prepareStatement(update);
        
        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());
        
        pst.execute();
        pst.close();
    }

    public void showCustomers() throws SQLException {
        String query = "select * from customer "
                + "order by customer_id desc "
                + "limit 5";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();

        int col = md.getColumnCount();

        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println("");
        }

    }
}
