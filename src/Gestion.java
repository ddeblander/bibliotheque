import java.time.LocalDate;

public class Gestion
{
    public static void main(String[] args)
    {
        Auteur a1= new Auteur("Kenoby  ","Jean","Belgique");

        Livre l1 = new Livre("L'avance Rapide",12, LocalDate.now(),22.0,"Fraçcais","Science-Fiction","548415-494",550,TypeLivre.DOCUMENTAIRE,"c'est l'histoire");
        l1.addLauteurs(a1);
        a1.getLouvrage().add(l1);

        Rayon r1 = new Rayon("42", l1.getGenre());
        Exemplaire ex1= new Exemplaire("45613A","Open",l1);
        ex1.setRayon(r1);
        Lecteur lect1 = new Lecteur(285,"Jean","Jacques",LocalDate.MIN,"46 Grand rue ","Zbla@Yahoo.be","465541652");

        Location loc1 = new Location(LocalDate.now(),LocalDate.of(2023,3,22),lect1,ex1);
        lect1.addLloc(loc1);

    }
}
