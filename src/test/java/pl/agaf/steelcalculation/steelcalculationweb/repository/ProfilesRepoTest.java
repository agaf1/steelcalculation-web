package pl.agaf.steelcalculation.steelcalculationweb.repository;

import org.junit.jupiter.api.Test;
import pl.agaf.steelcalculation.steelcalculationweb.entity.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfilesRepoTest {

    @Test
    public void shouldFindProfileBySectionModulus(){
        ProfilesRepo profilesRepo = new ProfilesRepo();

        Profile profile = profilesRepo.findBySectionModulus(45.0).get();

        assertEquals(53,profile.getSectionModulus());
    }

}