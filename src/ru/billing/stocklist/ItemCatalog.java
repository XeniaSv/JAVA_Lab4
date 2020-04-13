package ru.billing.stocklist;

import ru.billing.stocklist.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCatalog {
    //Коллекция со списком товаров
    private Map<Integer, GenericItem> catalog =
            new HashMap<Integer, GenericItem>();
    //Коллекция с тем же списком товаров( нужна для сравнения с catalog)
    private List<GenericItem> allCatalog =
            new ArrayList<GenericItem>();

    //Геттер для коллекции catalog
    public Map<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    //Сеттер для коллекции catalog
    public void setCatalog(HashMap<Integer, GenericItem> catalog) {
        this.catalog = catalog;
    }

    //Геттер для коллекции ALCatalog
    public List<GenericItem> getALCatalog() {
        return allCatalog;
    }

    //Сеттер для коллекции ALCatalog
    public void setALCatalog(ArrayList<GenericItem> allCatalog) {
        this.allCatalog = allCatalog;
    }

    // Метод добавления товара в каталог
    public void addItem(GenericItem item) {
        catalog.put(item.getID(), item); // Добавляем товар в HashMap
        allCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    //Метод вывод на экран товаров из каталога
    public void printItems() {
        for (GenericItem i : allCatalog) {
            System.out.println(i);
        }
    }

    //Метод поиска товара в каталоге по переданному ID товара
    //Поиск в коллекции catalog типа HashMap
    public GenericItem findItemByID(int id) {
        //Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    //Метод поиска товара в каталоге по переданному ID товара
    //Поиск в коллекции ALCatalog типа ArrayList
    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : allCatalog) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }


}
