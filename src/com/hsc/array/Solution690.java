package com.hsc.array;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    private HashSet<Integer> set = new HashSet<>();

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream()
                .collect(Collectors.toMap(employee -> employee.id, employee -> employee));
        return f(map, id);
    }

    private int f(Map<Integer, Employee> map, int id) {
        if (set.contains(id)) {
            return 0;
        }

        Employee employee = map.get(id);
        int sum = employee.importance;
        set.add(id);
        List<Integer> subordinates = employee.subordinates;
        for (int subId: subordinates) {
            sum += f(map, subId);
        }
        return sum;
    }
}
