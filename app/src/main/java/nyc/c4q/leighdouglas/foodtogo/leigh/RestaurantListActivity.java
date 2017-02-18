package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;
import nyc.c4q.leighdouglas.foodtogo.jon.sqlite.RestaurantDatabaseHelper;
import nyc.c4q.leighdouglas.foodtogo.jon.sqlite.SqlHelper;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantListActivity extends AppCompatActivity{
    private RecyclerView restaurantRV;
    private List<Restaurant> restaurantList;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
        restaurantRV = (RecyclerView) findViewById(R.id.restaurant_recyclerview);
        restaurantRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RestaurantAdapter adapter = new RestaurantAdapter();
//        adapter.updateList(restaurantList);
        //set adapter
    }

    @Override
    protected void onStart() {
        super.onStart();
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        RestaurantDatabaseHelper dbHelper = RestaurantDatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        restaurantList = SqlHelper.selectAllRestaurants(db);
        RestaurantAdapter adapter = new RestaurantAdapter();
        adapter.updateList(restaurantList);
    }
}
