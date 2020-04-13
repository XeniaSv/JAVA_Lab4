package ru.billing.exceptions;

//Собственное исключение, наследуется от базового класса исключения
public class CatalogLoadException extends Exception {
    private String nameError;

    //Конструктор #1
    public CatalogLoadException(ItemAlreadyExistsException e) {
        this.nameError = e.getNameError();
    }

    //Конструктор #2
    public CatalogLoadException(String nameError) {
        this.nameError = nameError;
    }

    //Получить имя ошибки
    public String getNameError() {
        return nameError;
    }
}