package ui.weather;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import logic.model.Weather;
import ui.network.Repository;

public class weatherViewModel extends ViewModel {
    public MutableLiveData<String> locationLiveData = new MutableLiveData<>();
    public String id;

    public LiveData<Weather> weatherLiveData = Transformations.switchMap(locationLiveData, id -> {
        return Repository.refreshWeather(id);
    });

    public void refreshWeather(String id) {
        this.id = id;
        locationLiveData.postValue(id);
    }
}
