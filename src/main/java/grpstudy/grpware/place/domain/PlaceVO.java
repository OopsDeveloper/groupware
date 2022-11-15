package grpstudy.grpware.place.domain;

import lombok.Data;

@Data
public class PlaceVO {
    float x;
    float y;
    String address;
    String name;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "placeVO{" +
                "x=" + x +
                ", y=" + y +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
