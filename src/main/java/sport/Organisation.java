package sport;
import java.util.ArrayList;
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
    
}
