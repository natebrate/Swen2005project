import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 29 13:25:57 BOT 2020
 */



/**
 * @author unknown
 */
public class ProductsPanel extends JFrame {
    public ProductsPanel() {
        initComponents();
    }

    private void productPanePropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void nameFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void quantityFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void priceFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        searchField = new JTextField();
        button1 = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        allLabel = new JButton();
        IDField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        label1 = new JLabel();
        saveBtn = new JButton();
        updateBtn = new JButton();
        deleteBtn = new JButton();
        clearBtn = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchField ----
        searchField.setText("Search");
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 550, searchField.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search");
        contentPane.add(button1);
        button1.setBounds(565, 5, 190, button1.getPreferredSize().height);

        //======== productPane ========
        {
            productPane.addPropertyChangeListener(e -> productPanePropertyChange(e));

            //---- productTable ----
            productTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "Name", "P_ID", "Quantity", "Price"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Integer.class, Integer.class, Double.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            productPane.setViewportView(productTable);
        }
        contentPane.add(productPane);
        productPane.setBounds(320, 40, 437, productPane.getPreferredSize().height);

        //---- allLabel ----
        allLabel.setText("Display All");
        contentPane.add(allLabel);
        allLabel.setBounds(70, 435, 165, allLabel.getPreferredSize().height);

        //---- IDField ----
        IDField.setText("P_ID");
        contentPane.add(IDField);
        IDField.setBounds(105, 170, 190, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.setText("Name");
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(105, 210, 190, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setText("Quantity");
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(105, 255, 190, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("Price");
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(105, 300, 190, priceField.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Modify Entrees to Table");
        contentPane.add(label1);
        label1.setBounds(10, 140, 295, label1.getPreferredSize().height);

        //---- saveBtn ----
        saveBtn.setText("Save");
        saveBtn.setForeground(new Color(0, 153, 51));
        contentPane.add(saveBtn);
        saveBtn.setBounds(new Rectangle(new Point(70, 355), saveBtn.getPreferredSize()));

        //---- updateBtn ----
        updateBtn.setText("Update");
        updateBtn.setForeground(new Color(0, 204, 204));
        contentPane.add(updateBtn);
        updateBtn.setBounds(new Rectangle(new Point(155, 355), updateBtn.getPreferredSize()));

        //---- deleteBtn ----
        deleteBtn.setText("Delete");
        deleteBtn.setForeground(new Color(204, 0, 0));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(new Rectangle(new Point(70, 395), deleteBtn.getPreferredSize()));

        //---- clearBtn ----
        clearBtn.setText("Clear");
        clearBtn.setForeground(Color.yellow);
        contentPane.add(clearBtn);
        clearBtn.setBounds(new Rectangle(new Point(155, 395), clearBtn.getPreferredSize()));

        //---- label2 ----
        label2.setText("Product ID:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 175), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Product Name:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(15, 215), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("Product Quantity:");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(5, 260), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("Product Price:");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(25, 310), label5.getPreferredSize()));

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
    private JTextField searchField;
    private JButton button1;
    private JScrollPane productPane;
    private JTable productTable;
    private JButton allLabel;
    private JTextField IDField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel label1;
    private JButton saveBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JButton clearBtn;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
