package pl.agaf.steelcalculation.steelcalculationweb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "steel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Steel {
    private String name;
    private int bendingStrength;

    public Steel(){}

    public Steel (String name, int bendingStrength){
        this.name = name;
        this.bendingStrength = bendingStrength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Steel steel = (Steel) o;
        return bendingStrength == steel.bendingStrength &&
                Objects.equals(name, steel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bendingStrength);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBendingStrength() {
        return bendingStrength;
    }

    public void setBendingStrength(int bendingStrength) {
        this.bendingStrength = bendingStrength;
    }
}
