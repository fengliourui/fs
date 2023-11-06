package ui.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.R;

import java.util.List;

import database.Sum;
import database.SumDao;
import database.SumDatabase;
import logic.model.Air;
import logic.model.Life;
import logic.model.New;
import logic.model.Time;
import logic.model.Weather;
import logic.model.Somedaily;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.view.View;

import com.example.weather.SunnyWeatherApplication;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;



public class WeatherActivity extends AppCompatActivity {
    public weatherViewModel viewModel;
    public DrawerLayout drawerLayout;//这个活动的主要展示布局，一个抽屉布局
    public BottomSheetDialog bottomSheetDialog;//底层抽屉

    public static SumDao database;//数据库
//    private SwipeRefreshLayout swipeRefreshLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ImageView homeButton = findViewById(R.id.home);
        drawerLayout = findViewById(R.id.drawerLayout);
        //数据库
        database= SumDatabase.getSumDatabase(this).sumDao();
        //搜索按钮相关内容
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(drawerView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                super.onDrawerClosed(drawerView);
            }
        });


//        设置状态为透明
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        setContentView(R.layout.activity_weather);


        //1
        viewModel = new ViewModelProvider(this).get(weatherViewModel.class);
        if (viewModel.id == null)//00
        {
            String id = getIntent().getStringExtra("id");
            if (id == null) {
                viewModel.id = " ";
            } else {
                viewModel.id = id;
            }
        }

        viewModel.weatherLiveData.observe(this, weather -> {
            if (weather != null) {
                String name = getIntent().getStringExtra("name");
                String id = getIntent().getStringExtra( "id");
                Sum sum = new Sum(weather,name,id);
                new Thread(new Runnable() {//开辟一个新线程
                    @Override
                    public void run() {
                        if(database.getSumByPlaceId(id)==null)
                        {
                            database.insert(sum);//添加数据库数据
                            Log.d("TAGGG","数据库写入");
                        }
                    }
                }).start();
                showWeatherInfo(weather,name);
            } else {
                Toast.makeText(WeatherActivity.this, "可能今天使用次数用完", Toast.LENGTH_SHORT).show();
            }
        });

        String ttt = getIntent().getStringExtra("TTT");
        //处理打开的视图是搜索还是上次还是报储存
        new Thread(new Runnable() {//开辟一个新线程
            @Override
            public void run() {
              Sum   latestSum =database.getLatestSum();
                if (latestSum != null&&ttt.equals("0")) {//保存上一次退出
                    runOnUiThread(new Runnable() {//保证在主线程中处理UI
                        @Override
                        public void run() {
                            showWeatherInfo(latestSum.getWeather(), latestSum.getPlace());
                        }
                    });
                }else if(latestSum != null&&ttt.equals("2"))//在保存框中点击跳转
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showWeatherInfo(SunnyWeatherApplication.summm1.getWeather(), SunnyWeatherApplication.summm1.getPlace());
                        }
                    });
                }else
                {
                    viewModel.refreshWeather(viewModel.id);
                }
            }
        }).start();
   }

    private void showWeatherInfo(Weather weather,String name) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SunnyWeatherApplication.summm2=database.getAllSums();
            }
        }).start();
        //获取相关功能的变量
        New aNew = weather.getNewdaily();
        List<Somedaily> somedaily=weather.getSomedaily();
        List<Life> life = weather.getLife();
        List<Time> times= weather.getTime();
        Air air = weather.getAir();

        //多天的数据
        RecyclerView timeRecyclerView = findViewById(R.id.timeLayout);
        timeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        TimeAdapter timeAdapter = new TimeAdapter(times,this);
        timeRecyclerView.setAdapter(timeAdapter);




        //生活点击事件
        RelativeLayout recyclerView1 =findViewById(R.id.life1);
        RelativeLayout recyclerView2 =findViewById(R.id.life2);
        RelativeLayout recyclerView3 =findViewById(R.id.life3);
        RelativeLayout recyclerView4 =findViewById(R.id.life4);
        RelativeLayout recyclerView5 =findViewById(R.id.life5);
        RelativeLayout recyclerView6 =findViewById(R.id.life6);

