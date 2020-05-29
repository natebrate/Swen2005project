import java.awt.*;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuLabel = new JLabel();
        saleDetialsBtn = new JButton();
        prodDetailsBtn = new JButton();
        label2 = new JLabel();

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
        contentPane.add(saleDetialsBtn);
        saleDetialsBtn.setBounds(75, 145, 295, saleDetialsBtn.getPreferredSize().height);

        //---- prodDetailsBtn ----
        prodDetailsBtn.setText("Product Details");
        contentPane.add(prodDetailsBtn);
        prodDetailsBtn.setBounds(75, 185, 295, prodDetailsBtn.getPreferredSize().height);

        //---- label2 ----
        label2.setText("User");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(420, 10), label2.getPreferredSize()));

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
    private JLabel menuLabel;
    private JButton saleDetialsBtn;
    private JButton prodDetailsBtn;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
