package ru.pupa;

import org.junit.Test;
import java.util.concurrent.TimeUnit;


public class DeleteTest extends InOutOfTest {

    @Test
    public void deleteTest() {
        //вводим логин-пароль
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //ждем 3 сек
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //нажимаем кнопку "отправленные"
        profilePage.clickSendetBtn();

        //ждем
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //выделяем и удаляем последнее отправленное письмо
        sendetPage.checkLetter();

        //ждем
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sendetPage.delLetter();

        //ждем
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
