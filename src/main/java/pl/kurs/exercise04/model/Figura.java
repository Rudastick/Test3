package pl.kurs.exercise04.model;

import java.io.Serial;
import java.io.Serializable;

public abstract class Figura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int counter = 0;
    private int id;

    protected Figura(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public abstract double getObwod();
    public abstract double getPole();

    public static Kwadrat stworzKwadrat(double bok) {
        return new Kwadrat(bok, ++counter);
    }

    public static Kolo stworzKolo(double promien) {
        return new Kolo(promien, ++counter);
    }

    public static Prostokat stworzProstokat(double bokA, double bokB) {
        return new Prostokat(bokA, bokB, ++counter);
    }
}
