package com.simbirsoft.qaa.course.task2.main.java;

public class ConstructURL {
    public static String VacanciesByEmployerID(String APIurl, String employerID) {
        return APIurl + "?employer_id=" + employerID;
    }
}
