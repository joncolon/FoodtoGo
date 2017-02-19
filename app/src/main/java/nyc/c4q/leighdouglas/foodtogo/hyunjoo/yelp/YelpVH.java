package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpHomelessShelters;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpVH extends RecyclerView.ViewHolder {

    private View mRoot;
    private TextView yelp_homelessTV,yelp_address1,yelpCity,yelpState,yelpZipCode,yelp_phoneNumber,yelpAvailability;
    // TODO: 2/18/17 for later
    private ImageView yelpClaimIcon;
    private ImageButton yelpDirection, yelpClaim;

    public YelpVH(View mView) {
        super(mView);
        mRoot = mView;
        yelpClaimIcon = (ImageView) mRoot.findViewById(R.id.yelp_claim_level_icon);
        yelp_homelessTV = (TextView) mRoot.findViewById(R.id.yelp_homeless_TV);
        yelp_address1 = (TextView) mRoot.findViewById(R.id.yelp_address_line1);
        yelpCity = (TextView) mRoot.findViewById(R.id.yelp_city);
        yelpState = (TextView) mRoot.findViewById(R.id.yelp_state);
        yelpZipCode = (TextView) mRoot.findViewById(R.id.yelp_zipcode);
        yelp_phoneNumber = (TextView) mRoot.findViewById(R.id.yelp_phone_number);
        yelpAvailability = (TextView) mRoot.findViewById(R.id.yelp_availability);
        yelp_homelessTV = (TextView) mRoot.findViewById(R.id.yelp_homeless_TV);
        yelpDirection = (ImageButton) mRoot.findViewById(R.id.yelp_directions);
        yelpClaim = (ImageButton) mRoot.findViewById(R.id.yelp_claim);
    }

    public void setYelpData(YelpHomelessShelters yelpHomelessShelters) {
        yelp_homelessTV.setText(yelpHomelessShelters.getName());
        yelp_address1.setText(yelpHomelessShelters.getLocation().getAddress());
        yelpCity.setText(yelpHomelessShelters.getLocation().getCity());
        yelpState.setText(yelpHomelessShelters.getLocation().getState());
        yelpZipCode.setText(yelpHomelessShelters.getLocation().getZipCode());
        yelp_phoneNumber.setText(yelpHomelessShelters.getPhoneNumber());
    }
}