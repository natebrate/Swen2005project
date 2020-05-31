import java.awt.*;
import java.awt.event.*;
import java.util.*;
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

    /**
     * Creates new form SaleDetails
     */
    Vector <Salesdetails> vec = new Vector <Salesdetails> ();
    public SaleDetails() {

        initComponents();
        int P_ID, quantity_sold;
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

        //======== this ========
        setTitle("Sales Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchButton ----
        searchButton.setText("Search");
        //searchButton.addActionListener(e -> searchButtonActionPerformed(e));

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                prodcodeActionPerformed(evt);
            }
        });

        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) { }
            @Override
            public void focusLost(FocusEvent e) {
                checkRecord cd = new checkRecord();
                cd.start();
            }
        });

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
        displayButton.setBounds(new Rectangle(new Point(130, 105), displayButton.getPreferredSize()));

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

    private void searchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(searchButton.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter an invoice number");
            searchButton.requestFocus();
            return;
        }


        SaleDetails g = new SaleDetails(Integer.parseInt(P_ID.getText()), Integer.parseInt(quantity.getText()));
        vec.addElement(g);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        for (int i=0;i < vec.size(); i++)
        {
            rowData[0] = formatter.format(date);
            rowData[1] = vec.elementAt(i).getP_ID();
            rowData[2] = vec.elementAt(i).getQuantity_sold();
            model.addRow(rowData);
        }
        searchButton.requestFocus();
    }

    private void prodcodeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    private void idFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    class checkRecord extends Thread {

        public void run() {
            try {
                DAO salesDAO = new DAO();
                if (salesDAO.openConnection()) {
                    saleDetailsCON thefind = null;
                    thefind = salesDAO.findsalesRecord(Integer.parseInt(searchField.getText()));
                    if (thefind != null) {
                    }
                    searchField.setText(thefind.getInvoice());
                    P_ID = thefind.getP_ID();
                    quantity_sold = thefind.getQuantity_sold();
                }
            } catch (Exception e) {
                System.out.println("Error in Check data method call. Exception!");
            }
        }
    }

    static class Salesdetails
    {
        int invoice, P_ID, quantity_sold, sub_total;

        public Salesdetails(int invoice, int P_ID, int quantity_sold, int sub_total)
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
