package model;


import metier.Exemplaire;
import metier.Ouvrage;

import java.util.List;

public class OuvrageModel extends AbstractModel<Ouvrage> implements SpecialOuvrage {
    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o) {
        return o.getLex();
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation) {
        return o.getLex(enLocation);
    }

    @Override
    public double amendeRetard(Ouvrage o, int nj) {
        return o.amendeRetard(nj);
    }
}
