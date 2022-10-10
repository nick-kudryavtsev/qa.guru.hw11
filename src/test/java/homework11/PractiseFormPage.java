package homework11;

import com.codeborne.selenide.SelenideElement;
import homework11.components.Calendar;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PractiseFormPage {
    Calendar calendarComponent = new Calendar();

    //  elements
    private SelenideElement
            username = $("#firstName"),
            lastname = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber"),
            subject = $("#subjectsInput"),
            radio = $(".custom-control.custom-checkbox.custom-control-inline:nth-child(1)"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    //  actions
    public PractiseFormPage openPage(){
        open("automation-practice-form");
        zoom(0.5);
        return this;
    }
    public PractiseFormPage setUsername(String username){
        this.username.setValue(username);
        return this;
    }
    public PractiseFormPage setLastname(String lastname){
        this.lastname.setValue(lastname);
        return this;
    }
    public PractiseFormPage setUserEmail(String email){
        this.userEmail.setValue(email);
        return this;
    }
    public PractiseFormPage setGender(String value){
        this.gender.$(byText(value)).click();
        return this;
    }
    public PractiseFormPage setPhone(String value){
        this.phone.setValue(value);
        return this;
    }
    public PractiseFormPage setBirthday(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public PractiseFormPage setSubject(String value){
        this.subject.setValue(value).pressEnter();
        return this;
    }
    public PractiseFormPage setRadio(){
        this.radio.click();
        return this;
    }
    public PractiseFormPage uploadImg(String value){
        this.picture.uploadFromClasspath(value);
        return this;
    }
    public PractiseFormPage setAddress(String value){
        this.address.setValue(value);
        return this;
    }
    public PractiseFormPage setState(String value){
        this.state.click();
        this.stateWrapper.$(byText(value)).click();
        return this;
    }
    public PractiseFormPage setCity(String value){
        this.city.click();
        this.cityWrapper.$(byText(value)).click();
        return this;
    }
    public PractiseFormPage clickOnSubmit(){
        this.submit.click();
        return this;
    }

}
