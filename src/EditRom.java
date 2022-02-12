import java.util.Random;

public class EditRom {
    //All randomization needs to be seeded with object seed.
    //Seed is generated on instance creation.
    protected long seed;
    protected byte[] rom;
    protected Random random;


    public EditRom(byte[] rom){
        this.rom = rom;
        Random random = new Random();
        this.seed = random.nextLong();
        this.random = new Random(this.seed);
    }

    public EditRom(byte[] rom, long seed){
        this.rom = rom;
        this.seed = seed;
        this.random = new Random(this.seed);
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

    public void editRom(int index, int lowerBound, int upperBound){
        //this method randomizes value with a value between upper and lower bounds.
        //lowerbound and upperbound are INCLUSIVE
        upperBound += 1;
        byte newByte = (byte)(this.random.nextInt(upperBound - lowerBound) + lowerBound);
        // creates int between the bounds and casts to byte type.
        this.rom[index] = newByte;
        System.out.println("Random Bit -- Offset: " + index + "    New Byte: " +  Byte.toString(newByte));

    }

    public void setByte(int index, int value){
        byte newByte = (byte) value;
        this.rom[index] = newByte;
        // System.out.println("Random Bit -- Offset: " + index + "    New Byte: " + Byte.toString(newByte));
    }

    public int chooseFromList(int[] list){
        int upperBound = list.length;
        int randomIndex = this.random.nextInt(upperBound);
        return list[randomIndex];
    }

    public void editRom(int index, int[] possibleValuesInt){

        //this method randomizes a value based off a list of possible values.
        int upperBound = possibleValuesInt.length;
        int randomIndex = this.random.nextInt(upperBound);
        byte newByte = 0;
        try {
            newByte = (byte) possibleValuesInt[randomIndex];
        }catch(Exception e){
            System.out.println("Array of possible values contain values outside of byte range");
            return;
        }
        this.rom[index] = newByte;
        System.out.println("Random Bit -- Offset: " + index + "    New Byte: " +  Byte.toString(newByte));
    }

}