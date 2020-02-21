package pl.agaf.steelcalculation.steelcalculationweb.services;


import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;

import java.util.Optional;

public class CalculateServices {

    public Optional<CalculationResult> calculate(Data data) {
        double capacity = this.calculateCapacity(data);
        double stress = this.calculateStress(data);
        Steel steel = data.getSteel();
        Profile profile = data.getProfile();

        return Optional.of( new CalculationResult(capacity,stress,steel,profile));
    }

    private double calculateCapacity(Data data) {
        double fd = data.getSteel().getBendingStrength();
        double wx = data.getProfile().getSectionModulus();
        double mx = data.getBendingMoment();
        double ax = data.getProfile().getArea();
        double fx = data.getTensionForce();

        double capacity = (((mx) / (wx * fd)) * 1000) + (((fx) / (ax * fd)) * 10);

        return capacity;
    }

    private double calculateStress(Data data) {
        double wx = data.getProfile().getSectionModulus();
        double mx = data.getBendingMoment();
        double ax = data.getProfile().getArea();
        double fx = data.getTensionForce();

        double stress = (mx / wx) * 1000 + (fx / ax) * 10;

        return stress;
    }
}
