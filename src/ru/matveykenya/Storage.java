package ru.matveykenya;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Storage {
    private List<Product> products = new ArrayList<>();

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public boolean addNewProduct(Product product){
        if (product == null){
            return false;
        }
        for (Product prod: products) {
            if (prod.getVendorCode() == product.getVendorCode()) {
                return false;
            }
        }
        products.add(product);
        return true;
    }

    public Product getProductByCode(int code){
        for (Product product: products){
            if (code == product.getVendorCode()){
                return product;
            }
        }
        return null;
    }

    public boolean deleteProductByCode(int code){
        for (int i = 0; i<products.size(); i++){
            if (code == products.get(i).getVendorCode()){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "{products=" + products + '}';
    }

    public List<Product> getAllProducts(){
        return products;
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
