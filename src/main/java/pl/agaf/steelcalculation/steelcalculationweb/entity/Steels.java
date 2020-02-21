package pl.agaf.steelcalculation.steelcalculationweb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "steels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Steels {
    @XmlElement(name = "steel")
    private List<Steel> steels;////

    public List<Steel> getSteels(){
        return steels;
    }

    public void setSteels(List<Steel> steels){
        this.steels = steels;
    }

}
