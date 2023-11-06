package logic.model;

import java.util.List;

public class somedailyresponse {
    private String code;
    private List<Somedaily> daily;

    public somedailyresponse(String code, List<Somedaily> daily) {
        this.code = code;
        this.daily = daily;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Somedaily> getDaily() {
        return daily;
    }

    public void setDaily(List<Somedaily> daily) {
        this.daily = daily;
    }
}
