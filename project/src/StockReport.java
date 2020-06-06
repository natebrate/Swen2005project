import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri Jun 05 23:37:06 BOT 2020
 */



/**
 * @author unknown
 */
public class StockReport extends JFrame {
    public StockReport() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        returnBtn = new JButton();
        scrollPane1 = new JScrollPane();
        reportTable = new JTable();

        //======== this ========
        setTitle("Product Report");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- returnBtn ----
        returnBtn.setText("Return");
        contentPane.add(returnBtn);
        returnBtn.setBounds(new Rectangle(new Point(215, 465), returnBtn.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- reportTable ----
            reportTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "P_ID", "Name", "Price", "Quantity"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, Double.class, Integer.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(reportTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(30, 20), scrollPane1.getPreferredSize()));

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
    private JButton returnBtn;
    private JScrollPane scrollPane1;
    private JTable reportTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
