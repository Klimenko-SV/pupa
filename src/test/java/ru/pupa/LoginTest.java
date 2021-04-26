package ru.pupa;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

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
    }

    @Test
    public void loginTest() {
//значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage, вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserMail();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
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
