package logic.model;

import java.util.List;

public class PlaceResponse {
    private String code;
    private List<Place> location;

    public PlaceResponse(String status, List<Place> places) {
        this.code = status;
        this.location = places;
    }

    public String getStatus() {
        return code;
    }

    public List<Place> getPlaces() {
        return location;
    }
}
