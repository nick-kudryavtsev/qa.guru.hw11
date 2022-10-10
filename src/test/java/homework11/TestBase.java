package homework11;

import com.codeborne.selenide.Configuration;
import homework11.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Screenshot name");
        Attach.pageSource("Page source name");
        Attach.browserConsoleLogs();
    }
}
