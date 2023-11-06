package ui.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import logic.dao.PlaceDao;
import logic.model.AirResponse;
import logic.model.LifeResponse;
import logic.model.NewResponse;
import logic.model.Place;
import logic.model.PlaceResponse;
import logic.model.TimeResponse;
import logic.model.Weather;
import logic.model.somedailyresponse;

public class Repository {
    // 保存地点信息
    public static void savePlace(Place place) {
        PlaceDao.savePlace(place);
    }
    // 获取保存的地点信息
    public static Place getSavedPlace() {
        return PlaceDao.getSavedPlace();
    }

    // 检查是否有保存的地点信息
    public static boolean isPlaceSaved() {
        return PlaceDao.isPlaceSaved();
    }


    public static LiveData<List<Place>> getPlaceLiveData(MutableLiveData<String> searchLiveData, MutableLiveData<String> apiKeyLiveData) {
        return Transformations.switchMap(searchLiveData, query -> {
            MutableLiveData<List<Place>> resultLiveData = new MutableLiveData<>();
            String apiKey = apiKeyLiveData.getValue();
            if (apiKey != null) {
                searchPlaces(query);
            }
            return resultLiveData;
        });
    }

    public interface ResultCallback<T> {
        void onSuccess(T result);

        void onFailure(Exception e);
    }

    public static LiveData<List<Place>> searchPlaces(String query) {
        MutableLiveData<List<Place>> resultLiveData = new MutableLiveData<>();
        new Thread(() -> {
            PlaceResponse placeResponse = SunnyWeatherNetwork.searchPlaces(query, "1bbbb4d603ae4affa79d4e5824b837d4");

            if ("200".equals(placeResponse.getStatus())) {
                List<Place> places = placeResponse.getPlaces();
                resultLiveData.postValue(places);
            } else {
                resultLiveData.postValue(null); // 或者传递一个默认值或错误信息
            }
        }).start();
        return resultLiveData;
    }

    public static LiveData<Weather> refreshWeather(String id) {
        MutableLiveData<Weather> liveData = new MutableLiveData<>();
        new Thread(() -> {
            NewResponse newdailyweather = SunnyWeatherNetwork.getNewdailyweather(id);
            somedailyresponse somedailyresponse = SunnyWeatherNetwork.getsomedailyweather(id);
            LifeResponse lifeResponse = SunnyWeatherNetwork.getdailylife(id, "0");
            TimeResponse timeResponse = SunnyWeatherNetwork.gettime(id);
            AirResponse airResponse = SunnyWeatherNetwork.getAir(id);


            if(newdailyweather != null&&somedailyresponse!=null&&lifeResponse!=null&&timeResponse!=null)
            {
                if (newdailyweather.getCode().equals("200") && somedailyresponse.getCode().equals("200")&&lifeResponse.getCode().equals("200")) {
                    Weather weather = new Weather(newdailyweather.getNow(),somedailyresponse.getDaily(),lifeResponse.getDaily(),timeResponse.getHourly(),airResponse.getNow());
                    liveData.postValue(weather);
                } else {

                    liveData.postValue(null); // 或者传递一个默认值或错误信息
                }
            }
        }).start();

        return liveData;
    }
}
