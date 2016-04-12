package allgedera.com.allgederaapp.businesses.expandable.list;

/**
 * Created by user0 on 03/04/2016.
 */
public class BusinessChild {

    private String imageUrl;
    private String about;
    private String address;
    private String phone;
    private double x_geo;
    private double y_geo;

    public BusinessChild(String imageUrl, String about, String address, String phone, double x_geo, double y_geo) {
        this.imageUrl = imageUrl;
        this.about = about;
        this.address = address;
        this.phone = phone;
        this.x_geo = x_geo;
        this.y_geo = y_geo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getX_geo() {
        return x_geo;
    }

    public void setX_geo(double x_geo) {
        this.x_geo = x_geo;
    }

    public double getY_geo() {
        return y_geo;
    }

    public void setY_geo(double y_geo) {
        this.y_geo = y_geo;
    }
}
