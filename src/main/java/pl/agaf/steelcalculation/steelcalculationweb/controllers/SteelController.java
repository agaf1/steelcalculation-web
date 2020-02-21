package pl.agaf.steelcalculation.steelcalculationweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.repository.SteelsRepo;

import javax.validation.Valid;

@Controller
@RequestMapping("/add-steel")
public class SteelController {

    @Autowired
    private SteelsRepo steelsRepo;

    @Autowired
    private FormSteel2SteelMapper formSteel2SteelMapper;

    @GetMapping
    public String steel (Model model) {
        model.addAttribute("formSteelData",new FormSteelData());
        return "add-steel.html";
    }

    @PostMapping
    public String addNewSteel (Model model, @Valid FormSteelData formSteelData, Errors errors){
        if(errors.hasErrors()){
            return "add-steel.html";
        }else {
            model.addAttribute("formSteelData",formSteelData);
            Steel steel = formSteel2SteelMapper.apply(formSteelData);
            steelsRepo.addNewSteel(steel);
            return "redirect:/";
        }
    }
}
