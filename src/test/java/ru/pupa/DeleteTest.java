package ru.pupa;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class DeleteTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static SendetPage sendetPage;

    //Осуществление начальных настроек
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver")); //определение пути до драйвера и его настройка
        WebDriver driver = new ChromeDriver(); //создание экземпляра драйвера
        driver.manage().window().maximize(); //разворачиваем окно на весь экран
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //максимальная задержка на выполнение теста 10 секунд
        driver.get(ConfProperties.getProperty("loginpage")); //получаем ссылку на страницу входа
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        sendetPage = new SendetPage(driver);
    }
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

    @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
        try {
            profilePage.driver.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
