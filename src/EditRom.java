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

    public void editRom(int index, int lowerBoundInt, int upperBoundInt){
        //this method randomizes value with a value between upper and lower bounds.
        //bytes are from -128 to 127, while the game is logically 0-255
        upperBoundInt -= 128;
        lowerBoundInt -= 128;


        byte lowerBound;
        byte upperBound;
        try{
            lowerBound = (byte)lowerBoundInt;
            upperBound = (byte)upperBoundInt;
        }
        catch(Exception e){
            System.out.println("given bounds for editRom are out of bounds. Index: " + index);
            return;
        }

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
        byte[] possibleValues = new byte[possibleValuesInt.length];
        byte holder;
        int counter = 0;
        try {
            for (int x : possibleValuesInt) {

                holder = (byte) (x - 128);
                possibleValuesInt[counter] = holder;
                counter +=1;
            }
        }
        catch(Exception e){
            System.out.println("given bounds for editRom are out of bounds. Index: " + index);
            return;
        }
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
