package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.leighdouglas.foodtogo.R;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpVH extends RecyclerView.ViewHolder {

    private View mRoot;
    public TextView textView;

    public YelpVH(View mView) {
        super(mView);
        mRoot = mView;
        textView = (TextView) mRoot.findViewById(R.id.yelp_TV);
    }
}