package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import org.springframework.stereotype.Component;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;

import java.util.function.Function;

@Component
public class FormSteel2SteelMapper implements Function<FormSteelData, Steel> {

    @Override
    public Steel apply(FormSteelData formSteelData) {
        String name = formSteelData.getName();
        int bendingStrength = Integer.parseInt(formSteelData.getBendingStrength());
        return new Steel (name,bendingStrength);
    }
}
