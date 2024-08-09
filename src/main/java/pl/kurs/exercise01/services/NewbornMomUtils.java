package pl.kurs.exercise01.services;

import pl.kurs.exercise01.models.Mom;
import pl.kurs.exercise01.models.Newborn;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewbornMomUtils {
    public static List<Newborn> getHighestBoyAndGirl(List<Newborn> newborns) {

        Newborn highestBoy = newborns.stream()
                .filter(newborn -> newborn.getGender().equals("s"))
                .max(Comparator.comparingInt(Newborn::getHeightCm))
                .orElse(null);

        Newborn highestGirl = newborns.stream()
                .filter(newborn -> newborn.getGender().equals("c"))
                .max(Comparator.comparingInt(Newborn::getHeightCm))
                .orElse(null);

        return List.of(highestBoy, highestGirl);

    }

    private static Map<DayOfWeek, Long> getDayOfWeekWithBirths(List<Newborn> newborns) {
        return newborns.stream()
                .map(newborn -> newborn.getBirthDate().getDayOfWeek())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map.Entry<DayOfWeek, Long> getDayOfWeekWithMostBirths(List<Newborn> newborns) {
        return getDayOfWeekWithBirths(newborns).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    public static Set<String> getNameOFMomsUnder25YearsOldWithKidsOver4000G(List<Mom> moms) {
        return moms.stream()
                .filter(mom -> mom.getAge() < 25)
                .filter(mom -> mom.getKids().stream()
                        .anyMatch(child -> child.getWeightGrams() > 4000))
                .map(Mom::getFirstName)
                .collect(Collectors.toSet());
    }

    public static List<Newborn> getGirlsWithSameNameAsMother(List<Newborn> newborns) {
        return newborns.stream()
                .filter(newborn -> newborn.getGender().equals("c"))
                .filter(newborn -> newborn.getMom().getFirstName().equals(newborn.getFirstName()))
                .toList();
    }

    public static List<Mom> getMomsWhoBornTwins(List<Mom> moms) {
        return moms.stream()
                .filter(mom -> {
                    List<Newborn> children = mom.getKids();
                    if (children.size() == 2) {
                        List<LocalDate> birthDates = children.stream()
                                .map(Newborn::getBirthDate)
                                .toList();

                        return birthDates.get(0).equals(birthDates.get(1));
                    }
                    return false;
                })
                .toList();
    }
}
