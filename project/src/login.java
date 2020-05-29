import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 29 12:37:06 BOT 2020
 */



/**
 * @author unknown
 */
public class login extends JFrame {
    public login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        passLabel = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("USER:");
        contentPane.add(label1);
        label1.setBounds(5, 155, 90, label1.getPreferredSize().height);

        //---- passLabel ----
        passLabel.setText("PASSWORD:");
        contentPane.add(passLabel);
        passLabel.setBounds(0, 195, 100, passLabel.getPreferredSize().height);

        //---- textField1 ----
        textField1.setText("Username");
        contentPane.add(textField1);
        textField1.setBounds(105, 150, 215, textField1.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.setText("Password");
        contentPane.add(passwordField1);
        passwordField1.setBounds(105, 190, 220, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("ENTER");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(350, 300), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("CANCEL");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(270, 300), button2.getPreferredSize()));

        //---- label2 ----
        label2.setText("LOGIN");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(235, 40), label2.getPreferredSize()));

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
    private JLabel label1;
    private JLabel passLabel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
