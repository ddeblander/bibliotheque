package presenter;


import metier.Auteur;
import metier.TypeLivre;
import model.DAO;
import view.ViewInterface;

import java.util.Comparator;


public class AuteurPresenter extends Presenter<Auteur> implements SpecialAuteurPresenter {


    public AuteurPresenter(DAO<Auteur> model, ViewInterface<Auteur> view, Comparator<Auteur>cmp) {
        super(model, view,cmp);
    }


    @Override
    public void listerOuvrages(Auteur a) {

    }

    @Override
    public void listerLivre(Auteur a, TypeLivre tl) {

    }

    @Override
    public void listerOuvrages(Auteur a, String genre) {

    }
}
