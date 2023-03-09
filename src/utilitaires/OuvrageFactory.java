package utilitaires;

import metier.Ouvrage;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class OuvrageFactory
{
    protected Scanner sc= new Scanner(System.in);

    public Ouvrage create()
    {
        try
        {
            System.out.println("titre");
            Ouvrage.OuvrageBuilder.setTitre(sc.nextLine());
            System.out.println("age minimum");
            Ouvrage.OuvrageBuilder.setAgeMin( sc.nextInt());
            sc.skip("\n");
            System.out.println("date de parution");

            Ouvrage.OuvrageBuilder.setDateParution(Utilitaire.lecDate());
            System.out.println("prix de location");
            Ouvrage.OuvrageBuilder.setPrixLocation(sc.nextDouble());
            sc.skip("\n");
            System.out.println("langue");
            Ouvrage.OuvrageBuilder.setLangue(sc.nextLine());
            System.out.println("genre");
            Ouvrage.OuvrageBuilder.setGenre(sc.nextLine());
            return Ouvrage.OuvrageBuilder.build();
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return null;

    }
}
