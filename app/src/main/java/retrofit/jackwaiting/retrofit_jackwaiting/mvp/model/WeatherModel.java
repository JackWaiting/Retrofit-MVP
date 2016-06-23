package retrofit.jackwaiting.retrofit_jackwaiting.mvp.model;


public interface WeatherModel {
    /**
     * 获取天气信息
     * @param format
     * @param city
     */
    void getWeatherData(String format, String city);

    void getWeatherType(int type);
}
