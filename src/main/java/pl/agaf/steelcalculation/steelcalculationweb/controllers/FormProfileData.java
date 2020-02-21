package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

class FormProfileData {

    @NotBlank(message = "This field cannot be empty")
    @Pattern(regexp = "[A-Z]+\\d{3,}",message = "Invalid value. Correct form YYY000 (eg IPE160)")
    private String name;

    @NotBlank(message = "This field cannot be empty")
    @Pattern(regexp = "^\\d+.?\\d{0,2}$",message = "Invalid value. Correct form xxx.yy")
    private String area;

    @NotBlank(message = "This field cannot be empty")
    @Pattern(regexp = "^\\d+.?\\d{0,2}$",message = "Invalid value. Correct form xxx.yy")
    private String sectionModulus;


    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getSectionModulus() {
        return sectionModulus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setSectionModulus(String sectionModulus) {
        this.sectionModulus = sectionModulus;
    }
}
