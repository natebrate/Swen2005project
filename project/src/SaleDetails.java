import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.DecimalFormat;
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
public class SaleDetails extends javax.swing.JFrame {
    public int P_ID, quantity_sold;
    public String search;

    /**
     * Creates new form SaleDetails
     */
    Vector <details> vec = new Vector <details> ();

    public SaleDetails() {

        initComponents();
        int P_ID, quantity_sold;
    }

    public SaleDetails(String text, int quantity_sold) {
    }

    private void searchFieldKeyPressed(KeyEvent e) {
        // TODO add your code here
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            Toolkit.getDefaultToolkit().beep();
            fillTable();
        }
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
        clearBtn = new JButton();
        returnBtn = new JButton();
        dateLabel = new JLabel();
        saleTitleLabel = new JLabel();
        dayLabel = new JLabel();
        idField = new JTextField();
        fnameLabel = new JLabel();
        lnameLabel = new JLabel();
        userLabel = new JLabel();

        //======== this ========
        setTitle("Sales Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> searchButtonActionPerformed(e));
        contentPane.add(searchButton);
        searchButton.setBounds(645, 5, 133, searchButton.getPreferredSize().height);

        //---- searchField ----
        searchField.setText("Search");
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                searchFieldKeyPressed(e);
            }
        });
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
        salesPane.setBounds(275, 90, 515, 355);

        //---- quantityLabel ----
        quantityLabel.setText("Amount Items Sold:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(new Rectangle(new Point(265, 450), quantityLabel.getPreferredSize()));

        //---- amountLabels ----
        amountLabels.setText("Quantity");
        contentPane.add(amountLabels);
        amountLabels.setBounds(new Rectangle(new Point(395, 450), amountLabels.getPreferredSize()));

        //---- totalSoldLabel ----
        totalSoldLabel.setText("Total Sold:");
        contentPane.add(totalSoldLabel);
        totalSoldLabel.setBounds(310, 480, 60, totalSoldLabel.getPreferredSize().height);

        //---- soldLabel ----
        soldLabel.setText("$00000000.00");
        contentPane.add(soldLabel);
        soldLabel.setBounds(new Rectangle(new Point(385, 480), soldLabel.getPreferredSize()));

        //---- displayButton ----
        displayButton.setText("Display Report");
        contentPane.add(displayButton);
        displayButton.setBounds(130, 155, 139, displayButton.getPreferredSize().height);

        //---- printButton ----
        printButton.setText("Print Report");
        contentPane.add(printButton);
        printButton.setBounds(130, 200, 139, printButton.getPreferredSize().height);

        //---- saveButton ----
        saveButton.setText("Save Report");
        contentPane.add(saveButton);
        saveButton.setBounds(130, 240, 139, saveButton.getPreferredSize().height);

        //---- clearBtn ----
        clearBtn.setText("Clear Records");
        contentPane.add(clearBtn);
        clearBtn.setBounds(130, 280, 139, clearBtn.getPreferredSize().height);

        //---- returnBtn ----
        returnBtn.setText("Return to Menu");
        contentPane.add(returnBtn);
        returnBtn.setBounds(20, 325, 220, returnBtn.getPreferredSize().height);

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

        //---- idField ----
        idField.setText("ID");
        idField.addActionListener(e -> idFieldActionPerformed(e));
        contentPane.add(idField);
        idField.setBounds(0, 280, 130, idField.getPreferredSize().height);

        //---- fnameLabel ----
        fnameLabel.setText("First Name");
        contentPane.add(fnameLabel);
        fnameLabel.setBounds(460, 40, 130, fnameLabel.getPreferredSize().height);

        //---- lnameLabel ----
        lnameLabel.setText("Last Name");
        contentPane.add(lnameLabel);
        lnameLabel.setBounds(600, 40, 130, lnameLabel.getPreferredSize().height);

        //---- userLabel ----
        userLabel.setText("USER:");
        contentPane.add(userLabel);
        userLabel.setBounds(new Rectangle(new Point(390, 40), userLabel.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(805, 545));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    private void searchButtonActionPerformed(ActionEvent evt) {
        // TODO add your code here
        if(searchField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter an invoice number");
            searchField.requestFocus();
            fillTable();
            return;
        }
    }

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
                fillTable();

                SaleDetails g = new SaleDetails(searchField.getText(), quantity_sold);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
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
                searchField.requestFocus();

            }
            else {
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


    class checkInvoice extends Thread {

        public void run() {
            try {
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
                    }
                    else {
                        searchField.requestFocus();
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sorry Invoice doesn't exist",
                            "Sorry Invoice doesn't exist", JOptionPane.WARNING_MESSAGE);
                }
                dao.closeConnection();
            } catch (Exception e) {
                System.out.println("Error in Check method call. Exception!");
            }
        }
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
    private JButton clearBtn;
    private JButton returnBtn;
    private JLabel dateLabel;
    private JLabel saleTitleLabel;
    private JLabel dayLabel;
    private JTextField idField;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel userLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
