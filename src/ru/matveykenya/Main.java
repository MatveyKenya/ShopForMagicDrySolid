package ru.matveykenya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Программа Магазин");
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop(); //открываем новый магазин
        shop.setProducts(getProducts()); //заполняем магазин продуктами





    }

    private static List<Product> getProducts(){
        return Arrays.asList(
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD),
                new Product("Яблоки", 1052, 57, 1000, Manufacturer.Farmer, Category.FOOD));
    }
}
