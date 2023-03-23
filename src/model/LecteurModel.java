package model;

import metier.Exemplaire;
import metier.Lecteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LecteurModel implements DAO,SpecialLecteur
{
    private int numcli = 0;
    private List<Lecteur> lecteurs;
    public LecteurModel(){
        lecteurs = new ArrayList<>();
        populate();
    }
    @Override
    public Lecteur add(Object o)
    {
        Lecteur l=(Lecteur) o;
        boolean present = lecteurs.contains(l);
        if (!present)
        {
            numcli++;
            l.setNumlecteur(numcli);
            lecteurs.add(l);
            return l;
        } else
            return null;
    }

    @Override
    public boolean remove(Object o)
    {
        return lecteurs.remove((Lecteur)o);

    }

    @Override
    public boolean update(Object o)
    {
        Lecteur l =(Lecteur) o;
        int id=lecteurs.indexOf(l);
        if(id<0)
        {
            return false;
        }
        lecteurs.set(id,l);
        return true;
    }

    @Override
    public List getAll()
    {
        return lecteurs;
    }

    @Override
    public Lecteur getByID(int id)
    {
        for (Lecteur l : lecteurs) {
            if (l.getNumlecteur() == id)
            {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l)
    {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l)
    {
        return new ArrayList<>(l.listerExemplairesLoues());
    }
    private void populate(){
        Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        add(lec);
        lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        add(lec);
    }
}
