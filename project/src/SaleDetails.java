import java.awt.*;
import java.awt.event.*;
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
    }


    private void searchFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    // FIND A RECORD AND DELETE IT FROM SALES DETAILS TABLE
    private void clearBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        clearBtn.addActionListener(e1 -> {

            DAO dao = new DAO();
            if (dao.openConnection()) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.deleteSaleRecord(Integer.parseInt(searchField.getText()));
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
        new MenuScreen();
    }

    private void idFieldFocusGained(FocusEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        searchButton = new JButton();
        searchField = new JTextField();
        salesPane = new JScrollPane();
        salesTable = new JTable();
        quantityLabel = new JLabel();
        amountLabels = new JLabel();
        totalSoldLabel = new JLabel();
        soldLabel = new JLabel();
        displayButton = new JButton();
        printButton = new JButton();
        saveButton = new JButton();
        dateLabel = new JLabel();
        saleTitleLabel = new JLabel();
        dayLabel = new JLabel();
        clearBtn = new JButton();
        idField = new JTextField();
        returnBtn = new JButton();
        nameLabel = new JLabel();
        userLabel = new JLabel();
        hSpacer1 = new JPanel(null);

        //======== this ========
        setTitle("Sales Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> {
            try {
                searchButtonActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(searchButton);
        searchButton.setBounds(635, 5, searchButton.getPreferredSize().width, 25);

        //---- searchField ----
        searchField.addActionListener(e -> searchFieldActionPerformed(e));
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 620, searchField.getPreferredSize().height);

        //======== salesPane ========
        {

            //---- salesTable ----
            salesTable.setAutoCreateRowSorter(true);
            salesTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "Invoice", "P_ID", "Quantity", "sub_total", "Date"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Integer.class, Integer.class, Integer.class, String.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            salesPane.setViewportView(salesTable);
        }
        contentPane.add(salesPane);
        salesPane.setBounds(260, 70, 445, 325);

        //---- quantityLabel ----
        quantityLabel.setText("Amount Items Sold:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(new Rectangle(new Point(260, 405), quantityLabel.getPreferredSize()));

        //---- amountLabels ----
        amountLabels.setText("Quantity");
        contentPane.add(amountLabels);
        amountLabels.setBounds(370, 405, 100, amountLabels.getPreferredSize().height);

        //---- totalSoldLabel ----
        totalSoldLabel.setText("Total Sold:");
        contentPane.add(totalSoldLabel);
        totalSoldLabel.setBounds(305, 430, 60, totalSoldLabel.getPreferredSize().height);

        //---- soldLabel ----
        soldLabel.setText("$00000000.00");
        contentPane.add(soldLabel);
        soldLabel.setBounds(370, 430, 100, soldLabel.getPreferredSize().height);

        //---- displayButton ----
        displayButton.setText("Display Report");
        displayButton.addActionListener(e -> {
            try {
                displayButtonActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(displayButton);
        displayButton.setBounds(130, 105, 120, displayButton.getPreferredSize().height);

        //---- printButton ----
        printButton.setText("Print Report");
        contentPane.add(printButton);
        printButton.setBounds(130, 145, 120, printButton.getPreferredSize().height);

        //---- saveButton ----
        saveButton.setText("Save Report");
        contentPane.add(saveButton);
        saveButton.setBounds(130, 185, 120, saveButton.getPreferredSize().height);

        //---- dateLabel ----
        dateLabel.setText("DATE:");
        contentPane.add(dateLabel);
        dateLabel.setBounds(15, 45, 35, dateLabel.getPreferredSize().height);

        //---- saleTitleLabel ----
        saleTitleLabel.setText("Sales Details:");
        contentPane.add(saleTitleLabel);
        saleTitleLabel.setBounds(255, 40, 115, saleTitleLabel.getPreferredSize().height);

        //---- dayLabel ----
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = formatter.format(date);
        dayLabel.setText(day);
        contentPane.add(dayLabel);
        dayLabel.setBounds(50, 45, 100, dayLabel.getPreferredSize().height);

        //---- clearBtn ----
        clearBtn.setText("Clear Records");
        contentPane.add(clearBtn);
        clearBtn.setBounds(130, 225, 120, clearBtn.getPreferredSize().height);

        //---- idField ----
        idField.addActionListener(e -> idFieldActionPerformed(e));
        idField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                idFieldFocusGained(e);
            }
        });
        contentPane.add(idField);
        idField.setBounds(15, 230, 110, 25);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        returnBtn.addActionListener(e -> returnBtnActionPerformed(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(15, 265, 220, returnBtn.getPreferredSize().height);

        //---- nameLabel ----
        nameLabel.setText("Name");
        contentPane.add(nameLabel);
        nameLabel.setBounds(585, 40, 115, nameLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(465, 40, 115, userLabel.getPreferredSize().height);
        contentPane.add(hSpacer1);
        hSpacer1.setBounds(0, 60, 730, hSpacer1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(730, 485));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    //Method to find the invoice number
    private void searchButtonActionPerformed(ActionEvent evt) throws SQLException
    {
        DAO dao = new DAO();
        if (dao.openConnection())
        {
            saleDetailsCON thefind;
            thefind = dao.findsalesRecord(Integer.parseInt(searchField.getText()));
            System.out.println(thefind);
            if (thefind != null)
            {
                details g = new details(invoice, P_ID, quantity_sold, sub_total);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                vec.addElement(g);
                Date date = new Date(System.currentTimeMillis());
                String day = formatter.format(date);

                DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                Object rowData[] = new Object[5];
                model.setRowCount(0);
                for (int i = 0; i < vec.size(); i++) {
                    rowData[0] = vec.elementAt(i).getInvoice();
                    rowData[1] = vec.elementAt(i).getP_ID();
                    rowData[2] = vec.elementAt(i).getQuantity_sold();
                    rowData[3] = vec.elementAt(i).getSub_total();
                    rowData[4] = day;
                    model.addRow(rowData);
                }
                searchField.setText("");
                searchField.requestFocus();
                P_ID = thefind.getP_ID();
                quantity_sold = thefind.getQuantity_sold();
                sub_total = thefind.getSub_total();

            } else {
                JOptionPane.showMessageDialog(null, "Please enter an invoice number");
                searchField.requestFocus();
            }
        }
    }


    private void idFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
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
    private JButton searchButton;
    private JTextField searchField;
    private JScrollPane salesPane;
    private JTable salesTable;
    private JLabel quantityLabel;
    private JLabel amountLabels;
    private JLabel totalSoldLabel;
    private JLabel soldLabel;
    private JButton displayButton;
    private JButton printButton;
    private JButton saveButton;
    private JLabel dateLabel;
    private JLabel saleTitleLabel;
    private JLabel dayLabel;
    private JButton clearBtn;
    private JTextField idField;
    private JButton returnBtn;
    private JLabel nameLabel;
    private JLabel userLabel;
    private JPanel hSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
