package com.demoqa.tests;

import com.github.javafaker.Faker;
import utils.RandomMonth;
import java.util.Locale;

public class TestData {
    private static Faker faker = new Faker(new Locale("en-US"));
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 25)),
            month = String.valueOf(RandomMonth.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1991, 2005)),
            subject = "Math",
            hobbies = "Sports",
            picture = "picture1.jpg",
            currentAddress = faker.address().streetAddress(),
            state = "NCR",
            city = "Delhi";
}
