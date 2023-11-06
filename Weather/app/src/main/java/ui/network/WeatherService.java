package ui.network;

import logic.model.AirResponse;
import logic.model.NewResponse;
import logic.model.LifeResponse;
import logic.model.TimeResponse;
import logic.model.somedailyresponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  WeatherService {
    @GET("v7/weather/now?")
     Call<NewResponse> getNewdailyweather(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey       // 必选参数：用户认证key
    );
    @GET("v7/weather/7d?")
    Call<somedailyresponse> getsomedailyweather(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey       // 必选参数：用户认证key
    );

    @GET("v7/indices/1d?")
    Call<LifeResponse> getdailylife(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey,
            @Query("type") String type
    );
    @GET("v7/weather/24h?")
    Call<TimeResponse> gettime(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey
    );

    @GET("v7/air/now?")
    Call<AirResponse> getAir(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey
    );

}
