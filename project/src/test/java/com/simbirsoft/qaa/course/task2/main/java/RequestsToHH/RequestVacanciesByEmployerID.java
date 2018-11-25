package com.simbirsoft.qaa.course.task2.main.java.RequestsToHH;


import com.simbirsoft.qaa.course.task2.main.java.deserialization.VacancyInfo;
import io.restassured.specification.RequestSpecification;

public class RequestVacanciesByEmployerID {

    public static VacancyInfo[] RequestByEmployerID(RequestSpecification request, String url) {
        return request
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath().getObject("items", VacancyInfo[].class);
    }

}
