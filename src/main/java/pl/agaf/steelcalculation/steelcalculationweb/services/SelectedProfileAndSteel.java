package pl.agaf.steelcalculation.steelcalculationweb.services;

import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;

public class SelectedProfileAndSteel {

    private Profile profile;
    private Steel steel;

    public SelectedProfileAndSteel(Profile profile, Steel steel) {
        this.profile = profile;
        this.steel = steel;
    }

    public Profile getProfile() {
        return profile;
    }

    public Steel getSteel() {
        return steel;
    }
}
