import java.util.*;

public class Player {
    public Map<CommitmentGroup, Integer> commitmentSumMap = new EnumMap<>(CommitmentGroup.class);

    public int[] calcSums(int[] results) {
        int[] sumArray = new int[6];
        List<Integer> resultsInteger = new Arrays.
        for(CommitmentGroup group : CommitmentGroup.values()){
            sumArray[group.ordinal()] = Collections.frequency(Arrays.asList(results), Integer.valueOf(group.getValue())) * group.getValue();
        }
        return sumArray;
    }

    public int findMaxSum(int[] sums) {
        return 0;
    }

    public CommitmentGroup commit(int[] results) {
        return null;
    }
}
