package presenter;

import metier.Exemplaire;
import metier.Lecteur;
import metier.Ouvrage;
import metier.Rayon;
import model.DAO;
import model.SpecialExemplaire;
import view.ViewInterface;

import java.util.Comparator;

public class ExemplairePresenter extends Presenter<Exemplaire> implements SpecialExemplairePresenter {
    private Presenter<Ouvrage> ouvragePresenter;



    private Presenter<Rayon> rayonPresenter;

    public ExemplairePresenter(DAO<Exemplaire> model, ViewInterface<Exemplaire> view, Comparator<Exemplaire>cmp) {
        super(model,view,cmp);
    }


    @Override
    public void setOuvragePresenter(Presenter<Ouvrage> ouvragePresenter) {

    }

    @Override
    public void setRayonPresenter(Presenter<Rayon> rayonPresenter) {

    }

    @Override
    public Ouvrage choixOuvrage() {
        return null;
    }

    @Override
    public Rayon choixRayon() {
        return null;
    }

    @Override
    public void enLocation(Exemplaire ex) {

    }

    @Override
    public void joursRetard(Exemplaire ex) {

    }

    @Override
    public void enRetard(Exemplaire ex) {

    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {

    }

    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {

    }

    @Override
    public void lecteurs(Exemplaire ex) {

    }

    @Override
    public void LecteurActuel(Exemplaire ex) {

    }

    @Override
    public void modifierEtat(Exemplaire ex, String etat) {

    }
}
