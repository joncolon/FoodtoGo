package nyc.c4q.leighdouglas.foodtogo.jon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.leighdouglas.foodtogo.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new SplashFragment())
                    .commit();
        }
    }
}


