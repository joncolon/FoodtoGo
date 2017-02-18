package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.leighdouglas.foodtogo.R;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantListActivity extends AppCompatActivity{
    private RecyclerView restaurantRV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
        restaurantRV = (RecyclerView) findViewById(R.id.restaurant_recyclerview);
        restaurantRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //set adapter
    }

    @Override
    protected void onStart() {
        super.onStart();
        //sqlite query
        //update adapter
    }
}
