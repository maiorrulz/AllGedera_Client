package allgedera.com.allgederaapp.rest;

import java.util.List;

import allgedera.com.allgederaapp.businesses.Business;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by user0 on 31/03/2016.
 */
public interface RestAPI {

    public static final String BASE_URL = "http://allgederarest.k5qrryukaz.us-east-1.elasticbeanstalk.com/api";

    /*
     * @GET("database/businesses") - path from base url
     *
     */
    @GET("/database/businesses")
    public void getBusinesses(Callback<List<Business>> response);
}
