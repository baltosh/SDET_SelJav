package com.simbirsoft.qaa.course.task2.main.java.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyInfo {
    public String id;
    public String name;
    public EmployerInfo employer;
}
