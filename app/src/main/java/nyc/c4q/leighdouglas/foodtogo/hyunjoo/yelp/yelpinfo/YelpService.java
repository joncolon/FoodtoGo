package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hyun on 2/18/17.
 */

public interface YelpService {

    @GET("v2/search/")
    Call<YelpResponse> getYelp(@Query("location") String location,
                               @Query("category_filter") String filter);
}
