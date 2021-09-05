package ru.matveykenya;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products = new ArrayList<>();
    private List<Product> basket = new ArrayList<>();

    public void setProducts(List<Product> products){
        this.products = products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

    public String basketToString() {
        return "Shop{" +
                "products=" + basket +
                '}';
    }

    public List<Product> getProductsByCategory(Category category){
        return products.stream()
                .filter(x -> x.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByManufacturer(Manufacturer manufacturer){
        return products.stream()
                .filter(x -> x.getManufacturer() == manufacturer)
                .collect(Collectors.toList());
    }
}
