package pl.kurs.exercise04.services;

import pl.kurs.exercise04.model.Figura;

import java.util.Comparator;
import java.util.List;

public class FiguraUtils {
    public static Figura getFiguraZNajwiekszymObwodem(List<Figura> figury) {
        return figury.stream()
                .max(Comparator.comparing(Figura::getObwod))
                .orElse(null);
    }

    public static Figura getFiguraZNajwikeszymPolem(List<Figura> figury) {
        return figury.stream()
                .max(Comparator.comparing(Figura::getPole))
                .orElse(null);
    }
}
