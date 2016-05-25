package allgedera.com.allgederaapp.businesses.entities;

import java.io.Serializable;

/**
 * Created by user0 on 29/03/2016.
 */
public class Business implements Serializable {

    private String id;
    private String name;
    private String category;
    private String about;
    private String city;
    private String address;
    private String phone;
    private double latitude;
    private double longitude;
    private String image;
    private String logo;

    public Business(String id, String name, String category,
                    String about, String city, String address,
                    String phone, double latitude, double longitude, String image, String logo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.about = about;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
