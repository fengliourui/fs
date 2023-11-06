package logic.model;

import java.util.List;

public class AirResponse {
    private String code;

    private Air now;
    private List<Airlocal> station;

    public AirResponse(String code, Air now, List<Airlocal> station) {
        this.code = code;
        this.now = now;
        this.station = station;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Air getNow() {
        return now;
    }

    public void setNow(Air now) {
        this.now = now;
    }

    public List<Airlocal> getStation() {
        return station;
    }

    public void setStation(List<Airlocal> station) {
        this.station = station;
    }
}
