public class StarterModule{
    
    private EditRom editRom;
    private int starterLevel;


    public StarterModule( EditRom editRom){
        
        this.editRom = editRom;
        this.starterLevel = 5;

    }

    public StarterModule(EditRom editRom, int starterLevel){
        
        this.editRom = editRom;
        this.starterLevel = starterLevel;

    }

    public void randomizeStarters(){
        editRom.editRom(1481653,1,151);
        editRom.editRom(1482114,1,151);
        editRom.editRom(1482168,1,151);
        
    }

    public void randomizeStarters(byte[] possibleValues){

    }

}