package pl.kurs.exercise04.app;

import pl.kurs.exercise04.model.Figura;
import pl.kurs.exercise04.model.Kwadrat;
import pl.kurs.exercise04.services.FiguraSerializer;
import pl.kurs.exercise04.services.FiguraUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20));
        for (Figura f : figury) {
            System.out.println(f);
        }

        Figura figuraZNajwiekszymObwodem = FiguraUtils.getFiguraZNajwiekszymObwodem(figury);
        Figura figuraZNajwikeszymPolem = FiguraUtils.getFiguraZNajwikeszymPolem(figury);

        System.out.println(figuraZNajwiekszymObwodem);
        System.out.println(figuraZNajwikeszymPolem);

        System.out.println(figury.contains(new Kwadrat(10)));

        try {
            FiguraSerializer.zapiszDoPliku(figury, "C:\\Users\\Macie\\Downloads\\figury.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Figura> wczytaneFigury = FiguraSerializer.wczytajZPliku("C:\\Users\\Macie\\Downloads\\figury.ser");
            for (Figura figura : wczytaneFigury){
                System.out.println(figura);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
