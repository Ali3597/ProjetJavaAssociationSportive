package sport;

import java.util.ArrayList;

public class Club {
    private Sport sport;
    private double budget;
    private ArrayList<Sportif> sportifs;
    private ArrayList<Tournoi> historiqueTournoi;
    private String nom;

    Club(Sport sport, double budget, String nom) {
        this.sport = sport;
        this.budget = budget;
        this.nom = nom;
        this.sportifs = new ArrayList<Sportif>();
        this.historiqueTournoi = new ArrayList<Tournoi>();
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Sportif> getSportifs() {
        return this.sportifs;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean participerTournoi(Organisation organisation, Tournoi tournoi) {
        double aPayer = tournoi.getPrixParticipation();
        if (this.budget > aPayer & this.sportifs.size() >= this.sport.nbMinParClub) {
            if (organisation.inscrireEquipeTournoi(tournoi, this)) {
                this.budget -= aPayer;
                this.historiqueTournoi.add(tournoi);
                return true;
            }

            return false;
        }

        return false;
    }

    public void refinancerClub(double montant) {
        this.budget += montant;
    }

    public Boolean integrerSportif(Sportif sportif) {
        if (this.placeClub()) {
            this.addPortif(sportif);
            return true;
        } else if (sportif.getPrestige() > this.avoirSportifAvecMoinsPrestige().getPrestige()) {
            Sportif sportifEjecte = this.avoirSportifAvecMoinsPrestige();
            this.ejecterSportif(sportifEjecte);
            this.addPortif(sportif);
            return true;
        }
        return false;
    }

    private void addPortif(Sportif sportif) {
        this.sportifs.add(sportif);
        sportif.setClub(this);
    }

    private void ejecterSportif(Sportif sportif) {
        this.sportifs.remove(sportif);
        sportif.setClub(null);
    }

    public boolean placeClub() {
        if (this.sportifs.size() < this.sport.nbMaxParClub) {
            return true;
        }
        return false;
    }

    public Sportif avoirSportifAvecMoinsPrestige() {
        Sportif moinsPrestigieux = this.sportifs.get(0);
        for (int i = 1; i < this.sportifs.size(); i++) {
            if (this.sportifs.get(i).getPrestige() <= moinsPrestigieux.getPrestige()) {
                moinsPrestigieux = this.sportifs.get(i);
            }
        }
        return moinsPrestigieux;
    }

    public void aficherTournoisVainqueur() {
        System.out.print(" to do ");
    }

    public void recupererRecompense(double prestige, double cashPrice) {
        for (int i = 0; i < this.sportifs.size(); i++) {
            this.sportifs.get(i).actualiserPrestige(prestige);
        }
        this.budget += cashPrice;
    }

}
