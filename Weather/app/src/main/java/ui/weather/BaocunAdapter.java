package ui.weather;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.SunnyWeatherApplication;

import java.util.List;

import database.Sum;

public class BaocunAdapter extends RecyclerView.Adapter<BaocunAdapter.baocunViewHolder> {

    private List<Sum> sums;

    private Context weatherActivity;

    public BaocunAdapter(List<Sum> sums, Context weatherActivity) {
        this.sums = sums;
        this.weatherActivity = weatherActivity;
    }

    public class baocunViewHolder extends RecyclerView.ViewHolder {
        public TextView placename;
        public TextView temp;

        public baocunViewHolder(@NonNull View itemView) {
            super(itemView);
            placename=itemView.findViewById(R.id.placeName2);
            temp = itemView.findViewById(R.id.placetemp);
        }
    }

    @NonNull
    @Override
    public BaocunAdapter.baocunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baocun_item, parent, false);
        baocunViewHolder holder = new baocunViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaocunAdapter.baocunViewHolder holder, int position) {
        Sum  sum = sums.get(position);
        holder.placename.setText(sum.getPlace());
        holder.temp.setText(sum.getWeather().getNewdaily().getTemp()+"℃");

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // 在这里处理长按事件
                showDeleteDialog(holder.getAdapterPosition());
                return true; // 返回 true 表示已处理此事件
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SunnyWeatherApplication.summm1=sum;
                Intent intent = new Intent(view.getContext(), WeatherActivity.class);
                intent.putExtra("name",sum.getPlace());
                intent.putExtra("id", sum.getPlaceid());
                intent.putExtra("TTT", "2");//说明是搜索框进行数据跳转;
                weatherActivity.startActivity(intent);
            }
        });
    }
    private void showDeleteDialog(final  int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(weatherActivity);
        builder.setTitle("删除");
        builder.setMessage("确定要删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeItem(position);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }
    public void removeItem(int position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WeatherActivity.database.deleteUser(sums.get(position));
                SunnyWeatherApplication.summm2=WeatherActivity.database.getAllSums();
            }
        }).start();;
        sums.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }
    @Override
    public int getItemCount() {
        if(sums==null)
        {
            return 0;
        }
        return sums.size();
    }
}
