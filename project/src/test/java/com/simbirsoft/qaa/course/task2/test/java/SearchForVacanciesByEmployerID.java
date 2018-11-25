package com.simbirsoft.qaa.course.task2.test.java;

import com.simbirsoft.qaa.course.task2.main.java.ConstructURL;
import com.simbirsoft.qaa.course.task2.main.java.deserialization.VacancyInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.simbirsoft.qaa.course.task2.main.java.RequestsToHH.RequestVacanciesByEmployerID.RequestByEmployerID;

public class SearchForVacanciesByEmployerID {

    @Test
    @Parameters({"APIurl", "employerID"})
    public void searchVacancies(String APIurl, String employerID) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        VacancyInfo[] vacancies = RequestByEmployerID(request, ConstructURL.VacanciesByEmployerID(APIurl, employerID));

        for (VacancyInfo vacancy :
                vacancies) {
            Assert.assertEquals(vacancy.employer.id, employerID, "");
        }
    }

}
