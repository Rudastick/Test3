package pl.kurs.exercise04.model;

import java.io.Serial;
import java.util.Objects;

public class Kwadrat extends Figura {
    @Serial
    private static final long serialVersionUID = 3L;
    public double dlugosc;

    public Kwadrat(double dlugosc) {
        super(0);
        this.dlugosc = dlugosc;

    }

    protected Kwadrat(double dlugosc, int id) {
        super(id);
        this.dlugosc = dlugosc;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    @Override
    public double getObwod() {
        return 4 * dlugosc;
    }

    @Override
    public double getPole() {
        return dlugosc * dlugosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return dlugosc == kwadrat.dlugosc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dlugosc);
    }

    @Override
    public String toString() {
        return "Figura nr " + getId() + ": Kwadrat o boku " + getDlugosc() ;

    }
}
