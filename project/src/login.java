import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 29 12:37:06 BOT 2020
 */



/**
 * @author Zachary AIRD, Nathan BRAITHWAITE, Clem FRANCIS, Samuel LOWE
 */
public class login extends JFrame {
    static JFrame frame = null;
    static User user;
    public login() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // If there is no username, DO NOT run no password check. This is because each no---Check has an AddFocus. Also
        // because we do not wish to bombard the user with popups
        if(noUsernameCheck())
            if(noPasswordCheck())
            attemptLogin();
    }



    private void userFieldFocusGained(FocusEvent e) {
        // To delete the placeholder text when user clicks here
        if (userField.getText().equals("Username"))
        {
            userField.setText("");
        }

    }

    private void passwordField1ActionPerformed(ActionEvent e) {
        if(noUsernameCheck())
            if(noPasswordCheck())
                attemptLogin();
    }

    private void userFieldActionPerformed(ActionEvent e) {
        if(noUsernameCheck())
            if(noPasswordCheck())
                attemptLogin();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        userLabel = new JLabel();
        passLabel = new JLabel();
        userField = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        loginLabel = new JLabel();

        //======== this ========
        setTitle("Alpha Group Systems");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(45, 100, 100, userLabel.getPreferredSize().height);

        //---- passLabel ----
        passLabel.setText("PASSWORD:");
        contentPane.add(passLabel);
        passLabel.setBounds(45, 140, 100, passLabel.getPreferredSize().height);

        //---- userField ----
        userField.setText("Username");
        userField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                userFieldFocusGained(e);
            }
        });
        userField.addActionListener(e -> userFieldActionPerformed(e));
        contentPane.add(userField);
        userField.setBounds(150, 90, 220, userField.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.addActionListener(e -> passwordField1ActionPerformed(e));
        contentPane.add(passwordField1);
        passwordField1.setBounds(150, 135, 220, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("LOGIN");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(220, 180), button1.getPreferredSize()));

        //---- loginLabel ----
        loginLabel.setText("LOGIN");
        contentPane.add(loginLabel);
        loginLabel.setBounds(new Rectangle(new Point(235, 40), loginLabel.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(455, 280));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passwordField1;
    private JButton button1;
    private JLabel loginLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    // METHODS

    private boolean noUsernameCheck()
    // Returns an error warning to user if the username field is blank
    {
        if (userField.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please enter a username!",
                    "Enter a Username", JOptionPane.WARNING_MESSAGE);
            userField.requestFocus();
            return false;
        }
        return true;
    }
    private Boolean noPasswordCheck()
            // Returns an error warning to user if the password field is blank
    {
        if (String.valueOf(passwordField1.getPassword()).isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please enter a password!",
                    "Please enter a password", JOptionPane.WARNING_MESSAGE);
            passwordField1.requestFocus();
            return false;
        }
        return true;
    }
    private void attemptLogin()
    {
        // Tries to login in with username and password entered. If they do not match, no login. If error, send warning
        // message
        DAO dao = new DAO();
        if(dao.openConnection())
        {
            user = dao.userLogin(userField.getText(), String.valueOf(passwordField1.getPassword()));
            if (user != null) {
                frame.setVisible(false);
                new MenuScreen(user);
            }
            else {
                userField.requestFocus();
            }
        }
        else
            // If Username-Password combination is incorrect
        {
            JOptionPane.showMessageDialog(null, "Sorry incorrect username or password",
                    "Incorrect username or password", JOptionPane.WARNING_MESSAGE);
        }
        dao.closeConnection();
    }

    public static void main(String[] args) {
        frame = new JFrame("Login");
        frame.setContentPane(new login().rootPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
