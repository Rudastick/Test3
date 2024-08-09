package pl.kurs.exercise01.services;

import pl.kurs.exercise01.models.Mom;

import java.util.ArrayList;
import java.util.List;

public class MomParser {
    public static List<Mom> parseMoms(List<String> momsData) {
        List<Mom> moms = new ArrayList<>();

        for (String momsDatum : momsData) {
            String[] line = momsDatum.split(" ");

            String identifier = line[0];
            String name = line[1];
            int age = Integer.parseInt(line[2]);

            moms.add(new Mom(identifier, name, age));
        }
        return moms;
    }
}
