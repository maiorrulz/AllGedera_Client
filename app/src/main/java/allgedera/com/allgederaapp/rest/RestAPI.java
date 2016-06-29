package allgedera.com.allgederaapp.rest;

import java.util.List;

import allgedera.com.allgederaapp.businesses.entities.Business;
import allgedera.com.allgederaapp.coupons.entities.Coupon;
import allgedera.com.allgederaapp.coupons.entities.Purchase;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


public interface RestAPI {

    String BASE_URL = "http://10.0.0.13:8080/com.allgedera.rest/api";//"http://allgederarest.k5qrryukaz.us-east-1.elasticbeanstalk.com/api";

    /*
     * @GET("database/businesses") - path from base url
     *
     */
    @GET("/database/businesses")
    void getBusinesses(Callback<List<Business>> response);

    @GET("/database/coupons")
    void getCoupons(Callback<List<Coupon>> response);

    @GET("/database/purchases")
    void getPurchases(Callback<List<Purchase>> response);

    @GET("/database/purchases/{user}")
    void getUserPurchases(@Path("user") String user, Callback<List<Purchase>> response);

    @POST("/database/purchases/add")
    void addPurchase(@Body Purchase purchase, Callback<Response> response);
}
