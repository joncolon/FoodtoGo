package nyc.c4q.leighdouglas.foodtogo.hyunjoo.dropoff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpSource;

/**
 * Created by Hyun on 2/18/17.
 */
public class DropOffListActivity extends AppCompatActivity {

    private RecyclerView mDropOffRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);

        mDropOffRecycler = (RecyclerView) findViewById(R.id.restaurant_recyclerview);
        mDropOffRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        YelpSource.getHomelessList(mDropOffRecycler);
    }


}
