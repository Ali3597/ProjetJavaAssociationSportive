package sport;

public enum Sport {
    
    FOOTBALL(1.8,22,11),
    VOLLEYBALL(0.9,18,9),
    RUGBY(1.4,30,15),
    BASKETBALL(1.2,15,7),
    HANDBALL(0.8,24,12);

    Double prestige;
    int nbMaxParClub;
    int nbMinParClub;

    Sport(Double prestige, int nbMaxParClub, int nbMinPArClub) {
        this.prestige = prestige;
        this.nbMaxParClub = nbMaxParClub;
        this.nbMinParClub = nbMinPArClub;
    }
}