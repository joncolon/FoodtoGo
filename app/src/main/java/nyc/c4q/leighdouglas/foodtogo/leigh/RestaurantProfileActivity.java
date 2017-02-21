package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.skyfishjy.library.RippleBackground;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.animations.Animations;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;
import nyc.c4q.leighdouglas.foodtogo.jon.sqlite.RestaurantDatabaseHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantProfileActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 555;
    long requestID;
    private SQLiteDatabase db;
    private FloatingActionButton addRestaurantButton;
    private EditText businessName;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText phoneNumber;
    private EditText contactName;
    private EditText pickupTime;
    private EditText additionInstructions;
    private NotificationCompat.Builder nCBuilder;
    private PendingIntent pIntent;
    private CardView businessInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantprofile);
        initViews();
        initUpSubmitButton();
        addRestaurantButton.setVisibility(View.GONE);
        Animations anim = new Animations(getApplicationContext());
        anim.slideInFromTop(businessInfo);
    }

    private void initViews() {
        businessInfo = (CardView) findViewById(R.id.business_info_card);
        businessName = (EditText) findViewById(R.id.business_name);
        addressLine1 = (EditText) findViewById(R.id.address_line1);
        addressLine2 = (EditText) findViewById(R.id.address_line2);
        phoneNumber = (EditText) findViewById(R.id.business_phone);
        contactName = (EditText) findViewById(R.id.contact_name);
        pickupTime = (EditText) findViewById(R.id.pick_up_time);
        addRestaurantButton = (FloatingActionButton) findViewById(R.id.fab_add_restaurant);
        additionInstructions = (EditText) findViewById(R.id.additional_instructions);

        additionInstructions.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                addRestaurantButton.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addRestaurantButton.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceInUp)
                        .duration(700)
                        .playOn(findViewById(R.id.fab_add_restaurant));
            }
        });

        requestID = System.currentTimeMillis();
    }



    private void initUpSubmitButton() {
        addRestaurantButton.setOnClickListener(view -> {

            final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
            final Intent intent = new Intent(getApplicationContext(), RestaurantListActivity.class);
            pIntent = PendingIntent.getActivity(getApplicationContext(), (int) requestID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            nCBuilder = (NotificationCompat.Builder)
                    new NotificationCompat.Builder(addRestaurantButton.getContext()).setContentIntent(pIntent)
                            .setSmallIcon(R.drawable.leaflogo_small)
                            .setContentTitle("Free food at " + businessName.getText())
                            .setContentInfo("Enjoy our second helping!");
            final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFICATION_ID, nCBuilder.build());

            Restaurant restaurant = createRestaurantFromEditTexts();
            saveRestaurant(restaurant);

            Toast.makeText(RestaurantProfileActivity.this, "Post successful!", Toast.LENGTH_SHORT).show();
            rippleBackground.startRippleAnimation();
        });
    }

    private boolean isFormComplete() {
        boolean bool = !(businessName.getText() + "").equals("") &&
                !(addressLine1.getText() + "").equals("") &&
                !(addressLine2.getText() + "").equals("") &&
                !(phoneNumber.getText() + "").equals("") &&
                !(contactName.getText() + "").equals("") &&
                !(pickupTime.getText() + "").equals("");

        return bool;
    }

    @NonNull
    private Restaurant createRestaurantFromEditTexts() {
        Restaurant restaurant = new Restaurant();
        restaurant.setBusinessName(businessName.getText().toString());
        restaurant.setAddressLine1(addressLine1.getText().toString());
        restaurant.setAddressLine2(addressLine2.getText().toString());
        restaurant.setPhoneNumber(phoneNumber.getText().toString());
        restaurant.setPickupTime(pickupTime.getText().toString());
        restaurant.setAdditionalInstructions(additionInstructions.getText().toString());
        return restaurant;
    }

    private void saveRestaurant(Restaurant restaurant) {
        RestaurantDatabaseHelper dbHelper = RestaurantDatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        cupboard().withDatabase(db).put(restaurant);
    }

}
