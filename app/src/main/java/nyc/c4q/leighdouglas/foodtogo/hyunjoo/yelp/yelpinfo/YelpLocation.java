package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpLocation implements Serializable {

    private String address;
    private String city;
    @SerializedName("state_code")
    private String state;
    @SerializedName("postal_code")
    private String zipCode;

    private YelpCoordinates coordinate  ;

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public YelpCoordinates getCoordinate() {
        return coordinate;
    }
}
