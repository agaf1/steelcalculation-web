package pl.agaf.steelcalculation.steelcalculationweb.repository;


import org.springframework.stereotype.Repository;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profiles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProfilesRepo {

    private Profiles profiles;
    private File profileFile;

    public ProfilesRepo() {
        JAXBContext jaxbContext = null;
        try {
            profileFile = new File(this.getClass().getClassLoader().getResource("profiles.xml").toURI());
            jaxbContext = JAXBContext.newInstance(Profiles.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            profiles = (Profiles) jaxbUnmarshaller.unmarshal(profileFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Profiles loadAll() {
        return this.profiles;
    }

    public List<Profile> sortedList() {
        List<Profile> sortedProfile = this.loadAll().getProfiles().stream()
                .sorted(Comparator.comparing(Profile::getSectionModulus))
                .collect(Collectors.toList());

        return sortedProfile;
    }

    public Optional<Profile> find(String profileName) {
        Optional<Profile> profile = this.profiles.getProfiles()
                .stream()
                .filter(pr -> pr.getName().equals(profileName))
                .findAny();
        return profile;
    }

    public Optional<Profile> findBySectionModulus (Double sectionModulus){
        Optional<Profile> profile = this.sortedList().stream()
                .filter(pr -> pr.getSectionModulus()>sectionModulus)
                .findFirst();

        return profile;
    }

    public void addNewProfile(Profile profile) {
        if (profiles.getProfiles().contains(profile) == false) {
            profiles.getProfiles().add(profile);
            saveProfile();
        }
    }


    private void saveProfile() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Profiles.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(profiles, profileFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
