package com.company;


import java.util.ArrayList;
import java.util.List;

public class Stos <T> {
    List<T> obiekty = new ArrayList<>();

    public T zerknij() {
        if(obiekty.size()>0)
            return obiekty.get(obiekty.size()-1);
        return null;
    }

    public void poloz(T t) {
        obiekty.add(t);
    }

    public T pobierz() {
        if(zerknij()==null)
            throw new IndexOutOfBoundsException("Proba dostepu do pustego stosu");
        else
            return obiekty.remove(obiekty.size()-1);
    }
}
