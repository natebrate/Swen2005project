import javax.swing.*;
import java.sql.*;

public class DAO {
    private Connection myConn = null;

    public boolean openConnection() {
        try {
            // Database parameters.
            String url = "jdbc:mysql://remotemysql.com:3306/bNop6iwTmM";
            String user = "bNop6iwTmM";
            String password = "U6IOEuL7qQ";

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
            }
            else {
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
}