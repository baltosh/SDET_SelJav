package com.simbirsoft.qaa.course.task2.main.java.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerInfo {
    public String id;
    public String name;
}
