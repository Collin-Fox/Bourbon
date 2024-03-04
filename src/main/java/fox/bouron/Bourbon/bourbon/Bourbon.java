package fox.bouron.Bourbon.bourbon;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bourbon")
public class Bourbon {
    @Id
    private int bID;
    private String distiller;
    private String name;
    private double abv;
    private int year;
    private int aged;

    public Bourbon(){}
    public Bourbon(int bID, String distiller, String name, double abv, int year, int aged) {
        this.bID = bID;
        this.distiller = distiller;
        this.name = name;
        this.abv = abv;
        this.year = year;
        this.aged = aged;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public String getDistiller() {
        return distiller;
    }

    public void setDistiller(String distiller) {
        this.distiller = distiller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAged() {
        return aged;
    }

    public void setAged(int aged) {
        this.aged = aged;
    }
}
