package allgedera.com.allgederaapp.businesses;

import java.io.Serializable;

/**
 * Created by user0 on 29/03/2016.
 */
public class Business implements Serializable {

    private String id;
    private String name;
    private String about;
    private String category;
    private String address;
    private String phone;
    private double x_geo;
    private double y_geo;
    private String area;
    private String image;
    private String logo;

    public Business(String id, String name, String about, String category, String address, String phone, double x_geo, double y_geo, String area, String image, String logo) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.category = category;
        this.address = address;
        this.phone = phone;
        this.x_geo = x_geo;
        this.y_geo = y_geo;
        this.area = area;
        this.image = image;
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImage() {
        return image;
    }

    public void setImge(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
