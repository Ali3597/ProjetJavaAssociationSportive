package sport;

import java.time.LocalDate;
import java.time.Period;

public class Sportif {

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Club club;
    private double prestige;

    Sportif(String nom,String prenom, LocalDate dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.club = null;
        this.prestige = 0;
    }


    Sportif(String nom,String prenom, LocalDate dateNaissance, double prestige ){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.prestige = prestige;
    }

    public double getPrestige(){
        return this.prestige;
    }

    public int getAge(){
        LocalDate curDate = LocalDate.now();
        return Period.between(this.dateNaissance, curDate).getYears();
    }
    
    public Club getClub(){
        return this.club;
    }

    public void setClub(Club club){
        this.club = club;
    }


    public boolean isAdulte() {
        if (getAge() >= 18){
            return true;
        }
		return false;
	}

    public Club integrerClub(Club club){
        return this.club = club;
    }

    public void actualiserPrestige(double prestige){
        this.prestige += prestige;
    }

	public void afficherInformations() {
		System.out.print(this.nom + " " + this.prenom + " a  "+ this.getAge() + " ans et  " + (this.club != null ? " est dans le club " + club.getNom() : "est sans club ")  );
	}

}