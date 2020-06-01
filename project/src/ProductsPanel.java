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

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        productPane.setBounds(320, 15, 510, 440);

        //---- allBtn ----
        allBtn.setText("Display All");
        allBtn.addActionListener(e -> allBtnActionPerformed(e));
        contentPane.add(allBtn);
        allBtn.setBounds(65, 360, 200, allBtn.getPreferredSize().height);

        //---- IDField -------
        IDField.setBounds(120, 65, 190, IDField.getPreferredSize().height);
        IDField.addActionListener(e -> IDFieldActionPerformed(e));
        contentPane.add(IDField);

        //---- nameField ----
        nameField.setVisible(false);
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(120, 105, 190, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setVisible(false);
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(120, 150, 190, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setVisible(false);
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(120, 195, 190, priceField.getPreferredSize().height);

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
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(65, 310, 100, deleteBtn.getPreferredSize().height);

        //---- IDLabel ----
        IDLabel.setText("Product ID:");
        contentPane.add(IDLabel);
        IDLabel.setBounds(15, 70, 100, IDLabel.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Product Name:");
        nameLabel.setVisible(false);
        contentPane.add(nameLabel);
        nameLabel.setBounds(15, 110, 100, nameLabel.getPreferredSize().height);

        //---- quantityLabel ----
        quantityLabel.setText("Product Quantity:");
        quantityLabel.setVisible(false);
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(15, 155, 100, quantityLabel.getPreferredSize().height);

        //---- priceLabel ----
        priceLabel.setText("Product Price:");
        priceLabel.setVisible(false);
        contentPane.add(priceLabel);
        priceLabel.setBounds(15, 205, 100, priceLabel.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        contentPane.add(returnBtn);
        returnBtn.setBounds(65, 420, 200, returnBtn.getPreferredSize().height);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    class checkData extends Thread
    {
        public void run() throws NumberFormatException //This exception needed as this runs when the num field is blank
        {
            try {
                DAO dao = new DAO();
                if (dao.openConnection())
                {
                    Product thefind = null;
                    thefind = dao.findProdRecord(Integer.parseInt(IDField.getText()));
                    dao.closeConnection();
                    if (thefind != null)
                    {
                        nameField.setText(thefind.getName());
                        quantityField.setText(String.valueOf(thefind.getQuantity()));
                        priceField.setText(String.valueOf(thefind.getPrice()));
                        addUpdateBtn.setText("Update");
                        deleteBtn.setVisible(true);
                    }
                }
            } catch (NumberFormatException ignored) { //Do nothing about the exception. It is harmless
            }
        }
    }
}
