public class TrainerPokemon {
    
    private EditRom editRom;
    private int starterLevel;


    public TrainerPokemon(EditRom editRom) {
        
        this.editRom = editRom;

    }

    public void randomizeTrainerPokemon(){

        // Randomize Trainers Pokemon
        for (int i = 2335140; i < 2352476; i+=8) {
            editRom.editRom(i,1,151);
        }
        
    }

}