package ui.network;
import android.util.Log;

import java.io.IOException;

import logic.model.AirResponse;
import logic.model.NewResponse;
import logic.model.PlaceResponse;
import logic.model.LifeResponse;
import logic.model.TimeResponse;
import logic.model.somedailyresponse;
import retrofit2.Response;

public class SunnyWeatherNetwork {

    private static final PlaceService placeService = ServiceCreator.create(PlaceService.class);//搜索城市
    private static final WeatherService weather=  ServiceCreator.create2(WeatherService.class);//天气信息
    private static final WeatherService life=  ServiceCreator.create3(WeatherService.class);//生活建议

    private static final WeatherService time = ServiceCreator.create4(WeatherService.class); //24小时信息
    private static final WeatherService air = ServiceCreator.create5(WeatherService.class); //24小时信息



    public static PlaceResponse searchPlaces(String query, String apiKey) {
        try {
            Response<PlaceResponse> response = placeService.searchPlaces(query, apiKey).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected HTTP code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 或者抛出适当的异常
        }
    }
    public static  NewResponse getNewdailyweather(String id) {
        try {
            Response<NewResponse> response1 = weather.getNewdailyweather("101010100","1bbbb4d603ae4affa79d4e5824b837d4").execute();
            if (response1.isSuccessful()) {
                return response1.body();
            } else {
                throw new IOException("Unexpected HTTP code: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 或者抛出适当的异常
        }
    }
    public static somedailyresponse getsomedailyweather(String id) {
        try {

            Response<somedailyresponse> response1 = weather.getsomedailyweather("101010100", "1bbbb4d603ae4affa79d4e5824b837d4").execute();
            if (response1.isSuccessful()) {
                return response1.body();
            } else {
                throw new IOException("Unexpected HTTP code: " + response1.code());

            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 或者抛出适当的异常
        }
    }
    public static LifeResponse getdailylife(String id, String type) {
        try {

            Response<LifeResponse> response3 = life.getdailylife(id,"1bbbb4d603ae4affa79d4e5824b837d4",type).execute();
            if (response3.isSuccessful()) {
                return response3.body();
            } else {
                throw new IOException("Unexpected HTTP code: " + response3.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 或者抛出适当的异常
        }
    }


    public static TimeResponse gettime(String id)
    {
        try{
            Response<TimeResponse> response4 = time.gettime(id,"1bbbb4d603ae4affa79d4e5824b837d4").execute();
            if (response4.isSuccessful()) {
                return response4.body();
            } else {
                throw new IOException("Unexpected HTTP code: " + response4.code());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static AirResponse getAir(String id)
    {
        try{
            Response<AirResponse> response5 = air.getAir(id,"1bbbb4d603ae4affa79d4e5824b837d4").execute();
            if (response5.isSuccessful()) {
                return response5.body();
            } else {
                throw new IOException("Unexpected HTTP code: " + response5.code());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
