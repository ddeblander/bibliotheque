package gestion;

import metier.*;
import model.LecteurModel;
import presenter.LecteurPresenter;
import utilitaires.*;
import view.LecteurViewConsole;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gestion extends OuvrageFactory
{
    private String erreur="mauvaise valeur introduite";
    private List<Auteur> la = new ArrayList<>();
    private List<Ouvrage> lo=new ArrayList<>();
    private List<Lecteur> ll = new ArrayList<>();
    private List<Exemplaire> lex = new ArrayList<>();
    private List<Rayon> lr= new ArrayList<>();
    private List<Location> lloc = new ArrayList<>();
    private List<Lecteur> llect = new ArrayList<>();

    private void menu()
    {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","restitution","fin"));
        do{
            int choix = Utilitaire.choixListe(options);

            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                case 7 : gestRestitution();break;
                default:System.exit(0);
            }
        }  while (true);
    }
    private void gestOuvrages()
    {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;

        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        lo.add(o);
        System.out.println("ouvrage créé");
    }
    private void gestAuteurs()
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
    private void gestLecteurs()
    {
        LecteurViewConsole lv = new LecteurViewConsole();
        lv.setPresenter(new LecteurPresenter(new LecteurModel(),lv));
        lv.setListDatas(llect);
    }
    private void gestRayons()
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
    private void gestExemplaires()
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
    private void louer()
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
    private void exit()
    {
        System.out.println("merci d'avoir utilisé notre programme.");
        System.out.println("Bonne journée.");
    }
    private short selectionCRUD()
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
    private void gestRestitution()
    {
        int i=0;
        Scanner sc= new Scanner(System.in);
        for(Exemplaire ex:lex)
        {
           System.out.println("numéro :"+i+ex.toString());
        }


        System.out.println("choississez l'exmplaire à rendre");
        try
        {
            lloc.get(sc.nextInt()).setDateRestitution(LocalDate.now());


        }catch(Exception e)
        {
            System.out.println(e.toString());
            gestRestitution();
        }
    }
    private void gestLocations() {
        int choix;
        choix = Utilitaire.choixListe(lex);
        if(lex.get(choix).enLocation()){
            System.out.println("exemplaire en location");
            return;
        }
        Exemplaire ex = lex.get(choix-1);
        choix=Utilitaire.choixListe(llect);
        Lecteur lec = llect.get(choix-1);
        lloc.add(new Location(lec,ex));
    }


    private void populate()
    {
        Auteur a1=null;
        Auteur a2=null;
        Livre l1=null;
        Rayon r1=null;

        try
        {
            a1= new Auteur("Kenoby  ","Jean","Belgique");
            a2 = new Auteur("Kubrick","Stanley","GB");
            l1 = new Livre("L'avance Rapide",12, LocalDate.now(),22.0,"Fraçcais","Science-Fiction","548415-494",550,TypeLivre.DOCUMENTAIRE,"c1'est l'histoire");
            r1 = new Rayon("42", l1.getGenre());
            Exemplaire ex1= new Exemplaire("45613A","Open",l1);
            Lecteur lect1 = new Lecteur(285,"Jean","Jacques",LocalDate.MIN,"46 Grand rue ","Zbla@Yahoo.be","465541652");
            Location loc1 = new Location(LocalDate.now(),LocalDate.of(2023,3,22),lect1,ex1);
            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0,0),(byte)2);
            CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20, LocalTime.of(1,40,0));

            la.add(a1);
            lo.add(l1);
            d.addAutresLangues(Arrays.asList("francais","italien"));
            d.addSousTitres(Arrays.asList("néerlandais","russe"));
            lo.add(d);

            a1.addOuvrage(d);


            la.add(a2);

            a2.addOuvrage(d);


            CD c1 = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            lo.add(c1);

            Rayon r = new Rayon("r12","aventure");
            lr.add(r);

            Exemplaire e = new Exemplaire("m12","état neuf",l1);
            lex.add(e);
            e.setRayon(r);


            r = new Rayon("r45","science fiction");
            lr.add(r);

            e = new Exemplaire("d12","griffé",d);
            lex.add(e);

            e.setRayon(r);


            Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
            llect.add(lec);

            Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
            lloc.add(loc);
            loc.setDateRestitution(LocalDate.of(2023,2,4));

            lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
            llect.add(lec);

            loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
            lloc.add(loc);
        }catch(Exception e)
        {
            System.out.println(e.toString());

        }




        System.out.println(a1.getLouvrage().toString());
        System.out.println(l1.toString());
    }
    public static void main(String[] args)
    {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }
}
