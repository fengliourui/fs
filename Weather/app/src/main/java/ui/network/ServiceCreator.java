package ui.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://geoapi.qweather.com/") // 设置基础 URL
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析器
            .build();
    static Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl("https://devapi.qweather.com/") // 设置基础 URL
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析器
            .build();
    static Retrofit retrofit3 = new Retrofit.Builder()
            .baseUrl("https://devapi.qweather.com/") // 设置基础 URL
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析器
            .build();

    static Retrofit retrofit4 = new Retrofit.Builder()
            .baseUrl("https://devapi.qweather.com/") // 设置基础 URL
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析器
            .build();

    static Retrofit retrofit5 = new Retrofit.Builder()
            .baseUrl("https://devapi.qweather.com/") // 设置基础 URL
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析器
            .build();
    public static <T> T create(Class<T> serviceClass) { return retrofit.create(serviceClass);}
    public static <T> T create2(Class<T> serviceClass) {
        return retrofit2.create(serviceClass);
    }

    public static <T> T create3(Class<T> serviceClass) {
        return retrofit3.create(serviceClass);
    }


    public static <T> T create4(Class<T> serviceClass) { return retrofit4.create(serviceClass); }
    public static <T> T create5(Class<T> serviceClass) { return retrofit5.create(serviceClass); }
}
