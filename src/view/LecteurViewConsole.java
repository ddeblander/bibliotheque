package view;

import metier.Lecteur;
import presenter.LecteurPresenter;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.*;

import static utilitaires.Utilitaire.*;

public class LecteurViewConsole implements ViewInterface
{
    private LinkedList<String> labels= new LinkedList<>();
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);
    public LecteurViewConsole()
    {
        labels.addAll(Arrays.asList("nom","prenom","date de naissance","adresse","mail","tel"));
    }


    @Override
    public void setPresenter(Presenter presenter) {
        LecteurPresenter l=(LecteurPresenter) presenter;
        this.presenter = l;

    }

    @Override
    public void setListDatas(List lecteurs)
    {
        this.llec = lecteurs;
        affListe(llec);
        try
        {
            menu();
        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

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

    @Override
    public Object selectionner(List l) {
        return null;
    }

    public void menu() throws Exception
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
    private void rechercher()
    {
        System.out.println("numLecteur : ");
        int idLecteur = sc.nextInt();
        presenter.search(idLecteur);
    }

    private void modifier() throws Exception
    {
        int choix = choixElt(llec);
        Lecteur l = llec.get(choix-1);
        String nom = modifyIfNotBlank(labels.get(0),l.getNom());
        String prenom = modifyIfNotBlank(labels.get(1),l.getPrenom());
        String date = modifyIfNotBlank(labels.get(2),getDateFrench(l.getDn()));
        String[] jma = date.split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        String adr = modifyIfNotBlank(labels.get(3),l.getAdresse());
        String mail= modifyIfNotBlank(labels.get(4),l.getMail());
        String tel =modifyIfNotBlank(labels.get(5),l.getTel());
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



    private void ajouter() throws Exception
    {
        String nom = CreateStringName(labels.get(0));

        String prenom = CreateStringName(labels.get(1));

        System.out.println(labels.get(2));
        LocalDate dn = lecDate();

        String adr = CreateString(labels.get(3));

        String mail = CreateString(labels.get(4));

        String tel = CreateString(labels.get(5));
        while(!tel.matches(".*[0-9].*"))
        {
                System.out.println("Veuillez inserer un numéro de téléphone sans lettre");
                tel = CreateString(labels.get(5));
        }

        Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        presenter.addLecteur(lec);
        llec=presenter.getAll();//rafraichissement
        affListe(llec);
    }
    private void special()
    {
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

