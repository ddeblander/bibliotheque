package model;

import metier.Lecteur;
import metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<T> implements DAO<T>
{
    private List<T> ldatas= new ArrayList<>();

    @Override
    public boolean remove(T o) {
        if(ldatas.remove(o))
            return true;
        return false;
    }

    @Override
    public boolean update(T o) {
        int id=ldatas.indexOf(o);
        if(id<0)
        {
            return false;
        }
        ldatas.set(id,o);
        return true;
    }

    @Override
    public T add(T o) {
        if(ldatas.contains(o))
            return null;
        ldatas.add(o);
        return o;

    }

    @Override
    public T read(T o)
    {
        return ldatas.get(ldatas.indexOf(o));
    }

    @Override
    public List<T> getAll() {
        return ldatas;
    }

}
