package cn.edu.gdmec.android.mvp.View;

import android.app.ProgressDialog;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

import cn.edu.gdmec.android.mvp.Showbean;
import cn.edu.gdmec.android.mvp.WeatherBean;
import cn.edu.gdmec.android.mvp.presenter.WeatherPresenter;
import cn.edu.gdmec.android.myapplication.R;

public class MainActivity extends AppCompatActivity implements  IWeatherView, View.OnClickListener{
     private TextView tvWeather;
     private TextView tvWeatherYesterday;
     private ProgressDialog progressDialog;
     private WeatherPresenter presenter;
     private Button btn_show;
     private TextView author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_search).setOnClickListener(this);
        findViewById(R.id.btn_beijing_search).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
        tvWeather=(TextView)findViewById(R.id.tv_weather);
        tvWeatherYesterday=(TextView)findViewById(R.id.tv_weather_yesterday);
        presenter=new WeatherPresenter(this);
        author=(TextView)findViewById(R.id.tv_author);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.btn_search:
              presenter.loadWeather("广州");
              break;
          case R.id.btn_beijing_search:
              presenter.loadWeather("北京");
              break;
          case R.id.btn_show:
              presenter.loadShow("作者");

      }
    }

    @Override
    public void showProgress() {
       if(progressDialog!=null&&progressDialog.isShowing()){
           progressDialog.dismiss();
       }
       progressDialog=ProgressDialog.show(MainActivity.this,"","正在获取");
    }

    @Override
    public void hideProgress() {
      if(progressDialog!=null&&progressDialog.isShowing()){
          progressDialog.dismiss();
      }
    }

    @Override
    public void showWeatherData(final WeatherBean weatherBean) {
         runOnUiThread(new TimerTask() {
             @Override
             public void run() {
                 if(weatherBean.getStatus()==304){
                     Toast.makeText(MainActivity.this,weatherBean.getMessage(), Toast.LENGTH_SHORT).show();
                 }else{
                     tvWeather.setText("城市:"+weatherBean.getCity()+"日期:"+weatherBean.getDate()+"温度:"+weatherBean.getData().getWendu());
                     tvWeatherYesterday.setText("昨日天气:"+weatherBean.getData().getYesterday().getLow()+""+weatherBean.getData().getYesterday().getHigh());
                 }
             }
         });
    }

    @Override
    public void showAuthorData(final Showbean showbean) {
        runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                if(showbean.getStart()==304){
                    Toast.makeText(MainActivity.this,showbean.getCount(),Toast.LENGTH_SHORT).show();
                }else{
                    author.setText("作者："+showbean.getBooks()+"图书标题");
                }
            }
        });
    }

    @Override
    public void showLoadFailMsg(final Exception e) {
         runOnUiThread(new TimerTask() {
             @Override
             public void run() {
                 tvWeather.setText("加载数据失败："+ e.toString());
             }
         });
    }
}
