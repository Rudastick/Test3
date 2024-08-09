package pl.kurs.exercise04.model;

import java.io.Serial;
import java.util.Objects;

public class Prostokat extends Figura {
    @Serial
    private static final long serialVersionUID = 4L;
    public double dlugosc;
    public double wysokosc;

    public Prostokat(double dlugosc, double wysokosc) {
        super(0);
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public Prostokat(double dlugosc, double wysokosc, int id) {
        super(id);
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    @Override
    public double getObwod() {
        return 2 * (dlugosc + wysokosc);
    }

    @Override
    public double getPole() {
        return dlugosc * wysokosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return dlugosc == prostokat.dlugosc && wysokosc == prostokat.wysokosc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dlugosc, wysokosc);
    }

    @Override
    public String toString() {
        return "Figura nr " + getId() + ": Prostokat o bokach " + getDlugosc() + "x" + getWysokosc();

    }
}
