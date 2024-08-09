package pl.kurs.exercise03.services;

import pl.kurs.exercise03.models.Person;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PeopleUtils {
    public static Person findPersonWithHighestSalary(List<Person> personList) {
        return personList.stream()
                .max(Comparator.comparing(Person::getIncome))
                .orElse(null);
    }

    public static long countWomen(List<Person> personList) {

        return personList.stream()
                .filter(person -> "Female".equals(person.getGender()))
                .count();
    }
    public static void saveOsobyToFile(List<Person> osoby, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(osoby);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> loadOsobyFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

