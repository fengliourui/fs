package ui.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;

import java.util.List;

import logic.model.Time;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder>{
    private List<Time> timeList;
    private Context context; // 添加Context成员变量

    public TimeAdapter(List<Time> timeList, Context context) {
        this.timeList = timeList;
        this.context = context;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_item, parent, false);
        return new TimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        Time time = timeList.get(position);
        if(position==0)
        {
            holder.timeText.setText("现在");
        }
        else
        {
            String k = time.getFxTime().substring(11,16);
            holder.timeText.setText(k);
        }
        holder.iconIcon.setText(Html.fromHtml("&#x" + time.getIcon() + ";"));
        holder.tempInfo.setText(time.getTemp()+"℃");
        holder.skyInfo.setText(time.getText());

        Typeface font = Typeface.createFromAsset(context.getAssets(), "qweather-icons.ttf");//加载图标字体
        holder.iconIcon.setTypeface(font);//设置textView使用图标字体。
        String iconday = time.getIcon();
        Log.d("TAGG",iconday);
        if (iconday.equals("100")){
            holder.iconIcon.setText(Html.fromHtml("&#xF101;"));
        }else if(iconday.equals("101")){
            holder.iconIcon.setText(Html.fromHtml("&#xF102;"));
        }else if(iconday.equals("102")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF103;"));
        }else if(iconday.equals("103")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF104;"));
        }else if(iconday.equals("104")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF105;"));
        }else if(iconday.equals("150")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF106;"));
        }else if(iconday.equals("151")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF107;"));
        }else if(iconday.equals("152")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF108;"));
        }else if(iconday.equals("153")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF109;"));
        } else if(iconday.equals("300")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF10A;"));
        }else if(iconday.equals("301")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF10B;"));
        }else if(iconday.equals("302")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF10C;"));
        }else if(iconday.equals("303")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF10D;"));
        }else if(iconday.equals("304")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF10E;"));
        }else if(iconday.equals("305")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF10F;"));
        }else if(iconday.equals("306")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF110;"));
        }else if(iconday.equals("307")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF111;"));
        }else if(iconday.equals("308")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF112;"));
        }else if(iconday.equals("309")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF113;"));
        }else if(iconday.equals("310")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF114;"));
        }else if(iconday.equals("311")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF115;"));
        }else if(iconday.equals("312")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF116;"));
        }else if(iconday.equals("313")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF117;"));
        }else if(iconday.equals("314")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF118;"));
        }else if(iconday.equals("315")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF119;"));
        }else if(iconday.equals("316")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF11A;"));
        }else if(iconday.equals("317")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF11B;"));
        }else if(iconday.equals("318")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF11C;"));
        }else if(iconday.equals("399")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF11F;"));
        }else if(iconday.equals("350")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF11D;"));
        }else if(iconday.equals("351")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF11E;"));
        }else if(iconday.equals("400")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF120;"));
        }else if(iconday.equals("401")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF121;"));
        }else if(iconday.equals("402")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF122;"));
        }else if(iconday.equals("403")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF123;"));
        }else if(iconday.equals("404")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF124;"));
        }else if(iconday.equals("405")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF125;"));
        }else if(iconday.equals("406")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF126;"));
        }else if(iconday.equals("407")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF127;"));
        }else if(iconday.equals("408")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF128;"));
        }else if(iconday.equals("409")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF129;"));
        }else if(iconday.equals("410")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF12A;"));
        }else if(iconday.equals("456")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF12B;"));
        }else if(iconday.equals("457")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF12C;"));
        }else if(iconday.equals("499")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF12D;"));
        }else if(iconday.equals("500")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF12E;"));
        }else if(iconday.equals("501")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF12F;"));
        }else if(iconday.equals("502")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF130;"));
        }else if(iconday.equals("503")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF131;"));
        }else if(iconday.equals("504")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF132;"));
        }else if(iconday.equals("507")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF133;"));
        }else if(iconday.equals("508")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF134;"));
        }else if(iconday.equals("509")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF135;"));
        }else if(iconday.equals("510")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF136;"));
        }else if(iconday.equals("511")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF137;"));
        }else if(iconday.equals("512")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF138;"));
        }else if(iconday.equals("513")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF139;"));
        }else if(iconday.equals("514")) {
            holder. iconIcon.setText(Html.fromHtml("&#xF13A;"));
        }else if(iconday.equals("515")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF13B;"));
        }else if(iconday.equals("900")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF144;"));
        }else if(iconday.equals("901")) {
            holder.iconIcon.setText(Html.fromHtml("&#xF145;"));
        }else{
            holder.iconIcon.setText(Html.fromHtml("&#xF146;"));
        }
}

    @Override
    public int getItemCount() {
        return timeList.size();
    }

    public static class TimeViewHolder extends RecyclerView.ViewHolder {
        TextView timeText;
        TextView iconIcon;

        TextView tempInfo;

        TextView skyInfo;

        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
            timeText = itemView.findViewById(R.id.timeInfo);
            iconIcon = itemView.findViewById(R.id.iconIcon);
            tempInfo = itemView.findViewById(R.id.tempInfo);
            skyInfo  = itemView.findViewById(R.id.skyInfo);
        }
    }
}
