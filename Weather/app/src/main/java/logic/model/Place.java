package logic.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Place {
    private String name;
    private String id;
    private String lat;
    private String lom;
    private String adm2;
    private String adm1;
    private String country;
    private String tz;
    private String utcOffset;

    public Place(String name, String id, String lat, String lom, String adm2, String adm1, String country, String tz, String utcOffset) {
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lom = lom;
        this.adm2 = adm2;
        this.adm1 = adm1;
        this.country = country;
        this.tz = tz;
        this.utcOffset = utcOffset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLom() {
        return lom;
    }

    public void setLom(String lom) {
        this.lom = lom;
    }

    public String getAdm2() {
        return adm2;
    }

    public void setAdm2(String adm2) {
        this.adm2 = adm2;
    }

    public String getAdm1() {
        return adm1;
    }

    public void setAdm1(String adm1) {
        this.adm1 = adm1;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }
}