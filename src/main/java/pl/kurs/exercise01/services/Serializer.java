package pl.kurs.exercise01.services;

import java.io.*;
import java.util.List;

public class Serializer {
    public static <T extends Serializable> void saveFile(String filePath, List<T> object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath.concat(".ser")))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> T readFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath.concat(".ser")))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
