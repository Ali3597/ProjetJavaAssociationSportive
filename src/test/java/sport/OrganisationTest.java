package sport;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;


public class OrganisationTest {
    LocalDate today = LocalDate.now();
    LocalDate todayPlusOne =today.plusDays(1);
    LocalDate todayPlusTwo =today.plusDays(2);

    @Test
    public void testCreerTournoiSansBudget() {
        Organisation monOrga = new Organisation("Mon organisation", 100.0);
        Tournoi monTournoi = monOrga.creerTournoi(18, 12, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);
        assertNull(monTournoi);
    }

    @Test
    public void testCreerTournoiSansBudgetAvecRefinancement() {
        Organisation monOrga = new Organisation("Mon organisation", 100.0);
        monOrga.refinancerClub(150000);
        Tournoi monTournoi = monOrga.creerTournoi(18, 12, 1500,Sport.RUGBY,todayPlusOne, todayPlusTwo, 300);
        assertNotNull(monTournoi);
    }

    @Test
    public void testCreerTournoiMauvaiseDate() {
        Organisation monOrga = new Organisation("Mon organisation", 150000.0);
        Tournoi monTournoi = monOrga.creerTournoi(18, 12, 1500,Sport.RUGBY, LocalDate.of(2023,2,14), LocalDate.of(2023,1,18), 300);
        assertNull(monTournoi);
    }

    @Test
    public void testCreerTournoiMauvaisNombreParticipant() {
        Organisation monOrga = new Organisation("Mon organisation", 150000.0);
        Tournoi monTournoi = monOrga.creerTournoi(10, 12, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);
        assertNull(monTournoi);
    }

    @Test
    public void testCreerBonTournoi() {
        Organisation monOrga = new Organisation("Mon organisation", 15000.0);
        Tournoi monTournoi = monOrga.creerTournoi(18, 12, 1500,Sport.RUGBY,todayPlusOne, todayPlusTwo, 300);
       
        assertNotNull(monTournoi);
        assertEquals(13248.0, monOrga.getBudget(),0);
    }

    @Test
    public void  testCestBienMonTournoi(){
        Organisation monOrga = new Organisation("Mon organisation", 155500.0);
        Organisation autreOrga =  new Organisation("Autre organisation", 155500.0);
        Tournoi monTournoi = monOrga.creerTournoi(18, 12, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);
        Tournoi autreTournoi = autreOrga.creerTournoi(18, 12, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);

        assertTrue(monOrga.monTournoi(monTournoi));
        assertFalse(autreOrga.monTournoi(monTournoi));
        assertFalse(monOrga.monTournoi(autreTournoi));
        assertTrue(autreOrga.monTournoi(autreTournoi));

    }

    @Test
    public void testInscrireEquipeASonTournoi(){
        Organisation monOrga = new Organisation("Mon organisation", 155500.0);
        Tournoi monTournoi = monOrga.creerTournoi(8, 4, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);
        Club unClubInscrit =  new Club(Sport.RUGBY, 15000, null);
        Club unClubNonInscrit = new Club(Sport.RUGBY, 15000, null);
        monOrga.inscrireEquipeTournoi(monTournoi, unClubInscrit);
        for (int i = 0; i < 7; i++) {
            monOrga.inscrireEquipeTournoi(monTournoi, new Club(Sport.RUGBY, 15000, null));
        }
        monOrga.inscrireEquipeTournoi(monTournoi, unClubNonInscrit);
        assertTrue((monTournoi.getParticipants()).contains(unClubInscrit));
        assertFalse(monTournoi.getParticipants().contains(unClubNonInscrit));
        

    }

   
    @Test
    public void testDeclarerVainqueur(){
        Organisation monOrga = new Organisation("Mon organisation", 155500.0);
        Tournoi monTournoi = monOrga.creerTournoi(4, 2, 1500,Sport.RUGBY, todayPlusOne, todayPlusTwo, 300);
        Club premierClub = new Club(Sport.RUGBY, 15000, null);
        for (int i = 0; i < 20; i++) {
            premierClub.integrerSportif(new Sportif(null, null, null));
        }
        Club secondClub =  new Club(Sport.RUGBY, 15000, null);
        for (int i = 0; i < 20; i++) {
            secondClub.integrerSportif(new Sportif(null, null, null));
        }
        Club troisiemeClub =  new Club(Sport.RUGBY, 15000, null);
        for (int i = 0; i < 20; i++) {
            troisiemeClub.integrerSportif(new Sportif(null, null, null));
        }
        premierClub.participerTournoi(monOrga, monTournoi);
        secondClub.participerTournoi(monOrga, monTournoi);
        troisiemeClub.participerTournoi(monOrga, monTournoi);
        monOrga.declarerVainqueur(monTournoi, premierClub, secondClub, troisiemeClub);
        assertEquals(15700.0, premierClub.getBudget(),0);
        assertEquals(15200.0, secondClub.getBudget(),0);
        assertEquals(14950, troisiemeClub.getBudget(),0);
        assertEquals(4.2, premierClub.getSportifs().get(4).getPrestige(),0.1);
        assertEquals(2.8,  secondClub.getSportifs().get(12).getPrestige(),0.1);
        assertEquals(1.4,  troisiemeClub.getSportifs().get(7).getPrestige(),0.1);
    }


}