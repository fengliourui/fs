package logic.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.weather.SunnyWeatherApplication;
import com.google.gson.Gson;

import logic.model.Place;

public class PlaceDao {
    // 保存地点信息
    public static void savePlace(Place place) {
        SharedPreferences.Editor editor = sharedPreferences().edit();
        editor.putString("place", new Gson().toJson(place));
        editor.apply();
    }

    // 获取保存的地点信息
    public static Place getSavedPlace() {
        String placeJson = sharedPreferences().getString("place", "");
        return new Gson().fromJson(placeJson, Place.class);
    }

    // 检查是否有保存的地点信息
    public static boolean isPlaceSaved() {
        return sharedPreferences().contains("place");
    }

    private static SharedPreferences sharedPreferences() {
        return SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE);
    }
}
