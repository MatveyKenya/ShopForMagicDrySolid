package ru.matveykenya;

public class Product {
    private String name; //название товара
    private int price; //упрощаем без плавающей точки
    private int vendorCode; //артикул
    private Manufacturer manufacturer; //производитель
    private Category category; //категория товара
    private int weight; //вес в граммах

    public Product(String name, int vendorCode, int price, int weight, Manufacturer manufacturer, Category category) {
        this.name = name;
        this.price = price;
        this.vendorCode = vendorCode;
        this.manufacturer = manufacturer;
        this.category = category;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vendorCode=" + vendorCode +
                ", manufacturer=" + manufacturer +
                ", category=" + category +
                ", weight=" + weight + " Gram" +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public int getWeight() {
        return weight;
    }
}
