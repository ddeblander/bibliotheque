package view;

import java.util.List;

public interface ViewInterface <T>
{
    public void setPresenter(T presenter);

    public void setListDatas(List<T> lecteurs);

    public void affMsg(String msg);


    void affList(List<T> lex);
}

