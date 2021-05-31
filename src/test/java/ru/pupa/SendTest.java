package ru.pupa;

import org.junit.Test;

public class SendTest extends InOutOfTest {

    @Test
    final public void sendTest() {
        loginPage = new LoginPage(driver);
        //значение login/password берутся из файла настроек
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //Заходим в раздел отправки писем
        profilePage = new ProfilePage(driver);
        profilePage.writeLetter();
        //выбираем раздел "шаблоны"
        profilePage.patternBtnClick();
        //выбираем нужный шаблон
        WaitDownload.wait(1);
        profilePage.myPatternClick();
        //заполняем поле "кому"
        WaitDownload.wait(1);
        String mailRecipient = ConfProperties.getProperty("sendto");
        profilePage.RecipientArea(mailRecipient);
        //нажимаем кнопку "отправить"
        profilePage.sendLetterClick();
        //нажимаем "закрыть окно"
        WaitDownload.wait(1);
        profilePage.closeButton();
        //ждем, чтобы посмотреть, что все верно (это не для тестирования, это для меня)
        WaitDownload.wait(5);
    }
}
