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
}
