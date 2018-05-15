package cn.edu.gdmec.android.mvp.model;

import cn.edu.gdmec.android.mvp.Showbean;
import cn.edu.gdmec.android.mvp.WeatherBean;

/**
 * Created by apple on 18/5/15.
 */

public interface ILoadListener {
    void onSuccess(WeatherBean bean);
    void onSuccess(Showbean showbean);
    void onFailure(Exception e);
}
