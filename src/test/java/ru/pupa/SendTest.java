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

        //ждем 3 сек
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        profilePage.writeLetter();
        //ждем 3 сек
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //выбираем раздел "шаблоны"
        profilePage.patternBtnClick();

        //ждем 1 сек
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //выбираем нужный шаблон
        profilePage.myPatternClick();

        //ждем 2 сек
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //заполняем поле "кому"
        String mailRecipient = ConfProperties.getProperty("sendto");
        profilePage.RecipientArea(mailRecipient);

        //ждем 2 сек
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //нажимаем кнопку "отправить"
        profilePage.sendLetterClick();
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
