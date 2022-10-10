package homework11;

import com.codeborne.selenide.Configuration;
import homework11.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Screenshot name");
        Attach.pageSource("Page source name");
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
