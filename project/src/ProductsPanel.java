import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 29 13:25:57 BOT 2020
 */



/**
 * @author unknown
 */
public class ProductsPanel extends JFrame {
    public ProductsPanel(User userLogin) throws SQLException {
        initComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Populate JTable from Database
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadProductsTable(productTable);
        }


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

    private void addBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void clearBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void allBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void IDFieldActionPerformed(ActionEvent e) {
        beginSearch();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        productPane = new JScrollPane();
        productTable = new JTable();
        allBtn = new JButton();
        IDField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        label1 = new JLabel();
        addUpdateBtn = new JButton();
        clearBtn = new JButton();
        deleteBtn = new JButton();
        IDLabel = new JLabel();
        nameLabel = new JLabel();
        quantityLabel = new JLabel();
        priceLabel = new JLabel();
        returnBtn = new JButton();
        button1 = new JButton();
        userNameLabel = new JLabel();
        userLabel = new JLabel();

        //======== this ========
        setTitle("Products Page");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== productPane ========
        {
            productPane.addPropertyChangeListener(e -> productPanePropertyChange(e));

            //---- productTable ----
            productTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null, null},
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
                    "P_ID", "NAME", "QUANTITY", "PRICE"
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
        productPane.setBounds(315, 60, 510, 395);

        //---- allBtn ----
        allBtn.setText("Display All");
        allBtn.addActionListener(e -> allBtnActionPerformed(e));
        contentPane.add(allBtn);
        allBtn.setBounds(65, 360, 200, allBtn.getPreferredSize().height);
        contentPane.add(IDField);
        IDField.setBounds(118, 65, 95, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(118, 105, 190, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(118, 150, 190, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(118, 195, 190, priceField.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Modify Entrees to Table: Add, Delete and Update");
        contentPane.add(label1);
        label1.setBounds(10, 15, 300, label1.getPreferredSize().height);

        //---- addUpdateBtn ----
        addUpdateBtn.setText("Add");
        addUpdateBtn.addActionListener(e -> addBtnActionPerformed(e));
        contentPane.add(addUpdateBtn);
        addUpdateBtn.setBounds(65, 260, 200, addUpdateBtn.getPreferredSize().height);

        //---- clearBtn ----
        clearBtn.setText("Clear");
        clearBtn.addActionListener(e -> clearBtnActionPerformed(e));
        contentPane.add(clearBtn);
        clearBtn.setBounds(165, 310, 100, clearBtn.getPreferredSize().height);

        //---- deleteBtn ----
        deleteBtn.setText("Delete");
        deleteBtn.setForeground(new Color(204, 0, 0));
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(65, 310, 100, deleteBtn.getPreferredSize().height);

        //---- IDLabel ----
        IDLabel.setText("Product ID:");
        contentPane.add(IDLabel);
        IDLabel.setBounds(10, 70, 100, IDLabel.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Product Name:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(10, 110, 100, nameLabel.getPreferredSize().height);

        //---- quantityLabel ----
        quantityLabel.setText("Product Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(10, 155, 100, quantityLabel.getPreferredSize().height);

        //---- priceLabel ----
        priceLabel.setText("Product Price:");
        contentPane.add(priceLabel);
        priceLabel.setBounds(10, 200, 100, priceLabel.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        contentPane.add(returnBtn);
        returnBtn.setBounds(65, 420, 200, returnBtn.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search");
        contentPane.add(button1);
        button1.setBounds(230, 65, 75, button1.getPreferredSize().height);

        //---- userNameLabel ----
        userNameLabel.setText("Full Name");
        contentPane.add(userNameLabel);
        userNameLabel.setBounds(650, 35, 145, userNameLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(650, 5, 145, userLabel.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(835, 495));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane productPane;
    private JTable productTable;
    private JButton allBtn;
    private JTextField IDField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel label1;
    private JButton addUpdateBtn;
    private JButton clearBtn;
    private JButton deleteBtn;
    private JLabel IDLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JButton returnBtn;
    private JButton button1;
    private JLabel userNameLabel;
    private JLabel userLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

//    class checkData extends Thread
//    {
//        public void run() throws NumberFormatException //This exception needed as this runs
//        when the num field is blank
//        {
//            try {
//                DAO dao = new DAO();
//                if (dao.openConnection())
//                {
//                    Product thefind;
//                    thefind = dao.findProdRecord(Integer.parseInt(IDField.getText()));
//                    dao.closeConnection();
//                    if (thefind != null)
//                    {
//                        nameField.setText(thefind.getName());
//                        quantityField.setText(String.valueOf(thefind.getQuantity()));
//                        priceField.setText(String.valueOf(thefind.getPrice()));
//                        addUpdateBtn.setText("Update");
//                        deleteBtn.setVisible(true);
//                    }
//                }
//            } catch (NumberFormatException ignored) { //Do nothing about the exception. It is harmless
//            }
//        }
//    }
    private void beginSearch()
    {
        DAO dao = new DAO();
        if (dao.openConnection())
        {
            Product thefind;
            thefind = dao.findProdRecord(Integer.parseInt(IDField.getText()));
            dao.closeConnection();
            if (thefind != null)
            {
                // Make textfields visible
                nameField.setText(thefind.getName());
                nameField.setEditable(true);
                quantityField.setText(String.valueOf(thefind.getQuantity()));
                quantityField.setEditable(true);
                priceField.setText(String.valueOf(thefind.getPrice()));
                priceField.setEditable(true);

                addUpdateBtn.setText("Update");
                deleteBtn.setVisible(true);

            }
        }

    }
}
