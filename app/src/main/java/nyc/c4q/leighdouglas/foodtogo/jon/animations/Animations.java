package nyc.c4q.leighdouglas.foodtogo.jon.animations;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import nyc.c4q.leighdouglas.foodtogo.R;

/**
 * Created by jonathancolon on 2/21/17.
 */

public class Animations {
    private final Context context;

    public Animations(Context context) {
        this.context = context;
    }

    public void slideInFromTop(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_top);
        view.startAnimation(slideIn);
    }

    public void slideInFromBottom(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_bottom);
        view.startAnimation(slideIn);
    }

    public void slowSlideInFromBottom(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_bottom_slow);
        view.startAnimation(slideIn);
    }

    public void slowSlideInFromTop(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_top_slow);
        view.startAnimation(slideIn);
    }

    public void slideInFromLeft(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_left);
        view.startAnimation(slideIn);
    }

    public void slideInFromRight(View view){
        Animation slideIn = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_right);
        view.startAnimation(slideIn);
    }
}
