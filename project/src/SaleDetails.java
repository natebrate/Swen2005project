import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Created by JFormDesigner on Fri May 29 12:44:19 BOT 2020
 */


/**
 * @author unknown
 */
public class SaleDetails extends JFrame {

    public int invoice, P_ID, quantity_sold, sub_total;
    public SaleDetails(User userLogin) throws SQLException {
        initComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Creates new form SaleDetails
     */
    Vector <details> vec = new Vector <details> ();
   
    private void searchFieldKeyPressed(KeyEvent e) {
        // TODO add your code here
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            Toolkit.getDefaultToolkit().beep();
            fillTable();
        }
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
                        dao.deleteSaleRecord(Integer.valueOf(searchField.getText()));
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
    }


    private void initComponents()
    {
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

        //======== this ========
        setTitle("Sales Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> searchButtonActionPerformed(e));
        contentPane.add(searchButton);
        searchButton.setBounds(new Rectangle(new Point(630, 5), searchButton.getPreferredSize()));

        //---- searchField ----
        searchField.setText("Search");
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 620, searchField.getPreferredSize().height);

        //======== salesPane ========
        {

            //---- salesTable ----
            salesTable.setAutoCreateRowSorter(true);
            salesTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "Date", "P_ID", "Quantity"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Date.class, Integer.class, Integer.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            salesPane.setViewportView(salesTable);
        }
        contentPane.add(salesPane);
        salesPane.setBounds(255, 65, 445, 325);

        //---- quantityLabel ----
        quantityLabel.setText("Amount Items Sold:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(new Rectangle(new Point(255, 400), quantityLabel.getPreferredSize()));

        //---- amountLabels ----
        amountLabels.setText("Quantity");
        contentPane.add(amountLabels);
        amountLabels.setBounds(new Rectangle(new Point(365, 400), amountLabels.getPreferredSize()));

        //---- totalSoldLabel ----
        totalSoldLabel.setText("Total Sold:");
        contentPane.add(totalSoldLabel);
        totalSoldLabel.setBounds(300, 425, 60, totalSoldLabel.getPreferredSize().height);

        //---- soldLabel ----
        soldLabel.setText("$00000000.00");
        contentPane.add(soldLabel);
        soldLabel.setBounds(new Rectangle(new Point(365, 425), soldLabel.getPreferredSize()));

        //---- displayButton ----
        displayButton.setText("Display Report");
        contentPane.add(displayButton);
        displayButton.setBounds(130, 105, 110, displayButton.getPreferredSize().height);

        //---- printButton ----
        printButton.setText("Print Report");
        contentPane.add(printButton);
        printButton.setBounds(130, 145, 110, printButton.getPreferredSize().height);

        //---- saveButton ----
        saveButton.setText("Save Report");
        contentPane.add(saveButton);
        saveButton.setBounds(130, 185, 110, saveButton.getPreferredSize().height);

        //---- dateLabel ----
        dateLabel.setText("DATE:");
        contentPane.add(dateLabel);
        dateLabel.setBounds(15, 45, 35, dateLabel.getPreferredSize().height);

        //---- saleTitleLabel ----
        saleTitleLabel.setText("Sales Details:");
        contentPane.add(saleTitleLabel);
        saleTitleLabel.setBounds(255, 40, 115, saleTitleLabel.getPreferredSize().height);

        //---- dayLabel ----
        dayLabel.setText("MM/DD/YYYY");
        contentPane.add(dayLabel);
        dayLabel.setBounds(50, 45, 100, dayLabel.getPreferredSize().height);

        //---- clearBtn ----
        clearBtn.setText("Clear Records");
        contentPane.add(clearBtn);
        clearBtn.setBounds(130, 225, 110, clearBtn.getPreferredSize().height);

        //---- idField ----
        idField.setText("ID");
        idField.addActionListener(e -> idFieldActionPerformed(e));
        contentPane.add(idField);
        idField.setBounds(15, 225, 95, idField.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        contentPane.add(returnBtn);
        returnBtn.setBounds(15, 265, 220, returnBtn.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(720, 485));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    private void searchButtonActionPerformed(ActionEvent evt)
    {
        // TODO add your code here
        if (searchField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a quantity");
            searchField.requestFocus();
            return;
        }

        details g = new details (invoice, P_ID,  quantity_sold, sub_total);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        vec.addElement(g);
        Date date = new Date(System.currentTimeMillis());

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            rowData[0] = formatter.format(date);
            rowData[1] = vec.elementAt(i).getP_ID();
            rowData[2] = vec.elementAt(i).getQuantity_sold();
            model.addRow(rowData);
        }
        searchField.setText("");
        searchField.requestFocus();
    }

    //WHEN USER SEARCHES BY INVOICE THIS POPULATES THE TABLE WITH SAID INVOICE
    private void fillTable()
    {
        DAO dao = new DAO();
        if (dao.openConnection())
        {
            saleDetailsCON thefind = null;
            thefind = dao.findsalesRecord(Integer.parseInt(searchField.getText()));
            if (thefind != null)
            {
                searchField.setText(Integer.toString(thefind.getInvoice()));
                P_ID = thefind.getP_ID();
                quantity_sold = thefind.getQuantity_sold();
                sub_total = thefind.getSub_total();

            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter an invoice number");
                searchField.requestFocus();
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry Invoice doesn't exist",
                    "Sorry Invoice doesn't exist", JOptionPane.WARNING_MESSAGE);
        }
        dao.closeConnection();
    }


    private void idFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    public class details
    {
        int invoice, P_ID, quantity_sold, sub_total;

        public details(int invoice, int P_ID, int quantity_sold, int sub_total)
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
        public int getSub_total()
        {
            return this.sub_total;
        }
        public int getQuantity_sold()
        {
            return this.quantity_sold;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
