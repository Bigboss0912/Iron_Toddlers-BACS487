public class TrainerPokemon {
    
    private EditRom editRom;
    private int starterLevel;


    public TrainerPokemon(EditRom editRom) {
        
        this.editRom = editRom;
        this.starterLevel = 5;

    }

    public void randomizeTrainerPokemon(){
        editRom.editRom(2335714,1,151);        
    }

}