package utilitaires;

import metier.DVD;
import metier.Lecteur;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LecteurFactory
{
    public Lecteur addDetail(int numlecteur, String nom, String prenom, LocalDate min, String adresse, String mail, String tel){
        System.out.println("numlecteur : ");
        long code= sc.nextLong();
        LocalTime dureeTotale=Utilitaire.lecTime();
        byte nbreBonus= sc.nextByte();
        Lecteur lec =new Lecteur(numlecteur,nom,prenom,min,adresse,mail,tel);
        Lecteur lect1 = new Lecteur(285,"Jean","Jacques",LocalDate.MIN,"46 Grand rue ","Zbla@Yahoo.be","465541652");
        System.out.println("autres langues");
        List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
        int choix;
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            lec.getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
        }while(true);
        System.out.println("sous-titres");
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            lec.getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
        }while(true);
        return lec;
    }
}
