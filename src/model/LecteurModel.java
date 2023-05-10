package model;

import metier.Exemplaire;
import metier.Lecteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecteurModel extends AbstractModel<Lecteur> implements SpecialLecteur
{
    private int numcli = 0;

    private Map<String,Lecteur> hml= new HashMap<>();

    public Lecteur add(Lecteur nl)
    {
        if(super.add(nl)!=null)
        {
            nl.setNumlecteur(++numcli);
            return nl;
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
    @Override
    public Lecteur lecParMail(String mail) {
        return hml.get(mail);
    }
}
