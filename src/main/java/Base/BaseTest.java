package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/giris?cb=%2F");
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }
}
