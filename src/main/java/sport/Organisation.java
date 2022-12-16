package sport;
import java.util.ArrayList;
import java.time.LocalDate;

public class Organisation {
    private String nom;
    private Double budget;
    private ArrayList<Tournoi> nosTournois;

    Organisation(String nom, double budget) {
        this.nom = nom;
        this.budget = budget;
        this.nosTournois = new ArrayList<Tournoi>();
    }

    public String getNom() {
        return this.nom;
    }

    public double getBudget(){
        return this.budget;
    }
    public Tournoi creerTournoi(int nbMaximumParticipants, int nbMinimumParticipants, double cashPrice, Sport sport,
            LocalDate dateDebut, LocalDate dateFin, double prixParticipation) {
        Tournoi tournoi = new Tournoi(nbMaximumParticipants, nbMinimumParticipants, cashPrice, sport, dateDebut,
                dateFin, prixParticipation);        
        if (tournoi.getNbMaximumParticipants() > tournoi.getNbMinimumParticipants()
                & tournoi.getPrixCreation() < this.budget & tournoi.getDateDebut().isAfter(LocalDate.now())
                & tournoi.getDateDebut().isBefore(tournoi.getDateFin())) {
            this.budget -= tournoi.getPrixCreation();
            this.nosTournois.add(tournoi);
            return tournoi;
        }
        return null;
    }

    public boolean monTournoi(Tournoi tounoi) {
        if (this.nosTournois.contains(tounoi)) {
            return true;
        }
        return false;
    }

    public boolean inscrireEquipeTournoi(Tournoi tournoi, Club club) {
        System.out.print("avant");
        if (this.monTournoi(tournoi) & !tournoi.tournoiPlein()) {
            this.budget += tournoi.getPrixParticipation();
            System.out.print("ok");
            tournoi.addClub(club);
            return true;
        }
        System.out.print("pas ok");
        return false;
    }

    public void refinancerClub(double montant) {
        this.budget += montant;
    }

    public void declarerVainqueur(Tournoi tournoi, Club premier, Club second, Club troisieme) {
        if (this.monTournoi(tournoi)) {
            double prestigeSport = tournoi.getSport().prestige;
            double cashPrice = tournoi.getCashPrice();
            premier.recupererRecompense(3 * prestigeSport, (cashPrice * 4) / 6);
            second.recupererRecompense(2 * prestigeSport, (cashPrice * 2) / 6);
            troisieme.recupererRecompense(prestigeSport, cashPrice / 6);
            tournoi.setGagnants(new Club[] { premier, second, troisieme });
        }

    }
}