import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void SuccessfullLogin() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("mystic.kerem@gmail.com");
        driver.findElement(By.name("login-password")).sendKeys("Qweasd123.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(text);
        Assert.assertEquals("Hesabım", text);
    }

    @Test
    public void UnSuccessfullLogin() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("mystic.kerem@gmail.com");
        driver.findElement(By.name("login-password")).sendKeys("Qweasd123..");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage, "E-posta adresiniz ve/veya şifreniz hatalı.");

        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("mystic.kereem@gmail.com");
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys("Qweasd123.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String warningMessage2 = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage2, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void ValidateLogin() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("mystic.keremgmail.com");
        driver.findElement(By.name("login-password")).sendKeys("Qweasd123..");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage, "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}