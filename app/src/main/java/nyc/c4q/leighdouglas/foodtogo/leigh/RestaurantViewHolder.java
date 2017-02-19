package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.dropoff.DropOffListActivity;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Runner;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    private Runner currentRunner;
    private ImageButton userClaimed;
    private TextView nameTV, address1TV, address2TV, phoneTV, pickupTV, instructionTV;
    private ImageButton claimIB, mapIB;
    private RestaurantAdapter.Listener listener;

    public RestaurantViewHolder(View itemView) {
        super(itemView);
        nameTV = (TextView) itemView.findViewById(R.id.restaurant_name);
        address1TV = (TextView) itemView.findViewById(R.id.address_line1);
        address2TV = (TextView) itemView.findViewById(R.id.address_line2);
        phoneTV = (TextView) itemView.findViewById(R.id.phoneNumber);
        pickupTV = (TextView) itemView.findViewById(R.id.availability);
        claimIB = (ImageButton) itemView.findViewById(R.id.claim);
        mapIB = (ImageButton) itemView.findViewById(R.id.directions);
    }

    public void bind(final Restaurant restaurant) {
        nameTV.setText(restaurant.getBusinessName());
        address1TV.setText(restaurant.getAddressLine1());
        address2TV.setText(restaurant.getAddressLine2());
        phoneTV.setText(restaurant.getPhoneNumber());
        pickupTV.setText(restaurant.getPickupTime());


        claimIB.setOnClickListener(v -> {

            int NOTIFICATION_ID = 555;

            NotificationCompat.Builder builder = new NotificationCompat.Builder(claimIB.getContext())
                    .setSmallIcon(R.drawable.ic_shopping_cart_black_24dp)
                    .setContentTitle("New Notification")
                    .setContentText("A user has claimed food!");

            // Get the notification manager system service
            NotificationManager notificationManager = (NotificationManager) v.getContext().getSystemService(Context.NOTIFICATION_SERVICE);

            // Setting a notification ID allows you to update the notification later on.
            notificationManager.notify(NOTIFICATION_ID, builder.build());
            restaurant.setClaimed(true);

            Intent intent = new Intent(v.getContext(), DropOffListActivity.class);
            intent.putExtra("Claimed", 1);
            v.getContext().startActivity(intent);

        });

        mapIB.setOnClickListener(v -> {
            Log.d("view holder", "onClick: " + "should start intent");

            Activity parentActivity = ((Activity) v.getContext());

            String uri = "http://maps.google.com/maps?daddr=" + restaurant.getAddressLine1();
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            parentActivity.startActivity(intent);
        });
    }
}

