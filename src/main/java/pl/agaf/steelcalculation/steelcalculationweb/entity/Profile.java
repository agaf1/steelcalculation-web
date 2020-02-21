package pl.agaf.steelcalculation.steelcalculationweb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {

    private String name;
    private double area;
    private double sectionModulus;

    public Profile(){}

    public Profile(String name, double area, double sectionModulus){
        this.name = name;
        this.area = area;
        this.sectionModulus = sectionModulus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Double.compare(profile.area, area) == 0 &&
                Double.compare(profile.sectionModulus, sectionModulus) == 0 &&
                Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, sectionModulus);
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getSectionModulus() {
        return sectionModulus;
    }
}
