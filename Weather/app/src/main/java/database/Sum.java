package database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import logic.model.Place;
import logic.model.Weather;

@Entity
public class Sum {
    private Weather weather;
    private String place;

    private String placeid;

    @PrimaryKey(autoGenerate = true)
    private long id;

    public Sum(Weather weather, String place, String placeid) {
        this.weather = weather;
        this.place = place;
        this.placeid = placeid;
        this.id = id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
