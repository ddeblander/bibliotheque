package gestion;

import metier.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Gestion
{
    private static String erreur="mauvaise valeur introduite";
    public static void main(String[] args)
    {
        populate();
        Scanner sc= new Scanner(System.in);
        int choix=0;
        System.out.println("1.auteur,2.ouvrage etc... 8.fin");
        do{

            try
            {
                choix=sc.nextInt();
            }catch(Exception e)
            {
                System.out.println(e.toString());
                sc.nextLine();
            }


            switch(choix)
            {
                case 1 : gestAuteurs();
                         break;
                case 2 : gestOuvrages();
                         break;
                case 3 : gestLecteurs();
                        break;
                case 4 : gestRayons();
                        break;
                case 5 : gestExemplaires();
                        break;
                case 6 : louer();
                        break;
                case 7 : rendre();
                        break;
                case 8 : exit();
                        break;
                default:
                    System.out.println(erreur);
            }
        }while(choix !=8);




        //TODO ajouter les methodes UML
        //TODO ajouter add automatique
        //TODO ajouter les gestion au dessus d'ici





    }
    private static void gestOuvrages()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void gestAuteurs()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void gestLecteurs()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void gestRayons()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void gestExemplaires()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void louer()
    {
        short choice=selectionCRUD();
        if(choice==1)
        {
            System.out.println("1");
        }
        else if(choice==2)
        {
            System.out.println("2");
        }
        else if(choice==3)
        {
            System.out.println("3");

        }
        else
        {
            System.out.println("4");

        }
    }
    private static void rendre()
    {

    }
    private static void exit()
    {
        System.out.println("merci d'avoir utilisé notre programme.");
        System.out.println("Bonne journée.");
    }
    private static short selectionCRUD()
    {
        int choiceCRUD=0;
        Scanner scCRUD = new Scanner(System.in);
        System.out.println("1.Ajout,2.Lire,3.Update,4.Delete ");

        try
        {
            choiceCRUD= scCRUD.nextInt();

        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        switch(choiceCRUD)
        {
            case 1 : return 1;
            case 2 : return 2;
            case 3 : return 3;
            case 4 : return 4;
            default:
                System.out.println(erreur);
                return selectionCRUD();
        }
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
