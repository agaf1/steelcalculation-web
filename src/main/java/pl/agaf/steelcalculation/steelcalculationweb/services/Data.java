package pl.agaf.steelcalculation.steelcalculationweb.services;

import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;

public class Data {
    private double bendingMoment;
    private double tensionForce;
    private Steel steel;
    private Profile profile;

    public Data(double bendingMoment, double tensionForce, Steel steel, Profile profile) {
        this.bendingMoment = bendingMoment;
        this.tensionForce = tensionForce;
        this.steel = steel;
        this.profile = profile;
    }

    public double getBendingMoment() {
        return bendingMoment;
    }

    public double getTensionForce() {
        return tensionForce;
    }

    public Steel getSteel() {
        return steel;
    }

    public Profile getProfile() {
        return profile;
    }
}
