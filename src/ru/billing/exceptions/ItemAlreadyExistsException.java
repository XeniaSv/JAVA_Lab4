package ru.billing.exceptions;

//Собственное исключение, наследуется от базового класса исключения
public class ItemAlreadyExistsException extends Exception {
    private String nameError;

    //Конструктор копирования
    public ItemAlreadyExistsException(ItemAlreadyExistsException e) {
        this(e.nameError);
    }

    //Конструктор с параметрами
    public ItemAlreadyExistsException(String nameError) {
        this.nameError = nameError;
    }

    //Получить имя ошибки
    public String getNameError() {
        return nameError;
    }
}