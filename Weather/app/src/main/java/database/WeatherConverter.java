package database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import logic.model.Weather;

public class WeatherConverter {
    @TypeConverter
    public static String fromWeather(Weather weather) {
        // 使用 Gson 将 Weather 对象转换成 JSON 字符串
        return new Gson().toJson(weather);
    }
    @TypeConverter
    public static Weather toWeather(String json) {
        // 使用 Gson 将 JSON 字符串转换回 Weather 对象
        return new Gson().fromJson(json, Weather.class);
    }
}

