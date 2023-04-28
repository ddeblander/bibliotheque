package model;

import metier.Exemplaire;
import metier.Rayon;

import java.util.List;


public class RayonModel extends AbstractModel<Rayon> implements SpecialRayon
{


    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return r.getLex();
    }
}