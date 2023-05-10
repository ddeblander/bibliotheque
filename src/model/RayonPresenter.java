package model;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.view.ViewInterface;
import presenter.SpecialRayonPresenter;

import java.util.Comparator;


public class RayonPresenter extends Presenter<Rayon> implements SpecialRayonPresenter {
    public RayonPresenter(DAO<Rayon> model, ViewInterface<Rayon> view, Comparator<Rayon>cmp) {
        super(model, view,cmp);
    }

    @Override
    public void listerExemplaires(Rayon r){
        view.affList(((SpecialRayon)model).listerExemplaires(r));
    }
}