import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Gracz {
    private List<Integer> zatrzymane = new ArrayList<>();
    private Random random = new Random();
    private int liczbaRzutow = 0;
    private static final int MAX_LICZBA_KOSTEK = 5;

    void zatrzymaj(List<Integer> list) throws PrzekroczonoLimitZatrzymanychKostek{
//        if(list.size()> MAX_LICZBA_KOSTEK)
//            throw new PrzekroczonoLimitZatrzymanychKostek(
//                    String.format("Proba zatrzymania %d kostek, to wiecej niz dozwolona liczba: %d",list.size(),MAX_LICZBA_KOSTEK)
//            );
//        zatrzymane = list;
    }

    List<Integer> rzucKoscmi() throws OddanoTrzyDozwoloneRzutyException, BrakDostepnychKosciException{
        if(liczbaRzutow++>2)
            throw new OddanoTrzyDozwoloneRzutyException("Rzut nr: "+liczbaRzutow);
        else if(zatrzymane.size()>=MAX_LICZBA_KOSTEK)
            throw new BrakDostepnychKosciException("Proba rzutu podczas zatrzymania wszystkich kosci");
        List<Integer> zwrocone = new ArrayList<>(5-zatrzymane.size());
        for(int i=0; i<5-zatrzymane.size(); i++)
            zwrocone.add(random.nextInt(6)+1);
        return zwrocone;
    }
}
