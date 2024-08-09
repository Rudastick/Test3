package pl.kurs.exercise04.model;

import java.io.Serial;
import java.util.Objects;

public class Kolo extends Figura {
    @Serial
    private static final long serialVersionUID = 2L;
    private double promien;

    public Kolo(double promien) {
        super(0);
        this.promien = promien;
    }

    protected Kolo(double promien, int id) {
        super(id);
        this.promien = promien;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    @Override
    public double getObwod() {
        return 2 * Math.PI * promien;
    }

    @Override
    public double getPole() {
        return Math.PI * promien * promien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return Double.compare(promien, kolo.promien) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(promien);
    }

    @Override
    public String toString() {
        return "Figura nr " + getId() + ": Koło o promieniu " + getPromien() ;
    }
}
