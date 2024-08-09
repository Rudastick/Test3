package pl.kurs.exercise01.services;

import pl.kurs.exercise01.models.Mom;
import pl.kurs.exercise01.models.Newborn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class NewbornParser {
    public static List<Newborn> parseNewborns(List<String> newbornsData, List<Mom> moms) {

        List<Newborn> newborns = new ArrayList<>();

        for (String newbornsDatum : newbornsData) {
            String[] line = newbornsDatum.split(" ");

            String identifier = line[0];
            String gender = line[1];
            String firstName = line[2];
            LocalDate birthDate = LocalDate.parse(line[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            int weight = Integer.parseInt(line[4]);
            int height = Integer.parseInt(line[5]);
            String momsIdentifier = line[6];

            Mom mom = moms.stream()
                    .filter(mom1 -> momsIdentifier.equals(mom1.getIdentifier()))
                    .findFirst()
                    .orElse(null);

            newborns.add(new Newborn(identifier, gender, firstName, birthDate, weight, height, mom));

        }
        return newborns;
    }
}
