package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static List<Employee> employees;

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Smith"));
        employees.add(new Employee(3, "John", "Doe"));
        employees.add(new Employee(4, "Bob", "Johnson"));
        employees.add(new Employee(2, "Jane", "Smith"));
        employees.add(new Employee(5, "Alice", "Williams"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniqueEmployees = findUniques(employees);
        System.out.println("Unique Employees: " + uniqueEmployees);

        List<Employee> uniqueList = removeDuplicates(employees);
        System.out.println("Unique List (No duplicates): " + uniqueList);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null && !seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();
        Set<Employee> seen = new HashSet<>();

        for (Employee employee : employees) {
            if (employee != null && seen.add(employee)) {
                uniqueEmployees.put(employee.getId(), employee);
            }
        }
        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Main.employees = employees;
        Set<Employee> seen = new HashSet<>();
        List<Employee> uniqueList = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null && seen.add(employee)) {
                uniqueList.add(employee);
            }
        }
        return uniqueList;
    }

}
