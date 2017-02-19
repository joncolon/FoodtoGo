package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpHomelessShelters implements Serializable {

    private String name;

    @SerializedName("display_phone")
    private String phoneNumber;

    private YelpLocation location;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public YelpLocation getLocation() {
        return location;
    }

}
