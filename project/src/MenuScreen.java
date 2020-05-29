import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 29 14:19:37 BOT 2020
 */



/**
 * @author unknown
 */
public class MenuScreen extends JFrame {
    public MenuScreen() {
        initComponents();
    }

    private void saleDetialsBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void prodDetailsBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuLabel = new JLabel();
        saleDetialsBtn = new JButton();
        prodDetailsBtn = new JButton();
        userLabel = new JLabel();
        fField = new JTextField();
        lField = new JTextField();

        //======== this ========
        setTitle("Menu");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- menuLabel ----
        menuLabel.setText("Menu");
        contentPane.add(menuLabel);
        menuLabel.setBounds(new Rectangle(new Point(10, 10), menuLabel.getPreferredSize()));

        //---- saleDetialsBtn ----
        saleDetialsBtn.setText("Sale Details");
        saleDetialsBtn.addActionListener(e -> saleDetialsBtnActionPerformed(e));
        contentPane.add(saleDetialsBtn);
        saleDetialsBtn.setBounds(75, 145, 295, saleDetialsBtn.getPreferredSize().height);

        //---- prodDetailsBtn ----
        prodDetailsBtn.setText("Product Details");
        prodDetailsBtn.addActionListener(e -> prodDetailsBtnActionPerformed(e));
        contentPane.add(prodDetailsBtn);
        prodDetailsBtn.setBounds(75, 185, 295, prodDetailsBtn.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("User");
        contentPane.add(userLabel);
        userLabel.setBounds(new Rectangle(new Point(420, 10), userLabel.getPreferredSize()));

        //---- fField ----
        fField.setText("Fname");
        contentPane.add(fField);
        fField.setBounds(350, 30, 124, fField.getPreferredSize().height);

        //---- lField ----
        lField.setText("Lname");
        contentPane.add(lField);
        lField.setBounds(350, 65, 125, lField.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(480, 430));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel menuLabel;
    private JButton saleDetialsBtn;
    private JButton prodDetailsBtn;
    private JLabel userLabel;
    private JTextField fField;
    private JTextField lField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
