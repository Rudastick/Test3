package pl.kurs.exercise01.app;

import pl.kurs.exercise01.models.Mom;
import pl.kurs.exercise01.models.Newborn;
import pl.kurs.exercise01.services.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.*;


public class ExerciseOneRunner {
    public static void main(String[] args) {
        List<Mom> moms = new ArrayList<>();
        List<Newborn> newborns = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Hello :)");

        System.out.println("Please provide filePath for file with moms");
        String momsFilePath = scanner.next();

        System.out.println("Now, please provide filePath for file with newborns");
        String newbornsFilePath = scanner.next();

        try {
            List<String> momsData = FileHandler.fileReader(momsFilePath);
            List<String> newbornsData = FileHandler.fileReader(newbornsFilePath);

            moms.addAll(MomParser.parseMoms(momsData));
            newborns.addAll(NewbornParser.parseNewborns(newbornsData, moms));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println("""
                    What would you like to do now?
                    1. Perform methods from exercise.
                                    
                    2. Save Objects to file
                                    
                    3. Read Objects from file.
                                    
                    4.exit
                    """);

            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.");

                    List<Newborn> highestBoyAndGirl = NewbornMomUtils.getHighestBoyAndGirl(newborns);

                    if (highestBoyAndGirl.get(0) != null) {
                        Newborn highestBoy = highestBoyAndGirl.getFirst();
                        System.out.println("Highest boy's name is " + highestBoy.getFirstName() + " and height is " + highestBoy.getHeightCm() + "cm");
                    } else {
                        System.out.println("No boy found");

                    }

                    if (highestBoyAndGirl.get(1) != null) {
                        Newborn highestGirl = highestBoyAndGirl.get(1);
                        System.out.println("Highest girl's name is " + highestGirl.getFirstName() + " and height is " + highestGirl.getHeightCm() + "cm");

                    } else {
                        System.out.println("No girl found");

                    }
                    System.out.println("-------------------------------------------------------------------------");

                    System.out.println("W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.");

                    Map.Entry<DayOfWeek, Long> dayOfWeekWithMostBirths = NewbornMomUtils.getDayOfWeekWithMostBirths(newborns);
                    System.out.println("Most newborns (" + dayOfWeekWithMostBirths.getValue() + ") were born on " + dayOfWeekWithMostBirths.getKey());
                    System.out.println("-------------------------------------------------------------------------");

                    System.out.println("Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.");
                    Set<String> nameOFMomsUnder25YearsOldWithKidsOver4000G = NewbornMomUtils.getNameOFMomsUnder25YearsOldWithKidsOver4000G(moms);
                    System.out.println(nameOFMomsUnder25YearsOldWithKidsOver4000G);
                    System.out.println("-------------------------------------------------------------------------");

                    System.out.println("Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.");
                    List<Newborn> girlsWithSameNameAsMother = NewbornMomUtils.getGirlsWithSameNameAsMother(newborns);
                    girlsWithSameNameAsMother.forEach(newborn -> System.out.println(newborn.getFirstName() + " " + newborn.getBirthDate()));
                    System.out.println("-------------------------------------------------------------------------");

                    System.out.println("Znajdz matki które urodziły bliźnięta.");
                    List<Mom> momsWhoBornTwins = NewbornMomUtils.getMomsWhoBornTwins(moms);
                    System.out.println(momsWhoBornTwins);
                    break;

                case 2:
                    System.out.println("You've chosen saving objects to file. Now choose if you want to save Moms (1) or Newborns (2) or both (3)");
                    int saveOption = scanner.nextInt();

                    switch (saveOption) {
                        case 1:
                            System.out.println("Please input file path with filename in format like this: C:\\Users\\Macie\\Downloads\\moms ");
                            String filePathMom = scanner.next();
                            Serializer.saveFile(filePathMom, moms);
                            break;
                        case 2:
                            System.out.println("Please input file path with filename in format like this: C:\\Users\\Macie\\Downloads\\newborns ");
                            String filePathNewborn = scanner.next();
                            Serializer.saveFile(filePathNewborn, newborns);
                            break;
                        case 3:
                            System.out.println("Please input file path with filename in format like this: C:\\Users\\Macie\\Downloads\\moms");
                            String filePathMomBoth = scanner.next();
                            System.out.println("Please input file path with filename in format like this: C:\\Users\\Macie\\Downloads\\newborns");
                            String filePathNewbornBoth = scanner.next();
                            Serializer.saveFile(filePathMomBoth, moms);
                            Serializer.saveFile(filePathNewbornBoth, newborns);
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("You've chosen reading objects from file. Now choose if you want to read Moms (1) or Newborns (2) or both (3)");
                    int readOption = scanner.nextInt();

                    switch (readOption) {
                        case 1:
                            System.out.println("Please input file path with filename to read moms: ");
                            String filePathReadMom = scanner.next();
                            moms = Serializer.readFile(filePathReadMom);
                            moms.forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Please input file path with filename to read newborns: ");
                            String filePathReadNewborn = scanner.next();
                            newborns = Serializer.readFile(filePathReadNewborn);
                            newborns.forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Please input file path with filename to read moms: ");
                            String filePathReadMomBoth = scanner.next();
                            System.out.println("Please input file path with filename to read newborns: ");
                            String filePathReadNewbornBoth = scanner.next();
                            moms = Serializer.readFile(filePathReadMomBoth);
                            newborns = Serializer.readFile(filePathReadNewbornBoth);

                            moms.forEach(System.out::println);
                            newborns.forEach(System.out::println);
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("exiting");
                    return;
                default:
                    System.out.println("Wrong Input choose 1/2/3/4");
            }
        }


    }
}

