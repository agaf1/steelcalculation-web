package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import javax.validation.constraints.Pattern;

public class FormSteelData {

    @Pattern(regexp = "S\\d{3,}",message = "Invalid value. Correct form Sxxx (eg S235)")
    private String name;

    @Pattern(regexp = "^\\d+$",message = "Invalid value. Correct form XXX (eg 235)")
    private String bendingStrength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBendingStrength() {
        return bendingStrength;
    }

    public void setBendingStrength(String bendingStrength) {
        this.bendingStrength = bendingStrength;
    }
}
