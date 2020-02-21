package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.repository.ProfilesRepo;
import pl.agaf.steelcalculation.steelcalculationweb.repository.SteelsRepo;
import pl.agaf.steelcalculation.steelcalculationweb.services.Data;

import java.util.function.Function;

@Component
class Form2DataMapper implements Function<FormData,Data> {
    @Autowired
    private ProfilesRepo profilesRepo;

    @Autowired
    private SteelsRepo steelsRepo;

    @Override
    public Data apply(FormData formData) {
        double bendingMoment = Double. parseDouble(formData.getBendingMoment());
        double tensionForce = Double.parseDouble(formData.getTensionForce());
        Steel steel = steelsRepo.find(formData.getSteel()).get();
        Profile profile = profilesRepo.find(formData.getProfile()).get();

        return new Data(bendingMoment, tensionForce, steel, profile);
    }
}
