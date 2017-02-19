package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.database.sqlite.SQLiteDatabase;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;
import nyc.c4q.leighdouglas.foodtogo.jon.sqlite.RestaurantDatabaseHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantProfileActivity extends AppCompatActivity {
    private SQLiteDatabase db;


    private static final int NOTIFICATION_ID = 555;
    private EditText businessName;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText phoneNumber;
    private EditText contactName;
    private EditText pickupTime;
    private EditText additionInstructions;
    private Button notifyButton;
    private NotificationCompat.Builder nCBuilder;
    long requestID;
    private PendingIntent pIntent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantprofile);
        initViews();

    }

    private void initViews() {
        businessName = (EditText) findViewById(R.id.business_name);
        addressLine1 = (EditText) findViewById(R.id.address_line1);
        addressLine2 = (EditText) findViewById(R.id.address_line2);
        phoneNumber = (EditText) findViewById(R.id.business_phone);
        contactName = (EditText) findViewById(R.id.contact_name);
        pickupTime = (EditText) findViewById(R.id.pick_up_time);
        additionInstructions = (EditText) findViewById(R.id.additional_instructions);
        notifyButton = (Button) findViewById(R.id.notify_button);
        requestID = System.currentTimeMillis();
        final Intent intent = new Intent(getApplicationContext(), RestaurantListActivity.class);

        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formIsntComplete()) {


                    pIntent = PendingIntent.getActivity(getApplicationContext(), (int) requestID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    nCBuilder = (NotificationCompat.Builder)
                            new NotificationCompat.Builder(notifyButton.getContext()).setContentIntent(pIntent)
                                    .setSmallIcon(R.drawable.ic_shopping_cart_black_24dp)
                                    .setContentTitle("Free food at " + businessName.getText())
                                    .setContentInfo("pick up item by ");
                    final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(NOTIFICATION_ID, nCBuilder.build());
                } else {
                    Toast.makeText(getApplicationContext(), "Complete form before notifying", Toast.LENGTH_SHORT).show();
                }
                Restaurant restaurant = createRestaurantFromEditTexts();
                saveRestaurant(restaurant);
            }
        });
    }

    private boolean formIsntComplete() {
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
