package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationFormPage;

public class PracticeFormWithPageObjectsTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Azat")
                .setLastName("Ziyatdinov")
                .setEmail("ziyatdinov@azat.com")
                .setGender("Male")
                .setPhoneNumber("9991122333")
                .setBirthDate("30", "October", "1994")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setUploadPicture("picture1.jpg")
                .setCurrentAddress("Moscow")
                .setStateAndCity("NCR", "Delhi")
                .setSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Azat Ziyatdinov")
                .checkResult("Student Email", "ziyatdinov@azat.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991122333")
                .checkResult("Date of Birth", "30 October,1994")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "picture1.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void fillPracticeFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName("Azat")
                .setLastName("Ziyatdinov")
                .setGender("Male")
                .setPhoneNumber("9991122333")
                .setSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Azat Ziyatdinov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991122333");
    }
}
