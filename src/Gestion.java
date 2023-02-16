import java.time.LocalDate;
import java.util.Scanner;

public class Gestion
{
    public static void main(String[] args)
    {
        populate();
        Scanner sc= new Scanner(System.in);
        int choix;
        do{
            System.out.println("1.auteur,2.ouvrage etc... 8.fin");
            choix=sc.nextInt();

            switch(choix)
            {
                case 1 : gestAuteurs();
                         break;
                case 2 : gestOuvrage;
                         break;
            }
        }while(choix !=8);
        //TODO ajouter les methodes UML
        //TODO ajouter add automatique
        //TODO ajouter les gestion au dessus d'ici





    }
    private static void populate()
    {
        Auteur a1= new Auteur("Kenoby  ","Jean","Belgique");
        Livre l1 = new Livre("L'avance Rapide",12, LocalDate.now(),22.0,"Fraçcais","Science-Fiction","548415-494",550,TypeLivre.DOCUMENTAIRE,"c'est l'histoire");
        Rayon r1 = new Rayon("42", l1.getGenre());
        Exemplaire ex1= new Exemplaire("45613A","Open",l1);
        Lecteur lect1 = new Lecteur(285,"Jean","Jacques",LocalDate.MIN,"46 Grand rue ","Zbla@Yahoo.be","465541652");
        Location loc1 = new Location(LocalDate.now(),LocalDate.of(2023,3,22),lect1,ex1);
        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,"120 min",(byte)2);
        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,"100 min");


        lect1.addLloc(loc1);

        a1.addOuvrage(l1);






        System.out.println(a1.getLouvrage().toString());
        System.out.println(l1.toString());
    }
}
