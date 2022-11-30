package sport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class ClubTest {

    @Test
    public void testPasAssezDeSportif() {
        Club monClub = new Club(Sport.FOOTBALL, 15000, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        Organisation orga = new Organisation(null, 12000);
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL, LocalDate.of(2022, 12, 8),
                LocalDate.of(2022, 12, 10), 500);
        boolean inscritTournoi = monClub.participerTournoi(orga, tournoi);
        assertFalse(inscritTournoi);

    }

    @Test
    public void testPasAssezArgent() {
        Club monClub = new Club(Sport.FOOTBALL, 200, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        Organisation orga = new Organisation(null, 12000);
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL, LocalDate.of(2022, 12, 8),
                LocalDate.of(2022, 12, 10), 500);
        boolean inscritTournoi = monClub.participerTournoi(orga, tournoi);
        assertFalse(inscritTournoi);
    }

    @Test
    public void testPasAssezArgentMaisRefinancement() {
        Club monClub = new Club(Sport.FOOTBALL, 200, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        monClub.integrerSportif(new Sportif(null, null, null));
        Organisation orga = new Organisation(null, 12000);
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL, LocalDate.of(2022, 12, 8),
                LocalDate.of(2022, 12, 10), 500);
        monClub.refinancerClub(12000);
        boolean inscritTournoi = monClub.participerTournoi(orga, tournoi);
        assertTrue(inscritTournoi);
    }

    @Test
    public void testRecolterREcompense() {
        Club monClub = new Club(Sport.FOOTBALL, 200, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null, 5));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.recupererRecompense(3, 1500);
        assertEquals(1700.0, monClub.getBudget(), 0);
        assertEquals(8.0, monClub.getSportifs().get(0).getPrestige(), 0);
        assertEquals(5.0, monClub.getSportifs().get(1).getPrestige(), 0);

    }

    @Test
    public void testAvoirSportifAvecMoinsPrestige() {
        Club monClub = new Club(Sport.FOOTBALL, 15000, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null, 12));
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        monClub.integrerSportif(new Sportif(null, null, null, 8));
        monClub.integrerSportif(new Sportif(null, null, null, 6));
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        Sportif moinsPrestigieux = monClub.avoirSportifAvecMoinsPrestige();
        assertEquals(monClub.getSportifs().get(4), moinsPrestigieux);
    }

    @Test
    public void testIntegrationSportifClubPlein() {
        Club monClub = new Club(Sport.BASKETBALL, 200, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        monClub.integrerSportif(new Sportif(null, null, null, 8));
        monClub.integrerSportif(new Sportif(null, null, null, 55));
        monClub.integrerSportif(new Sportif(null, null, null, 42));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 12));
        monClub.integrerSportif(new Sportif(null, null, null, 3));
        monClub.integrerSportif(new Sportif(null, null, null, 6));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 5));
        monClub.integrerSportif(new Sportif(null, null, null, 8));
        monClub.integrerSportif(new Sportif(null, null, null, 6));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        monClub.integrerSportif(new Sportif(null, null, null, 7));

        Sportif aIntegrer = new Sportif(null, null, null, 7);
        Sportif aEjecter = monClub.avoirSportifAvecMoinsPrestige();

        monClub.integrerSportif(aIntegrer);

        assertEquals(aIntegrer, monClub.getSportifs().get(14));
        assertEquals(null, aEjecter.getClub());

    }

    @Test
    public void testIntegrationSportifClubPleinPasAssezPrestige() {
        Club monClub = new Club(Sport.BASKETBALL, 200, "Le Club");
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        monClub.integrerSportif(new Sportif(null, null, null, 8));
        monClub.integrerSportif(new Sportif(null, null, null, 55));
        monClub.integrerSportif(new Sportif(null, null, null, 42));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 12));
        monClub.integrerSportif(new Sportif(null, null, null, 3));
        monClub.integrerSportif(new Sportif(null, null, null, 6));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 5));
        monClub.integrerSportif(new Sportif(null, null, null, 8));
        monClub.integrerSportif(new Sportif(null, null, null, 6));
        monClub.integrerSportif(new Sportif(null, null, null, 2));
        monClub.integrerSportif(new Sportif(null, null, null, 4));
        Sportif dernierSportif = new Sportif(null, null, null, 7);
        monClub.integrerSportif(dernierSportif);

        Sportif aIntegrer = new Sportif(null, null, null, 0);
        Sportif aEjecter = monClub.avoirSportifAvecMoinsPrestige();

        monClub.integrerSportif(aIntegrer);

        assertEquals(dernierSportif, monClub.getSportifs().get(14));
        assertEquals(monClub, aEjecter.getClub());
        assertEquals(null, aIntegrer.getClub());

    }

}