package ru.matveykenya;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Shop shop = new Shop("SuperMOLL", "Moscow, Russia"); //открываем новый магазин
    private final static Basket basket = new Basket(); //корзинка

    public static void main(String[] args) {
        System.out.println("Программа Магазин " + shop);
        shop.setProducts(getProducts()); //заполняем магазин продуктами
        runShopping(); // начинаем шопинг
        System.out.println("Спасибо за покупки, До свидание!");
    }

    private static void runShopping() {
        boolean whileExit = true;
        while (whileExit) {
            switch (menuShow("""
                    Выберете пункт меню:
                    1 - Смотреть все товары
                    2 - Выбрать товары ЕДА
                    3 - Выбрать товары ЭЛЕКТРОНИКА
                    4 - Выбрать товары ОДЕЖДА
                    5 - Моя корзина
                    0 - Выход из магазина""", 0, 5)) {
                case 1 -> selectProdToBasket(shop.getAllProducts());
                case 2 -> selectProdToBasket(shop.getProductsByCategory(Category.FOOD));
                case 3 -> selectProdToBasket(shop.getProductsByCategory(Category.ELECTRONIC));
                case 4 -> selectProdToBasket(shop.getProductsByCategory(Category.CLOTHES));
                case 5 -> basketShow();
                case 0 -> whileExit = false;
            }
        }

    }

    private static void basketShow() {
        boolean whileExit = true;
        while (whileExit) {
            System.out.println(basket.information());
            System.out.println(basket + "\n");
            int input = menuShow("""
                    Введите КОД товара для удаления из корзины
                    0 --- для выхода
                    -1 --- для совершения покупки""", -1, Product.MAX_VENDOR_CODE);
            if (input > 0) {
                Product product = basket.getProductByCode(input);
                if (product != null) {
                    basket.deleteProductByCode(input);
                    System.out.println("Товар удален");
                    shop.addNewProduct(product, product.getCount());
                } else {
                    System.out.println("Неверный КОД !!! товар не удален из корзины");
                }
            } else if (input == -1) {
                System.out.println("Корзина куплена");
                basket.clear();
                whileExit = false;
            } else {
                whileExit = false;
            }
        }
    }

    private static int menuShow_input_code_of_Product() {
        return menuShow("\nВведите КОД товара (vendorCode) для добавления в корзину (0-выход)",
                0, Product.MAX_VENDOR_CODE);
    }

    private static int menuShow_input_count_of_Product(int code) {
        return menuShow("Введите количество:", 1, shop.getProductByCode(code).getCount());
    }

    private static void selectProdToBasket(List<Product> productList) {
        System.out.println(productList);
        boolean whileExit = true;
        int count;
        int code;
        while (whileExit) {
            code = menuShow_input_code_of_Product();
            if (code > 0) {
                if (shop.getProductByCode(code) != null) {
                    count = menuShow_input_count_of_Product(code);
                    if (shop.addNewProduct(shop.getProductByCode(code), -count)) {
                        basket.addNewProduct(shop.getProductByCode(code), count);
                        System.out.println("Продукт добавлен в корзину");
                    } else {
                        System.out.println("Продукт не добавлен!");
                    }
                } else {
                    System.out.println("Нет продукта с таким кодом!");
                }
            } else {
                whileExit = false;
            }
        }
    }

    private static int menuShow(String title, int minItem, int maxItem) {
        System.out.println(title);
        int result = minItem - 1;
        while (result < minItem || result > maxItem) {
            System.out.println("Введите число от " + minItem + " до " + maxItem);
            String input = scanner.nextLine();
            try {
                result = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                result = minItem - 1;
            }
        }
        return result;
    }

    private static List<Product> getProducts() {
        return Arrays.asList(
                new Product("Яблоки", 1052, 57, Unit.kg, Manufacturer.Farmer, Category.FOOD).setCount(500),
                new Product("Бананы", 5689, 30, Unit.kg, Manufacturer.CitiFoodCompany, Category.FOOD).setCount(600),
                new Product("Телевизор", 8974, 5000, Unit.pcs, Manufacturer.Samsung, Category.ELECTRONIC).setCount(25),
                new Product("Компьютер", 1259, 10000, Unit.pcs, Manufacturer.ElectronicMaker, Category.ELECTRONIC).setCount(10),
                new Product("Телефон", 1547, 7500, Unit.pcs, Manufacturer.Xiaomi, Category.ELECTRONIC).setCount(6),
                new Product("Футболка", 6359, 400, Unit.pcs, Manufacturer.Lacoste, Category.CLOTHES).setCount(8),
                new Product("Бейсболка>", 7594, 600, Unit.pcs, Manufacturer.Xiaomi, Category.CLOTHES).setCount(80));
    }
}
