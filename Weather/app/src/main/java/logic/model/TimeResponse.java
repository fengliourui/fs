package logic.model;

import java.util.List;

public class TimeResponse {
    private String code;
    private List<Time> hourly;

    public TimeResponse(String code, List<Time> hourly) {
        this.code = code;
        this.hourly = hourly;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Time> getHourly() {
        return hourly;
    }

    public void setHourly(List<Time> hourly) {
        this.hourly = hourly;
    }
}
