package retrofit.jackwaiting.retrofit_jackwaiting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import retrofit.jackwaiting.retrofit_jackwaiting.mvp.WeatherIDUtils;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherData;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean.WeatherType;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.presenter.WeatherPresenter;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.presenter.WeatherPresenterImp;
import retrofit.jackwaiting.retrofit_jackwaiting.mvp.view.WeatherView;

public class MainActivity extends Activity {

    private WeatherPresenter mWeatherPresenter;
    private TextView tvCity,tvDate,tvTemperature,tvWeather_id,tvDressing_advice,tvDressing_index,tv_Uv_index,tvDressing_indexs,tvTravel_index,tvType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCity = (TextView) findViewById(R.id.textView1);
        tvDate = (TextView) findViewById(R.id.textView2);
        tvTemperature = (TextView) findViewById(R.id.textView3);
        tvWeather_id = (TextView) findViewById(R.id.textView4);
        tvDressing_advice = (TextView) findViewById(R.id.textView5);
        tvDressing_index = (TextView) findViewById(R.id.textView6);
        tv_Uv_index = (TextView) findViewById(R.id.textView7);
        tvDressing_indexs = (TextView) findViewById(R.id.textView8);
        tvTravel_index = (TextView) findViewById(R.id.textView9);
        tvType = (TextView) findViewById(R.id.textView10);

        mWeatherPresenter = new WeatherPresenterImp(new WeatherView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void loadWeatherData(WeatherData weatherData) {
                if(weatherData!=null){
                    Log.i("weatherData", "weatherData==" + weatherData.toString());
                    tvCity.setText("城市：" + weatherData.getResult().getToday().getCity());
                    tvDate.setText("日期：" + weatherData.getResult().getToday().getWeek());
                    tvTemperature.setText("今日温度：" + weatherData.getResult().getToday().getTemperature());
                    tvWeather_id.setText("天气标识：" + WeatherIDUtils.transfer(weatherData.getResult().getToday().getWeather_id().getFa()));
                    tvDressing_advice.setText("穿衣指数：" + weatherData.getResult().getToday().getDressing_advice());
                    tvDressing_index.setText("干燥指数：" + weatherData.getResult().getToday().getDressing_index());
                    tv_Uv_index.setText("紫外线强度：" + weatherData.getResult().getToday().getUv_index());
                    tvDressing_indexs.setText("穿衣建议：" + weatherData.getResult().getToday().getDressing_advice());
                    tvTravel_index.setText("旅游指数：" + weatherData.getResult().getToday().getTravel_index());
                }
            }

            @Override
            public void loadWeatherType(WeatherType body) {
                Log.i("weatherData", "weatherData==" + body.getResultcode());
                if(body!=null &&body.getResult()!=null){
                    tvType.setText("'"+body.getResult().get(0).getWeather()+"'+测试成功");
                }
                else{
                    Log.i("weatherData","失败了");
                    tvType.setText("测试失败，请检查key");
                }
            }

        });
       mWeatherPresenter.getWeatherType(0);
       mWeatherPresenter.getWeatherData("2","深圳");

    }




}
