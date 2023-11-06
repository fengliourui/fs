package ui.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.weather.R;
import com.example.weather.SunnyWeatherApplication;

public class baocun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.baocun);
        RecyclerView baocRecycleView = findViewById(R.id.baocrecyclerView);
        baocRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        BaocunAdapter baocunAdapter = new BaocunAdapter(SunnyWeatherApplication.summm2,this);
        int  t = SunnyWeatherApplication.summm2.size();
        Log.d("TAGG","数据库获取长度 0000000"+t);
        baocRecycleView.setAdapter(baocunAdapter);
    }
}