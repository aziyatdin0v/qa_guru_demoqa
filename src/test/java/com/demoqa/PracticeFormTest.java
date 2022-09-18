package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("div[aria-label='Choose Sunday, October 30th, 1994']").click();

        $("#subjectsInput").setValue("Maths").pressEnter();;
        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("picture1.jpg");

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        //проверка
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text(email), text("Male"), text(phoneNumber), text("30 October,1994"),
                text("Maths"), text("Sports, Reading, Music"), text("picture1.jpg"), text(currentAddress), text("NCR Delhi"));

        /* как лучше сделать проверку на соответствие паре ключ-значение в таблице?
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text(firstName+ " " +lastName));
        $(".table-responsive").$(byText("Student Name")).parent().lastChild().shouldHave(text(firstName+ " " +lastName));
         */
    }

}
