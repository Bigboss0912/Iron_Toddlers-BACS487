public class TrainerPokemon {
    
    private EditRom editRom;
    private int starterLevel;


    public TrainerPokemon(EditRom editRom) {
        
        this.editRom = editRom;

    }

    public void randomizeTrainerPokemon(){

        // Bug Catcher Ricks Pokemon
        editRom.editRom(2336044,1,151);
        editRom.editRom(2336052,1,151);
    }

}