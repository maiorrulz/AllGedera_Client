package allgedera.com.allgederaapp.rest;

import java.util.List;

import allgedera.com.allgederaapp.businesses.entities.Business;
import allgedera.com.allgederaapp.coupons.entities.Coupon;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by user0 on 31/03/2016.
 */
public interface RestAPI {

    String BASE_URL = "http://allgedera-rest.us-west-2.elasticbeanstalk.com/api";//"http://allgederarest.k5qrryukaz.us-east-1.elasticbeanstalk.com/api";

    /*
     * @GET("database/businesses") - path from base url
     *
     */
    @GET("/database/businesses")
    void getBusinesses(Callback<List<Business>> response);

    @GET("/database/coupons")
    void getCoupons(Callback<List<Coupon>> response);

    @GET("/database/purchases/{id}/{coupon_id}")
    void addPurchase(@Path("id") int id, @Path("coupon_id") int coupon_id, Callback<Response> Response);
}
