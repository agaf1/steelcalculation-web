package pl.agaf.steelcalculation.steelcalculationweb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.repository.ProfilesRepo;

import javax.validation.Valid;

@Controller
@RequestMapping("/add-profile")
public class ProfileController {

    @Autowired
    private FormProfile2ProfileMapper formProfil2ProfileMapper;

    @Autowired
    private ProfilesRepo profilesRepo;

    @GetMapping
    public String profile(Model model){
        model.addAttribute("formProfileData",new FormProfileData());
        return "add-profile.html";
    }

    @PostMapping
    public String addNewProfile (Model model, @Valid FormProfileData formProfileData, Errors errors) {
        if (errors.hasErrors()) {
            return "add-profile.html";
        } else {
            model.addAttribute("formProfileData",formProfileData);
            Profile profile = formProfil2ProfileMapper.apply(formProfileData);
            profilesRepo.addNewProfile(profile);
            return "redirect:/";
        }
    }
}
