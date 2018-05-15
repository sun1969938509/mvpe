package cn.edu.gdmec.android.mvp.utils;

import com.google.gson.Gson;

import cn.edu.gdmec.android.mvp.Showbean;
import cn.edu.gdmec.android.mvp.WeatherBean;

/**
 * Created by apple on 18/5/15.
 */

public class JsonUtils {
    public static WeatherBean getWeather(String res){
        Gson gson=new Gson();
        WeatherBean weatherBean=gson.fromJson(res,WeatherBean.class);
        return weatherBean;
    }

    public static Showbean getShow(String res) {
        Gson gson=new Gson();
        Showbean showbean=gson.fromJson(res,Showbean.class);
        return showbean;
    }
}
