package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import org.springframework.stereotype.Component;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;

import java.util.function.Function;

@Component
class FormProfile2ProfileMapper implements Function<FormProfileData, Profile> {


    @Override
    public Profile apply(FormProfileData formProfileData) {
        String name = formProfileData.getName();
        double area = Double.parseDouble(formProfileData.getArea());
        double sectionModulus = Double.parseDouble(formProfileData.getSectionModulus());
        return new Profile(name,area,sectionModulus);
    }
}
