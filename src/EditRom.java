import java.util.Random;
import java.lang.Integer;

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
        //this method randomizes value with a value between upper and lower bounds.
        //lowerbound and upperbound are INCLUSIVE
        upperBound += 1;



        System.out.println("upperBound " + upperBound + "   lowerBound " + lowerBound);

        Random random = new Random(this.seed);
        byte newByte = (byte)(random.nextInt(upperBound - lowerBound) + lowerBound);
        // creates int between the bounds and casts to byte type.

        System.out.println("bit before edit" + this.rom[index]);
        this.rom[index] = newByte;
        System.out.println("bit after edit" + this.rom[index]);
        System.out.println("Offset: " + index + "    New Byte: " +  Byte.toString(newByte));

    }

    public void editRom(int index, int[] possibleValuesInt){

        //this method randomizes a value based off a list of possible values.
        int upperBound = possibleValuesInt.length;
        Random random = new Random(this.seed);
        int randomIndex = random.nextInt(upperBound);
        byte newByte = 0;
        try {
            newByte = (byte) possibleValuesInt[randomIndex];
        }catch(Exception e){
            System.out.println("Array of possible values contain values outside of byte range");
        }
        this.rom[index] = newByte;
        System.out.println("Offset: " + index + "    New Byte: " +  Byte.toString(newByte));
    }



}
