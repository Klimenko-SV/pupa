package ru.pupa;

import java.util.concurrent.TimeUnit;
//Задаем явные ожидания (когда надо)
final public class WaitDownload {
    public static void wait(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
