package retrofit.jackwaiting.retrofit_jackwaiting.mvp.presenter;

import android.util.Log;

import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.model.WeatherModel;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.model.WeatherModelImp;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.view.WeatherView;


public class WeatherPresenterImp  implements WeatherPresenter,WeatherModelImp.WeatherOnListener{

    /**
     * WeatherModel和WeatherView都是通过接口来实现，这就Java设计原则中依赖倒置原则使用
     */
   private WeatherModel mWeatherModel;
   private WeatherView mWeatherView;

    public WeatherPresenterImp( WeatherView mWeatherView) {
        this.mWeatherModel = new WeatherModelImp(this);
        this.mWeatherView = mWeatherView;
    }

    @Override
    public void getWeatherData(String format, String city) {
        mWeatherView.showProgress();
        mWeatherModel.getWeatherData(format,city);
    }

    @Override
    public void getWeatherType(int type) {
        mWeatherView.showProgress();
        mWeatherModel.getWeatherType(type);
    }

    @Override
    public void onSuccessData(WeatherData data) {
        mWeatherView.loadWeatherData(data);
        mWeatherView.hideProgress();
        Log.d("-------", "onSuccess() called with: " + "s = [" + data.toString() + "]");
    }

    @Override
    public void onFailure(Throwable e) {
        mWeatherView.hideProgress();
        Log.d("-------", "onFailure" + e.getMessage());
    }

    @Override
    public void onSuccessType(WeatherType body) {
        Log.d("WeatherData", "onSuccess() called with: " + "body = ["+body+"]");
        mWeatherView.loadWeatherType(body);
        mWeatherView.hideProgress();
    }
}
