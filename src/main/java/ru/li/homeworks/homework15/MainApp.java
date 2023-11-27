package ru.li.homeworks.homework15;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Integer> list = fillRange(3, 15);
        int sum = sumElements(list);
        rewriteList(8, list);
        increaseListValues(2, list);
        // ----------------------------------------------------
        ArrayList<Employee> employees = getListOfEmployee();
        ArrayList<String> names = getEmployeeNames(employees);
        ArrayList<Employee> selectedEmployees = selectedEmployeesByAge(employees, 40);
        avarageAgeExceeds(employees, 30);
        Employee yongestEmployee = getYongestEmployee(employees);
    }

    private static Employee getYongestEmployee(ArrayList<Employee> employees) {
        Employee result = null;
        for (Employee employee : employees) {
            if (result == null) {
                result = employee;
                continue;
            }
            if (result.getAge() > employee.getAge()) {
                result = employee;
            }
        }
        return result;
    }

    private static boolean avarageAgeExceeds(ArrayList<Employee> employees, int minAvarageAge) {
        int generalAge = 0;
        for (Employee employee : employees) {
            generalAge += employee.getAge();
        }
        int avarageAge = generalAge / employees.size();
        System.out.println("Средний возраст сотрудников: " + avarageAge + " Превышает минимальный порог: " + (avarageAge > minAvarageAge));
        return avarageAge > minAvarageAge;
    }

    private static ArrayList<Employee> selectedEmployeesByAge(ArrayList<Employee> employees, int minAge) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                result.add(employee);
            }
        }
        return result;
    }

    private static ArrayList<String> getEmployeeNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    private static ArrayList<Employee> getListOfEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Oliver", 20));
        employees.add(new Employee("Jack", 25));
        employees.add(new Employee("Harry", 30));
        employees.add(new Employee("Jacob", 35));
        employees.add(new Employee("Oscar", 40));
        employees.add(new Employee("James", 45));
        employees.add(new Employee("Amelia", 50));
        return employees;
    }

    private static void increaseListValues(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + value);
        }
        System.out.println(list);
    }

    private static void rewriteList(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
        System.out.println(list);
    }

    private static int sumElements(ArrayList<Integer> list) {
        int result = 0;
        for (Integer number : list) {
            if (number > 5) {
                result += number;
            }
        }
        System.out.println(result);
        return result;
    }

    private static ArrayList<Integer> fillRange(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        System.out.println(result);
        return result;
    }
}
