package com.company;

import java.util.*;

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
private void zerknijNaPuste(){
        Stos stos = new Stos<Integer>();
        assert stos.zerknij()==null: "Stos nie zwraca pustego gdy jest pusty";
    }

    private void polozPotemZerknij(){
        Stos stos = new Stos<Integer>();
        stos.poloz(3);
        assert stos.zerknij().equals(3): "Stos nie zwraca obiektu";
        stos.poloz(5);
        assert stos.zerknij().equals(5): "Stos nie zmienia sie przy poloz";
    }

    private void pobierzNaPustym(){
        Stos stos = new Stos<Integer>();
        try {
            stos.pobierz();
            assert false: "Stos nie rzucil wyjatku";
        } catch (Exception ignored) {
        }
    }

    private void kladziePOtemPobiera(){
        Stos<Integer> stos = new Stos<>();
        stos.poloz(5);
        stos.poloz(16);
        try {
            //noinspection AssertWithSideEffects
            assert stos.pobierz().equals(16): "Wierzchni element zly";
            //noinspection AssertWithSideEffects
            assert stos.pobierz().equals(5): "Glebszy element zly";
            stos.pobierz();
            assert false: "Blad oprozniania stosu";
        } catch (Exception ignored) {
        }
    }

    private void czyZerkanieNieZmieniaStanu(){
        Stos<Integer> stos = new Stos<>();
        stos.poloz(5);
        stos.poloz(16);
        assert stos.zerknij().equals(stos.zerknij()): "Zerkanie modyfikuje stos";
        try {
            //noinspection AssertWithSideEffects
            assert !stos.pobierz().equals(stos.zerknij()): "Pobieranie nie zmienilo stosu";
            //noinspection AssertWithSideEffects
            assert !stos.pobierz().equals(stos.zerknij()): "Pobieranie nie zmienilo stosu";
        } catch (PustyStosException e) {
            e.printStackTrace();
        }
    }

    private void stosStringow() throws PustyStosException {
        String[] data = new String[]{"Dane", "Wiecej danych", "Jeszcze troche", "Starczy"};
        testStosuGenerykow(data);
    }

    private void stosFloatow() throws PustyStosException {
        Float[] data = new Float[]{1.23f, 2.34f, 4.56f, 4.56f};
        testStosuGenerykow(data);
    }

    private void stosCharow() throws PustyStosException {
        Character[] data = new Character[]{'a', 'b', 'c', 'd', 'e'};
        testStosuGenerykow(data);
    }

    private <T> void testStosuGenerykow(T[] data) throws PustyStosException {
        Stos<T> stos = new Stos<>();
        for (T t : data){
            stos.poloz(t);
            assert stos.zerknij().equals(t): "Blad kladzenia stringa";
        }
        Collections.reverse(Arrays.asList(data));
        for (T t_reverse : data){
            assert stos.zerknij().equals(t_reverse): "Blad zerkania";
            //noinspection AssertWithSideEffects
            assert stos.pobierz().equals(t_reverse): "Blad pobierania";
        }
        try {
            stos.pobierz();
            assert false : "Blad oprozniania";
        } catch (PustyStosException ignored) {
        }
    }

    public static void main(String[] args) throws PustyStosException {
        StosTest stosTest = new StosTest();
        stosTest.zerknijNaPuste();
        stosTest.polozPotemZerknij();
        stosTest.pobierzNaPustym();
        stosTest.kladziePOtemPobiera();
        stosTest.czyZerkanieNieZmieniaStanu();
        stosTest.stosStringow();
        stosTest.stosFloatow();
        stosTest.stosCharow();
    }
}
