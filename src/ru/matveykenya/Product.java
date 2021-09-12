package ru.matveykenya;

public class Product {
    private String name; //название товара
    private int price; //упрощаем без плавающей точки
    private int vendorCode; //артикул
    private Manufacturer manufacturer; //производитель
    private Category category; //категория товара
    private int count = 0; //количество
    private Unit unit; //ед. измерения
    protected static final int MAX_VENDOR_CODE = 9999; // Magic number

    public Product(String name, int vendorCode, int price, Unit unit, Manufacturer manufacturer, Category category) {
        this.name = name;
        this.price = price;
        this.vendorCode = vendorCode;
        this.manufacturer = manufacturer;
        this.category = category;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vendorCode=" + vendorCode +
                ", manufacturer=" + manufacturer +
                ", category=" + category +
                ", count=" + count + ' ' + unit +
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

    public int getCount() {
        return count;
    }

    public Product setCount(int count) {
        if (count > 0) {
            this.count = count;
        }
        return this;
    }

    public Product copy() {
        return new Product(name, vendorCode, price, unit, manufacturer, category);
    }

    public boolean add(int count) {
        if (this.count + count > 0) {
            this.count += count;
            return true;
        }
        return false;
    }

    public Unit getUnit() {
        return unit;
    }
}
