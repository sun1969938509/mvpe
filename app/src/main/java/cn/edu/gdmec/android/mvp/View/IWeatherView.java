package cn.edu.gdmec.android.mvp.View;

import cn.edu.gdmec.android.mvp.Showbean;
import cn.edu.gdmec.android.mvp.WeatherBean;

/**
 * Created by apple on 18/5/15.
 */

public interface IWeatherView {
    void showProgress();
    void hideProgress();
    void showWeatherData(WeatherBean weatherBean);
    void showAuthorData(Showbean showbean);
    void showLoadFailMsg(Exception e);
}
