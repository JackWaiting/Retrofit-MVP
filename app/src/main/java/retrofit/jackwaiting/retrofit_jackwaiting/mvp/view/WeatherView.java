package retrofit.jackwaiting.retrofit_jackwaiting.mvp.view;


import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;


public interface WeatherView {

    void showProgress();
    void hideProgress();
    void loadWeatherData(WeatherData weatherData);
    void loadWeatherType(WeatherType body);
}


