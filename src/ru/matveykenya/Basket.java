package ru.matveykenya;

public class Basket extends Storage {

    public String information() {
        int countProd = getAllProducts().size();
        int summa = 0;
        for (Product product : getAllProducts()) {
            summa += product.getCount() * product.getPrice();
        }
        return "Корзина содержит " + countProd + " вида товаров на сумму " + summa;
    }
}
