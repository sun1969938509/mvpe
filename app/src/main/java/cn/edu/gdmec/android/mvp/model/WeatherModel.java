package cn.edu.gdmec.android.mvp.model;

import cn.edu.gdmec.android.mvp.Showbean;
import cn.edu.gdmec.android.mvp.WeatherBean;
import cn.edu.gdmec.android.mvp.utils.OkHttpUtils;
import okhttp3.OkHttpClient;

/**
 * Created by apple on 18/5/15.
 */

public class WeatherModel  implements  IWeatherModel{
    @Override
    public void loadWeather(String url, final ILoadListener loadListener) {
        OkHttpUtils.ResultCallback resultCallback=new OkHttpUtils.ResultCallback() {
            @Override
            public void getWeather(WeatherBean weatherBean) {
                loadListener.onSuccess(weatherBean);
            }

            @Override
            public void getShow(Showbean showbean) {
            }


            @Override
            public void onFailure(Exception e) {
            loadListener.onFailure(e);
            }
        };
        OkHttpUtils.getResultCallback(url,resultCallback);
    }



    @Override
    public void loadshow(String url2, final ILoadListener loadListener) {
                OkHttpUtils.ResultCallback resultCallback1=new OkHttpUtils.ResultCallback() {
            public void getShow(Showbean showbean) {
                loadListener.onSuccess(showbean);
            }

                    @Override
                    public void getWeather(WeatherBean weatherBean) {
                    }

                    @Override
            public void onFailure(Exception e) {
                loadListener.onFailure(e);
            }
        };
           OkHttpUtils.getShowRequest(url2,resultCallback1);
    }


}
