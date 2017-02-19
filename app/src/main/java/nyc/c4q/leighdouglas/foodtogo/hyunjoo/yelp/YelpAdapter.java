package nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.hyunjoo.yelp.yelpinfo.YelpHomelessShelters;

/**
 * Created by Hyun on 2/18/17.
 */

public class YelpAdapter extends RecyclerView.Adapter<YelpVH> {

    private List<YelpHomelessShelters> yelpInfoList = new ArrayList<>();
    private LayoutInflater layoutinflater;
    private View mView;

    public YelpAdapter(List<YelpHomelessShelters> yelpHomelessList) {
        yelpInfoList = yelpHomelessList;
        notifyDataSetChanged();
    }

    @Override
    public YelpVH onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutinflater = LayoutInflater.from(parent.getContext());
        mView = layoutinflater.inflate(R.layout.yelp_viewholder, parent, false);
        return new YelpVH(mView);
    }
    @Override
    public void onBindViewHolder(YelpVH holder, int position) {
        holder.setYelpData(yelpInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return yelpInfoList.size();
    }

}
