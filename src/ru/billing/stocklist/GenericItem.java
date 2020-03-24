package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private static int currentID; // Хранение максимально назначенный ID товара в текущей сессии
    private int ID; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private String analog;// Аналог

    //Геттер для ID товара
    public int getID() {
        return ID;
    }

    //Сеттер для ID товара
    public void setID(int ID) {
        this.ID = ID;
    }

    //Геттер для названия товара
    public String getName() {
        return name;
    }

    //Сеттер для названия товара
    public void setName(String name) {
        this.name = name;
    }

    //Геттер для цены товара
    public float getPrice() {
        return price;
    }

    //Сеттер для цены товара
    public void setPrice(float price) {
        this.price = price;
    }

    //Геттер для аналога
    public String getAnalog() {
        return analog;
    }

    //Сеттер для аналога
    public void setAnalog(String analog) {
        this.analog = analog;
    }

    //Конструктор №1
    public GenericItem(String name, float price, Category category) {
        this.ID = GenericItem.currentID++; // Инициализирование поле ID товара очередным свободным номером
        this.name = name;
        this.price = price;
        this.category = category;
    }

    //Конструктор №2
    public GenericItem(String name, float price, String analog) {
        this.ID = GenericItem.currentID++;// Инициализирование поле ID товара очередным свободным номером
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    //Конструктор №3
    public GenericItem() {
        this.ID = GenericItem.currentID++; // Инициализирование поле ID товара очередным свободным номером
    }

    //Метод вывода данных
    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price:%5.2f , Analog: %-20s, Category:%-8s\n", ID, name, price, analog, category);
    }

    //Поле типа Category со значением по умолчанию GENERAL
    public Category category = Category.GENERAL;

    //Метод сравнения с помощью метода equals 2-х объектов класса
    public boolean equals(Object o) {
        if (hashCode() != o.hashCode()) {
            return false;
        }
        if (!(o instanceof GenericItem)) return false;
        GenericItem temp = (GenericItem) o;
        return this.ID == temp.ID && this.name.equals(temp.name) && this.price == temp.price && this.analog.equals(temp.analog);
    }

    //Метод клонирования экземпляра класса
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Метод перевода в строку
    public String toString() {
        return "ID: " + this.ID + "\tName: " + this.name + "\tPrice: " + this.price +
                "\tAnalog: " + analog;
    }
}


