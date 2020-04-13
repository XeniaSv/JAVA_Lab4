package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

import java.io.IOException;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        //Товары
        GenericItem one = new GenericItem("Milk", 50f, Category.FOOD);
        GenericItem two = new GenericItem("Book", 150f, Category.PRINT);
        GenericItem three = new GenericItem("T-shirt", 999f, Category.DRESS);
        GenericItem four = new GenericItem("Toy", 400f, Category.GENERAL);
        GenericItem five = new GenericItem("Chips", 49f, Category.FOOD);
        GenericItem six = new GenericItem("Magazine", 200f, Category.PRINT);
        GenericItem seven = new GenericItem("Coat", 15000f, Category.DRESS);
        GenericItem eight = new GenericItem("Phone", 50000f, Category.GENERAL);
        GenericItem nine = new GenericItem("Garlic", 14f, Category.FOOD);
        GenericItem ten = new GenericItem("Bag", 50f, Category.DRESS);

        //Добавление товаров в коллекцию
        ItemCatalog itCat = new ItemCatalog();
        //Обработка исключения для уже существующего товара
        try {
            itCat.addItem(one);
            itCat.addItem(two);
            itCat.addItem(three);
            itCat.addItem(four);
            itCat.addItem(five);
            itCat.addItem(six);
            itCat.addItem(seven);
            itCat.addItem(eight);
            itCat.addItem(nine);
            itCat.addItem(ten);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        //Скорость поиска по двум типам коллекций
        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++) {
            itCat.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            itCat.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        //Экземпляр, загружающий товары в каталог с помощью объекта-загрузчика
        CatalogLoader loader = new CatalogStubLoader();
        //Обработка исключения для загрузки товара
        try {
            loader.load(itCat);
        } catch (IOException | CatalogLoadException e) {
            e.printStackTrace();
        }

        //Загружаем продукты с файла
        CatalogFileLoader fileLoader = new CatalogFileLoader("C:\\Users\\Ксения\\Desktop\\4 sem\\Java\\Lab4\\src\\ru\\billing\\client\\File.txt");
        try {
            fileLoader.load(itCat);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Вывод всех товаров
        itCat.printItems();
    }
}
