package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.services.CalculationResult;

import java.text.DecimalFormat;
import java.util.Optional;

class CalculationResultDto {
    private String capacity;
    private String stress;
    private Steel steel;
    private Profile profile;
    private String steelName;
    private String profileName;
    private String message;

    CalculationResultDto() {
    }

    CalculationResultDto(Optional<CalculationResult> result) {
        result.ifPresentOrElse(res->{
            DecimalFormat df = new DecimalFormat("#.##");
            capacity = df.format(res.getCapacity());
            stress = df.format(res.getStress());
            steel = res.getSteel();
            profile = res.getProfile();
            steelName = res.getSteel().getName();
            profileName = res.getProfile().getName();
        },()->{
            message = "correct profile is not exist in this data";
        });
    }

    public String getMessage() {
        return message;
    }

    public String getCapacity() {
        return capacity;
    }


    public String getStress() {
        return stress;
    }

    public Steel getSteel() {
        return steel;
    }

    public String getSteelName() {
        return steelName;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getProfileName() {
        return profileName;
    }


}
