package homework11.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName){
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{pageSourceName}", type="text/plain")
    public static byte[] pageSource(String pageSourceName){
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachLogName}", type = "text/plain")
    public static String attachAsText(String attachLogName, String message){
        return message;
    }
    public static void browserConsoleLogs(){
        attachAsText(
                "Browser console.logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }
}
