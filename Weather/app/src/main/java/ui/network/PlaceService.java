package ui.network;

import logic.model.PlaceResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {

    @GET("v2/city/lookup?")
    Call<PlaceResponse>  searchPlaces(
            @Query("location") String location,  // 必选参数：需要查询地区的名称
            @Query("key") String apiKey       // 必选参数：用户认证key
    );
}
