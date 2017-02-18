package nyc.c4q.leighdouglas.foodtogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import nyc.c4q.leighdouglas.foodtogo.hyunjoo.RestaurantActivity;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.RunnerActivity;

public class LoginActivity extends AppCompatActivity{

    private EditText emailET, passwordET;
    private RadioButton runnerRadioBtn, restaurantRadioBtn;
    private Button nextBtn;
    private boolean checked;
    private int picked = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        emailET = (EditText) findViewById(R.id.email_ET);
        passwordET = (EditText) findViewById(R.id.password_ET);
        runnerRadioBtn = (RadioButton) findViewById(R.id.runnerRadio_Btn);
        restaurantRadioBtn = (RadioButton) findViewById(R.id.restaurantRadio_Btn);
        nextBtn = (Button) findViewById(R.id.next_Btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (picked == 1) {
                    Toast.makeText(getApplicationContext(), "RUNNER", Toast.LENGTH_LONG).show();
                    Intent runner = new Intent(getApplicationContext(), RunnerActivity.class);
                    startActivity(runner);
                } else if (picked == 2) {
                    Intent restaurant = new Intent(getApplicationContext(), RestaurantActivity.class);
                    startActivity(restaurant);
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.runnerRadio_Btn:
                if (checked)
                    picked = 1;
                Toast.makeText(getApplicationContext(), "RUNNER", Toast.LENGTH_LONG).show();
                break;
            case R.id.restaurantRadio_Btn:
                if (checked)
                    picked = 2;
                break;
        }
    }
}