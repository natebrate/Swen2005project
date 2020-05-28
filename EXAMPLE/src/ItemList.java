
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khair Muhammad
 */
public class ItemList extends JFrame {

    public Item first;

    public ItemList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(String name, int itemNumber, int qty, double price) {

        Item newItem = new Item(name, itemNumber, qty, price);
        newItem.next = first;
        first = newItem;
        //JOptionPane.showMessageDialog(null, "Item saved");
    }

    public Item delete(int itNumber) {
        Item current = first;
        Item previous = first;

        while (current.itemNumber != itNumber) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public Item find(int itNumber) {
        Item current = first; 
        while (current.itemNumber != itNumber) {
            if (current.next == null) 
            {
                return null; 
            } else 
            {
                current = current.next;
            }
        }
        return current;
    }

    public void displayList() {
        
            /*Item current = first;
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0);
            while (current != null) {
                model.addRow(new Object[]{current.itemNumber, current.name, current.qty, current.price});
                current = current.next;
            }*/
    }

}
