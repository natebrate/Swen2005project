import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class DAO {
    private Connection myConn = null;

    public boolean openConnection() {
        try {
            // Database parameters.
            String url = "jdbc:mysql://localhost:3306/swen2005_finalproject";
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
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        }
        catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void loadProductsTable(JTable table) throws SQLException {
        try {
            String query = "Select * from products";
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            //To remove previously added rows
            while(table.getRowCount() > 0)
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    /*Use to find invoice in the sales details*/
//    public saleDetailsCON findsalesRecord(int code)
//    {
//        saleDetailsCON theOne = null;
//        //the mysql insert statement
//        String query = "select * from sales_details where invoice = ?";
//        try {
//            //create the mysql insert preparedstatement
//            PreparedStatement myPreStmt = myConn.prepareStatement(query);
//            myPreStmt.setInt(1, code);
//            ResultSet rs = myPreStmt.executeQuery();
//            while (rs.next()) {
//                theOne = new saleDetailsCON(rs.getInt("invoice"), rs.getInt("P_ID"), rs.getInt("quantity_sold"), rs.getInt("sub_total "));
//            }
//        } catch (Exception e) {
//            System.out.println("Got an exception! Error in Find Record");
//            System.out.println(e.getMessage());
//        }
//        return theOne;
//    }


}