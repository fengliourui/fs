package logic.model;

public class Time {
    private String fxTime;          //预报时间
    private String temp;             //温度，默认单位：摄氏度
    private String icon;             //天气状况的图标代码，另请参考天气图标项目
    private String text;
    private String wind360;
    private String windDir;
    private String windScale;
    private String windSpeed;
    private String humidity;
    private String precip;
    private String pop;
    private String pressure;
    private String cloud;
    private String dew;

    public Time(String fxTime, String temp, String icon, String text, String wind360, String windDir, String windScale, String windSpeed, String humidity, String precip, String pop, String pressure, String cloud, String dew) {
        this.fxTime = fxTime;
        this.temp = temp;
        this.icon = icon;
        this.text = text;
        this.wind360 = wind360;
        this.windDir = windDir;
        this.windScale = windScale;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.precip = precip;
        this.pop = pop;
        this.pressure = pressure;
        this.cloud = cloud;
        this.dew = dew;
    }

    public String getFxTime() {
        return fxTime;
    }

    public void setFxTime(String fxTime) {
        this.fxTime = fxTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
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

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
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
