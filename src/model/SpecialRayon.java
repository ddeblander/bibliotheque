package model;

import metier.Exemplaire;
import metier.Rayon;

import java.util.List;

public interface SpecialRayon
{
    public List<Exemplaire> listerExemplaires(Rayon r);
}
