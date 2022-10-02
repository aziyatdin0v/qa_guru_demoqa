package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    String firstName = "Azat";
    String lastName = "Ziyatdinov";
    String email = "ziyatdinov@azat.com";
    String phoneNumber = "9991122333";
    String currentAddress = "Moscow";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("picture1.jpg");

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //проверка
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        checkTableRow("Student Name", firstName + ' ' + lastName);
        checkTableRow("Student Email", email);
        checkTableRow("Gender", "Male");
        checkTableRow("Mobile", phoneNumber);
        checkTableRow("Date of Birth", "30 October,1994");
        checkTableRow("Subjects", "Maths");
        checkTableRow("Hobbies", "Sports, Reading, Music");
        checkTableRow("Picture", "picture1.jpg");
        checkTableRow("Address", currentAddress);
        checkTableRow("State and City", "NCR Delhi");

//      $(".table-responsive").shouldHave(text(firstName), text(lastName),
//                text(email), text("Male"), text(phoneNumber), text("30 October,1994"),
//                text("Maths"), text("Sports, Reading, Music"), text("picture1.jpg"), text(currentAddress), text("NCR Delhi"));

    }

    private void checkTableRow(String title, String expectedValue) {
        $(".table-responsive").$(byText(title)).parent().shouldHave(text(expectedValue));
    }
}
