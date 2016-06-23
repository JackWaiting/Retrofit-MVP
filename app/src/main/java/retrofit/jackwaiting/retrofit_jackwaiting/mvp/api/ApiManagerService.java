package retrofit.jackwaiting.retrofit_jackwaiting.mvp.api;



import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiManagerService {
    /**
     * 获取天气数据
     * @param cityname
     * @param key
     */
    @GET("/weather/index")
    Call<WeatherData> getWeatherData(@Query("format") String format, @Query("cityname") String cityname, @Query("key") String key);

    /**
     * 获取天气种类和标识列表
     * @param dtype
     * @param key
     * @return  http://v.juhe.cn/weather/uni?dtype=&key=8ce7c2ac685f5e0f9743d305a68aaf5a
     */

    @GET("/weather/uni")
    Call<WeatherType> getWeatherType (@Query("dtype") String dtype, @Query("key") String key);

}
