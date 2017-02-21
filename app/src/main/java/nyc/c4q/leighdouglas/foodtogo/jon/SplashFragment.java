package nyc.c4q.leighdouglas.foodtogo.jon;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.leighdouglas.foodtogo.LoginActivity;
import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.animations.Animations;

/**
 * Created by jonathancolon on 2/21/17.
 */

public class SplashFragment extends Fragment {

    private static final String TAG = SplashFragment.class.getSimpleName();
    private View mRoot;
    private ImageView logo, gradient;
    private TextView appName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_splashscreen, parent, false);

        logo = (ImageView) mRoot.findViewById(R.id.logo);
        gradient = (ImageView) mRoot.findViewById(R.id.gradient);
        appName = (TextView) mRoot.findViewById(R.id.app_name);

        Animations anim = new Animations(mRoot.getContext());

        anim.slowSlideInFromTop(logo);
        anim.slowSlideInFromBottom(gradient);

        Typeface robotoreg = Typeface.createFromAsset(appName.getContext().getApplicationContext().getAssets(), "fonts/paperdaisy_demo.ttf");
        appName.setTypeface(robotoreg);





        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginActivity();
            }
        });
        return mRoot;
    }

    private void startLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        SplashFragment.this.startActivity(intent);
    }



}