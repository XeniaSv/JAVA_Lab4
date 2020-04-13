package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Class CatalogFileLoader that implements from CatalogLoader
 */
public class CatalogFileLoader implements CatalogLoader {

    //Путь к файлу
    private String fileName;

    //Конструктор
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    //Перегруженный метод загрзки
    @Override
    public void load(ItemCatalog cat) throws IOException {
        File f = new File(fileName);
        String line;

        try (FileInputStream stream = new FileInputStream(f)) {
            Scanner scanner = new Scanner(stream);
            //Пока читается линия
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    break;
                }
                //Разделяем данные
                String[] items = line.split(";");
                String name = items[0];
                float price = Float.parseFloat(items[1]);
                short expires = Short.parseShort(items[2]);
                FoodItem item = new FoodItem(name, price, expires);
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    //Чтение файла с кодировкой UTF-8
    public void parseUtf8(ItemCatalog cat) throws IOException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes(StandardCharsets.UTF_8));
                String[] items = string.split(";");
                String name = items[0];
                float price = Float.parseFloat(items[1]);
                short expires = Short.parseShort(items[2]);
                FoodItem item = new FoodItem(name, price, expires);
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    //Чтение файла с кодировкой Windows-1251
    public void parseWindows1251(ItemCatalog cat) throws IOException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes("windows-1251"));
                String[] items = string.split(";");
                String name = items[0];
                float price = Float.parseFloat(items[1]);
                short expires = Short.parseShort(items[2]);
                FoodItem item = new FoodItem(name, price, expires);
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
