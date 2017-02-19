package nyc.c4q.leighdouglas.foodtogo.jon.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;


public class SqlHelper {

    public SqlHelper() {
    }

    public static List<Restaurant> selectAllRestaurants(SQLiteDatabase db) {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            QueryResultIterable<Restaurant> itr = cupboard().withDatabase(db).query(Restaurant.class).query();
            for (Restaurant restaurant : itr) {
                if (restaurant.getisClaimed() == false) {
                    restaurants.add(restaurant);
                }
            }
            itr.close();
        } catch (Exception e) {
            Log.e("Restaurant List", "selectAllRestaurants: ", e);
        }
        return restaurants;
    }

    public Restaurant getRestaurantByName(SQLiteDatabase db, String restaurantName) {
        return cupboard().withDatabase(db).query(Restaurant.class).withSelection("restaurantName = ?", restaurantName).get();
    }
}
