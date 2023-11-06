package ui.place;

import static com.example.weather.SunnyWeatherApplication.context;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.MainActivity;
import com.example.weather.R;

import java.util.List;

//import javax.xml.transform.Result;

import logic.model.Place;
import ui.weather.WeatherActivity;

public class PlaceFragment extends Fragment {
    public PlaceViewModel viewModel;
    private PlaceAdapter adapter;
    RecyclerView recyclerView;
    TextView searchPlaceEdit;

    ImageView bgImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {//初始化页面
        View view = inflater.inflate(R.layout.fragment_place, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        searchPlaceEdit = view.findViewById(R.id.searchPlaceEdit);
        bgImageView = view.findViewById(R.id.bgImageView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {//初始化功能
        super.onActivityCreated(savedInstanceState);
        if (viewModel.isPlaceSaved()&&getActivity() instanceof MainActivity) {//数据储存
            Place place = viewModel.getSavedPlace();
            Intent intent = new Intent(context, WeatherActivity.class);
            intent.putExtra("name", place.getName());
            intent.putExtra("TTT", "0");
            intent.putExtra("id", place.getId());
            startActivity(intent);
            if (getActivity() != null) {
                getActivity().finish();
            }
            return;
        }


        viewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        adapter = new PlaceAdapter(this, viewModel.getPlaceList());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        searchPlaceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String content = s.toString();
                if (content != null) {
                    viewModel.searchPlaces(content);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    bgImageView.setVisibility(View.VISIBLE);
                    viewModel.getPlaceList().clear();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewModel.getPlaceLiveData().observe(getViewLifecycleOwner(), new Observer<List<Place>>() {
            @Override
            public void onChanged(List<Place> places) {
                if (places != null) {
                    recyclerView.setVisibility(View.VISIBLE);
                    bgImageView.setVisibility(View.GONE);
                    viewModel.getPlaceList().clear();
                    viewModel.getPlaceList().addAll(places);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "未能查询到任何地点", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
