package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ouvrage {
    protected String titre;
    protected int ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage to;
    protected double prixLocation;
    protected String langue;
    protected String genre;

    protected List<Auteur> lauteurs=new ArrayList<>();
    protected List<Exemplaire> lex;


    public Ouvrage(String titre, int ageMin, LocalDate dateParution, TypeOuvrage to, double prixLocation, String langue, String genre) throws Exception {
        if(titre==null || titre.trim().equals("")) throw new Exception("titre invalide");
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.to = to;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
        lauteurs = new ArrayList<>();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTo() {
        return to;
    }

    public void setTo(TypeOuvrage to) {
        this.to = to;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Auteur> getLauteurs() {
        return lauteurs;
    }

    public void setLauteurs(List<Auteur> lauteurs) {
        this.lauteurs = lauteurs;
    }
    public void addLauteurs(Auteur a) {
        this.lauteurs.add(a);
    }
    public void deleteLauteurs(Auteur a) {
        lauteurs.remove(a);
    }
    public Auteur deleteLauteurs(int id) {
        return lauteurs.get(id);
    }

    public List<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(List<Exemplaire> lex) {
        this.lex = lex;
    }

    @Override
    public String toString() {
        return "metier.Ouvrage{" +
                "titre='" + titre + '\'' +
                ", ageMin=" + ageMin +
                ", dateParution=" + dateParution +
                ", to=" + to +
                ", prixLocation=" + prixLocation +
                ", langue='" + langue + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static class OuvrageBuilder
    {
        protected static String titre;
        protected static int ageMin;
        protected static LocalDate dateParution;
        protected static TypeOuvrage to;
        protected static double prixLocation;
        protected static String langue;
        protected static String genre;


        public static void setTitre(String titre1) {
            titre = titre;
        }

        public static void setAgeMin(int ageMin1) {
            ageMin = ageMin;
        }

        public static void setDateParution(LocalDate dateParution1) {
            dateParution = dateParution;
        }

        public static void setTo(TypeOuvrage to1) {
            to = to1;
        }

        public static void setPrixLocation(double prixLocation1) {
            prixLocation = prixLocation;
        }

        public static void setLangue(String langue1) {
            langue = langue;
        }

        public static void setGenre(String genre1) {
            genre = genre;
        }

       /* public void setLauteurs(List<Auteur> lauteurs) {
            this.lauteurs = lauteurs;
        }

        public void setLex(List<Exemplaire> lex) {
            this.lex = lex;
        }*/
        public static Ouvrage build()
        {
            if((titre!="")&&(dateParution!=null)&&(ageMin!=0)&&(dateParution!=null)&&(to!=null)&&(prixLocation!=0.0)&&(langue!="")&&(genre!=""))
            {
                try
                {
                    return new Ouvrage(titre,ageMin,dateParution,to,prixLocation,langue,genre);
                }catch (Exception e)
                {
                    System.out.println(e.toString());
                }

            }
            return null;
        }
    }

}
