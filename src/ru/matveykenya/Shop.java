package ru.matveykenya;

public class Shop extends Storage {
    private String name;
    private String address;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Магазин " + name + " (" + address + " )";
    }
}
