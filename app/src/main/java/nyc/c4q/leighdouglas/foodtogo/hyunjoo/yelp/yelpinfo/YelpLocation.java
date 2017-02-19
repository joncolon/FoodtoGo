package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hyun on 2/18/17.
 */


public class YelpLocation implements Serializable {

    private String[] address;
    private String city;
    @SerializedName("state_code")
    private String state;
    @SerializedName("postal_code")
    private String zipcode;
    private YelpCoordinate coordinate;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public YelpCoordinate getCoordinate() {
        return coordinate;
    }

    public String[] getAddress() {
        return address;
    }
}