package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.repository.ProfilesRepo;
import pl.agaf.steelcalculation.steelcalculationweb.repository.SteelsRepo;
import pl.agaf.steelcalculation.steelcalculationweb.services.CalculateProfile;
import pl.agaf.steelcalculation.steelcalculationweb.services.CalculateServices;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProfilesRepo profilesRepo;

    @Autowired
    private SteelsRepo steelsRepo;

    @Autowired
    private Form2DataMapper form2DataMapper;

    @GetMapping
    public String home(Model model) {
        updateModel(model);
        model.addAttribute("formData", new FormData());
        model.addAttribute("wynik", new CalculationResultDto());

        return "home.html";
    }

    @PostMapping
    public String calculate(Model model, @Valid FormData data, Errors errors) {

        updateModel(model);
        model.addAttribute("formData", data);
        model.addAttribute("wynik", new CalculationResultDto());

        if (errors.hasErrors()) {
            return "home.html";
        } else {
            switch (data.getOperation()) {
                case "calculate":
                    CalculateServices calculator = new CalculateServices();
                    model.addAttribute("wynik", new CalculationResultDto(calculator.calculate(form2DataMapper.apply(data))));
                    break;
                case "select-profile":
                    CalculateProfile calculateProfile = new CalculateProfile(steelsRepo, profilesRepo);
                    model.addAttribute("wynik", new CalculationResultDto(calculateProfile.selectProfile(form2DataMapper.apply(data))));
                    break;
            }
            return "home.html";
        }
    }

    private void updateModel(Model model) {
        List<Profile> profiles = profilesRepo.loadAll().getProfiles();
        List<Steel> steels = steelsRepo.loadAll().getSteels();

        model.addAttribute("steels", steels);
        model.addAttribute("profiles", profiles);
    }
}
