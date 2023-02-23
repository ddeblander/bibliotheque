package metier;

import java.time.LocalDate;
import java.util.Objects;

public class Livre extends Ouvrage{
    private String isbn;
    private int nbrePages;
    private TypeLivre tl;
    private String resume;


    public Livre(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre, String isbn, int nbrePages, TypeLivre tl, String resume) {
        super(titre, ageMin, dateParution, TypeOuvrage.LIVRE, prixLocation, langue, genre);
        this.isbn=isbn;
        this.nbrePages=nbrePages;
        this.tl=tl;
        this.resume=resume;
    }
    private Livre(LivreBuilder lb)
    {
        super(lb.o.titre, lb.o.ageMin, lb.o.dateParution, TypeOuvrage.LIVRE, lb.o.prixLocation, lb.o.langue, lb.o.genre);
        this.isbn=lb.isbn;
        this.nbrePages=lb.nbrePages;
        this.tl=lb.tl;
        this.resume=lb.resume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNbrePages() {
        return nbrePages;
    }

    public void setNbrePages(int nbrePages) {
        this.nbrePages = nbrePages;
    }

    public TypeLivre getTl() {
        return tl;
    }

    public void setTl(TypeLivre tl) {
        this.tl = tl;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return super.toString()+ "metier.Livre{" +
                "isbn='" + isbn + '\'' +
                ", nbrePages=" + nbrePages +
                ", tl=" + tl +
                ", resume='" + resume + '\'' +
                "} " + super.toString();
    }


    public static class LivreBuilder
    {
        protected Ouvrage o;
        protected String isbn;
        protected int nbrePages;
        protected TypeLivre tl;
        protected String resume;

        public LivreBuilder setOuvrage(Ouvrage o) {
            if(o!=null)
            {
                this.o = o;
            }
            else
            {
                System.out.println("Ouvrage non définis ! ");
            }

            return this;
        }
        public LivreBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public LivreBuilder setNbrePages(int nbrePages) {
            this.nbrePages = nbrePages;
            return this;
        }

        public LivreBuilder setTl(TypeLivre tl) {
            this.tl = tl;
            return this;
        }

        public LivreBuilder setResume(String resume) {
            this.resume = resume;
            return this;
        }
        public Livre build() throws Exception
        {
            if(isbn!=""||nbrePages!=0||tl!=null||o!=null)
            {
                return new Livre(this);
            }
            throw new Exception("Imformation de livre non complete");
        }
    }
}