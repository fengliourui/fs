package logic.model;

public class Somedaily {
    private String fxDate;          //预报日期
    private String sunrise;         //日出时间，在高纬度地区可能为空
    private String sunset;          //日落时间，在高纬度地区可能为空
    private String moonrise;             //当天月升时间，可能为空
    private String moonset ;             //当天月落时间，可能为空
    private String moonPhase;          // 月相名称
    private String moonPhaseIcon;          // 月相图标代码，另请参考天气图标项目
    private String tempMax;        //预报当天最高温度
    private String tempMin;        //预报当天最高温度
    private String iconDay;         // 预报白天天气状况的图标代码，另请参考天气图标项目
    private String textDay;           // 预报白天天气状况文字描述，包括阴晴雨雪等天气状态的描述
    private String iconNight;         // 预报夜间天气状况的图标代码，另请参考天气图标项目
    private String textNight;              //预报晚间天气状况文字描述，包括阴晴雨雪等天气状态的描述
    private String wind360Day;            // 预报白天风向360角度
    private String windDirDay;              // 预报白天风向

    private String windScaleDay;         //  预报白天风速，公里/小时
    private String wind360Night;          //预报夜间风向360角度
    private String windDirNight;             // 预报夜间当天风向
    private String windScaleNight ;             //预报夜间风力等级
    private String windSpeedNight;          //  预报夜间风速，公里/小时
    private String precip;          // 预报当天总降水量，默认单位：毫米
    private String uvIndex;        //紫外线强度指数
    private String humidity;        //相对湿度，百分比数值
    private String pressure;         // 大气压强，默认单位：百帕
    private String vis;           // 能见度，默认单位：公里
    private String cloud;         // 云量，百分比数值。可能为空

    public Somedaily(String fxDate, String sunrise, String sunset, String moonrise, String moonset, String moonPhase, String moonPhaseIcon, String tempMax, String tempMin, String iconDay, String textDay, String iconNight, String textNight, String wind360Day, String windDirDay, String windScaleDay, String wind360Night, String windDirNight, String windScaleNight, String windSpeedNight, String precip, String uvIndex, String humidity, String pressure, String vis, String cloud) {
        this.fxDate = fxDate;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonPhase = moonPhase;
        this.moonPhaseIcon = moonPhaseIcon;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.iconDay = iconDay;
        this.textDay = textDay;
        this.iconNight = iconNight;
        this.textNight = textNight;
        this.wind360Day = wind360Day;
        this.windDirDay = windDirDay;
        this.windScaleDay = windScaleDay;
        this.wind360Night = wind360Night;
        this.windDirNight = windDirNight;
        this.windScaleNight = windScaleNight;
        this.windSpeedNight = windSpeedNight;
        this.precip = precip;
        this.uvIndex = uvIndex;
        this.humidity = humidity;
        this.pressure = pressure;
        this.vis = vis;
        this.cloud = cloud;
    }

    public String getFxDate() {
        return fxDate;
    }

    public void setFxDate(String fxDate) {
        this.fxDate = fxDate;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public String getMoonPhaseIcon() {
        return moonPhaseIcon;
    }

    public void setMoonPhaseIcon(String moonPhaseIcon) {
        this.moonPhaseIcon = moonPhaseIcon;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getIconDay() {
        return iconDay;
    }

    public void setIconDay(String iconDay) {
        this.iconDay = iconDay;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public String getIconNight() {
        return iconNight;
    }

    public void setIconNight(String iconNight) {
        this.iconNight = iconNight;
    }

    public String getTextNight() {
        return textNight;
    }

    public void setTextNight(String textNight) {
        this.textNight = textNight;
    }

    public String getWind360Day() {
        return wind360Day;
    }

    public void setWind360Day(String wind360Day) {
        this.wind360Day = wind360Day;
    }

    public String getWindDirDay() {
        return windDirDay;
    }

    public void setWindDirDay(String windDirDay) {
        this.windDirDay = windDirDay;
    }

    public String getWindScaleDay() {
        return windScaleDay;
    }

    public void setWindScaleDay(String windScaleDay) {
        this.windScaleDay = windScaleDay;
    }

    public String getWind360Night() {
        return wind360Night;
    }

    public void setWind360Night(String wind360Night) {
        this.wind360Night = wind360Night;
    }

    public String getWindDirNight() {
        return windDirNight;
    }

    public void setWindDirNight(String windDirNight) {
        this.windDirNight = windDirNight;
    }

    public String getWindScaleNight() {
        return windScaleNight;
    }

    public void setWindScaleNight(String windScaleNight) {
        this.windScaleNight = windScaleNight;
    }

    public String getWindSpeedNight() {
        return windSpeedNight;
    }

    public void setWindSpeedNight(String windSpeedNight) {
        this.windSpeedNight = windSpeedNight;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
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
}
