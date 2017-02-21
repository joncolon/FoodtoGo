package nyc.c4q.leighdouglas.foodtogo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import nyc.c4q.leighdouglas.foodtogo.hyunjoo.RunnerActivity;
import nyc.c4q.leighdouglas.foodtogo.jon.animations.Animations;
import nyc.c4q.leighdouglas.foodtogo.leigh.RestaurantProfileActivity;

public class LoginActivity extends AppCompatActivity {

    private RadioButton runnerRadioBtn, restaurantRadioBtn;
    private CardView login;
    private Button submitBtn;
    private boolean checked;
    private int picked = 0;
    private TextView appName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        login = (CardView) findViewById(R.id.login);
        runnerRadioBtn = (RadioButton) findViewById(R.id.runnerRadio_Btn);
        restaurantRadioBtn = (RadioButton) findViewById(R.id.restaurantRadio_Btn);
        submitBtn = (Button) findViewById(R.id.submit_btn);
        appName = (TextView) findViewById(R.id.app_name);

        Typeface robotoreg = Typeface.createFromAsset(appName.getContext().getApplicationContext().getAssets(), "fonts/paperdaisy_demo.ttf");
        appName.setTypeface(robotoreg);

        Animations anim = new Animations(getApplicationContext());
        anim.slideInFromLeft(login);
        anim.slideInFromRight(submitBtn);

        submitBtn.setOnClickListener(v -> {

            if (picked == 1) {
                Intent runner = new Intent(getApplicationContext(), RunnerActivity.class);
                startActivity(runner);
            } else if (picked == 2) {
                Intent restaurant = new Intent(getApplicationContext(), RestaurantProfileActivity.class);
                startActivity(restaurant);
            } else {
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .playOn(findViewById(R.id.login));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.runnerRadio_Btn:
                if (checked)
                    picked = 1;
                break;
            case R.id.restaurantRadio_Btn:
                if (checked)
                    picked = 2;
                break;
        }
    }
}
