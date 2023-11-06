
package ui.place;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import logic.model.Place;
import ui.network.Repository;

public class PlaceViewModel extends ViewModel {

    // 保存地点信息
    public static void savePlace(Place place) {
        Repository.savePlace(place);
    }

    // 获取保存的地点信息
    public static Place getSavedPlace() {
        return Repository.getSavedPlace();
    }

    // 检查是否有保存的地点信息
    public static boolean isPlaceSaved() {
        return Repository.isPlaceSaved();
    }

    public  MutableLiveData<String> searchLiveData = new MutableLiveData<>();
    public List<Place> placeList;

    public PlaceViewModel() {
        placeList = new ArrayList<>();
    }

    LiveData<List<Place>> placeLiveData = Transformations.switchMap(searchLiveData, new androidx.arch.core.util.Function<String, LiveData<List<Place>>>() {
        @Override
        public LiveData<List<Place>> apply(String query) {
            return Repository.searchPlaces(query);
        }
    });


    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setSearchData(String query, String apiKey) {
        searchLiveData.setValue(query);
    }

    public void clearPlaceList() {
        if (placeList != null) {
            placeList.clear();
        }
    }
    public void setPlaceList(List<Place> places) {
        placeList = places;
    }
    public void searchPlaces(String content) {
        searchLiveData.setValue(content);
    }
    public LiveData<List<Place>> getPlaceLiveData() {
        return placeLiveData;
    }
}
