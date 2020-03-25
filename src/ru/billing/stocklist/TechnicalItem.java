package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {
    private short warrantyTime; // гарантийный срок (суток)

    //Геттер для гарантийного срока товара
    public short getWarrantyTime() {
        return warrantyTime;
    }

    //Сеттер для гарантийного срока товара
    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    //Метод вывода данных
    public void printAll() {
        System.out.printf("ID: %d , " +
                        "Name: %-20s , " +
                        "Price:%5.2f , " +
                        "Analog: %-20s, " +
                        "Category:%-8s" +
                        "WarrantyTime:%d\n",
                getID(), getName(), getPrice(), getAnalog(), category, warrantyTime);
    }

    //Метод сравнения с помощью метода equals 2-х объектов класса
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;
        TechnicalItem temp = (TechnicalItem) o;
        return super.equals(temp) && this.warrantyTime == temp.warrantyTime;
    }

    //Метод клонирования экземпляра класса
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Метод перевода в строку
    public String toString() {
        return super.toString() + "\tWarranty time" + this.warrantyTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
        return result;
    }
}

