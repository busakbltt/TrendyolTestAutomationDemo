import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void SuccessfullLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);
        Assert.assertEquals("Hesabım", mainPage.getUserInfo());
    }

    @Test
    public void UnSuccessfullLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword("Qweasd123..")
                .clickLogin();

        sleep(3000);
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");

        loginPage.fillMail("mysticdefe@gmail.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void ValidateLogin() throws InterruptedException {
        loginPage.fillMail("mystic.keremgmail.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        Assert.assertEquals(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}