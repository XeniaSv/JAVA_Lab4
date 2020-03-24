package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {
    //Метод, загружающий список товаров в указанный каталог (ItemCatalog)
    public void load(ItemCatalog cat);
}
