package allgedera.com.allgederaapp.coupons.entities;

public class Purchase {

    int id;
    String user;
    int coupon_id;
    int price;
    int credit_number;
    int validity_month;
    int validity_year;
    String date;
    String receipt;

    public Purchase(int id,
                    String user,
                    int coupon_id,
                    int price,
                    int credit_number,
                    int validity_month,
                    int validity_year,
                    String date,
                    String receipt) {
        this.id = id;
        this.user = user;
        this.coupon_id = coupon_id;
        this.price = price;
        this.credit_number = credit_number;
        this.validity_month = validity_month;
        this.validity_year = validity_year;
        this.date = date;
        this.receipt = receipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
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

    public int getValidity_month() {
        return validity_month;
    }

    public void setValidity_month(int validity_month) {
        this.validity_month = validity_month;
    }

    public int getValidity_year() {
        return validity_year;
    }

    public void setValidity_year(int validity_year) {
        this.validity_year = validity_year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", coupon_id=" + coupon_id +
                ", price=" + price +
                ", credit_number=" + credit_number +
                ", validity_month=" + validity_month +
                ", validity_year=" + validity_year +
                ", date='" + date + '\'' +
                '}';
    }
}
