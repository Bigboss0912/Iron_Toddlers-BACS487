public class StarterModule{
    
    private EditRom editRom;
    //starterLevel bounds must be > 0 and <= 100
    private int startLevelUpper = 5;
    private int startLevelLower = 5;
    private int startIndex1 = 1481653;
    private int startIndex2 = 1482114;
    private int startIndex3 = 1482168;
    private int starterLevelIndex = 1481870;
    


    public StarterModule( EditRom editRom){
        this.editRom = editRom;
    }

    public StarterModule(EditRom editRom, int starterLevelLowerBound, int starterLevelUpperBound){
        
        this.editRom = editRom;
        this.startLevelUpper = starterLevelUpperBound;
        this.startLevelLower = starterLevelLowerBound; 

    }

    public void randomizeStarters(){
        //default randomization - starter is replaced by random value from 1-151.
        editRom.editRom(startIndex1,1,151);
        editRom.editRom(startIndex2,1,151);
        editRom.editRom(startIndex3,1,151);
        randomizeStarterLevel();
        
    }

    public void randomizeStarterLevel(){
        //randomizes starter level between upper and lower bounds (inclusive)
        if((startLevelLower != 5) || (startLevelUpper != 5))
        editRom.editRom(starterLevelIndex ,startLevelLower, startLevelUpper);
    }

    public void randomizeStartersThreeStage(){
        int[] threeStagePokemon = new int[]{1, 4, 7, 10, 13, 16, 29, 32, 43, 60, 63, 66, 69, 74, 92, 147};
        randomizeStarters(threeStagePokemon);
    }

    public void randomizeStarters(int[] possibleValues){
        // starters will be replaced by value in the array of possible values. Level will be randomized if given non-default values of 5
        editRom.editRom(startIndex1, possibleValues);
        editRom.editRom(startIndex2, possibleValues);
        editRom.editRom(startIndex3, possibleValues);
        randomizeStarterLevel();
    }

}