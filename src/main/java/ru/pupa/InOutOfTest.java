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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Задаем настройки тайм-аутов вебдрайвера
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        InOutOfTest.driver = driver;
    }

    @AfterClass
     public static void tearDown() {
        //Закрываем вебдрайвер
        try {
            profilePage.driver.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
