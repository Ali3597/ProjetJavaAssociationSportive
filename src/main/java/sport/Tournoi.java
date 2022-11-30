package sport;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tournoi {

    private ArrayList<Club> clubsParticipant;
    private int nbMaximumParticipants;
    private int nbMinimumParticipants;
    private double cashPrice;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prixParticipation;
    private Sport sport;
    private Club[] gagnants;


    Tournoi(int nbMaximumParticipants,int nbMinimumParticipants,double cashPrice,Sport sport,LocalDate dateDebut,LocalDate dateFin,double prixParticipation ){
        this.nbMaximumParticipants =nbMaximumParticipants;
        this.nbMinimumParticipants = nbMinimumParticipants;
        this.cashPrice =cashPrice;
        this.sport = sport;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixParticipation = prixParticipation;
        this.gagnants = new Club[3];
        this.clubsParticipant = new ArrayList<Club>();


    }

    public double getPrixParticipation(){
        return this.prixParticipation;
    }
    public LocalDate getDateDebut(){
        return this.dateDebut;
    }
    public LocalDate getDateFin(){
        return this.dateFin;
    }

    public int getNbMaximumParticipants(){
        return this.nbMaximumParticipants;
    }
    public int getNbMinimumParticipants() {
        return this.nbMinimumParticipants;
    }

    public  Club[] getGagnants(){
        return this.gagnants;
    }
  

    public Sport getSport(){
        return this.sport;
    }

    public double getCashPrice(){
        return this.cashPrice;
    }

    public  ArrayList<Club> getParticipants(){
        return this.clubsParticipant;
    }
   

    public void addClub(Club club){
        this.clubsParticipant.add(club);
    }
    
}
