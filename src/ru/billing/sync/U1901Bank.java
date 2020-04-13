package ru.billing.sync;

//Класс банка
public class U1901Bank {
    //Вклад банка
    private int intTo;
    //Счёт владельца
    private int intFrom = 220;

    //Расчет транзакции
    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("Before:" + Thread.currentThread().getName() + "\nintFrom: " + intFrom + "\nintTo:" + intTo);

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo += intTransaction;

        System.out.println("After:" + Thread.currentThread().getName() + "\nintFrom: " + intFrom + "\nintTo:" + intTo);

    }

}