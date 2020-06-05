import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.*;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
/*
 * Created by JFormDesigner on Fri May 29 13:25:57 BOT 2020
 */


/**
 * @author unknown
 */
public class ProductsPanel extends JFrame {
    Product lastSearchedProduct = null;
    User userLogin = null;

    public ProductsPanel(User userLogin) throws SQLException {
        initComponents();
        IDField.requestFocusInWindow();
        addChangeListener(searchField, e -> searchName());
        // Load blank Product for purposes later

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Populate JTable from Database
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadProductsTable(productTable);
        }
        this.userLogin = userLogin;
        userLabel.setText(userLogin.getUsername() + ": " + userLogin.adminCredentials());
        userNameLabel.setText(userLogin.getFirstName());


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

    private void addBtnActionPerformed(ActionEvent e) throws SQLException {
        if (addUpdateBtn.getText().equals("Add")) {
            addProduct();
        } else {
            updateProduct();
        }
    }

    private void deleteBtnActionPerformed(ActionEvent e) throws SQLException {
        deleteProduct();
    }

    private void clearBtnActionPerformed(ActionEvent e) {
        clearAllFields();
    }

    private void allBtnActionPerformed(ActionEvent e) throws SQLException {
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadProductsTable(productTable);
        }
    }

    private void IDFieldActionPerformed(ActionEvent e) {
        beginSearch();
    }

    private void button1ActionPerformed(ActionEvent e) {
        if (searchBtn.getText().equals("Search"))
            beginSearch();
        else {
            IDField.setEditable(true);
            clearAllFields();
            lockEditableFields();
            IDField.setEnabled(true);
            IDField.requestFocus();
            searchBtn.setText("Search");
        }
    }

    private void searchFieldActionPerformed(ActionEvent e) {
        searchName();
    }

    public void keyTyped(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_TYPED) {
            char inputChar = e.getKeyChar();
            if (inputChar >= '0' && inputChar <= '9') {
                String text = quantityField.getText() + inputChar;
                System.out.println("Number :- " + Integer.parseInt(text));
            } else {
                e.consume();
            }
        }
    }

    public void negativeCheck (int field) {
        if(field < 0)
        {
            System.out.println(field +" is a negative number");
        }
        else
        {
            System.out.println(field +" is neither positive nor negative");
        }
    }

    private void productPanePropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void returnBtnActionPerformed(ActionEvent e) throws SQLException {
        setVisible(false);
        dispose();
    }

    private void IDFieldFocusGained(FocusEvent e) {
        // TODO add your code here
    }

    private void searchFieldFocusGained(FocusEvent e) {
        if (searchField.getText().equals("Search")) {
            searchField.setText("");
            searchField.setFont(searchField.getFont().deriveFont(searchField.getFont().getStyle() | Font.PLAIN));
            searchField.setForeground(Color.black);
        }
    }


    private void searchFieldFocusLost(FocusEvent e) throws SQLException {
        if (searchField.getText().isBlank()) {
            searchField.setText("Search");
            searchField.setFont(searchField.getFont().deriveFont(searchField.getFont().getStyle() | Font.ITALIC));
            searchField.setForeground(Color.lightGray);

        }
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadProductsTable(productTable);
        }
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
        InfoLabel = new JLabel();
        addUpdateBtn = new JButton();
        clearBtn = new JButton();
        deleteBtn = new JButton();
        IDLabel = new JLabel();
        nameLabel = new JLabel();
        quantityLabel = new JLabel();
        priceLabel = new JLabel();
        returnBtn = new JButton();
        searchBtn = new JButton();
        userNameLabel = new JLabel();
        userLabel = new JLabel();
        searchField = new JTextField();

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

        //---- IDField ----
        IDField.addActionListener(e -> IDFieldActionPerformed(e));
        IDField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                IDFieldFocusGained(e);
            }
        });
        contentPane.add(IDField);
        IDField.setBounds(118, 65, 95, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.setEditable(false);
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(118, 105, 190, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setEditable(false);
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(118, 150, 190, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setEditable(false);
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(118, 195, 190, priceField.getPreferredSize().height);

        //---- InfoLabel ----
        InfoLabel.setText("Modify Entrees to Table: Add, Delete and Update");
        contentPane.add(InfoLabel);
        InfoLabel.setBounds(10, 15, 300, InfoLabel.getPreferredSize().height);

        //---- addUpdateBtn ----
        addUpdateBtn.setText("Add");
        addUpdateBtn.setEnabled(false);
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
        deleteBtn.setEnabled(false);
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
        returnBtn.addActionListener(e -> returnBtnActionPerformed(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(65, 420, 200, returnBtn.getPreferredSize().height);

        //---- searchBtn ----
        searchBtn.setText("Search");
        searchBtn.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(searchBtn);
        searchBtn.setBounds(230, 65, 75, searchBtn.getPreferredSize().height);

        //---- userNameLabel ----
        userNameLabel.setText("Full Name");
        contentPane.add(userNameLabel);
        userNameLabel.setBounds(650, 35, 145, userNameLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(650, 5, 145, userLabel.getPreferredSize().height);

        //---- searchField ----
        searchField.setText("Search");
        searchField.setFont(searchField.getFont().deriveFont(searchField.getFont().getStyle() | Font.ITALIC));
        searchField.setForeground(Color.lightGray);
        searchField.addActionListener(e -> searchFieldActionPerformed(e));
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchFieldFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                searchFieldFocusLost(e);
            }
        });
        contentPane.add(searchField);
        searchField.setBounds(315, 10, 295, searchField.getPreferredSize().height);

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
    private JLabel InfoLabel;
    private JButton addUpdateBtn;
    private JButton clearBtn;
    private JButton deleteBtn;
    private JLabel IDLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JButton returnBtn;
    private JButton searchBtn;
    private JLabel userNameLabel;
    private JLabel userLabel;
    private JTextField searchField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void beginSearch() {
        if (IDField.getText().isBlank() || Integer.parseInt(IDField.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Please enter a valid ID!",
                    "Enter an ID", JOptionPane.WARNING_MESSAGE);
        } else {
            // Initalize return value for option dialogue below
            int returnValue;
            DAO dao = new DAO();
            if (dao.openConnection()) {
                Product theFind;
                theFind = dao.findProdRecord(Integer.parseInt(IDField.getText()));
                dao.closeConnection();
                if (theFind != null) {
                    lastSearchedProduct = theFind;
                    // Make textfields editable
                    nameField.setText(theFind.getName());
                    quantityField.setText(String.valueOf(theFind.getQuantity()));
                    priceField.setText(String.valueOf(theFind.getPrice()));
                    unlockEditableFields();
                    // Make buttons editable
                    addUpdateBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);

                    // Change search button to clear ID
                    searchBtn.setText("Clear");

                    addUpdateBtn.setText("Update");
                    deleteBtn.setVisible(true);

                    // Lock ID field to prevent updating primary key
                    IDField.setEnabled(false);

                } else {
                    returnValue = JOptionPane.showConfirmDialog(null, "Product ID not found! Would you like to " +
                                    "add this product now?",
                            "Add Product", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (returnValue == JOptionPane.YES_OPTION) {
                        // Unlock ID fields and allow editing of other fields
                        addUpdateBtn.setText("Add");
                        addUpdateBtn.setEnabled(true);
                        //Disable delete button, cannot delete something that doesn't exist!
                        deleteBtn.setEnabled(false);
                        // Clear and unlock all fields to facilitate data entry
                        clearEditableFields();
                        unlockEditableFields();
                        //Block ID field to prevent updating an existing product's primary key!
                        IDField.setEditable(false);
                        // Change search to clear in case user wants to go back
                        searchBtn.setText("Clear");

                    } else {
                        IDField.setText("");
                    }
                }
            }
        }
    }

    private void addProduct() throws SQLException {
        int returnValue;
        if (nameField.getText().isBlank() || quantityField.getText().isBlank() || priceField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields to continue!",
                    "Fill in all fields to continue", JOptionPane.WARNING_MESSAGE);
        } else {
            Product theAdd = new Product(Integer.parseInt(IDField.getText()), nameField.getText(),
                    Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
            returnValue = JOptionPane.showConfirmDialog(null, "Are you sure you would like to "
                            + "add this product?\n" + theAdd.toString(),
                    "Confirm Changes", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            DAO dao = new DAO();
            if (returnValue == JOptionPane.YES_OPTION) {
                if (dao.openConnection()) {
                    dao.insertProduct(theAdd);
                    // Refresh Product Table
                    dao.loadProductsTable(productTable);
                    dao.closeConnection();
                    clearAllFields();
                    lockEditableFields();
                    searchBtn.setText("Search");
                    IDField.setEnabled(true);
                    searchBtn.setEnabled(true);

                }
            }
        }
    }

    public void isInt (String Value)
    {
        try
        {
            Integer.parseInt(Value);
            JOptionPane.showMessageDialog(null, "please enter a Number",
                    "please enter a Number", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "please enter a Number",
                "please enter a Number", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void updateProduct() throws SQLException {
        int returnValue;
        if (nameField.getText().isBlank() || quantityField.getText().isBlank() || priceField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields to continue!",
                    "Fill in all fields to continue", JOptionPane.WARNING_MESSAGE);
        } else {
            Product theUpdate = new Product(Integer.parseInt(IDField.getText()), nameField.getText(),

                    Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
            returnValue = JOptionPane.showConfirmDialog(null, "Are you sure you would like to "
                            + "make this update?\n\nOriginal:\n" + lastSearchedProduct.toString() + "\n\nUpdate:\n" +
                            theUpdate.toString(),
                    "Confirm Changes", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (returnValue == JOptionPane.YES_OPTION) {
                DAO dao = new DAO();
                if (dao.openConnection()) {
                    dao.updateProdRecord(theUpdate);
                    // Refresh Product Table
                    dao.loadProductsTable(productTable);
                    dao.closeConnection();
                    clearAllFields();
                    lockEditableFields();
                    searchBtn.setText("Search");
                    IDField.setEnabled(true);
                }
            }
        }
    }

    private void deleteProduct() throws SQLException {
        if (userLogin.getIsAdmin()) {
            int returnValue;
            returnValue = JOptionPane.showConfirmDialog(null, "Are you certain you want to " +
                            "delete this product?:\n\n"
                            + lastSearchedProduct.toString(),
                    "Delete Product", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (returnValue == JOptionPane.YES_OPTION) {
                int theDeleteID = Integer.parseInt(IDField.getText());
                DAO dao = new DAO();
                if (dao.openConnection()) {
                    dao.deleteProdRecord(theDeleteID);
                    // Refresh Product Table
                    dao.loadProductsTable(productTable);
                    dao.closeConnection();
                    clearAllFields();
                    lockEditableFields();
                    searchBtn.setText("Search");
                    IDField.setEnabled(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must have admin credentials to delete" +
                            "a product!",
                    "Need Admin Credentials!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void searchName() {
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.queryProductsSearch(productTable, searchField.getText());
            dao.closeConnection();
        }
    }

    private void lockEditableFields() {
        nameField.setEditable(false);
        quantityField.setEditable(false);
        priceField.setEditable(false);
    }

    private void unlockEditableFields() {
        nameField.setEditable(true);
        quantityField.setEditable(true);
        priceField.setEditable(true);
    }

    private void clearEditableFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    private void clearAllFields() {
        IDField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        searchField.setText("Search");

    }

    private void lockButtons() {
        addUpdateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }
    private String nonNegativeCheck(int value)
            // This is used to ensure that negative numbers are not entered. If they are, warn user and then clear the
            // corresponding field
    {
        if (value < 0)
        {
            JOptionPane.showMessageDialog(null, "You must enter a non negative number to continue" +
                            "a product!",
                    "Please enter a non negative number!!", JOptionPane.WARNING_MESSAGE);
            return "";
        }
    return null;
    }

    // FOLLOWING REUSED FROM PUBLIC DOMAIN
    /**
     * Installs a listener to receive notification when the text of any
     * {@code JTextComponent} is changed. Internally, it installs a
     * {@link DocumentListener} on the text component's {@link Document},
     * and a {@link PropertyChangeListener} on the text component to detect
     * if the {@code Document} itself is replaced.
     *
     * @param text           any text component, such as a {@link JTextField}
     *                       or {@link JTextArea}
     * @param changeListener a listener to receieve {@link ChangeEvent}s
     *                       when the text is changed; the source object for the events
     *                       will be the text component
     * @throws NullPointerException if either parameter is null
     */
    public static void addChangeListener(JTextComponent text, ChangeListener changeListener) {
        Objects.requireNonNull(text);
        Objects.requireNonNull(changeListener);
        DocumentListener dl = new DocumentListener() {
            private int lastChange = 0, lastNotifiedChange = 0;

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lastChange++;
                SwingUtilities.invokeLater(() -> {
                    if (lastNotifiedChange != lastChange) {
                        lastNotifiedChange = lastChange;
                        changeListener.stateChanged(new ChangeEvent(text));
                    }
                });
            }
        };
        text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
            Document d1 = (Document) e.getOldValue();
            Document d2 = (Document) e.getNewValue();
            if (d1 != null) d1.removeDocumentListener(dl);
            if (d2 != null) d2.addDocumentListener(dl);
            dl.changedUpdate(null);
        });
        Document d = text.getDocument();
        if (d != null) d.addDocumentListener(dl);
    }
}