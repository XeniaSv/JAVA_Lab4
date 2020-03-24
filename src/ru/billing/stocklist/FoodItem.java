package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome = new Date(); // дата производства
    private short expires; // срок годности

    //Геттер для даты производства товара
    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    //Сеттер для даты производства товара
    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    //Геттер для срока годности товара
    public short getExpires() {
        return expires;
    }

    //Сеттер для срока годности товара
    public void setExpires(short expires) {
        this.expires = expires;
    }

    //Конструктор №1
    public FoodItem(String name, float price, String analog, Date date, short expires) {
        this(name, price, expires); // Вызов частного конструктора №2
        setAnalog(analog);
        setDateOfIncome(date);

    }

    //Конструктор №2
    public FoodItem(String name, float price, short expires) {
        this(name); //Вызов частного конструктора №3
        setPrice(price);
        this.expires = expires;
    }

    //Конструктор №3
    public FoodItem(String name) {
        setName(name);
    }

    //Метод вывода данных
    public void printAll() {
        System.out.printf("ID: %d , " +
                        "Name: %-20s , " +
                        "Price: %5.2f , " +
                        "Analog: %-20s, " +
                        "Category: %-8s, " +
                        "Expires:%d, " +
                        "Date: %7$td %7$tB %7$tY\n",
                getID(), getName(), getPrice(), getAnalog(), category, expires, dateOfIncome);
    }

    //Метод сравнения с помощью метода equals 2-х объектов класса
    public boolean equals(Object o) { //
        if (hashCode() != o.hashCode()) {
            return false;
        }
        if (!(o instanceof FoodItem)) return false;
        FoodItem temp = (FoodItem) o;
        return super.equals(temp) && this.dateOfIncome.equals(temp.dateOfIncome) && this.expires == temp.expires;
    }

    //Метод клонирования экземпляра класса
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Метод перевода в строку
    public String toString() {
        return super.toString() + "\tDate of income: " + this.dateOfIncome + "\tExpires: " + this.expires;
    }

}