//        BottomSheetLayout bottomSheetLayout = findViewById(R.id.bottomSheetLayout);
//        TextView textViewInBottomSheet = findViewById(R.id.textViewInBottomSheet);


        // 定义变量
        TextView placeName = findViewById(R.id.placename);
        TextView currentTemp = findViewById(R.id.currentTemp);
        TextView feelsLike = findViewById(R.id.feelsLike);
        TextView weathertext = findViewById(R.id.weathertext);

        ImageView buttonjia = findViewById(R.id.tianjia);
        LinearLayout forecastLayout = findViewById(R.id.forecastLayout);

        TextView  coldRiskText = findViewById(R.id.coldRiskText);
        TextView  dressingText =findViewById(R.id.dressingText);
        TextView  ultravioletText =findViewById(R.id.ultravioletText);
        TextView  carWashingtext = findViewById(R.id.carWashingText);
        TextView  diaoyu = findViewById(R.id.diaoyuText);
        TextView fs = findViewById(R.id.fsText);

        TextView airweight =findViewById(R.id.kqText);
        TextView pm=findViewById(R.id.pmText);
        TextView tx =findViewById(R.id.txText);

        //开始导入现在的数据

//        Log.e("TAG", );
        if (placeName != null) {
            placeName.setText(name);//城市名字
        } else {
            Log.e("TAG", "在布局中找不到placeName TextView");
        }
        currentTemp.setText(aNew.getTemp()+"℃");
        feelsLike.setText("体感  "+aNew.getFeelsLike()+"℃");
        weathertext.setText(aNew.getText());
        buttonjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(WeatherActivity.this,baocun.class);
            startActivity(intent);
            }
        });





        //导入未来几天的数据
        // 填充forecast.xml 布局中的数据
        forecastLayout.removeAllViews();//清空布局确保之前这个布局是干净的
        for (int i = 0; i < 7; i++) {//前面导入了7天的数据
            Somedaily somedaily1= somedaily.get(i);
            // 创建一个新的视图，使用 forecast_item 作为模板
            View view = LayoutInflater.from(this).inflate(R.layout.forcast_item, forecastLayout, false);
            // 在新视图中找到日期信息的 TextView 组件
            TextView dateInfo = view.findViewById(R.id.dateInfo);
            dateInfo.setText(somedaily1.getFxDate());
            // 在新视图中找到天气图标的 ImageView 组件
            TextView textView = view.findViewById(R.id.skyIcon);
            Typeface font = Typeface.createFromAsset(getAssets(), "qweather-icons.ttf");//加载图标字体
            textView.setTypeface(font);//设置textView使用图标字体。
            String iconday= somedaily1.getIconDay();
            if (iconday.equals("100")){
                textView.setText(Html.fromHtml("&#xF101;"));
            }else if(iconday.equals("101")){
                textView.setText(Html.fromHtml("&#xF102;"));
            }else if(iconday.equals("102")) {
                textView.setText(Html.fromHtml("&#xF103;"));
            }else if(iconday.equals("103")) {
                textView.setText(Html.fromHtml("&#xF104;"));
            }else if(iconday.equals("104")) {
                textView.setText(Html.fromHtml("&#xF105;"));
            }else if(iconday.equals("150")) {
                textView.setText(Html.fromHtml("&#xF106;"));
            }else if(iconday.equals("151")) {
                textView.setText(Html.fromHtml("&#xF107;"));
            }else if(iconday.equals("152")) {
                textView.setText(Html.fromHtml("&#xF108;"));
            }else if(iconday.equals("153")) {
                textView.setText(Html.fromHtml("&#xF109;"));
            } else if(iconday.equals("300")) {
                textView.setText(Html.fromHtml("&#xF10A;"));
            }else if(iconday.equals("301")) {
                textView.setText(Html.fromHtml("&#xF10B;"));
            }else if(iconday.equals("302")) {
                textView.setText(Html.fromHtml("&#xF10C;"));
            }else if(iconday.equals("303")) {
                textView.setText(Html.fromHtml("&#xF10D;"));
            }else if(iconday.equals("304")) {
                textView.setText(Html.fromHtml("&#xF10E;"));
            }else if(iconday.equals("305")) {
                textView.setText(Html.fromHtml("&#xF10F;"));
            }else if(iconday.equals("306")) {
                textView.setText(Html.fromHtml("&#xF110;"));
            }else if(iconday.equals("307")) {
                textView.setText(Html.fromHtml("&#xF111;"));
            }else if(iconday.equals("308")) {
                textView.setText(Html.fromHtml("&#xF112;"));
            }else if(iconday.equals("309")) {
                textView.setText(Html.fromHtml("&#xF113;"));
            }else if(iconday.equals("310")) {
                textView.setText(Html.fromHtml("&#xF114;"));
            }else if(iconday.equals("311")) {
                textView.setText(Html.fromHtml("&#xF115;"));
            }else if(iconday.equals("312")) {
                textView.setText(Html.fromHtml("&#xF116;"));
            }else if(iconday.equals("313")) {
                textView.setText(Html.fromHtml("&#xF117;"));
            }else if(iconday.equals("314")) {
                textView.setText(Html.fromHtml("&#xF118;"));
            }else if(iconday.equals("315")) {
                textView.setText(Html.fromHtml("&#xF119;"));
            }else if(iconday.equals("316")) {
                textView.setText(Html.fromHtml("&#xF11A;"));
            }else if(iconday.equals("317")) {
                textView.setText(Html.fromHtml("&#xF11B;"));
            }else if(iconday.equals("318")) {
                textView.setText(Html.fromHtml("&#xF11C;"));
            }else if(iconday.equals("399")) {
                textView.setText(Html.fromHtml("&#xF11F;"));
            }else if(iconday.equals("350")) {
                textView.setText(Html.fromHtml("&#xF11D;"));
            }else if(iconday.equals("351")) {
                textView.setText(Html.fromHtml("&#xF11E;"));
            }else if(iconday.equals("400")) {
                textView.setText(Html.fromHtml("&#xF120;"));
            }else if(iconday.equals("401")) {
                textView.setText(Html.fromHtml("&#xF121;"));
            }else if(iconday.equals("402")) {
                textView.setText(Html.fromHtml("&#xF122;"));
            }else if(iconday.equals("403")) {
                textView.setText(Html.fromHtml("&#xF123;"));
            }else if(iconday.equals("404")) {
                textView.setText(Html.fromHtml("&#xF124;"));
            }else if(iconday.equals("405")) {
                textView.setText(Html.fromHtml("&#xF125;"));
            }else if(iconday.equals("406")) {
                textView.setText(Html.fromHtml("&#xF126;"));
            }else if(iconday.equals("407")) {
                textView.setText(Html.fromHtml("&#xF127;"));
            }else if(iconday.equals("408")) {
                textView.setText(Html.fromHtml("&#xF128;"));
            }else if(iconday.equals("409")) {
                textView.setText(Html.fromHtml("&#xF129;"));
            }else if(iconday.equals("410")) {
                textView.setText(Html.fromHtml("&#xF12A;"));
            }else if(iconday.equals("456")) {
                textView.setText(Html.fromHtml("&#xF12B;"));
            }else if(iconday.equals("457")) {
                textView.setText(Html.fromHtml("&#xF12C;"));
            }else if(iconday.equals("499")) {
                textView.setText(Html.fromHtml("&#xF12D;"));
            }else if(iconday.equals("500")) {
                textView.setText(Html.fromHtml("&#xF12E;"));
            }else if(iconday.equals("501")) {
                textView.setText(Html.fromHtml("&#xF12F;"));
            }else if(iconday.equals("502")) {
                textView.setText(Html.fromHtml("&#xF130;"));
            }else if(iconday.equals("503")) {
                textView.setText(Html.fromHtml("&#xF131;"));
            }else if(iconday.equals("504")) {
                textView.setText(Html.fromHtml("&#xF132;"));
            }else if(iconday.equals("507")) {
                textView.setText(Html.fromHtml("&#xF133;"));
            }else if(iconday.equals("508")) {
                textView.setText(Html.fromHtml("&#xF134;"));
            }else if(iconday.equals("509")) {
                textView.setText(Html.fromHtml("&#xF135;"));
            }else if(iconday.equals("510")) {
                textView.setText(Html.fromHtml("&#xF136;"));
            }else if(iconday.equals("511")) {
                textView.setText(Html.fromHtml("&#xF137;"));
            }else if(iconday.equals("512")) {
                textView.setText(Html.fromHtml("&#xF138;"));
            }else if(iconday.equals("513")) {
                textView.setText(Html.fromHtml("&#xF139;"));
            }else if(iconday.equals("514")) {
                textView.setText(Html.fromHtml("&#xF13A;"));
            }else if(iconday.equals("515")) {
                textView.setText(Html.fromHtml("&#xF13B;"));
            }else if(iconday.equals("900")) {
                textView.setText(Html.fromHtml("&#xF144;"));
            }else if(iconday.equals("901")) {
                textView.setText(Html.fromHtml("&#xF145;"));
            }else{
                textView.setText(Html.fromHtml("&#xF146;"));
            }





            // 在新视图中找到天气信息的 TextView 组件
            TextView skyInfo = view.findViewById(R.id.skyInfo);
            if(somedaily1.getTextDay().equals("晴")&&!somedaily1.getTextNight().equals("晴"))
            {
                skyInfo.setText(somedaily1.getTextNight());
            }
            else if(somedaily1.getTextNight().equals("晴")&&!somedaily1.getTextDay().equals("晴"))
            {
                skyInfo.setText(somedaily1.getTextDay());
            }
            else
            {
                skyInfo.setText(somedaily1.getTextDay());
            }
            // 在新视图中找到温度信息的 TextView 组件
            TextView temperatureInfo = view.findViewById(R.id.temperatureInfo);
            temperatureInfo.setText(somedaily1.getTempMin()+"℃ " + "~ " +somedaily1.getTempMax()+"℃");
            // 将填充好数据的新视图添加到 forecastLayout 布局中
            forecastLayout.addView(view);
        }
        //开始写生活助手
        coldRiskText.setText(life.get(8).getCategory());
        diaoyu.setText(life.get(3).getCategory());
        dressingText.setText(life.get(2).getCategory());
        carWashingtext.setText(life.get(1).getCategory());
        fs.setText(life.get(15).getCategory());
        ultravioletText.setText(life.get(0).getCategory());


        // 初始化 BottomSheetDialog
        bottomSheetDialog = new BottomSheetDialog(WeatherActivity.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet);
        // 设置点击外部区域关闭
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        // 可选：设置行为
        View bottomSheetView = bottomSheetDialog.findViewById(R.id.bottomsheet);
        TextView bottomtext=bottomSheetView.findViewById(R.id.bottom);
        if (bottomSheetView != null) {
            BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheetView);
            behavior.setPeekHeight(500); // 设置最小高度
        }
        recyclerView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(8).getText());
                bottomSheetDialog.show();
            }
        });
        recyclerView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(3).getText());
                bottomSheetDialog.show();
            }
        });
        recyclerView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(2).getText());
                bottomSheetDialog.show();
            }
        });
        recyclerView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(1).getText());
                bottomSheetDialog.show();
            }
        });
        recyclerView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(15).getText());
                bottomSheetDialog.show();
            }
        });
        recyclerView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomtext.setText(life.get(0).getText());
                bottomSheetDialog.show();
            }
        });
        //空气问题
        airweight.setText(air.getCategory());
        pm.setText(air.getPm2p5());
        if(air.getPrimary()==null)
        {
            tx.setText("质量较好");
        }
        else {
            tx.setText(air.getPrimary());
        }
    }
}