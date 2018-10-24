import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test
public class GameTest {

    @DataProvider
    public static Object[][] possibleNumberOfDicesToThrow() {
        return new Object[][]{
                {1}, {2}, {3}, {4}, {5}
        };
    }

    @DataProvider
    public static Object[][] numbersAndRespectiveCommitmens() {
        return new Object[][]{
                {new int[] {1, 1, 1, 1, 2}, CommitmentGroup.ONES},
                {new int[] {1, 2, 3, 4, 5}, CommitmentGroup.FIVES},
                {new int[] {5, 5, 4, 4, 4}, CommitmentGroup.FOURS},
                {new int[] {3, 3, 6, 3, 6}, CommitmentGroup.SIXES},
                {new int[] {1, 6}, CommitmentGroup.SIXES},
                {new int[] {5, 2, 2}, CommitmentGroup.FIVES},
                {new int[] {2, 2, 4}, CommitmentGroup.TWOS},
                {new int[] {6, 6, 6}, CommitmentGroup.SIXES}
        };
    }

    @Test(invocationCount = 100)
    public void forASingleThrowReturnsNumberBetween1And6() {
        //given:
        Game game = new Game();

        //when
        int result = game.throwDice();

        //then:
        Assertions.assertThat(result)
                .as("single throw result %d not between 1 and 6", result)
                .isBetween(1, 6);
    }

    @Test(dataProvider = "possibleNumberOfDicesToThrow")
    public void forAGivenNumberOfDicesReturnsSameAmountOfNumbers(int numberOfDices) throws Exception {
        //given:
        Game game = new Game();

        //when:
        int[] results = game.throwDices(numberOfDices);

        //then:
        Assertions.assertThat(results)
                .as("%d throws results in %d results", numberOfDices, results.length)
                .hasSize(numberOfDices);

        Assertions.assertThat(Arrays.stream(results).sum())
                .as("sum of %d throws is not between %d and %d", numberOfDices, numberOfDices, numberOfDices * 6)
                .isBetween(numberOfDices, 6 * numberOfDices);
    }

    @Test(expectedExceptions = MoreThan5DicesThrownException.class)
    public void cantThrowMoreThan5Dices() throws Exception {
        //given:
        Game game = new Game();

        //when:
        Assertions.assertThat(game.throwDices(6))
                .as("throws more than 5 dices at once");
    }

    @Test(expectedExceptions = LessThan1DiceThrownException.class)
    public void cantThrowLessThan1Dice() throws Exception {
        //given:
        Game game = new Game();

        //when:
        Assertions.assertThat(game.throwDices(0))
                .as("throws less tan 1 dice at once");
    }

}
