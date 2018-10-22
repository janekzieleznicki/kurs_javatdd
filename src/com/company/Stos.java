package com.company;


import java.util.Arrays;

class Stos <T> {
    private T[] obiekty = (T[]) new Object[0];
    private int size = 0;

    T zerknij() {
        if(size > 0)
            return obiekty[size-1];
        return null;
    }

    void poloz(T t) {
        obiekty= Arrays.copyOf(obiekty,++size);
        obiekty[size-1]=t;
    }

    T pobierz() throws PustyStosException{
        if(zerknij()==null)
            throw new PustyStosException("Proba dostepu do pustego stosu");
        else{
            T out = obiekty[size-1];
            obiekty = Arrays.copyOf(obiekty,--size);
            return out;
        }
    }
}
