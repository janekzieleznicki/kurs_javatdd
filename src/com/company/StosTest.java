package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Metody:
 * zerknij - zwraca wierzch
 * poloz - kladzie na wierzch, bezpieczna
 * pobierz - zwraca wierzch i usuwa, NIE bezpieczna
 *
 * Przypadki testowe:
 * zerknij -> na pustym zwraca puste
 * poloz -> zerknij: poloz obiekt i zwroc
 * poloz -> poloz -> zerknij: zerknij daje 2 obiekt
 * pobierz -> na pustym wyjatek
 * poloz -> poloz -> zerknij -> pobierz: pobierz i zerknij zwraca to samo -> zerknij: zwraca inne
 * poloz -> poloz -> pobierz: zwraca wierzch -> pobierz: zwraca 2 -> pobierz: wyjatek
 *
 */
public class StosTest {
    List<String> bledy = new LinkedList<>();


//    private <T> void stosAssert(T expected, T actual){
//        assert actual.equals(expected): String.format("dla %s nie zwraca %s",nr, expected);
//    }
    void zerknijNaPuste(){
        Stos stos = new Stos<Integer>();
        assert stos.zerknij()==null: "Stos nie zwraca pustego gdy jest pusty";
    }

    void polozPotemZerknij(){
        Stos stos = new Stos<Integer>();
        stos.poloz(new Integer(3));
        assert stos.zerknij().equals(3): "Stos nie zwraca obiektu";
        stos.poloz(5);
        assert stos.zerknij().equals(5): "Stos nie zmienia sie przy poloz";
    }

    void pobierzNaPustym(){
        Stos stos = new Stos<Integer>();
        try {
            stos.pobierz();
            assert true==false: "Stos nie rzucil wyjatku";
        } catch (Exception e) {
        }
    }

    void kladziePOtemPobiera(){
        Stos<Integer> stos = new Stos<>();
        stos.poloz(5);
        stos.poloz(16);
        assert stos.pobierz().equals(16): "Wierzchni element zly";
        assert stos.pobierz().equals(5): "Glebszy element zly";
        try {
            stos.pobierz();
            assert true==false: "Blad oprozniania stosu";
        } catch (Exception e) {
        }
    }

    void czyZerkanieNieZmieniaStanu(){
        Stos<Integer> stos = new Stos<>();
        stos.poloz(5);
        stos.poloz(16);
        assert stos.zerknij().equals(stos.zerknij()): "Zerkanie modyfikuje stos";
        assert !stos.pobierz().equals(stos.zerknij()): "Pobieranie nie zmienilo stosu";
        assert !stos.pobierz().equals(stos.zerknij()): "Pobieranie nie zmienilo stosu";
    }

    public static void main(String[] args){
        StosTest stosTest = new StosTest();
        stosTest.zerknijNaPuste();
        stosTest.polozPotemZerknij();
        stosTest.pobierzNaPustym();
        stosTest.kladziePOtemPobiera();
        stosTest.czyZerkanieNieZmieniaStanu();
    }
}
