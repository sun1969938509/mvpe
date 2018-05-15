package cn.edu.gdmec.android.mvp.presenter;

/**
 * Created by apple on 18/5/15.
 */

public interface IWeatherPresenter {
    void loadWeather(String city);
    void loadShow(String author);
}
