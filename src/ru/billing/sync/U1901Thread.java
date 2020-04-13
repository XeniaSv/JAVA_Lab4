package ru.billing.sync;

//Класс потоков
public class U1901Thread extends Thread {

    private U1901Bank bankWork;
    //Транзакция
    private int intTrans;
    //Время для засыпания потока
    private long lngSleep;

    //Конструктор
    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    //Поехали!
    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }


}