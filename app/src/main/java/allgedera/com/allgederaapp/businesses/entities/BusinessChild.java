package allgedera.com.allgederaapp.businesses.entities;


public class BusinessChild {

    private String imageUrl;
    private String about;
    private String address;
    private String city;
    private String phone;
    private double latitude;
    private double longitude;

    public BusinessChild(String imageUrl, String about, String address, String city, String phone, double latitude, double longitude) {
        this.imageUrl = imageUrl;
        this.about = about;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

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
}
