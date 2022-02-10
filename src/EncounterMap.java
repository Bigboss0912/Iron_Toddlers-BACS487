
public class EncounterMap {
    private int bank;
    private int mapNumber;
    private int startOffset;
    private int byteLength;

    private boolean grass;
    private boolean water;
    private boolean tree;
    private boolean fishingRod;

    public EncounterMap(int bank, int mapNumber, int startOffset, boolean grass, boolean water, boolean tree, boolean fishingRod){
        this.bank = bank;
        this.mapNumber = mapNumber;
        this.startOffset = startOffset;
        this.grass = grass;
        this.water = water;
        this.tree = tree;
        this.fishingRod = fishingRod;
        this.byteLength = this.calculateLength();
    }

    public EncounterMap(int bank, int mapNumber, boolean grass, boolean water, boolean tree, boolean fishingRod){
        this.bank = bank;
        this.mapNumber = mapNumber;
        this.grass = grass;
        this.water = water;
        this.tree = tree;
        this.fishingRod = fishingRod;
        this.byteLength = this.calculateLength();
    }

    @Override
    public String toString(){
        String output = String.format("Bank: %s  Map: %s  StartOffset: %s  ByteLength: %s  Grass: %s  Water: %s  Tree: %s  Fishing Rod: %s", this.bank, this.mapNumber, this.startOffset, this.byteLength,  this.grass, this.water, this.tree, this.fishingRod);
        return output;
    }

    public int calculateLength(){
        int length = 0;
        if (this.grass){
            length+= 56;
        }
        if (this.water){
            length+= 28;
        }
        if (this.tree){
            length += 28;
        }
        if (this.fishingRod){
            length += 48;
        }

        return length;
    }

    public int getByteLength(){
        return this.byteLength;
    }

    public int getBank(){
        return this.bank;
    }

    public int getMapNumber(){
        return this.mapNumber;
    }

    public int getStartOffset(){
        return this.startOffset;
    }

    public boolean getGrass(){
        return this.grass;
    }
    
    public boolean getFishingRod(){
        return this.fishingRod;
    }

    public boolean getWater(){
        return this.water;
    }

    public boolean getTree(){
        return this.tree;
    }

    public void setOffset(int offset){
        this.startOffset = offset;
    }
    
}
