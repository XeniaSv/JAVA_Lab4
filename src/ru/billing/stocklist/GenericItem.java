package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private static int currentID; // Хранение максимально назначенный ID товара в текущей сессии
    private int id; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private Category category = Category.GENERAL; //Поле типа Category со значением по умолчанию GENERAL
    private String analog; // Аналог

    //Конструктор №1
    public GenericItem(String name, float price, Category category) {
        this.id = GenericItem.currentID++; // Инициализирование поле ID товара очередным свободным номером
        this.name = name;
        this.price = price;
        this.category = category;
    }

    //Конструктор №2
    public GenericItem(String name, float price, String analog) {
        this(name, price, Category.GENERAL);
        this.analog = analog;
    }

    //Конструктор №3
    public GenericItem() {
        this(null, 0.0f, Category.GENERAL);
    }

    //Геттер для ID товара
    public int getID() {
        return id;
    }

    //Сеттер для ID товара
    public void setID(int id) {
        this.id = id;
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

    public Category getCategory() {
        return this.category;
    }

    //Метод вывода данных
    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , Price:%5.2f , Analog: %-20s, Category:%-8s\n", id, name, price, analog, category);
    }

    //Метод сравнения с помощью метода equals 2-х объектов класса
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        GenericItem temp = (GenericItem) o;
        return this.id == temp.id && this.name.equals(temp.name) && this.price == temp.price && this.analog.equals(temp.analog);
    }

    //Метод клонирования экземпляра класса
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Метод перевода в строку
    public String toString() {
        return "ID: " + this.id + "\tName: " + this.name + "\tPrice: " + this.price +
                "\tAnalog: " + analog;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }
}
