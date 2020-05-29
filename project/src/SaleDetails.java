import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        searchButton = new JButton();
        searchField = new JTextField();
        salesPane = new JScrollPane();
        salesTable = new JTable();
        label1 = new JLabel();
        amountLabels = new JLabel();
        totalSoldLabel = new JLabel();
        soldLabel = new JLabel();
        displayButton = new JButton();
        printButton = new JButton();
        saveButton = new JButton();
        dateLabel = new JLabel();

        //======== this ========
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
            salesPane.setViewportView(salesTable);
        }
        contentPane.add(salesPane);
        salesPane.setBounds(255, 40, 445, 355);

        //---- label1 ----
        label1.setText("Total Quantity Sold:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(255, 400), label1.getPreferredSize()));

        //---- amountLabels ----
        amountLabels.setText("Quantity");
        contentPane.add(amountLabels);
        amountLabels.setBounds(new Rectangle(new Point(365, 400), amountLabels.getPreferredSize()));

        //---- totalSoldLabel ----
        totalSoldLabel.setText("Total Sold:");
        contentPane.add(totalSoldLabel);
        totalSoldLabel.setBounds(new Rectangle(new Point(255, 425), totalSoldLabel.getPreferredSize()));

        //---- soldLabel ----
        soldLabel.setText("$00000000.00");
        contentPane.add(soldLabel);
        soldLabel.setBounds(new Rectangle(new Point(365, 425), soldLabel.getPreferredSize()));

        //---- displayButton ----
        displayButton.setText("Display Report");
        contentPane.add(displayButton);
        displayButton.setBounds(new Rectangle(new Point(5, 110), displayButton.getPreferredSize()));

        //---- printButton ----
        printButton.setText("Print Report");
        contentPane.add(printButton);
        printButton.setBounds(5, 145, 110, printButton.getPreferredSize().height);

        //---- saveButton ----
        saveButton.setText("Save Report");
        contentPane.add(saveButton);
        saveButton.setBounds(5, 185, 110, saveButton.getPreferredSize().height);

        //---- dateLabel ----
        dateLabel.setText("DATE");
        contentPane.add(dateLabel);
        dateLabel.setBounds(10, 45, 235, dateLabel.getPreferredSize().height);

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
    private JLabel label1;
    private JLabel amountLabels;
    private JLabel totalSoldLabel;
    private JLabel soldLabel;
    private JButton displayButton;
    private JButton printButton;
    private JButton saveButton;
    private JLabel dateLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
