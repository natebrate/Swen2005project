import java.awt.*;
import java.awt.event.*;
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

    private void nameFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void quantityFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void priceFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        searchField = new JTextField();
        searchBtn = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        allBtn = new JButton();
        IDField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        label1 = new JLabel();
        saveBtn = new JButton();
        updateBtn = new JButton();
        deleteBtn = new JButton();
        clearBtn = new JButton();
        IDLabel = new JLabel();
        nameLabel = new JLabel();
        quantityLabel = new JLabel();
        priceLabel = new JLabel();

        //======== this ========
        setTitle("Product Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- searchField ----
        searchField.setText("Search");
        contentPane.add(searchField);
        searchField.setBounds(10, 5, 550, searchField.getPreferredSize().height);

        //---- searchBtn ----
        searchBtn.setText("Search");
        contentPane.add(searchBtn);
        searchBtn.setBounds(565, 5, 190, searchBtn.getPreferredSize().height);

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

        //---- allBtn ----
        allBtn.setText("Display All");
        contentPane.add(allBtn);
        allBtn.setBounds(70, 435, 165, allBtn.getPreferredSize().height);

        //---- IDField ----
        IDField.setText("P_ID");
        contentPane.add(IDField);
        IDField.setBounds(105, 170, 190, IDField.getPreferredSize().height);

        //---- nameField ----
        nameField.setText("Name");
        nameField.addActionListener(e -> nameFieldActionPerformed(e));
        contentPane.add(nameField);
        nameField.setBounds(105, 210, 190, nameField.getPreferredSize().height);

        //---- quantityField ----
        quantityField.setText("Quantity");
        quantityField.addActionListener(e -> quantityFieldActionPerformed(e));
        contentPane.add(quantityField);
        quantityField.setBounds(105, 255, 190, quantityField.getPreferredSize().height);

        //---- priceField ----
        priceField.setText("Price");
        priceField.addActionListener(e -> priceFieldActionPerformed(e));
        contentPane.add(priceField);
        priceField.setBounds(105, 300, 190, priceField.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Modify Entrees to Table: Save, Delete and Update");
        contentPane.add(label1);
        label1.setBounds(10, 140, 295, label1.getPreferredSize().height);

        //---- saveBtn ----
        saveBtn.setText("Save");
        saveBtn.setForeground(new Color(0, 153, 51));
        contentPane.add(saveBtn);
        saveBtn.setBounds(new Rectangle(new Point(70, 355), saveBtn.getPreferredSize()));

        //---- updateBtn ----
        updateBtn.setText("Update");
        updateBtn.setForeground(new Color(0, 204, 204));
        contentPane.add(updateBtn);
        updateBtn.setBounds(new Rectangle(new Point(155, 355), updateBtn.getPreferredSize()));

        //---- deleteBtn ----
        deleteBtn.setText("Delete");
        deleteBtn.setForeground(new Color(204, 0, 0));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(new Rectangle(new Point(70, 395), deleteBtn.getPreferredSize()));

        //---- clearBtn ----
        clearBtn.setText("Clear");
        clearBtn.setForeground(Color.yellow);
        contentPane.add(clearBtn);
        clearBtn.setBounds(new Rectangle(new Point(155, 395), clearBtn.getPreferredSize()));

        //---- IDLabel ----
        IDLabel.setText("Product ID:");
        contentPane.add(IDLabel);
        IDLabel.setBounds(new Rectangle(new Point(35, 175), IDLabel.getPreferredSize()));

        //---- nameLabel ----
        nameLabel.setText("Product Name:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(new Rectangle(new Point(15, 215), nameLabel.getPreferredSize()));

        //---- quantityLabel ----
        quantityLabel.setText("Product Quantity:");
        contentPane.add(quantityLabel);
        quantityLabel.setBounds(new Rectangle(new Point(5, 260), quantityLabel.getPreferredSize()));

        //---- priceLabel ----
        priceLabel.setText("Product Price:");
        contentPane.add(priceLabel);
        priceLabel.setBounds(new Rectangle(new Point(25, 310), priceLabel.getPreferredSize()));

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
    private JButton searchBtn;
    private JScrollPane productPane;
    private JTable productTable;
    private JButton allBtn;
    private JTextField IDField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel label1;
    private JButton saveBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JButton clearBtn;
    private JLabel IDLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
