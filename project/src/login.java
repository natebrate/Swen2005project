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
    public login() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // If there is no username, DO NOT run no password check. This is because each no---Check has an AddFocus. Also
        // because we do not wish to bombard the user with popups
        if(!noUsernameCheck())
        {
            noPasswordCheck();
        }
    }

    private void userFieldFocusGained(FocusEvent e) {
        // TODO add your code here
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
        setTitle("Login ");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(40, 155, 35, userLabel.getPreferredSize().height);

        //---- passLabel ----
        passLabel.setText("PASSWORD:");
        contentPane.add(passLabel);
        passLabel.setBounds(10, 195, 70, passLabel.getPreferredSize().height);

        //---- userField ----
        userField.setText("Username");
        userField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                userFieldFocusGained(e);
            }
        });
        contentPane.add(userField);
        userField.setBounds(105, 150, 220, userField.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(105, 190, 220, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("LOGIN");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(225, 300), button1.getPreferredSize()));

        //---- loginLabel ----
        loginLabel.setText("LOGIN");
        contentPane.add(loginLabel);
        loginLabel.setBounds(new Rectangle(new Point(235, 40), loginLabel.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
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
    {
        if (userField.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please enter a username!", "Enter a Username", JOptionPane.WARNING_MESSAGE);
            userField.requestFocus();
            return true;
        }
        return false;
    }
    private void noPasswordCheck()
    {
        if (String.valueOf(passwordField1.getPassword()).isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please enter a password!", "Please enter a password", JOptionPane.WARNING_MESSAGE);
            requestFocus();
        }
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
