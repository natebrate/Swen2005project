import java.awt.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 29 13:25:57 BOT 2020
 */



/**
 * @author unknown
 */
public class ProductsPanel extends JFrame {
    public ProductsPanel() {
        initComponents();
    }

    private void productPanePropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        searchField = new JTextField();
        button1 = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        allLabel = new JButton();
        IDField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchField ----
        searchField.setText("Search");
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 550, searchField.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search");
        contentPane.add(button1);
        button1.setBounds(650, 5, 105, button1.getPreferredSize().height);

        //======== productPane ========
        {
            productPane.addPropertyChangeListener(e -> productPanePropertyChange(e));

            //---- productTable ----
            productTable.setModel(new DefaultTableModel(
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
                    "Name", "P_ID", "Quantity", "Price"
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
        productPane.setBounds(320, 40, 437, productPane.getPreferredSize().height);

        //---- allLabel ----
        allLabel.setText("Display All");
        contentPane.add(allLabel);
        allLabel.setBounds(new Rectangle(new Point(10, 50), allLabel.getPreferredSize()));

        //---- IDField ----
        IDField.setText("ID");
        contentPane.add(IDField);
        IDField.setBounds(10, 170, 120, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.setText("Name");
        contentPane.add(nameField);
        nameField.setBounds(10, 210, 120, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setText("Quantity");
        contentPane.add(quantityField);
        quantityField.setBounds(10, 255, 120, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("Price");
        contentPane.add(priceField);
        priceField.setBounds(10, 305, 120, priceField.getPreferredSize().height);

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
    private JTextField searchField;
    private JButton button1;
    private JScrollPane productPane;
    private JTable productTable;
    private JButton allLabel;
    private JTextField IDField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
