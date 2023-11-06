package logic.model;

public class New {
    private String obsTime;          //数据观测时间
    private String temp;             //温度，默认单位：摄氏度
    private String feelsLike;        //体感温度，默认单位：摄氏度
    private String icon;             //天气状况的图标代码，另请参考天气图标项目
    private String text;             //天气状况的文字描述，包括阴晴雨雪等天气状态的描述
    private String wind360;          //风向360角度
    private String windDir;          //风向
    private String windScale;        //风力等级
    private String windSpeed;        //风速，公里/小时
    private String humidity;         //相对湿度，百分比数值
    private String precip;           //当前小时累计降水量，默认单位：毫米
    private String pressure;         //大气压强，默认单位：百帕
    private String vis;              //能见度，默认单位：公里
    private String cloud;            //云量，百分比数值。可能为空
    private String dew;              //露点温度。可能为空

    public New(String obsTime, String temp, String feelsLike, String icon, String text, String wind360, String windDir, String windScale, String windSpeed, String humidity, String precip, String pressure, String vis, String cloud, String dew) {
        this.obsTime = obsTime;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.icon = icon;
        this.text = text;
        this.wind360 = wind360;
        this.windDir = windDir;
        this.windScale = windScale;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.precip = precip;
        this.pressure = pressure;
        this.vis = vis;
        this.cloud = cloud;
        this.dew = dew;
    }

    public String getObsTime() {
        return obsTime;
    }

    public void setObsTime(String obsTime) {
        this.obsTime = obsTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWind360() {
        return wind360;
    }

    public void setWind360(String wind360) {
        this.wind360 = wind360;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindScale() {
        return windScale;
    }

    public void setWindScale(String windScale) {
        this.windScale = windScale;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }
}
