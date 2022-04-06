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
    
    public Seed(){

    }

    public void randomizeStarter(){
        
    }

    public void processConfigString(){
        int endOfRandomSeed = this.configString.indexOf("xx");
        this.randomSeed = Long.parseLong(this.configString.substring(0,endOfRandomSeed));
        this.starterString = this.configString.substring(endOfRandomSeed + 2, endOfRandomSeed + 10);
        this.wildString = this.configString.substring(endOfRandomSeed + 10, endOfRandomSeed + 15);
    }

    public String returnConfig(){
        return this.configString();
    }

    public long getSeed(){
        return this.randomSeed;
    } 

    public void setSeed(long seed){
        this.randomSeed = seed;
    }
}