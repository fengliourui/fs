package logic.model;

import java.util.List;

public class Weather {
    public  New  newdaily;
    public  List<Somedaily> somedaily;
    public List<Life> life;

    public List<Time> time;

    public Air air;

    public Weather(New newdaily, List<Somedaily> somedaily, List<Life> life, List<Time> time, Air air) {
        this.newdaily = newdaily;
        this.somedaily = somedaily;
        this.life = life;
        this.time = time;
        this.air = air;
    }

    public New getNewdaily() {
        return newdaily;
    }

    public void setNewdaily(New newdaily) {
        this.newdaily = newdaily;
    }

    public List<Somedaily> getSomedaily() {
        return somedaily;
    }

    public void setSomedaily(List<Somedaily> somedaily) {
        this.somedaily = somedaily;
    }

    public List<Life> getLife() {
        return life;
    }

    public void setLife(List<Life> life) {
        this.life = life;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }
}
