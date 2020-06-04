import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

public class DAO {
    private Connection myConn = null;

    public boolean openConnection() {
        try {
            // Database parameters.

            String url = "jdbc:mysql://localhost:3306/swen2005_finalproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";


            // creates a connection to the remote database.
            myConn = DriverManager.getConnection(url, user, password);
            if (myConn != null)
                System.out.println("Connection Successful");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void closeConnection() {
        try {
            if ((myConn != null))
                myConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User userLogin(String username, String password) {
        User theOne = null;
        String query = "select * from users where user_name=? and user_password=?";
        try {
            //create the mysql insert prepared statement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setString(1, username);
            myPreStmt.setString(2, password);
            ResultSet rs = myPreStmt.executeQuery();
            if (rs.next()) {
                theOne = new User(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                return theOne;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void loadProductsTable(JTable table) throws SQLException {
        try {
            String query = "SELECT * from products order by name";
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Product theProd) {
        //the mysql insert statement
        String query = "insert into products (name, quantity, price) values (?,?,?)";

        //create the mysql insert prepared statement
        try {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setString(1, theProd.getName());
            myPreStmt.setInt(2, theProd.getQuantity());
            myPreStmt.setDouble(3, theProd.getPrice());

            //execute the prepared statement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    public void deleteProdRecord(int id) {
        //the mysql insert statement
        String query = "delete from products where prod_id = ?";

        try {
            //create the mysql insert prepared statement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, id);
            //execute the preparedstatement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    public void updateProdRecord(Product theProd) {
        //the mysql insert statement
        String query = "update products set name=?, quantity=?, price=? WHERE prod_id=?";

        //create the mysql update prepared statement
        try {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setString(1, theProd.getName());
            myPreStmt.setInt(2, theProd.getQuantity());
            myPreStmt.setDouble(3, theProd.getPrice());
            myPreStmt.setInt(4, theProd.getProd_id());

            //execute the prepared statement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    public Product findProdRecord(int prod_id) {
        Product theOne = null;
        //the mysql insert statement
        String query = "select * from products where prod_id = ?";
        try {
            //create the mysql insert preparedstatement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, prod_id);
            //execute the preparedstatement
            ResultSet rs = myPreStmt.executeQuery();
            while (rs.next()) {
                theOne = new Product(rs.getInt("prod_id"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price"));
                theOne.setProd_id(rs.getInt("prod_id"));
            }
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
        return theOne;
    }


    /** SALES DETAILS DAO BELOWE HERE **/

    public void deleteSaleRecord(int id) {
        //the mysql insert statement
        String query = "delete from sales_details where invoice = ?";

        try {
            //create the mysql insert prepared statement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, id);
            //execute the preparedstatement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }


    public Sale findsalesRecord(int code) {
        Sale theOne = null;
        String query = "select * from sales_details where invoice  = ?";
        try {

            //create the mysql insert preparedstatement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, code);
            ResultSet rs = myPreStmt.executeQuery();
            while (rs.next()) {
                theOne = new Sale(rs.getInt("invoice"), rs.getInt("P_ID"), rs.getInt("quantity_sold"), rs.getDouble("sub_total"));
            }
        } catch (Exception e) {
            System.out.println("Got an exception! Error in Find Record");
            System.out.println(e.getMessage());
        }
        return theOne;
    }

    public void insertSale(Sale theSale) {
        //the mysql insert statement
        String query = "insert into sales_details (invoice, P_ID, quantity_sold, sub_total) values (?,?,?,?)";
        //create the mysql insert prepared statement
        try
        {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, theSale.getInvoice());
            myPreStmt.setInt(2,theSale.getP_ID());
            myPreStmt.setInt(3, theSale.getQuantity_sold());
            myPreStmt.setInt(4, (int) theSale.getSub_total());

            //execute the prepared statement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    public void updateSaleRecord(Sale theSale)
    {
    //the mysql insert statement
        String query = "update sales_details set P_ID=?, quantity_sold=? where invoice=?";
        //create the mysql insert prepared statement
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,theSale.getInvoice());
            myPreStmt.setInt(2,theSale.getP_ID());
            myPreStmt.setDouble(3,theSale.getQuantity_sold());

            //execute the prepared statement
            myPreStmt.execute();
        } catch(Exception e){
            System.out.println("Got an exception! Error in insert");
            System.out.println(e.getMessage());
        }
    }

    public void loadSalesDetailsTable(JTable table) throws SQLException {
        try {
            String query = "SELECT * from sales_details order by Invoice";
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void queryProductsSearch(JTable table, String keyword)
    {
        String query = "SELECT * from products where name like '%" + keyword + "%' order by name";
        try {
            //create the mysql insert preparedstatement
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
