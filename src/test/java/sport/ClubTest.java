package sport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;


public class ClubTest {
    LocalDate today = LocalDate.now();
    LocalDate todayPlusOne =today.plusDays(1);
    @Test
    public void testPasAssezDeSportif() {
        Club monClub = new Club(Sport.FOOTBALL, 15000, "Le Club");
        for (int i = 0; i < 4; i++) {
            monClub.integrerSportif(new Sportif(null, null, null));
          }
        Organisation orga = new Organisation(null, 12000);
        LocalDate today = LocalDate.now();
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL,todayPlusOne,
        today.plusDays(2), 500);
        boolean inscritTournoi = monClub.participerTournoi(orga, tournoi);
        assertFalse(inscritTournoi);

    }

    @Test
    public void testPasAssezArgent() {
        Club monClub = new Club(Sport.FOOTBALL, 200, "Le Club");
        for (int i = 0; i < 13; i++) {
            monClub.integrerSportif(new Sportif(null, null, null));
          }
        Organisation orga = new Organisation(null, 12000);
        LocalDate today = LocalDate.now();
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL,todayPlusOne,
        today.plusDays(2), 500);
        boolean inscritTournoi = monClub.participerTournoi(orga, tournoi);
        assertFalse(inscritTournoi);
    }

    @Test
    public void testPasAssezArgentMaisRefinancement() {
        Club monClub = new Club(Sport.FOOTBALL, 200, "Le Club");
        for (int i = 0; i < 13; i++) {
            monClub.integrerSportif(new Sportif(null, null, null));
          }
        Organisation orga = new Organisation(null, 12000);
        LocalDate today = LocalDate.now();
        Tournoi tournoi = orga.creerTournoi(12, 8, 2000, Sport.FOOTBALL,todayPlusOne,
        today.plusDays(2), 500);
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
    public void testSportifIntegrerClub() {
        Club monClub = new Club(Sport.FOOTBALL, 15000, "Le Club");
        int[] prestige_list = new int[]{12,4,8,6,4};
        for (int i = 0; i < prestige_list.length; i++) {
            monClub.integrerSportif(new Sportif(null, null, null, prestige_list[i]));
        }
        Sportif aIntegrer = new Sportif(null, null, null, 7);
        monClub.integrerSportif(aIntegrer);
        assertEquals(monClub.getSportifs().get(5), aIntegrer);
    }

    @Test
    public void testIntegrationSportifClubPleinPlusPrestige() {
        Club monClub = new Club(Sport.BASKETBALL, 200, "Le Club");
        int[] prestige_list = new int[]{4,8,55,42,2,12,3,6,2,5,8,6,2,4,7};
        for (int i = 0; i < prestige_list.length; i++) {
            monClub.integrerSportif(new Sportif(null, null, null, prestige_list[i]));
        }
        Sportif aIntegrer = new Sportif(null, null, null, 7);
        Sportif aEjecter = monClub.avoirSportifAvecMoinsPrestige();

        monClub.integrerSportif(aIntegrer);

        assertEquals(aIntegrer, monClub.getSportifs().get(14));
        assertEquals(null, aEjecter.getClub());

    }

    @Test
    public void testIntegrationSportifClubPleinPasAssezPrestige() {
        Club monClub = new Club(Sport.BASKETBALL, 200, "Le Club");
        int[] prestige_list = new int[]{4,8,55,42,2,12,3,6,2,5,8,6,2,4};
        for (int i = 0; i < prestige_list.length; i++) {
            monClub.integrerSportif(new Sportif(null, null, null, prestige_list[i]));
        }
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