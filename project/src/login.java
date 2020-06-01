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

    private void userFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void passwordField1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void loginBtnKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void passwordField1KeyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("ENTER pressed");
            attemptLogin();

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        userLabel = new JLabel();
        passLabel = new JLabel();
        userField = new JTextField();
        passwordField1 = new JPasswordField();
        loginBtn = new JButton();
        loginLabel = new JLabel();

        //======== this ========
        setTitle("Login ");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(40, 155, 55, userLabel.getPreferredSize().height);

        //---- passLabel ----
        passLabel.setText("PASSWORD:");
        contentPane.add(passLabel);
        passLabel.setBounds(10, 195, 100, passLabel.getPreferredSize().height);

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
        userField.setBounds(145, 145, 220, userField.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.addActionListener(e -> passwordField1ActionPerformed(e));
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                passwordField1KeyPressed(e);
            }
        });
        contentPane.add(passwordField1);
        passwordField1.setBounds(145, 190, 220, passwordField1.getPreferredSize().height);

        //---- loginBtn ----
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(e -> button1ActionPerformed(e));
        loginBtn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                loginBtnKeyPressed(e);
            }
        });
        contentPane.add(loginBtn);
        loginBtn.setBounds(new Rectangle(new Point(225, 300), loginBtn.getPreferredSize()));

        //---- loginLabel ----
        loginLabel.setText("LOGIN");
        contentPane.add(loginLabel);
        loginLabel.setBounds(new Rectangle(new Point(235, 40), loginLabel.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(505, 405));
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
    private JButton loginBtn;
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
