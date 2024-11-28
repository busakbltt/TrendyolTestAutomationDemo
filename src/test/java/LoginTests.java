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

    @Test(description = "Başarılı kullanıcı giriş kontrolü")
    public void SuccessfullLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);

        assertEqualsText("Hesabım", mainPage.getUserInfo());
    }

    @Test(description = "Başarısız kullanıcı giriş kontrolü")
    public void UnSuccessfullLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword("Qweasd123..")
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");

        loginPage.fillMail("mysticdefe@gmail.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test(description = "Geçersiz karakter girişi")
    public void ValidateLogin() throws InterruptedException {
        loginPage.fillMail("mystic.keremgmail.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }

    @Test(description = "Max min karakter kontrolü")
    public void MaxMinCharacterControl() throws InterruptedException {
        loginPage.clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen e-posta ve/veya şifre alanını doldurunuz");

        loginPage.fillMail("arrestedbyoengeadfdsafmsadlkglasdkghoğsahgoılğasdhgılkğsadghbnlasdhbglkjasdhg fasdnhcgkljfsahkjlsadbklgjsadbhkljghasbdkjlbsadkljlksfdjlkhgvdfsajklsdfajhtgjklasdfjhgdasfhjlkjlhkg")
                .fillPassword("dsafdasjkhfodsahgsdahgdsahgljksadghljksadhglkjasdhgoısdaghoıusadhgıosadhgoısadhgoısadhgoısahgoısadhgoıasdhgoısadhgoısahgoıpsadhgoıpsahgosaoıshgoasıhgsaıoghasıohghsdaıoghsaıodgsad")
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}