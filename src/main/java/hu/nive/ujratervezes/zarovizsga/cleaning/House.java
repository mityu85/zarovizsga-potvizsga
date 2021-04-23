package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;
    private final int PRICE = 80;

    public int getPRICE() {
        return PRICE;
    }

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return area * PRICE;
    }

    public int getArea() {
        return area;
    }
}
