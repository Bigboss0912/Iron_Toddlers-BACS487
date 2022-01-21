import java.util.Random;

public class EditRom {
    //All randomization needs to be seeded with object seed.
    //Seed is generated on instance creation.
    protected long seed;
    protected byte[] rom;


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
        //upper bound is inclusive.
        upperBound += 1;
        //this method randomizes value with a value between upper and lower bounds.
        Random random = new Random(this.seed);
        byte newByte = (byte)(random.nextInt(upperBound - lowerBound) + lowerBound);
        // creates int between the bounds and casts to byte type.

        this.rom[index] = newByte;
        System.out.printf("Offset: %i   New Byte: %i ", index, Byte.toString(newByte));

    }

    public void editRom(int index, byte[] possibleValues){
        //this method randomizes a value based off a list of possible values.
        int lowerBound = 0;
        int upperBound = possibleValues.length;
        Random random = new Random(this.seed);
        int randomIndex = random.nextInt(random.nextInt(upperBound - lowerBound) + lowerBound);
        byte newByte = possibleValues[randomIndex];
        this.rom[index] = newByte;
        System.out.printf("Offset: %i   New Byte: %i ", index, Byte.toString(newByte));
    }





}
