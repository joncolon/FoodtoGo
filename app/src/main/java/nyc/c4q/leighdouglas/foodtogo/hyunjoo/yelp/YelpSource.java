package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpHomelessShelters;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpResponse;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpSource{

    private static List<YelpHomelessShelters> yelpHomelessList;
    private static YelpResponse yelpResponse;
    private static final String API_URL = "https://api.yelp.com/";
    public static final String CONSUMER_KEY = "cNFbdkyNCwcSXyRtmAvlRg";
    public static final String CONSUMER_SECRET = "aKIt7mBB9Hr0m82zO6_0naHN5EY";
    public static final String TOKEN = "0bDATQ2Z2XFvrvY51nI6LYgEkmB0yPWu";
    public static final String TOKEN_SECRET = "11k2DR0quF27g2Wl6jzp_Qt2NiI";


    public static void getHomelessList(final RecyclerView mRecycler) {

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(TOKEN, TOKEN_SECRET);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        YelpService yelpService = retrofit.create(YelpService.class);
        Call<YelpResponse> yelpInfo = yelpService.getYelp(
                "NEWYORK",
                "homelessshelters,foodbanks");

        yelpInfo.enqueue(new Callback<YelpResponse>() {
            @Override
            public void onResponse(Call<YelpResponse> call, Response<YelpResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d("Retrofit:", "success");
                        yelpResponse = response.body();
                        yelpHomelessList = yelpResponse.getBusinesses();
                        mRecycler.setAdapter(new YelpAdapter(yelpHomelessList));

                    } else {
                        Log.d("Retrofit:", "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e("Retrofit", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<YelpResponse> call, Throwable t) {
                new Throwable("YELPSOURCE FAILED");
            }
        });
    }
}
