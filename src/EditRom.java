import java.util.Random;

public class EditRom {
    //All randomization needs to be seeded with object seed.
    //Seed is generated on instance creation.
    long seed;
    byte[] rom;

    public EditRom(byte[] rom){
        this.rom = rom;
        Random random = new Random();
        this.seed = random.nextLong();

    }

    public EditRom(byte[] rom, long seed){
        this.rom = rom;
        this.seed = seed;
    }

    public void setSeed(long seed){
        this.seed = seed;
    }

    public long getSeed(){
        return this.seed;
    }

    public byte[] getRom(){
        return this.rom;
    }

    public void editRom(int index, byte lowerBound, byte upperBound){
        //this method randomizes value with a value between upper and lower bounds.



    }



}
