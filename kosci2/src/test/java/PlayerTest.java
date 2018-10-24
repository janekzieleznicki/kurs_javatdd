import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test
public class PlayerTest {

    @DataProvider
    public static Object[][] resultsAndRespectiveSums() {
        return new Object[][]{
                {new int[] {1, 1, 1, 1, 2}, new int[] {4, 2, 0, 0, 0, 0}},
                {new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5, 0}},
                {new int[] {5, 5, 4, 4, 4}, new int[] {0, 0, 0, 12, 10, 0}},
                {new int[] {3, 3, 6, 3, 6}, new int[] {0, 0, 9, 0, 0, 12}},
                {new int[] {1, 6}, new int[] {1, 0, 0, 0, 0, 6}},
                {new int[] {5, 2, 2}, new int[] {0, 4, 0, 0, 5, 0}},
                {new int[] {2, 2, 4}, new int[] {0, 4, 0, 4, 0, 0}},
                {new int[] {6, 6, 6}, new int[] {0, 0, 0, 0, 0, 18}}
        };
    }

    @DataProvider
    public static Object[][] sumsAndRespectiveMaxes() {
        return new Object[][]{
                {new int[] {4, 2, 0, 0, 0, 0}, 4},
                {new int[] {1, 2, 3, 4, 5, 0}, 5},
                {new int[] {0, 0, 0, 12, 10, 0}, 12},
                {new int[] {0, 0, 9, 0, 0, 12}, 12},
                {new int[] {1, 0, 0, 0, 0, 6}, 6},
                {new int[] {0, 4, 0, 0, 5, 0}, 5},
                {new int[] {0, 4, 0, 4, 0, 0}, 4},
                {new int[] {0, 0, 0, 0, 0, 18}, 18}
        };
    }

    @DataProvider
    public static Object[][] resultsAndRespectiveCommitmens() {
        return new Object[][]{
                {new int[] {4, 2, 0, 0, 0, 0}, CommitmentGroup.ONES},
                {new int[] {1, 2, 3, 4, 5, 0}, CommitmentGroup.FIVES},
                {new int[] {0, 0, 0, 12, 10, 0}, CommitmentGroup.FOURS},
                {new int[] {0, 0, 9, 0, 0, 12}, CommitmentGroup.SIXES},
                {new int[] {1, 0, 0, 0, 0, 6}, CommitmentGroup.SIXES},
                {new int[] {0, 4, 0, 0, 5, 0}, CommitmentGroup.FIVES},
                {new int[] {0, 4, 0, 4, 0, 0}, CommitmentGroup.TWOS},
                {new int[] {0, 0, 0, 0, 0, 18}, CommitmentGroup.SIXES}
        };
    }

    @Test(dataProvider = "resultsAndRespectiveSums")
    public void translatesResultsArrayToSumsArray(int[] results, int[] sums) {
        //given:
        Player player = new Player();

        //when:
        Assertions.assertThat(player.calcSums(results))
                .as("hasn't translated %s to %s", Arrays.asList(results).toString(), Arrays.asList(sums).toString())
                .isEqualTo(sums);
    }

    @Test(dataProvider = "sumsAndRespectiveMaxes")
    public void findsMaxSumFromSumsArray(int[] sums, int max) {
        //given:
        Player player = new Player();

        //when:
        Assertions.assertThat(player.findMaxSum(sums))
                .as("hasn't found correct max sum - for %a should be %i", sums, max)
                .isEqualTo(max);
    }

    @Test(dataProvider = "resultsAndRespectiveCommitmens")
    public void commitToMostValuableGroupAndUpdatePoints(int[] results, CommitmentGroup expectedCommitment) throws Exception {
        //given:
        Player player = new Player();

        //when & then:
        //TODO: Blednie napisana asercja - brak porownania do spodziewanej wartosci
        Assertions.assertThat(player.commit(results))
                .as("for results given %a hasn't choosen commitement group %s", results, expectedCommitment.name());

        Assertions.assertThat(player.commitmentSumMap.get(expectedCommitment))
                .as("hasn't updated points for commitment group ")
                .isEqualTo(player.findMaxSum(player.calcSums(results)));
    }


}
