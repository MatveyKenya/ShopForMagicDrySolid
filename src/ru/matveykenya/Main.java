package ru.matveykenya;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Shop shop = new Shop(); //открываем новый магазин
    private final static Basket basket = new Basket(); //корзинка

    public static void main(String[] args) {
        System.out.println("Программа Магазин");
        shop.setProducts(getProducts()); //заполняем магазин продуктами
        //System.out.println(shop);

        runShopping();
        System.out.println("Спасибо за покупки, До свидание!");
    }

    private static void runShopping() {
        boolean whileExit = true;
        while (whileExit){
            switch (menuShow("""
                Выберете пункт меню:
                1 - Смотреть все товары
                2 - Выбрать товары по Производителю
                3 - Выбрать товары по Категории
                4 - Моя корзина
                0 - выход""", 5)) {
                case 1 -> selectProdToBasket(shop.getAllProducts());
                case 2 -> System.out.println("пункт 2");
                case 3 -> System.out.println("пункт 3");
                case 4 -> System.out.println(basket);
                case 0 -> whileExit = false;
            }
        }

    }

    private static void selectProdToBasket(List<Product> productList){
        System.out.println(productList);
        boolean whileExit = true;
        int count;
        while (whileExit){
            int code = menuShow("""
                Введите КОД товара (vendorCode) для покупки (0-выход)
                """, 9999);
            if(code > 0){
                System.out.println("Введите количество:");
                count = Integer.parseInt(scanner.nextLine()); //todo обработать ошибки ввода

                //todo разобраться с количеством
                if (count > 0){
                    if (basket.addNewProduct(shop.getProductByCode(code))){
                        System.out.println("Продукт добавлен в корзину");
                    } else {
                        System.out.println("Продукт не добавлен! проверьте КОД.");
                    }
                }

            } else {
                whileExit = false;
            }
        }


    }

    private static int menuShow(String title, int countItem){
        System.out.println(title);
        int result = -1;
        while (result < 0 || result > countItem - 1){
            System.out.println("Введите число от 0 до " + countItem);
            String input = scanner.nextLine();
            try{
                result = Integer.parseInt(input);
            } catch (NumberFormatException e){
                //e.printStackTrace();
                result = -1;
            }
        }
        return result;
    }

    private static List<Product> getProducts(){
        return Arrays.asList(
                new Product("Яблоки", 1052, 57, Unit.kg, Manufacturer.Farmer, Category.FOOD).addCount(500),
                new Product("Бананы", 5689, 30, Unit.kg, Manufacturer.CitiFoodCompany, Category.FOOD).addCount(600),
                new Product("Телевизор", 8974, 5000, Unit.pcs, Manufacturer.Samsung, Category.ELECTRONIC).addCount(25),
                new Product("Компьютер", 1259, 10000, Unit.pcs, Manufacturer.ElectronicMaker, Category.ELECTRONIC).addCount(10),
                new Product("Телефон", 1547, 7500, Unit.pcs, Manufacturer.Xiaomi, Category.ELECTRONIC).addCount(6),
                new Product("Футболка", 6359, 400, Unit.pcs, Manufacturer.Lacoste, Category.CLOTHES).addCount(8),
                new Product("Бейсболка>", 7594, 600, Unit.pcs, Manufacturer.Xiaomi, Category.CLOTHES).addCount(80));
    }
}
