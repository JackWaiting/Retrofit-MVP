package retrofit.jackwaiting.retrofit_jackwaiting.mvp.model;


import android.util.Log;

import retrofit.jackwaiting.retrofit_jackwaiting.mvp.api.ApiManager;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeatherModelImp  implements WeatherModel {

    private WeatherOnListener mWeatherOnListener;


    public WeatherModelImp(WeatherOnListener mWeatherOnListener) {
        this.mWeatherOnListener = mWeatherOnListener;
    }

    @Override
    public void getWeatherData(String format,String city) {
        ApiManager.getWeatherData(format,city).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                mWeatherOnListener.onSuccessData(response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                mWeatherOnListener.onFailure(t);
            }
        });
    }

    @Override
    public void getWeatherType(int type) {
        ApiManager.getWeatherType(type).enqueue(new Callback<WeatherType>() {
            @Override
            public void onResponse(Call<WeatherType> call, Response<WeatherType> response) {
                Log.i("WeatherData","response.body()="+response.body());
                mWeatherOnListener.onSuccessType(response.body());
            }

            @Override
            public void onFailure(Call<WeatherType> call, Throwable t) {
                mWeatherOnListener.onFailure(t);
            }
        });
    }

    //以下为RXJava回调方式。
   /* ApiManager.getWeatherData(format, city).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<WeatherData>() {
        @Override
        public void call(WeatherData weatherData) {
            mWeatherOnListener.onSuccess(weatherData);
        }
    }, new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mWeatherOnListener.onFailure(throwable);
        }
    });*/

    public interface WeatherOnListener{
        void onSuccessData(WeatherData s);
        void onFailure(Throwable e);
        void onSuccessType(WeatherType body);
    }
}
