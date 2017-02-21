package nyc.c4q.leighdouglas.foodtogo.hyunjoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.dropoff.DropOffListActivity;
import nyc.c4q.leighdouglas.foodtogo.leigh.RestaurantListActivity;

/**
 * Created by Hyun on 2/18/17.
 */

public class RunnerActivity extends AppCompatActivity{

    private ImageButton dropOffBtn, pickUpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner);
        initViews();
    }

    private void initViews() {
        dropOffBtn = (ImageButton) findViewById(R.id.dropoff_btn);
        pickUpBtn = (ImageButton) findViewById(R.id.pickup_btn);
    }

    public void runnerButtons(View v) {
        switch(v.getId()){
            case R.id.dropoff_btn:
                Intent dropOff = new Intent(getApplicationContext(), DropOffListActivity.class);
                startActivity(dropOff);
                break;
            case R.id.pickup_btn:
                Intent pickUp = new Intent(getApplicationContext(), RestaurantListActivity.class);
                startActivity(pickUp);
                break;
        }
    }
}
