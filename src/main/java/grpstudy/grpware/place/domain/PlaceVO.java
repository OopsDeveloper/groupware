package grpstudy.grpware.place.domain;

import lombok.Data;

@Data
public class PlaceVO {
    float placeX;
    float placeY;
    String placeAddress;
    String placeName;

    public float getPlaceX() {
        return placeX;
    }

    public void setPlaceX(float placeX) {
        this.placeX = placeX;
    }

    public float getPlaceY() {
        return placeY;
    }

    public void setPlaceY(float placeY) {
        this.placeY = placeY;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return "PlaceVO{" +
                "placeX=" + placeX +
                ", placeY=" + placeY +
                ", placeAddress='" + placeAddress + '\'' +
                ", placeName='" + placeName + '\'' +
                '}';
    }
}
