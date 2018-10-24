public enum CommitmentGroup {
     ONES(1) ,TWOS(2), THREES(3) , FOURS(4) , FIVES(5), SIXES(6);

    private int value;

    CommitmentGroup(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static CommitmentGroup getCommitmentGroupByValue(int value){
        for(CommitmentGroup group : CommitmentGroup.values()){
            if(group.value == value) return group;
        }
        return null;
    }

}
