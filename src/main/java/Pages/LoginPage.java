package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    public LoginPage fillMail(String text) {
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys(text);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        return this;
    }

    public String getErrorMessage() {
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        return warningMessage;
    }
}
