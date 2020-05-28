

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Khair Muhammad
 */
public class Item {

    public String name;
    public int itemNumber;
    public int qty;
    public double price;
    public Item next;

    public Item(String name, int itemNumber, int qty, double price) {

        this.name = name;
        this.itemNumber = itemNumber;
        this.qty = qty;
        this.price = price;
    }

    public void displayItem() {

        System.out.println(name + " " + itemNumber + " " + qty + " " + price);
        System.out.println();
    }

}
