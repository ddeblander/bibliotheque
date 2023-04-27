package presenter;

import metier.Exemplaire;
import metier.Lecteur;
import model.DAO;
import model.SpecialLecteur;
import view.ViewInterface;

import javax.swing.text.View;
import java.util.List;

public class LecteurPresenter extends Presenter<Lecteur>
{
    private DAO model;
    private ViewInterface view;

    public LecteurPresenter(DAO<Lecteur> model, ViewInterface<Lecteur> view) {
        super(model, view);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Lecteur> getAll(){
        return model.getAll();
    }

    public void addLecteur(Lecteur lecteur) {
        Lecteur lec = (Lecteur) model.add(lecteur);
        if(lec!=null) view.affMsg("création de :"+lec);
        else view.affMsg("erreur de création");
        List<Lecteur> lecteurs = model.getAll();
        // view.setListDatas(lecteurs); //désactivé pour éviter appels imbriqués
    }


    public void removeLecteur(Lecteur lecteur) {
        boolean ok = model.remove(lecteur);
        if(ok) view.affMsg("lecteur effacé");
        else view.affMsg("lecteur non effacé");
        List<Lecteur> lecteurs = model.getAll();
        //view.setListDatas(lecteurs); //désactivé pour éviter appels imbriqués
    }
    public void update(Lecteur lecteur) {
        boolean l  =model.update(lecteur);
        if(!l) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+lecteur);
        //view.setListDatas(model.getClients());//désactivé pour éviter appels imbriqués
    }

    public void search(int idLecteur) {
        try
        {
            Lecteur l = (Lecteur) model.read(new Lecteur(idLecteur,"search","search",null,"","",""));
            if(l==null) view.affMsg("recherche infructueuse");
            else view.affMsg(l.toString());
        }catch (Exception e)
        {
            System.out.println(e.toString());
        }


    }

    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}