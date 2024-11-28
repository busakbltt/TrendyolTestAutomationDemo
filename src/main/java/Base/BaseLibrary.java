package Base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import static Base.BaseTest.driver;

public class BaseLibrary extends Data {

    @Step("{time} Süre beklenir")
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    @Step("Field kontrolü sağlanmıştır")
    public void assertEqualsText(String text, String value) {
        screenshot();
        Assert.assertEquals(text, value);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
