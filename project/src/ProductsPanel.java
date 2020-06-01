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
        searchBtn = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        IDField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        label1 = new JLabel();
        allBtn = new JButton();
        saveBtn = new JButton();
        deleteBtn = new JButton();
        updateBtn = new JButton();
        clearBtn = new JButton();
        IDLabel = new JLabel();
        nameLabel = new JLabel();
        quantityLabel = new JLabel();
        priceLabel = new JLabel();
        returnBtn = new JButton();
        userLabel = new JLabel();
        fnameLabel = new JLabel();
        lnameLabel = new JLabel();

        //======== this ========
        setTitle("Product Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchField ----
        searchField.setText("Search");
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 550, searchField.getPreferredSize().height);

        //---- searchBtn ----
        searchBtn.setText("Search");
        contentPane.add(searchBtn);
        searchBtn.setBounds(660, 5, 100, 25);

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
        productPane.setBounds(340, 70, 437, productPane.getPreferredSize().height);

        //---- IDField ----
        IDField.setText("P_ID");
        contentPane.add(IDField);
        IDField.setBounds(115, 170, 200, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.setText("Name");
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(115, 210, 200, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setText("Quantity");
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(115, 255, 200, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("Price");
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(115, 300, 200, priceField.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Modify Entrees to Table: Save, Delete and Update");
        contentPane.add(label1);
        label1.setBounds(13, 140, 300, label1.getPreferredSize().height);

        //---- allBtn ----
        allBtn.setText("Display All");
        contentPane.add(allBtn);
        allBtn.setBounds(50, 435, 200, 30);

        //---- saveBtn ----
        saveBtn.setText("Save");
        saveBtn.setForeground(new Color(0, 153, 51));
        contentPane.add(saveBtn);
        saveBtn.setBounds(45, 355, 100, 30);

        //---- deleteBtn ----
        deleteBtn.setText("Delete");
        deleteBtn.setForeground(new Color(204, 0, 0));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(45, 395, 100, 30);

        //---- updateBtn ----
        updateBtn.setText("Update");
        updateBtn.setForeground(new Color(0, 204, 204));
        contentPane.add(updateBtn);
        updateBtn.setBounds(155, 355, 100, 30);

        //---- clearBtn ----
        clearBtn.setText("Clear");
        clearBtn.setForeground(Color.yellow);
        contentPane.add(clearBtn);
        clearBtn.setBounds(155, 395, 100, 30);

        //---- IDLabel ----
        IDLabel.setText("Product ID:");
        contentPane.add(IDLabel);
        IDLabel.setBounds(new Rectangle(new Point(35, 175), IDLabel.getPreferredSize()));

        //---- nameLabel ----
        nameLabel.setText("Product Name:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(15, 215, nameLabel.getPreferredSize().width, 21);

        //---- quantityLabel ----
        quantityLabel.setText("Product Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(new Rectangle(new Point(2, 260), quantityLabel.getPreferredSize()));

        //---- priceLabel ----
        priceLabel.setText("Product Price:");
        contentPane.add(priceLabel);
        priceLabel.setBounds(new Rectangle(new Point(21, 305), priceLabel.getPreferredSize()));

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        contentPane.add(returnBtn);
        returnBtn.setBounds(13, 105, 300, 30);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(15, 40, 60, userLabel.getPreferredSize().height);

        //---- fnameLabel ----
        fnameLabel.setText("First Name");
        contentPane.add(fnameLabel);
        fnameLabel.setBounds(85, 40, 130, fnameLabel.getPreferredSize().height);

        //---- lnameLabel ----
        lnameLabel.setText("Last Name");
        contentPane.add(lnameLabel);
        lnameLabel.setBounds(215, 40, 130, lnameLabel.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(795, 545));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField searchField;
    private JButton searchBtn;
    private JScrollPane productPane;
    private JTable productTable;
    private JTextField IDField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel label1;
    private JButton allBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton clearBtn;
    private JLabel IDLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JButton returnBtn;
    private JLabel userLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
