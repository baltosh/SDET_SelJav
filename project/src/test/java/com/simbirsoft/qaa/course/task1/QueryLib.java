package com.simbirsoft.qaa.course.task1;

import java.util.ArrayList;
import java.util.List;

public class QueryLib {
    private List<String> queryList;

    public QueryLib() {
        queryList = new ArrayList<>();
        queryList.add("Автоматизация тестирования");
        queryList.add("Sad Pablo Escobar");
        queryList.add("Happy Pablo Escobar");
    }

    public String getQueryText(int index) {
        if (index > queryList.size()) index = queryList.size() - 1;

        return queryList.get(index);
    }
}
