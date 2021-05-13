package ru.pupa;

import org.junit.Test;
import java.util.concurrent.TimeUnit;


public class SendTest extends InOutOfTest {

    private void wait(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendTest() {
        //значение login/password берутся из файла настроек
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //ждем 3 сек
        wait(3);
        //Заходим в раздел отправки писем
        profilePage.writeLetter();
        //ждем 3 сек
        wait(3);

        //выбираем раздел "шаблоны"
        profilePage.patternBtnClick();

        //ждем 1 сек
        wait(1);

        //выбираем нужный шаблон
        profilePage.myPatternClick();

        //ждем 2 сек
        wait(2);

        //заполняем поле "кому"
        String mailRecipient = ConfProperties.getProperty("sendto");
        profilePage.RecipientArea(mailRecipient);

        //ждем 2 сек
        wait(2);
        //нажимаем кнопку "отправить"
        profilePage.sendLetterClick();

        //ждем 2 сек
        wait(2);
        //нажимаем "закрыть окно"
        profilePage.closeButton();
    }
}
