package pl.kurs.exercise01.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<String> fileReader(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String data;

            while ((data = bufferedReader.readLine()) != null)
                lines.add(data);
        }
        return lines;
    }
}
