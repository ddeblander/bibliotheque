import java.time.LocalDate;

abstract class Ouvrage
{
    protected String titre;
    protected byte ageMin;
    protected LocalDate dateParution;
    protected TypeOuvr typeOuvrage;
    protected double prixLocation;
    protected String langue,genre;

    public Ouvrage(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.typeOuvrage = typeOuvrage;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
    }
}
