
package ui.place;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;

import java.util.List;

import logic.model.Place;
import ui.weather.WeatherActivity;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
        private PlaceFragment fragment;
        private List<Place> placeList;
        private Place place;
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView placeName;
            public TextView placeAddress;

            public ViewHolder(View view) {
                super(view);
                placeName = view.findViewById(R.id.placeName);
                placeAddress = view.findViewById(R.id.placeAddress);
            }
        }

        public PlaceAdapter(PlaceFragment fragment, List<Place> placeList) {
            this.fragment = fragment;
            this.placeList = placeList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Place place = placeList.get(viewType);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent(parent.getContext(), WeatherActivity.class);
                        intent.putExtra("name", place.getName());
                        intent.putExtra("id", place.getId());
                        intent.putExtra("TTT", "1");//说明是搜索框进行数据跳转
                        Log.d("TAGG",place.getName());
                        fragment.viewModel.savePlace(place);
                        fragment.startActivity(intent);
                }
            });
            return holder;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            place = placeList.get(position);
            holder.placeName.setText(place.getName());
            holder.placeAddress.setText(place.getCountry()+" "+place.getAdm1()+" "+place.getAdm2());
        }

        @Override
        public int getItemCount() {
            return placeList.size();
        }
}
