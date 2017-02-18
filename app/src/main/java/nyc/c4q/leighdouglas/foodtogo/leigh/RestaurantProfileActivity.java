package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.leighdouglas.foodtogo.R;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantProfileActivity extends AppCompatActivity {

    private EditText businessName;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText phoneNumber;
    private EditText contactName;
    private EditText pickupTime;
    private EditText additionInstructions;
    private Button notifyButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantprofile);

        initViews();

    }

    private void initViews(){
        businessName = (EditText) findViewById(R.id.business_name);
        addressLine1 = (EditText) findViewById(R.id.address_line1);
        addressLine2 = (EditText) findViewById(R.id.address_line2);
        phoneNumber = (EditText) findViewById(R.id.business_phone);
        contactName = (EditText) findViewById(R.id.contact_name);
        pickupTime = (EditText) findViewById(R.id.pick_up_time);
        additionInstructions = (EditText) findViewById(R.id.additional_instructions);
        notifyButton = (Button) findViewById(R.id.notify_button);

        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save data to sqlite database
                //make phone notification
            }
        });
    }
}
