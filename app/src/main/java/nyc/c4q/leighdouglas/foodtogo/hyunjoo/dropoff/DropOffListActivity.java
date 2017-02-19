package nyc.c4q.leighdouglas.foodtogo.hyunjoo.dropoff;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpSource;
import nyc.c4q.leighdouglas.foodtogo.leigh.RestaurantListActivity;

/**
 * Created by Hyun on 2/18/17.
 */
public class DropOffListActivity extends AppCompatActivity {

    private RecyclerView mDropOffRecycler;
    private Button optOutBttn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropoff);

        optOutBttn = (Button) findViewById(R.id.opt_out);
        optOutBttn.setVisibility(View.GONE);
        getIntent().getIntExtra("Claimed", 0);

        if (getIntent().getIntExtra("Claimed", 0) == 1) {
            optOutBttn.setVisibility(View.VISIBLE);
        }

        mDropOffRecycler = (RecyclerView) findViewById(R.id.drop_off_recyclerview);
        mDropOffRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        YelpSource.getHomelessList(mDropOffRecycler);


        optOutBttn = (Button) findViewById(R.id.opt_out);
        optOutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int NOTIFICATION_ID = 555;

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_shopping_cart_black_24dp)
                        .setContentTitle("On no!")
                        .setContentText("The user is no longer able to pick-up");

                // Get the notification manager system service
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // Setting a notification ID allows you to update the notification later on.
                notificationManager.notify(NOTIFICATION_ID, builder.build());

                view.getContext().startActivity(new Intent(getApplicationContext(), RestaurantListActivity.class));
            }
        });

    }


}
