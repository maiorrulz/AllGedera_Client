package allgedera.com.allgederaapp.profile.entities;

/**
 * Created by user0 on 02/06/2016.
 */
public class PurchaseChild {

    int price;
    int credit_number;
    String receipt;

    public PurchaseChild(int price, int credit_number, String receipt) {
        this.price = price;
        this.credit_number = credit_number;
        this.receipt = receipt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCredit_number() {
        return credit_number;
    }

    public void setCredit_number(int credit_number) {
        this.credit_number = credit_number;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
