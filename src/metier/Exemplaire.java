package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc;


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) throws Exception {
        if(ouvrage==null) throw new Exception("ouvrage invalide");
        rayon=null;
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        //this.ouvrage.getLex().add(this);
        lloc= new ArrayList<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

     public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "metier.Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }
    public Lecteur lecteurActuel()
    {
        if(enLocation())
        {
            return lloc.get(lloc.size()-1).getLoueur();
        }
        return null;
    }
    public List<Lecteur> lecteurs()
    {
        List<Lecteur> ll = new ArrayList<>();
        for(Location l : lloc)
        {
            if(ll.contains(l.getLoueur()));
            ll.add(l.getLoueur());
        }
        return null;
    }
    public void envoiMailLecteurActuel(Mail mail)
    {
        if(lecteurActuel()!=null)
        {
            System.out.println("envoi de "+mail+ " à "+lecteurActuel().getMail());
        }
        else System.out.println("aucune location en cours");
    }
    public void envoiMailLecteurs(Mail mail)
    {
        List<Lecteur>ll=lecteurs();
        if(ll.isEmpty())
        {
            System.out.println("aucun lecteur enregistré");
        }
        else{
            for(Lecteur l: ll){
                System.out.println("envoi de "+mail+ " à "+l.getMail());
            }
        }
    }

    public boolean enLocation()
    {
        if(lloc.isEmpty()) return false;
        Location l = lloc.get(lloc.size()-1);
        if(l.getDateRestitution()==null) return true;
        return false;
    }
}
