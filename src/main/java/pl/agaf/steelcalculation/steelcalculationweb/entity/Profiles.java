package pl.agaf.steelcalculation.steelcalculationweb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "profiles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profiles {
    @XmlElement(name = "profile")
    private List<Profile> profiles;

    public List<Profile> getProfiles(){
        return profiles;
    }
}
