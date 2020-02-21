package pl.agaf.steelcalculation.steelcalculationweb.services;

import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;


public class CalculationResult {

    private double capacity ;
    private double stress ;
    private Steel steel;
    private Profile profile;

    public CalculationResult(double capacity, double stress, Steel steel, Profile profile) {
        this.capacity = capacity;
        this.stress = stress;
        this.steel = steel;
        this.profile = profile;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getStress() {
        return stress;
    }

    public Steel getSteel() {
        return steel;
    }

    public Profile getProfile() {
        return profile;
    }
}
