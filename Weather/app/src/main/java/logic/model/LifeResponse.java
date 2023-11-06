package logic.model;

import java.util.List;

public class LifeResponse {
    private String code;
    private List<Life> daily;

    public LifeResponse(String code, List<Life> daily) {
        this.code = code;
        this.daily = daily;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Life> getDaily() {
        return daily;
    }

    public void setDaily(List<Life> daily) {
        this.daily = daily;
    }
}
