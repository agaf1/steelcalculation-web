package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

class FormData {

    @Pattern(regexp = "^\\d+.?\\d{0,2}$",message = "Invalid value. Correct form xxx.yy")
    private String bendingMoment;

    @Pattern(regexp = "^\\d+.?\\d{0,2}$",message = "Invalid value. Correct form xxx.yy")
    private String tensionForce;

    private String steel;

    private String profile;

    @NotBlank(message = "You must check one option.")
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBendingMoment() {
        return bendingMoment;
    }

    public void setBendingMoment(String bendingMoment) {
        this.bendingMoment = bendingMoment;
    }

    public String getTensionForce() {
        return tensionForce;
    }

    public void setTensionForce(String tensionForce) {
        this.tensionForce = tensionForce;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
