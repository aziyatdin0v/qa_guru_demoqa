package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationFormPage;
import static io.qameta.allure.Allure.step;

public class PracticeFormWithTestDataTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillPracticeFormTest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage()
                    .setFirstName(TestData.firstName)
                    .setLastName(TestData.lastName)
                    .setEmail(TestData.email)
                    .setGender(TestData.gender)
                    .setPhoneNumber(TestData.phoneNumber)
                    .setBirthDate(TestData.day, TestData.month, TestData.year)
                    .setSubjects(TestData.subject)
                    .setHobbies(TestData.hobbies)
                    .setUploadPicture(TestData.picture)
                    .setCurrentAddress(TestData.currentAddress)
                    .setStateAndCity(TestData.state, TestData.city)
                    .setSubmit();
        });

        step("Fill form", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", TestData.firstName + " " + TestData.lastName)
                    .checkResult("Student Email", TestData.email)
                    .checkResult("Gender", TestData.gender)
                    .checkResult("Mobile", TestData.phoneNumber)
                    .checkResult("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
                    .checkResult("Subjects", TestData.subject)
                    .checkResult("Hobbies", TestData.hobbies)
                    .checkResult("Picture", TestData.picture)
                    .checkResult("Address", TestData.currentAddress)
                    .checkResult("State and City", TestData.state + " " + TestData.city);
        });
    }

    @Test
    void fillPracticeFormWithMinimumDataTest() {
        step("Check form results", () -> {
            registrationFormPage.openPage()
                    .setFirstName(TestData.firstName)
                    .setLastName(TestData.lastName)
                    .setGender(TestData.gender)
                    .setPhoneNumber(TestData.phoneNumber)
                    .setSubmit();

            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", TestData.firstName + " " + TestData.lastName)
                    .checkResult("Gender", TestData.gender)
                    .checkResult("Mobile", TestData.phoneNumber);
        });
    }

}
