package homework11;

import com.codeborne.selenide.logevents.SelenideLogger;
import homework11.components.TableResults;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PractiseFormTestSuite extends TestBase {

    @Test
    void checkPractiseForm(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        PractiseFormPage practiseFormPage = new PractiseFormPage();
        TableResults tableResults = new TableResults();

        step("Open page 'https://demoqa.com/automation-practice-form' with zoom .5", () -> {
            practiseFormPage.openPage();
        });
        step("Filling 'Student Registration Form'", () -> {
            practiseFormPage.setUsername("Nick")
                    .setLastname("Kudryavtsev")
                    .setUserEmail("nick@ya.ru")
                    .setGender("Male")
                    .setPhone("8800555353")
                    .setBirthday("18", "July", "1997")
                    .setSubject("Math")
                    .setRadio()
                    .uploadImg("lesson.png")
                    .setAddress("Smth")
                    .setState("NCR")
                    .setCity("Delhi")
                    .clickOnSubmit();
        });
        step("Check for input === output", () -> {
            tableResults.isModalAppear()
                    .checkResults("Nick")
                    .checkResults("Kudryavtsev")
                    .checkResults("nick@ya.ru")
                    .checkResults("8800555353");
        });
    }
}
