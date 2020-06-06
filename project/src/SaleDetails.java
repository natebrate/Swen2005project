import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
/*
 * Created by JFormDesigner on Fri May 29 12:44:19 BOT 2020
 */


/**
 * @author unknown
 */
public class SaleDetails extends JFrame {
    User userLogin = null;
    int lastClickedRow;
    int lastClickedCol;

    //Flags
    boolean addingNewInvoice;
    boolean updatingExistingInvoice;



    public SaleDetails(User userLogin) throws SQLException {
        initComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.userLogin = userLogin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLabel.setText(userLogin.getUsername() + ": " + userLogin.adminCredentials());
        nameLabel.setText(userLogin.getFirstName());
        dayLabel.setText(CurrentDateTimeExample1());


        loadTables();
    }

    private void loadTables() throws SQLException {
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadSearchDetails(searchTable);
            dao.loadSalesReport(reportTable);
        }
        dao.closeConnection();
    }


    private void searchFieldActionPerformed(ActionEvent e) {
    }

    // FIND A RECORD AND DELETE IT FROM SALES DETAILS TABLE
    private void clearBtnActionPerformed(ActionEvent e) {
        deleteBtn.addActionListener(e1 -> {

            DAO dao = new DAO();
            if (dao.openConnection()) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.deleteSaleRecord(Integer.parseInt(invoiceField.getText()));
                        dao.closeConnection();
                    } else {
                        dispose();
                    }
                } catch (NumberFormatException J) {
                    JOptionPane.showMessageDialog(null, "Cannot find invoice number");
                }
            }
        }); //end of action listener
    }

    //PROBABLY CANNOT WORK LIKE THIS
    private void displayButtonActionPerformed(ActionEvent e) throws SQLException {
        // TODO add your code here
        // Populate JTable from Database
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadSalesReport(reportTable);
        }
        dao.closeConnection();
    }

    private void returnBtnActionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
    }

    private void prodFieldActionPerformed(ActionEvent e) {
            findProductDetails();
            quantityField.requestFocus();
        }

    private void quantityFieldActionPerformed(ActionEvent e) {
        addBtn.setEnabled(true);
    }

    private void deleteBtnActionPerformed(ActionEvent e) throws SQLException {
        switch (deleteBtn.getText())
        {
            case "Cancel":
                addingNewInvoice = false;
                clearAll();
                lockButtons();
                lockFields();
                deleteBtn.setText("Delete");
                saveBtn.setText("Create Invoice");
                break;

            case "Delete Invoice":
                if (userLogin.getIsAdmin()) {
                    int returnValue;
                    returnValue = JOptionPane.showConfirmDialog(null, "Are you certain you want to " +
                                    "delete Invoice No: " + invoiceField.getText(),
                            "Delete Invoice", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (returnValue == JOptionPane.YES_OPTION)
                    {
                        deleteInvoice();
                        DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
                        model.setRowCount(0);
                        loadTables();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You must have admin credentials to delete" +
                                        "an invoice!",
                                "Need Admin Credentials!", JOptionPane.WARNING_MESSAGE);
                    }
                }
        }
    }


    private void saveBtnActionPerformed(ActionEvent e) throws SQLException {
        switch (saveBtn.getText())
        {
            case "Create Invoice":
            unlockFields();
            invoiceField.setText(String.valueOf(genInvoiceID()));
            invoiceField.setEnabled(false);
            prodField.requestFocus();
            saveBtn.setText("Save Invoice");
            addBtn.setEnabled(true);
            addingNewInvoice = true;
            break;

            case "Save Invoice":
            uploadInvoice();
            loadTables();
            clearAll();
            lockFields();
            lockButtons();
            saveBtn.setText("Create Invoice");
            addingNewInvoice = false;
            break;

            case "Update Invoice":
            updateInvoice();
            loadTables();
            clearAll();
            lockFields();
            lockButtons();
            saveBtn.setText("Create Invoice");
            addingNewInvoice = false;
            break;
        }
        deleteBtn.setText("Cancel");
    }

    private void dayLabelPropertyChange(PropertyChangeEvent e) {
            CurrentDateTimeExample1();
    }

    private void addBtnActionPerformed(ActionEvent e) {
        if(prodField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a Product ID!",
                    "Enter an ID", JOptionPane.WARNING_MESSAGE);
            prodField.requestFocus();
            return;
        }
        if(quantityField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a quantity!",
                    "Enter a quantity", JOptionPane.WARNING_MESSAGE);
            quantityField.requestFocus();
            return;
        }
        Product order = new Product(Integer.parseInt(prodField.getText()), prodName.getText(),
                Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
        Vector <Product> vec = new Vector<Product>();
        vec.addElement(order);
        DefaultTableModel model =(DefaultTableModel) invoiceTable.getModel();
        Object[] rowData = new Object[5];
        if (addBtn.getText().equals("Add to Order")) {
            for (int i=0; i < vec.size(); i++)
            {
                rowData[0] = vec.elementAt(i).getProd_id();
                rowData[1] = vec.elementAt(i).getName();
                rowData[2] = vec.elementAt(i).getQuantity();
                rowData[3] = vec.elementAt(i).getPrice();
                rowData[4] = vec.elementAt(i).getPrice() * vec.elementAt(i).getQuantity();
                model.addRow(rowData);
            }
        } else {
            for (int i=0; i < vec.size(); i++)
            {
                rowData[0] = vec.elementAt(i).getProd_id();
                rowData[1] = vec.elementAt(i).getName();
                rowData[2] = vec.elementAt(i).getQuantity();
                rowData[3] = vec.elementAt(i).getPrice();
                rowData[4] = vec.elementAt(i).getPrice() * vec.elementAt(i).getQuantity();
                model.removeRow(lastClickedRow);
                model.insertRow(lastClickedRow, rowData);
            }
            addBtn.setText("Add to Order");
        }
        Double currentTotal = Double.parseDouble(totalFigLabel.getText()) + order.getPrice() * order.getQuantity();
        totalFigLabel.setText(String.valueOf(currentTotal));
    }

