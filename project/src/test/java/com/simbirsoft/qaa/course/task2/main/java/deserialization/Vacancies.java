package com.simbirsoft.qaa.course.task2.main.java.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancies {
    private VacancyInfo[] items;

    public VacancyInfo[] getItems() {
        return this.items;
    }
}
