package com.simbirsoft.qaa.course.task2.main.java.RequestsToHH;


import com.simbirsoft.qaa.course.task2.main.java.deserialization.Vacancies;
import com.simbirsoft.qaa.course.task2.main.java.deserialization.VacancyInfo;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Type;

public class RequestVacanciesByEmployerID {

    public static Vacancies RequestByEmployerID(Type VacancyArray, RequestSpecification request, String url,
                                                String parameterName, String parameterValue, String responseCode) {
        return request
                .params(parameterName, parameterValue)
                .get(url)
                .then()
                .statusCode(Integer.parseInt(responseCode))
                .extract()
                .as(VacancyArray);
    }

}
