package model;

import metier.Lecteur;
import metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAO<Rayon> {

    private List<Rayon> rayons = new ArrayList<>();

    @Override
    public boolean remove(Rayon elt)
    {
        return rayons.remove(elt);
    }

    @Override
    public boolean update(Rayon elt)
    {
        int p = rayons.indexOf(elt);
        if (p < 0) return false;
        rayons.set(p, elt);
        return true;
    }



    @Override
    public List<Rayon> getAll()
    {

        return rayons;
    }

    @Override
    public Rayon read(Rayon o) {
        if(o == null)
        {
            return null;
        }
        for(Rayon i : rayons)
        {
            if(i.equals(o))
            {
                return i;
            }
        }
        return null;
    }

    public Rayon add(Rayon nl)
    {
        if (rayons.contains(nl)) return null;
        rayons.add(nl);
        return nl;
    }
}