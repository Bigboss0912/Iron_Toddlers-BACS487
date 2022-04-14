public class Seed{
// Seed string form that is given to user will be in following form 
// {randomSeed}xx{Starter}{Wild}{Trainer}{FieldItems}{PokeStats}{Moves+compat}{summary}
    private long randomSeed;
    private String configString;
    private String starterString;
    private String wildString;
    private String trainerString;
    private String fieldItemsString;
    private String pokeStatsString;
    private String movesString;
    private String summaryString;
    private EditRom editRom;
    
    public Seed(EditRom editRom, Long seed){
        this.randomSeed = seed;
        this.editRom = editRom;
    }

    public void randomizeStarter(){
        Boolean levelRandom = 
        this.starterString.charAt(0) == 1 ? true : false;
        int lowerBound = 
        levelRandom ? Integer.parseInt(this.starterString.substring(1, 3)) : 5;
        int upperBound = 
        levelRandom ? Integer.parseInt(this.starterString.substring(3, 5)) : 5;
        
        StarterModule start = new StarterModule(this.editRom, lowerBound, upperBound);
        if(this.starterString.charAt(5) == '1'){
            start.randomizeStartersAllPokemon();
        }
        else if(this.starterString.charAt(6) == '1'){
            start.randomizeStarterThreeStage();
        }
        else if(this.starterString.charAt(7) == '1'){
            start.randomizeStartersAllPokemonNoLegendary();
        }
    }

    public void processConfigString(){
        int endOfRandomSeed = this.configString.indexOf("xx");
        this.randomSeed = Long.parseLong(this.configString.substring(0,endOfRandomSeed));
        this.starterString = this.configString.substring(endOfRandomSeed + 2, endOfRandomSeed + 10);
        this.wildString = this.configString.substring(endOfRandomSeed + 10, endOfRandomSeed + 15);
    }

    public String returnConfigString(){
        this.configString = this.randomSeed + "xx" + this.starterString;
        return this.configString;
    }

    public long getSeed(){
        return this.randomSeed;
    } 

    public void setSeed(long seed){
        this.randomSeed = seed;
    }

    public void setStarterString(String x){
        this.starterString = x;
    }

    public void test(){
        
    }
}