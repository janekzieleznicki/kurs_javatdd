import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GraczTest {

	@Test(expectedExceptions = BrakDostepnychKosciException.class)
	public void rzuciWyjatekPodczasRzutuJesliZatrzymanoWszystkieKosci() throws PrzekroczonoLimitZatrzymanychKostek,
			OddanoTrzyDozwoloneRzutyException, BrakDostepnychKosciException {
		Gracz gracz = new Gracz();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		gracz.zatrzymaj(list);
		gracz.rzucKoscmi();
	}

	@Test(expectedExceptions = OddanoTrzyDozwoloneRzutyException.class)
	public void rzuciWyjatekJesliGraczRzuciWiecejNiz3Razy() throws PrzekroczonoLimitZatrzymanychKostek,
			OddanoTrzyDozwoloneRzutyException, BrakDostepnychKosciException {
		Gracz gracz = new Gracz();
		for (int i = 0; i < 4; i++)
			gracz.rzucKoscmi();
	}

	@Test(expectedExceptions = PrzekroczonoLimitZatrzymanychKostek.class)
	public void rzuciWyjatekJesliGraczZatrzymaWiecejNiz5Kostek() throws PrzekroczonoLimitZatrzymanychKostek {
		Gracz gracz = new Gracz();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		gracz.zatrzymaj(list);
	}

	@Test
	public void graczOtrzyma5Kostek() throws PrzekroczonoLimitZatrzymanychKostek, OddanoTrzyDozwoloneRzutyException,
			BrakDostepnychKosciException {
		Gracz gracz = new Gracz();
		List<Integer> kostki = gracz.rzucKoscmi();

		Assertions.assertThat(kostki.size()).isEqualTo(5);
	}

	@DataProvider(name = "kostkiDoZatrzymania")
	public Object[][] kostkiDoZatrzymania() {
		return new Object[][] { { Arrays.asList(1) }, { Arrays.asList(1, 2) }, { Arrays.asList(1, 2, 3) },
				{ Arrays.asList(1, 2, 3, 4) } };
	}

	@Test(dataProvider = "kostkiDoZatrzymania")
	public void graczOtrzymaXKostek(List<Integer> kostkiDoZatrzymania) throws PrzekroczonoLimitZatrzymanychKostek,
			OddanoTrzyDozwoloneRzutyException, BrakDostepnychKosciException {
		Gracz gracz = new Gracz();

		gracz.zatrzymaj(kostkiDoZatrzymania);
		List<Integer> kostki = gracz.rzucKoscmi();
		Assertions.assertThat(kostki.size()).isEqualTo(5 - kostkiDoZatrzymania.size());
	}

}
