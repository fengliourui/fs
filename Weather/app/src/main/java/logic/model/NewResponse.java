package logic.model;

import java.util.List;

public class NewResponse {
    private String code;
    private New now;

    public NewResponse(String code, New now) {
        this.code = code;
        this.now = now;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public New getNow() {
        return now;
    }

    public void setNow(New now) {
        this.now = now;
    }
}
