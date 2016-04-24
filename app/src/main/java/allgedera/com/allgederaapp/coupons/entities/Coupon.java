package allgedera.com.allgederaapp.coupons.entities;

/**
 * Created by user0 on 15/04/2016.
 */
public class Coupon {

    private int id;
    private String details;
    private int price;
    private String image;
    private int business_id;

    public Coupon(int id, String details, int price, String image, int business_id) {
        this.id = id;
        this.details = details;
        this.price = price;
        this.image = image;
        this.business_id = business_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
}
