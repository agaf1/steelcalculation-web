package pl.agaf.steelcalculation.steelcalculationweb.services;

import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Steel;
import pl.agaf.steelcalculation.steelcalculationweb.repository.ProfilesRepo;
import pl.agaf.steelcalculation.steelcalculationweb.repository.SteelsRepo;

import java.util.List;
import java.util.Optional;

public class CalculateProfile {

    private final SteelsRepo steelsRepo;

    private final ProfilesRepo profilesRepo;

    public CalculateProfile(SteelsRepo steelsRepo, ProfilesRepo profilesRepo) {
        this.steelsRepo = steelsRepo;
        this.profilesRepo = profilesRepo;
    }

    public Optional<CalculationResult> selectProfile(Data data) {
        Steel selectedSteel = findSteelBySectionModulus(data);
        SelectedProfileAndSteel answerProfileAndSteel = selectedProfileAndSteel(selectedSteel, data);

        if (answerProfileAndSteel != null) {
            Steel steel = answerProfileAndSteel.getSteel();
            Profile profile = answerProfileAndSteel.getProfile();
            double capacity = this.checkProfile(steel, profile, data);
            double stress = capacity * steel.getBendingStrength();

            return Optional.of(new CalculationResult(capacity, stress, steel, profile));
        }
        return Optional.ofNullable(null);
    }

    private SelectedProfileAndSteel selectedProfileAndSteel(Steel steel, Data data) {

        List<Steel> sortedSteels = steelsRepo.sortedList();
        List<Profile> sortedProfiles = profilesRepo.sortedList();

        SelectedProfileAndSteel answerProfileAndSteel = null;
        int indexSteel = sortedSteels.indexOf(steel);
        boolean found = false;

        int i = indexSteel;

        while(found == false && i < sortedSteels.size() ){

            for (Profile profile : sortedProfiles) {
                double result = checkProfile(sortedSteels.get(i), profile, data);
                if (result <= 1) {
                    answerProfileAndSteel = new SelectedProfileAndSteel(profile, sortedSteels.get(i));
                    //return answerProfileAndSteel;
                    found = true;
                    break;
                }
            }
            i++;
        }
        return answerProfileAndSteel;
    }

    private Steel findSteelBySectionModulus(Data data) {

        List<Steel> sortedSteels = steelsRepo.sortedList();

        Steel selectedSteel = null;

        for (Steel steel : sortedSteels) {
            double mx = data.getBendingMoment();
            double fd = steel.getBendingStrength();
            double wx = (mx / fd) * 1000;

            Optional<Profile> profile = profilesRepo.findBySectionModulus(wx);
            if (profile.isPresent()) {
                selectedSteel = steel;
                break;
            }
        }
        return selectedSteel;
    }

    private double checkProfile(Steel steel, Profile profile, Data data) {
        double fd = steel.getBendingStrength();
        double wx = profile.getSectionModulus();
        double ax = profile.getArea();
        double mx = data.getBendingMoment();
        double fx = data.getTensionForce();
        return (((mx) / (wx * fd)) * 1000) + (((fx) / (ax * fd)) * 10);
    }
}
