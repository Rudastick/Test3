package pl.kurs.exercise03.app;

import pl.kurs.exercise03.models.Person;
import pl.kurs.exercise03.models.Student;
import pl.kurs.exercise03.models.Worker;
import pl.kurs.exercise03.services.PeopleUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Student("John", "Doe", "12345678901", "New York", "Group A", new BigDecimal("1500")),
                new Student("Jane", "Smith", "12345678902", "Los Angeles", "Group B", new BigDecimal("1800")),
                new Student("Emily", "Johnson", "12345678903", "Chicago", "Group A", new BigDecimal("1600")),
                new Student("Michael", "Brown", "12345678904", "Houston", "Group C", new BigDecimal("1700")),
                new Student("Sarah", "Davis", "12345678905", "Phoenix", "Group B", new BigDecimal("1750")),
                new Worker("Alice", "Wilson", "22345678901", "Philadelphia", "Manager", new BigDecimal("5000")),
                new Worker("Robert", "Martinez", "22345678902", "San Antonio", "Engineer", new BigDecimal("4500")),
                new Worker("David", "Anderson", "22345678903", "San Diego", "Technician", new BigDecimal("4000")),
                new Worker("Laura", "Thomas", "22345678904", "Dallas", "Analyst", new BigDecimal("4200")),
                new Worker("James", "Jackson", "22345678905", "San Jose", "Developer", new BigDecimal("4800"))
        );
        people.forEach(System.out::println);


        System.out.println("-----------------------------------");

        PeopleUtils.saveOsobyToFile(people, "C:\\Users\\Macie\\Downloads\\people.ser");

        List<Person> people1 = PeopleUtils.loadOsobyFromFile("C:\\Users\\Macie\\Downloads\\people.ser");

        people1.forEach(System.out::println);

    }
}
