package pl.agaf.steelcalculation.steelcalculationweb.repository;

import org.springframework.stereotype.Repository;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steels;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SteelsRepo {

    private Steels steels;
    private File steelFile;

    public SteelsRepo() {
        JAXBContext jaxbContext = null;
        try {
            steelFile = new File(this.getClass().getClassLoader().getResource("steels.xml").toURI());

            jaxbContext = JAXBContext.newInstance(Steels.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            steels = (Steels) jaxbUnmarshaller.unmarshal(steelFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Steels loadAll() {

        return this.steels;
    }

    public List<Steel> sortedList(){

        List<Steel> sortedSteels = this.loadAll().getSteels().stream()
                .sorted(Comparator.comparing(Steel::getBendingStrength))
                .collect(Collectors.toList());

        return sortedSteels;
    }

    public Optional<Steel> find(String steelName) {
        Optional<Steel> steel = this.steels.getSteels()
                .stream()
                .filter(st -> st.getName().equals(steelName))
                .findAny();
        return steel;
    }

    public void addNewSteel(Steel steel) {
        if (steels.getSteels().contains(steel) == false) {
            this.steels.getSteels().add(steel);
            saveSteel();
        }
    }

    private void saveSteel() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Steels.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(steels, steelFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

