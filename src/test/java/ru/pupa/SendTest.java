package ru.pupa;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SendTest {
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
    public void sendTest() {
        //вводим пароль
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //нажимаем кнопку "Написать письмо
        profilePage.writeLetter();
        //вводим получателя письма
        profilePage.RecipientArea(ConfProperties.getProperty("sendto"));
        //вводим тему письма
        profilePage.SubjArea(ConfProperties.getProperty("sendSubject"));
        //вводим текст письма
        profilePage.TextOfLetter(ConfProperties.getProperty("sendText"));
        //нажимаем кнопку отправить
        profilePage.sendButton();
        //нажимаем кнопку закрытия окна отправки сообщения
        profilePage.closeButton();

    }
    @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
        try {
            profilePage.driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
