package ru.pupa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitFields {
    public WebDriver driver;
    public InitFields(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
