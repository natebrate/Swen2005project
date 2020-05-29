import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 29 12:44:19 BOT 2020
 */



/**
 * @author unknown
 */
public class SaleDetails extends JFrame {
    public SaleDetails() {
        initComponents();
    }

    private void searchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void idFieldActionPerformed(ActionEvent e) {
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
            ));
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

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