//    private void loadRowArray(Vector<Product> vec, Object[] rowData, int lastClickedRow) {
//        rowData[0] = vec.elementAt(lastClickedRow).getProd_id();
//        rowData[1] = vec.elementAt(lastClickedRow).getName();
//        rowData[2] = vec.elementAt(lastClickedRow).getQuantity();
//        rowData[3] = vec.elementAt(lastClickedRow).getPrice();
//        rowData[4] = vec.elementAt(lastClickedRow).getPrice() * vec.elementAt(lastClickedRow).getQuantity();
//    }

    private void reportBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void textField1ActionPerformed(ActionEvent e) {
        searchInvoice();
    }

    private void searchTableMouseClicked(MouseEvent e) {
        // ONLY CLEAR USERS INVOICE FIELD IF AND ONLY IF THEY ARE NOT CREATING SOMETHING NEW
        if (!addingNewInvoice) {
            updatingExistingInvoice = true;
            if (e.getClickCount() == 1) {
                final JTable jTable= (JTable)e.getSource();
                final int row = jTable.getSelectedRow();
                int invoiceToSearch = Integer.parseInt(jTable.getValueAt(row, 1).toString());
                DAO dao = new DAO();
                if (dao.openConnection()) {
                    dao.loadInvoiceTable(invoiceTable, invoiceToSearch);
                }
                dao.closeConnection();
                unlockButtons();
                unlockFields();
                invoiceField.setText(String.valueOf(invoiceToSearch));
                saveBtn.setText("Update Invoice");
                addBtn.setText("Add to Order");
                totalFigLabel.setText(jTable.getValueAt(lastClickedRow, 3).toString());
            }
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
        int returnValue;
        returnValue = JOptionPane.showConfirmDialog(null, "Are you certain you want to " +
                        "delete " + model.getValueAt(lastClickedRow, 1).toString() + " from the order?",
                "Delete Invoice", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        model.removeRow(lastClickedRow);
    }

    private void invoiceTableMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            final JTable jTable = (JTable) e.getSource();
            lastClickedRow = jTable.getSelectedRow();
            lastClickedCol = jTable.getSelectedColumn();
            int ID = Integer.parseInt(jTable.getValueAt(lastClickedRow, 0).toString());
            String name = jTable.getValueAt(lastClickedRow,1).toString();
            int quantity = Integer.parseInt(jTable.getValueAt(lastClickedRow, 2).toString());
            double price = Double.parseDouble(jTable.getValueAt(lastClickedRow, 3).toString());
            prodField.setText(String.valueOf(ID));
            prodName.setText(name);
            prodName.setVisible(true);
            quantityField.setText(String.valueOf(quantity));
            priceField.setText(String.valueOf(price));
            priceField.setVisible(true);
            addBtn.setText("Update Order");
            unlockButtons();
            unlockFields();
            if (updatingExistingInvoice) saveBtn.setText("Update Invoice");
            invoiceField.setEnabled(false);
            deleteBtn.setText("Cancel");

        }
    }
    private void updateCell()
    {
        try {

            DAO dao = new DAO();
            Product prod = null;
            if (dao.openConnection()) {
                int ID = Integer.parseInt( invoiceTable.getValueAt(invoiceTable.getEditingRow(), 0).toString());
                prod = dao.findProdRecord(ID);
            }
            dao.closeConnection();
            int row = invoiceTable.getEditingRow();
            int col = invoiceTable.getEditingColumn();

            // If editing ID, change name and price
            if (invoiceTable.getEditingColumn() == 0)
            {
                //Set name
                String name = prod.getName();
                invoiceTable.setValueAt(name, row, 1);

                // Set price
                invoiceTable.setValueAt(0, row, 3);
            }
            // If editing Quantity, change price
            if (invoiceTable.getEditingColumn() == 2)
            {
                int quantity = Integer.parseInt(invoiceTable.getValueAt(row, col).toString());
                // Set price
                invoiceTable.setValueAt(prod.getPrice() * quantity, row, 2 );
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private void invoiceTableFocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void searchFieldFocusGained(FocusEvent e) {
        searchField.setText("");
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        invoicePane = new JScrollPane();
        invoiceTable = new JTable();
        searchPane = new JScrollPane();
        searchTable = new JTable();
        reportPane = new JScrollPane();
        reportTable = new JTable();
        searchBtn = new JButton();
        addBtn = new JButton();
        saveBtn = new JButton();
        modifyBtn = new JButton();
        allBtn = new JButton();
        deleteBtn = new JButton();
        returnBtn = new JButton();
        reportBtn = new JButton();
        dateLabel = new JLabel();
        dayLabel = new JLabel();
        userLabel = new JLabel();
        nameLabel = new JLabel();
        DesciptionLabel = new JLabel();
        invoiceLabel = new JLabel();
        prodLabel = new JLabel();
        quantityLabel = new JLabel();
        totalLabel = new JLabel();
        totalFigLabel = new JLabel();
        prodName = new JLabel();
        priceField = new JLabel();
        searchField = new JTextField();
        invoiceField = new JTextField();
        prodField = new JTextField();
        quantityField = new JTextField();
        deleteOrderBtn = new JButton();

        //======== this ========
        setTitle("INVOICE AND SALE DETAILS");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== invoicePane ========
        {

            //---- invoiceTable ----
            invoiceTable.setAutoCreateRowSorter(true);
            invoiceTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "PRODUCT ID", "NAME", "QUANTITY", "PRICE", "TOTAL"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, Integer.class, Double.class, Double.class
                };
                boolean[] columnEditable = new boolean[] {
                    true, false, true, false, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            invoiceTable.setToolTipText("For modification to invoices");
            invoiceTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    invoiceTableMouseClicked(e);
                }
            });
            invoiceTable.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    invoiceTableFocusLost(e);
                }
            });
            invoicePane.setViewportView(invoiceTable);
        }
        contentPane.add(invoicePane);
        invoicePane.setBounds(395, 80, 515, 165);

        //======== searchPane ========
        {

            //---- searchTable ----
            searchTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "DATE", "INVOICE", "TOTAL QUANTITY SOLD", "TOTAL SOLD"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Integer.class, Integer.class, Integer.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            searchTable.setAutoCreateRowSorter(true);
            searchTable.setToolTipText("to Search Records in Invoice");
            searchTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    searchTableMouseClicked(e);
                }
            });
            searchPane.setViewportView(searchTable);
        }
        contentPane.add(searchPane);
        searchPane.setBounds(395, 275, 515, 180);

        //======== reportPane ========
        {

            //---- reportTable ----
            reportTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "DATE", "INVOICE", "NAME", "ITEMS SOLD", "TOTAL REVENUE"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Integer.class, String.class, Integer.class, Double.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            reportTable.setAutoCreateRowSorter(true);
            reportTable.setToolTipText("To Display report");
            reportPane.setViewportView(reportTable);
        }
        contentPane.add(reportPane);
        reportPane.setBounds(395, 460, 515, 110);

        //---- searchBtn ----
        searchBtn.setText("Go");
        searchBtn.addActionListener(e -> {
            try {
                searchBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(searchBtn);
        searchBtn.setBounds(645, 45, 70, searchBtn.getPreferredSize().height);

        //---- addBtn ----
        addBtn.setText("Add to Order");
        addBtn.setEnabled(false);
        addBtn.addActionListener(e -> addBtnActionPerformed(e));
        contentPane.add(addBtn);
        addBtn.setBounds(10, 205, 115, addBtn.getPreferredSize().height);

        //---- saveBtn ----
        saveBtn.setText("Create Invoice");
        saveBtn.addActionListener(e -> {
            try {
                saveBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(saveBtn);
        saveBtn.setBounds(10, 245, 240, saveBtn.getPreferredSize().height);

        //---- modifyBtn ----
        modifyBtn.setText("Modify Invoice");
        modifyBtn.addActionListener(e -> addBtnActionPerformed(e));
        contentPane.add(modifyBtn);
        modifyBtn.setBounds(10, 290, 240, modifyBtn.getPreferredSize().height);

        //---- allBtn ----
        allBtn.setText("Display Report");
        allBtn.addActionListener(e -> {
            try {
                displayButtonActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(allBtn);
        allBtn.setBounds(10, 330, 240, allBtn.getPreferredSize().height);

        //---- deleteBtn ----
        deleteBtn.setText("Delete Invoice");
        deleteBtn.setForeground(Color.red);
        deleteBtn.addActionListener(e -> {
            try {
                deleteBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(10, 370, 240, deleteBtn.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        returnBtn.addActionListener(e -> returnBtnActionPerformed(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(7, 538, 240, returnBtn.getPreferredSize().height);

        //---- reportBtn ----
        reportBtn.setText("Sales Report");
        reportBtn.addActionListener(e -> reportBtnActionPerformed(e));
        contentPane.add(reportBtn);
        reportBtn.setBounds(127, 473, 115, reportBtn.getPreferredSize().height);

        //---- dateLabel ----
        dateLabel.setText("DATE:");
        contentPane.add(dateLabel);
        dateLabel.setBounds(5, 5, 115, 15);

        //---- dayLabel ----
        dayLabel.setText("MM/DD/YYYY");
        dayLabel.addPropertyChangeListener(e -> dayLabelPropertyChange(e));
        contentPane.add(dayLabel);
        dayLabel.setBounds(130, 4, 115, dayLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(680, 4, 115, userLabel.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Name");
        contentPane.add(nameLabel);
        nameLabel.setBounds(805, 4, 115, nameLabel.getPreferredSize().height);

        //---- DesciptionLabel ----
        DesciptionLabel.setText("Search and Create Invoices Here");
        contentPane.add(DesciptionLabel);
        DesciptionLabel.setBounds(10, 40, 350, DesciptionLabel.getPreferredSize().height);

        //---- invoiceLabel ----
        invoiceLabel.setText("Invoice Number:");
        contentPane.add(invoiceLabel);
        invoiceLabel.setBounds(10, 77, 100, invoiceLabel.getPreferredSize().height);

        //---- prodLabel ----
        prodLabel.setText("Product ID:");
        contentPane.add(prodLabel);
        prodLabel.setBounds(10, 115, 100, prodLabel.getPreferredSize().height);

        //---- quantityLabel ----
        quantityLabel.setText("Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(10, 160, 100, quantityLabel.getPreferredSize().height);

        //---- totalLabel ----
        totalLabel.setText("GRAND TOTAL: $");
        contentPane.add(totalLabel);
        totalLabel.setBounds(670, 250, 115, totalLabel.getPreferredSize().height);

        //---- totalFigLabel ----
        totalFigLabel.setText("0.00");
        contentPane.add(totalFigLabel);
        totalFigLabel.setBounds(795, 250, 115, totalFigLabel.getPreferredSize().height);

        //---- prodName ----
        prodName.setText("prodName ");
        prodName.setForeground(Color.red);
        prodName.setFont(prodName.getFont().deriveFont(prodName.getFont().getStyle() | Font.ITALIC));
        prodName.setVisible(false);
        contentPane.add(prodName);
        prodName.setBounds(280, 115, 100, prodName.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("priceField");
        priceField.setFont(priceField.getFont().deriveFont(priceField.getFont().getStyle() | Font.ITALIC));
        priceField.setForeground(Color.red);
        priceField.setVisible(false);
        contentPane.add(priceField);
        priceField.setBounds(280, 165, 100, priceField.getPreferredSize().height);

        //---- searchField ----
        searchField.setText("Search");
        searchField.setFont(searchField.getFont().deriveFont(searchField.getFont().getStyle() | Font.ITALIC));
        searchField.setForeground(Color.lightGray);
        searchField.addActionListener(e -> textField1ActionPerformed(e));
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchFieldFocusGained(e);
            }
        });
        contentPane.add(searchField);
        searchField.setBounds(395, 45, 245, searchField.getPreferredSize().height);

        //---- invoiceField ----
        invoiceField.setEnabled(false);
        contentPane.add(invoiceField);
        invoiceField.setBounds(110, 70, 140, invoiceField.getPreferredSize().height);

        //---- prodField ----
        prodField.setEnabled(false);
        prodField.addActionListener(e -> prodFieldActionPerformed(e));
        contentPane.add(prodField);
        prodField.setBounds(110, 110, 140, prodField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setEnabled(false);
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(110, 155, 140, quantityField.getPreferredSize().height);

        //---- deleteOrderBtn ----
        deleteOrderBtn.setText("Delete From Order");
        deleteOrderBtn.setEnabled(false);
        deleteOrderBtn.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(deleteOrderBtn);
        deleteOrderBtn.setBounds(135, 205, 115, deleteOrderBtn.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(940, 610));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    private void invoiceFieldActionPerformed(ActionEvent e) {
        DAO dao = new DAO();
        if(dao.openConnection())
        {
            dao.findInvoiceNumber(invoiceTable, Integer.parseInt(invoiceField.getText()));
            dao.closeConnection();
        }
    }

    private String CurrentDateTimeExample1 (){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = formatter.format(date);
        return day;
    }

    //Method to find record belonging to invoice method
    private void searchBtnActionPerformed(ActionEvent e)  throws SQLException {
    }
    private int genInvoiceID()
    {
        Random rand = new Random();
        return rand.nextInt(100000 - 1) + 1;
    }
    private void unlockFields()
    {
        prodField.setEnabled(true);
        quantityField.setEnabled(true);
        invoiceField.setEnabled(true);
    }
    private void lockFields()
    {
        prodField.setEnabled(false);
        quantityField.setEnabled(false);
    }
    private void findProductDetails()
    {
        if (!prodField.getText().isBlank()) {
            DAO dao = new DAO();
            if (dao.openConnection()) {
                Product theFind;
                theFind = dao.findProdRecord(Integer.parseInt(prodField.getText()));
                dao.closeConnection();
                if (theFind != null) {
                    prodName.setText(theFind.getName());
                    priceField.setText(String.valueOf(theFind.getPrice()));
                    prodName.setVisible(true);
                    priceField.setVisible(true);
                }
                else
                {
                    prodName.setText("Not found");
                    priceField.setText(null);
                }
                }
        }
    }
    private void searchInvoice()
    {
        DAO dao = new DAO();
        if (dao.openConnection()) {
                dao.querySalesSearch(searchTable,Integer.parseInt(searchField.getText()));
            dao.closeConnection();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane invoicePane;
    private JTable invoiceTable;
    private JScrollPane searchPane;
    private JTable searchTable;
    private JScrollPane reportPane;
    private JTable reportTable;
    private JButton searchBtn;
    private JButton addBtn;
    private JButton saveBtn;
    private JButton modifyBtn;
    private JButton allBtn;
    private JButton deleteBtn;
    private JButton returnBtn;
    private JButton reportBtn;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JLabel userLabel;
    private JLabel nameLabel;
    private JLabel DesciptionLabel;
    private JLabel invoiceLabel;
    private JLabel prodLabel;
    private JLabel quantityLabel;
    private JLabel totalLabel;
    private JLabel totalFigLabel;
    private JLabel prodName;
    private JLabel priceField;
    private JTextField searchField;
    private JTextField invoiceField;
    private JTextField prodField;
    private JTextField quantityField;
    private JButton deleteOrderBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

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
    private void uploadInvoice()
    {
        DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
        Vector<Vector> vec = model.getDataVector();
        Product prodSale = null;
        for (int i=0; i < vec.size(); i++)
        {
            prodSale = new Product(Integer.parseInt(vec.elementAt(i).get(0).toString()), vec.elementAt(i).get(1).toString(),
                    Integer.parseInt(vec.elementAt(i).get(2).toString()), Double.parseDouble( vec.elementAt(i).get(3).toString()));
            DAO dao = new DAO();
            if (dao.openConnection()) {
                dao.productTransaction(Integer.parseInt(invoiceField.getText()), prodSale);
            }
            dao.closeConnection();

        }
        //Reset Invoice Number and Table
        model.setRowCount(0);
    }
    private void updateInvoice() throws SQLException {
        deleteInvoice();
        uploadInvoice();
    }
    private void deleteInvoice() throws SQLException {
        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.deleteInvoice(Integer.parseInt(invoiceField.getText()));
        }
        dao.closeConnection();
    }
    private void clearAll()
    {
        invoiceField.setText("");
        prodField.setText("");
        priceField.setText("");
        prodName.setText("");
        searchField.setText("");
        quantityField.setText("");
    }
    private void lockButtons()
    {
        addBtn.setEnabled(false);
        deleteOrderBtn.setEnabled(false);
    }
    private void unlockButtons()
    {
        addBtn.setEnabled(true);
        deleteOrderBtn.setEnabled(true);
    }
}
