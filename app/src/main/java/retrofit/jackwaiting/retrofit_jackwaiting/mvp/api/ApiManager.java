package retrofit.jackwaiting.retrofit_jackwaiting.mvp.api;


import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiManager {
    /**
     * 基础地址
     */
    private static final String ENDPOINT = "http://v.juhe.cn";

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();
    private static final ApiManagerService apiManager = sRetrofit.create(ApiManagerService.class);

    /**
     * 获取天气数据
     * @param city
     * @return
     */
    public static Call<WeatherData> getWeatherData(String format, String city) {
        Call<WeatherData> call = apiManager.getWeatherData(format, city, "8ce7c2ac685f5e0f9743d305a68aaf5a");
        return  call;
    }

    /**
     * 获取天气种类
     * @param type
     * @return
     */
    public static Call<WeatherType> getWeatherType(int type) {
        Call<WeatherType> call = apiManager.getWeatherType(type+"", "8ce7c2ac685f5e0f9743d305a68aaf5a");
        return  call;
    }

}
