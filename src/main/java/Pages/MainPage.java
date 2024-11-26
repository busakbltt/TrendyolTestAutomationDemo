package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    public String getUserInfo() {
        String text = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        return text;
    }
}
