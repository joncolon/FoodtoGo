package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTV, address1TV, address2TV, phoneTV, pickupTV, instructionTV;
    private ImageButton claimIB, mapIB;
    private RestaurantAdapter.Listener listener;
    public RestaurantViewHolder(View itemView) {
        super(itemView);
        nameTV = (TextView)itemView.findViewById(R.id.restaurant_name);
        address1TV = (TextView)itemView.findViewById(R.id.address_line1);
        address2TV = (TextView)itemView.findViewById(R.id.address_line2);
        phoneTV = (TextView)itemView.findViewById(R.id.phoneNumber);
        pickupTV = (TextView)itemView.findViewById(R.id.availability);
        mapIB = (ImageButton)itemView.findViewById(R.id.directions);
    }

    public void bind(final Restaurant restaurant){
        nameTV.setText(restaurant.getBusinessName());
        address1TV.setText(restaurant.getAddressLine1());
        address2TV.setText(restaurant.getAddressLine2());
        phoneTV.setText(restaurant.getPhoneNumber());
        pickupTV.setText(restaurant.getPickupTime());

        mapIB.setOnClickListener(v -> {
            Log.d("view holder", "onClick: " + "should start intent");

            Activity parentActivity =((Activity)v.getContext());

            String uri = "http://maps.google.com/maps?daddr=" + restaurant.getAddressLine1();
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            parentActivity.startActivity(intent);
        });

    }
}
