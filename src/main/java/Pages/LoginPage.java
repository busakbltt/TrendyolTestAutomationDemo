package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    @Step("E-posta alanı doldurulur")
    public LoginPage fillMail(String text) {
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Şifre alanı doldurulur")
    public LoginPage fillPassword(String text) {
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Giriş butonuna basılır")
    public LoginPage clickLogin() {
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        return this;
    }

    @Step("Hata mesajı alınır")
    public String getErrorMessage() {
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Allure.addAttachment(warningMessage + " hata mesajı ekrandan çekilir", "");
        screenshot();
        return warningMessage;
    }
}
