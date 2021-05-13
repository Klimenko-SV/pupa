package ru.pupa;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;
import java.util.concurrent.TimeUnit;

public class InOutOfTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static SendetPage sendetPage;

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
