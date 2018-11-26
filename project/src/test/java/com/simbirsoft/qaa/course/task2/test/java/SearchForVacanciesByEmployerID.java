package com.simbirsoft.qaa.course.task2.test.java;

import com.simbirsoft.qaa.course.task2.main.java.deserialization.Vacancies;
import com.simbirsoft.qaa.course.task2.main.java.deserialization.VacancyInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.simbirsoft.qaa.course.task2.main.java.RequestsToHH.RequestVacanciesByEmployerID.RequestByEmployerID;

public class SearchForVacanciesByEmployerID {

    @Test
    @Parameters({"APIurl", "parameterName", "employerID", "responseCode"})
    public void searchVacancies(String APIurl, String parameterName,
                                String employerID, String responseCode) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Vacancies vacancies = RequestByEmployerID(Vacancies.class, request,
                APIurl, parameterName, employerID, responseCode);

        for (VacancyInfo vacancy :
                vacancies.getItems()) {
            Assert.assertEquals(vacancy.employer.id, employerID);
        }
    }

}
