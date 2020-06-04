import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 29 12:44:19 BOT 2020
 */


/**
 * @author unknown
 */
public class SaleDetails extends JFrame {
    public int invoice, P_ID, quantity_sold;
    public double sub_total;
    User userLogin = null;

    Vector<details> vec = new Vector<details>();

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


        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadSalesDetailsTable(reportTable);
        }
        dao.closeConnection();
    }


    private void searchFieldActionPerformed(ActionEvent e) {
    }

    // FIND A RECORD AND DELETE IT FROM SALES DETAILS TABLE
    private void clearBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
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
            dao.loadSalesDetailsTable(reportTable);
        }
        dao.closeConnection();
    }

    private void returnBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        //new MenuScreen();
    }

    private void prodFieldActionPerformed(ActionEvent e) {
        //  TODO add your code here
    }

    private void quantityFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void saveBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void dayLabelPropertyChange(PropertyChangeEvent e) {
            CurrentDateTimeExample1();
    }

    private void addBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void reportBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void textField1ActionPerformed(ActionEvent e) {
        // TODO add your code here
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
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "PRODUCT ID", "NAME", "QUANTITY", "PRICE", "TOTAL"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, Integer.class, Double.class, Double.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            invoiceTable.setToolTipText("For modification to invoices");
            invoicePane.setViewportView(invoiceTable);
        }
        contentPane.add(invoicePane);
        invoicePane.setBounds(395, 80, 515, 165);

        //======== searchPane ========
        {

            //---- searchTable ----
            searchTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
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
            searchPane.setViewportView(searchTable);
        }
        contentPane.add(searchPane);
        searchPane.setBounds(395, 275, 515, 180);

        //======== reportPane ========
        {

            //---- reportTable ----
            reportTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
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
        searchBtn.setText("Search");
        searchBtn.addActionListener(e -> {
            try {
                searchBtnActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(searchBtn);
        searchBtn.setBounds(270, 70, 120, searchBtn.getPreferredSize().height);

        //---- addBtn ----
        addBtn.setText("Add to Order");
        contentPane.add(addBtn);
        addBtn.setBounds(110, 200, 140, addBtn.getPreferredSize().height);

        //---- saveBtn ----
        saveBtn.setText("SAVE INVOICE");
        saveBtn.addActionListener(e -> saveBtnActionPerformed(e));
        contentPane.add(saveBtn);
        saveBtn.setBounds(10, 245, 240, saveBtn.getPreferredSize().height);

        //---- modifyBtn ----
        modifyBtn.setText("MODIFY INVOICE");
        modifyBtn.addActionListener(e -> addBtnActionPerformed(e));
        contentPane.add(modifyBtn);
        modifyBtn.setBounds(10, 290, 240, modifyBtn.getPreferredSize().height);

        //---- allBtn ----
        allBtn.setText("DISPLAY REPORT");
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
        deleteBtn.setText("DELETE INVOICE");
        deleteBtn.setForeground(Color.red);
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(10, 370, 240, deleteBtn.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        returnBtn.addActionListener(e -> returnBtnActionPerformed(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(10, 450, 240, returnBtn.getPreferredSize().height);

        //---- reportBtn ----
        reportBtn.setText("SALES REPORT");
        reportBtn.addActionListener(e -> reportBtnActionPerformed(e));
        contentPane.add(reportBtn);
        reportBtn.setBounds(275, 450, 115, reportBtn.getPreferredSize().height);

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
        prodLabel.setText("Poduct ID:");
        contentPane.add(prodLabel);
        prodLabel.setBounds(10, 115, 100, prodLabel.getPreferredSize().height);

        //---- quantityLabel ----
        quantityLabel.setText("Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(10, 160, 100, quantityLabel.getPreferredSize().height);

        //---- totalLabel ----
        totalLabel.setText("GRAND TOTAL:");
        contentPane.add(totalLabel);
        totalLabel.setBounds(670, 250, 115, totalLabel.getPreferredSize().height);

        //---- totalFigLabel ----
        totalFigLabel.setText("$0");
        contentPane.add(totalFigLabel);
        totalFigLabel.setBounds(795, 250, 115, totalFigLabel.getPreferredSize().height);

        //---- prodName ----
        prodName.setText("prodName ");
        contentPane.add(prodName);
        prodName.setBounds(280, 115, 100, prodName.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("priceField");
        contentPane.add(priceField);
        priceField.setBounds(280, 165, 100, priceField.getPreferredSize().height);

        //---- searchField ----
        searchField.setText("Search");
        searchField.setFont(searchField.getFont().deriveFont(searchField.getFont().getStyle() | Font.ITALIC));
        searchField.setForeground(Color.lightGray);
        searchField.addActionListener(e -> textField1ActionPerformed(e));
        contentPane.add(searchField);
        searchField.setBounds(395, 45, 245, searchField.getPreferredSize().height);
        contentPane.add(invoiceField);
        invoiceField.setBounds(110, 70, 140, invoiceField.getPreferredSize().height);

        //---- prodField ----
        prodField.addActionListener(e -> prodFieldActionPerformed(e));
        contentPane.add(prodField);
        prodField.setBounds(110, 110, 140, prodField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(110, 155, 140, quantityField.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(930, 610));
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

    public String CurrentDateTimeExample1 (){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = formatter.format(date);
        return day;
    }

    //Method to find record belonging to invoice method
    private void searchBtnActionPerformed(ActionEvent e)  throws SQLException {
 /**       DAO dao = new DAO();
        if (dao.openConnection())
        { Sale thefind;
            thefind = dao.findInvoiceNumber(Integer.parseInt(invoiceField.getText()));
            System.out.println(thefind);
            if (thefind != null)
            {
                details g = new details(invoice, P_ID, quantity_sold, sub_total);
                vec.addElement(g);

                DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
                Object rowData[] = new Object[5];
                model.setRowCount(0);
                for (int i = 0; i < vec.size(); i++) {
                    rowData[0] = vec.elementAt(i).getInvoice();
                    rowData[1] = vec.elementAt(i).getP_ID();
                    rowData[2] = vec.elementAt(i).getQuantity_sold();
                    rowData[3] = CurrentDateTimeExample1();
                    model.addRow(rowData);
                }
                invoiceField.setText("");
                invoiceField.requestFocus();
                P_ID = thefind.getP_ID();
                quantity_sold = thefind.getQuantity_sold();
                sub_total = thefind.getSub_total();

            } else {
                JOptionPane.showMessageDialog(null, "Please enter an invoice number");
               invoiceField.requestFocus();
           }
        } **/
    }

    static class details
    {
        int invoice, P_ID, quantity_sold;
        double sub_total;

        public details(int invoice, int P_ID, int quantity_sold, double sub_total)
        {
            this.invoice = invoice;
            this.P_ID = P_ID;
            this.quantity_sold = quantity_sold;
            this.sub_total = sub_total;
        }
        public int getInvoice()
        {
            return this.invoice;
        }
        public int getP_ID()
        {
            return this.P_ID;
        }
        public int getQuantity_sold()
        {
            return this.quantity_sold;
        }
        public double getSub_total()
        {
            return this.sub_total;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
