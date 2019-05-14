package sg.edu.rp.c346.carapp;

public class Car {

    private int _id;
    private String brand;
    private double litre;

    public Car(int _id, String brand, double litre) {
        this._id = _id;
        this.brand = brand;
        this.litre = litre;
    }

    public int get_id() {
        return _id;
    }

    public String getBrand() {
        return brand;
    }

    public double getLitre() {
        return litre;
    }
}
