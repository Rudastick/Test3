package pl.kurs.exercise04.services;

import pl.kurs.exercise04.model.Figura;

import java.io.*;
import java.util.List;

public class FiguraSerializer {
    public static void zapiszDoPliku(List<Figura> figury, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(figury);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Figura> wczytajZPliku(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Figura>) ois.readObject();
        }
    }
}
