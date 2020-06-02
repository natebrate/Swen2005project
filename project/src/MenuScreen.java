import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 29 14:19:37 BOT 2020
 */



/**
 * @author unknown
 */
public class MenuScreen extends JFrame {
    // Instantiate User class in order to carry on credentials into main menu
    User userLogin;
    public MenuScreen(User userLogin) {
        initComponents();
        this.userLogin = userLogin;

        // Personalise the menu screen to match the user's login credentials
        userLabel.setText(userLogin.getUsername() + ": " + userLogin.adminCredentials());
        nameLabel.setText(userLogin.getFirstName());

        // Load this menu
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public MenuScreen() {

    }

    private void saleDetialsBtnActionPerformed(ActionEvent e) throws SQLException {
        new SaleDetails(userLogin);
    }

    private void prodDetailsBtnActionPerformed(ActionEvent e) throws SQLException {
        new ProductsPanel(userLogin);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuLabel = new JLabel();
        salesDetailsBtn = new JButton();
        prodDetailsBtn = new JButton();
        userLabel = new JLabel();
        nameLabel = new JLabel();

        //======== this ========
        setTitle("Menu");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- menuLabel ----
        menuLabel.setText("Menu");
        contentPane.add(menuLabel);
        menuLabel.setBounds(new Rectangle(new Point(10, 10), menuLabel.getPreferredSize()));

        //---- salesDetailsBtn ----
        salesDetailsBtn.setText("Sale Details");
        salesDetailsBtn.addActionListener(e -> {
            try {
                saleDetialsBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(salesDetailsBtn);
        salesDetailsBtn.setBounds(75, 85, 295, salesDetailsBtn.getPreferredSize().height);

        //---- prodDetailsBtn ----
        prodDetailsBtn.setText("Product Details");
        prodDetailsBtn.addActionListener(e -> {
            try {
                prodDetailsBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(prodDetailsBtn);
        prodDetailsBtn.setBounds(75, 125, 295, prodDetailsBtn.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("User");
        contentPane.add(userLabel);
        userLabel.setBounds(325, 10, 118, userLabel.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Full Name");
        contentPane.add(nameLabel);
        nameLabel.setBounds(325, 30, 140, nameLabel.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(480, 265));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel menuLabel;
    private JButton salesDetailsBtn;
    private JButton prodDetailsBtn;
    private JLabel userLabel;
    private JLabel nameLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
