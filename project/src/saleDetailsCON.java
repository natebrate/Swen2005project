public class saleDetailsCON {

    public int invoice, P_ID, quantity_sold, sub_total;


    saleDetailsCON (int P_ID, int quantity_sold, int sub_total)
        {
            this.invoice = invoice;
            this.P_ID = P_ID;
            this.quantity_sold = quantity_sold;
            this.sub_total = sub_total;
        }

    saleDetailsCON (int invoice, int P_ID, int quantity_sold, int sub_total)
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

        public int getQuantity_sold()
        {
            return quantity_sold;
        }

        public int getP_ID() { return P_ID; }

        public int getSub_total () { return sub_total; }
}

