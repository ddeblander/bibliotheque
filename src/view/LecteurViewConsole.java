package view;

import metier.Lecteur;
import presenter.LecteurPresenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class LecteurViewConsole implements ViewInterface
{
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);
    public LecteurViewConsole()
    {

    }
    @Override
    public void setPresenter(Object presenter)
    {
        LecteurPresenter l=(LecteurPresenter) presenter;
        this.presenter = l;
    }

    @Override
    public void setListDatas(List lecteurs)
    {
        this.llec = lecteurs;
        affListe(llec);
        menu();
    }

    @Override
    public void affMsg(String msg)
    {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List lex)
    {
        affListe(lex);
    }
    public void menu()
    {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "rechercher","modifier","special","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    special();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }
    private void rechercher() {
        System.out.println("numLecteur : ");
        int idLecteur = sc.nextInt();
        presenter.search(idLecteur);
    }

    private void modifier() {
        int choix = choixElt(llec);
        Lecteur l = llec.get(choix-1);
        String nom = modifyIfNotBlank("nom",l.getNom());
        String prenom = modifyIfNotBlank("prenom",l.getPrenom());
        String date = modifyIfNotBlank("date de naissance",getDateFrench(l.getDn()));
        String[] jma = date.split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        String adr = modifyIfNotBlank("adresse",l.getAdresse());
        String mail= modifyIfNotBlank("mail",l.getMail());
        String tel =modifyIfNotBlank("tel",l.getTel());
        Lecteur lec = new Lecteur(l.getNumlecteur(), nom, prenom, dn, adr, mail, tel);
        presenter.update(lec);
        llec=presenter.getAll();//rafraichissement
        affListe(llec);
    }

    private void retirer() {
        int choix = choixElt(llec);
        Lecteur lecteur = llec.get(choix-1);
        presenter.removeLecteur(lecteur);
        llec=presenter.getAll();//rafraichissement
        affListe(llec);
    }


    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        System.out.println("adresse");
        String adr = sc.nextLine();
        System.out.println("mail");
        String mail = sc.nextLine();
        System.out.println("tel ");
        String tel = sc.nextLine();
        Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        presenter.addLecteur(lec);
        llec=presenter.getAll();//rafraichissement
        affListe(llec);
    }
    private void special() {
        int choix =  choixElt(llec);
        Lecteur lec = llec.get(choix-1);
        do {
            System.out.println("1.Exemplaire en location\n2.Exemplaires loués\n3.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.exemplairesEnLocation(lec);
                    break;
                case 2:
                    presenter.exemplairesLoues(lec);
                    break;
                case 3: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);


    }
}

