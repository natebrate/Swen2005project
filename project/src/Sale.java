public class Sale {

    private int invoice, P_ID, quantity_sold;
    double sub_total;

    Sale(int P_ID, int quantity_sold, double sub_total)
        {
            this.invoice = invoice;
            this.P_ID = P_ID;
            this.quantity_sold = quantity_sold;
            this.sub_total = sub_total;
        }

    Sale(int invoice, int P_ID, int quantity_sold, double sub_total)
    {
        this.invoice = invoice;
        this.P_ID = P_ID;
        this.quantity_sold = quantity_sold;
        this.sub_total = sub_total;
    }

        public int getInvoice()
        {
            return invoice;
        }

        public int getP_ID() { return P_ID; }

        public int getQuantity_sold()
    {
        return quantity_sold;
    }

        public double getSub_total () { return sub_total; }
}

