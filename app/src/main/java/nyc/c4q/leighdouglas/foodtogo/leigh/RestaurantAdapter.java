package nyc.c4q.leighdouglas.foodtogo.leigh;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.jon.models.Restaurant;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {
    private List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_viewholder, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public void updateList(ArrayList<Restaurant> list) {
        restaurantList.clear();
        restaurantList.addAll(list);
        notifyDataSetChanged();
    }
}
