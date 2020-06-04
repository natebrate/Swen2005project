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

    Vector<details> vec = new Vector<details>();

    public SaleDetails(User userLogin) throws SQLException {
        initComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLabel.setText(userLogin.getUsername() + ": " + userLogin.adminCredentials());
        nameLabel.setText(userLogin.getFirstName());


        DAO dao = new DAO();
        if (dao.openConnection()) {
            dao.loadSalesDetailsTable(salesTable);
        }
        dao.closeConnection();
    }


    private void searchFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
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
            dao.loadSalesDetailsTable(salesTable);
        }
        dao.closeConnection();
    }

    private void returnBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        //new MenuScreen();
    }

    private void prodFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
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



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        salesPane = new JScrollPane();
        salesTable = new JTable();
        searchBtn = new JButton();
        saveBtn = new JButton();
        deleteBtn = new JButton();
        allBtn = new JButton();
        returnBtn = new JButton();
        dateLabel = new JLabel();
        dayLabel = new JLabel();
        nameLabel = new JLabel();
        userLabel = new JLabel();
        quantityLabel = new JLabel();
        prodLabel = new JLabel();
        invoiceLabel = new JLabel();
        quantityField = new JTextField();
        prodField = new JTextField();
        invoiceField = new JTextField();
        Desciption_menu = new JLabel();

        //======== this ========
        setTitle("Sales Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== salesPane ========
        {

            //---- salesTable ----
            salesTable.setAutoCreateRowSorter(true);
            salesTable.setModel(new DefaultTableModel(
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
                },
                new String[] {
                    "Invoice", "P_ID", "Amount", "Date"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Integer.class, Integer.class, String.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            salesPane.setViewportView(salesTable);
        }
        contentPane.add(salesPane);
        salesPane.setBounds(365, 55, 465, 340);

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
        searchBtn.setBounds(240, 65, 120, searchBtn.getPreferredSize().height);

        //---- saveBtn ----
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(e -> saveBtnActionPerformed(e));
        contentPane.add(saveBtn);
        saveBtn.setBounds(45, 265, 240, saveBtn.getPreferredSize().height);

        //---- deleteBtn ----
        deleteBtn.setText("Delete Invoice");
        deleteBtn.setForeground(Color.red);
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(165, 305, 120, deleteBtn.getPreferredSize().height);

        //---- allBtn ----
        allBtn.setText("Display All");
        allBtn.addActionListener(e -> {
            try {
                displayButtonActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(allBtn);
        allBtn.setBounds(45, 305, 120, allBtn.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        returnBtn.addActionListener(e -> returnBtnActionPerformed(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(45, 345, 240, returnBtn.getPreferredSize().height);

        //---- dateLabel ----
        dateLabel.setText("DATE:");
        contentPane.add(dateLabel);
        dateLabel.setBounds(10, 15, 100, 15);

        //---- dayLabel ----
        dayLabel.setText("MM/DD/YYYY");
        dayLabel.addPropertyChangeListener(e -> dayLabelPropertyChange(e) );
        contentPane.add(dayLabel);
        dayLabel.setBounds(120, 15, 110, dayLabel.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Name");
        contentPane.add(nameLabel);
        nameLabel.setBounds(675, 15, 115, nameLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(555, 15, 115, userLabel.getPreferredSize().height);

        //---- quantityLabel ----
        quantityLabel.setText("Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(10, 160, 100, quantityLabel.getPreferredSize().height);

        //---- prodLabel ----
        prodLabel.setText("Product ID:");
        contentPane.add(prodLabel);
        prodLabel.setBounds(10, 115, 100, prodLabel.getPreferredSize().height);

        //---- invoiceLabel ----
        invoiceLabel.setText("Invoice Number:");
        contentPane.add(invoiceLabel);
        invoiceLabel.setBounds(10, 75, 100, invoiceLabel.getPreferredSize().height);

        //---- quantityField ----
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(120, 160, 110, quantityField.getPreferredSize().height);

        //---- prodField ----
        prodField.addActionListener(e -> prodFieldActionPerformed(e));
        contentPane.add(prodField);
        prodField.setBounds(120, 115, 110, prodField.getPreferredSize().height);
        contentPane.add(invoiceField);
        invoiceField.setBounds(120, 70, 110, invoiceField.getPreferredSize().height);

        //---- Desciption_menu ----
        Desciption_menu.setText("Search and Create Invoices Here");
        contentPane.add(Desciption_menu);
        Desciption_menu.setBounds(10, 40, 230, Desciption_menu.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(845, 440));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    public String CurrentDateTimeExample1 (){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = formatter.format(date);
        return day;
    }
        //Method to find the invoice number

    private void searchBtnActionPerformed(ActionEvent e)  throws SQLException {
        DAO dao = new DAO();
        if (dao.openConnection())
        {
            Sale thefind;
            thefind = dao.findsalesRecord(Integer.parseInt(invoiceField.getText()));
            System.out.println(thefind);
            if (thefind != null)
            {
                details g = new details(invoice, P_ID, quantity_sold, sub_total);
                vec.addElement(g);

                DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
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
        }
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
    private JScrollPane salesPane;
    private JTable salesTable;
    private JButton searchBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton allBtn;
    private JButton returnBtn;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JLabel nameLabel;
    private JLabel userLabel;
    private JLabel quantityLabel;
    private JLabel prodLabel;
    private JLabel invoiceLabel;
    private JTextField quantityField;
    private JTextField prodField;
    private JTextField invoiceField;
    private JLabel Desciption_menu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
