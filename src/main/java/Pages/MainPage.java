package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Kullanıcı bilgisi getirilir")
    public String getUserInfo() {
        String text = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        Allure.addAttachment(text + " metni ekanda görüntülenmiştir", "");
        screenshot();
        return text;
    }
}
