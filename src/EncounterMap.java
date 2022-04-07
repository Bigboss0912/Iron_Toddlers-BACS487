import java.util.HashMap;
import java.util.ArrayList;

public class EncounterMap {
    private final static int[] allPokemon = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411};
    private final static int[] allPokemonNoLegendary = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 147, 148, 149, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 246, 247, 248, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 411};
    private ArrayList<Integer> pokemonPool = new ArrayList<Integer>();
    public static ArrayList<Integer> encounterMapConstantPool = new ArrayList<Integer>();

    private int bank;
    private int mapNumber;
    private int startOffset;
    private int byteLength;

    private boolean grass;
    private boolean water;
    private boolean tree;
    private boolean fishingRod;

    public EncounterMap(int bank, int mapNumber, int startOffset, boolean grass, boolean water, boolean tree, boolean fishingRod, boolean allowLegend){
        this.bank = bank;
        this.mapNumber = mapNumber;
        this.startOffset = startOffset;
        this.grass = grass;
        this.water = water;
        this.tree = tree;
        this.fishingRod = fishingRod;
        this.byteLength = this.calculateLength();
        if(allowLegend){
            for (int i : EncounterMap.allPokemon){
                this.pokemonPool.add(i);
                encounterMapConstantPool.add(i);
            }
        }
        else{
            for (int i : EncounterMap.allPokemonNoLegendary){
                this.pokemonPool.add(i);
                encounterMapConstantPool.add(i);
            }
        }
    }

    public EncounterMap(int bank, int mapNumber, boolean grass, boolean water, boolean tree, boolean fishingRod, boolean allowLegend){
        this.bank = bank;
        this.mapNumber = mapNumber;
        this.grass = grass;
        this.water = water;
        this.tree = tree;
        this.fishingRod = fishingRod;
        this.byteLength = this.calculateLength();
        if(allowLegend){
            for (int i : EncounterMap.allPokemon){
                this.pokemonPool.add(i);
                encounterMapConstantPool.add(i);
            }
        }
        else{
            for (int i : EncounterMap.allPokemonNoLegendary){
                this.pokemonPool.add(i);
                encounterMapConstantPool.add(i);
            }
        }
    }

    public void oneToOneArea(EditRom editRom){
        int curCounter = this.startOffset;
        int newPokemon;
        int defaultPokemon;
        HashMap<Integer, Integer> keys = new HashMap<Integer, Integer>(150);
        if(this.grass){
            for (int i = 1; i <=12; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(this.pokemonPool);
                    if(EncounterModule.oneAppearance){
                        this.pokemonPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.water){
            for (int i = 1; i <=5; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(this.pokemonPool);
                    if(EncounterModule.oneAppearance){
                        this.pokemonPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.tree){
            for (int i = 1; i <=5; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(this.pokemonPool);
                    if(EncounterModule.oneAppearance){
                        this.pokemonPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.fishingRod){
            for (int i = 1; i <=10; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(this.pokemonPool);
                    if(EncounterModule.oneAppearance){
                        this.pokemonPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }
    }

    public HashMap<Integer, Integer> oneToOnePokemon(EditRom editRom, HashMap<Integer, Integer> keys){
        int curCounter = this.startOffset;
        int newPokemon;
        int defaultPokemon;
        if(this.grass){
            for (int i = 1; i <=12; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(EncounterMap.encounterMapConstantPool);
                    if(EncounterModule.oneAppearance){
                        EncounterMap.encounterMapConstantPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.water){
            for (int i = 1; i <=5; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(EncounterMap.encounterMapConstantPool);
                    if(EncounterModule.oneAppearance){
                        EncounterMap.encounterMapConstantPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.tree){
            for (int i = 1; i <=5; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(EncounterMap.encounterMapConstantPool);
                    if(EncounterModule.oneAppearance){
                        EncounterMap.encounterMapConstantPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }

        if(this.fishingRod){
            for (int i = 1; i <=10; i++){
                defaultPokemon = editRom.getByte(curCounter);
                if(keys.containsKey(defaultPokemon)){
                    newPokemon = keys.get(defaultPokemon);
                }
                else{
                    newPokemon = editRom.chooseFromList(EncounterMap.encounterMapConstantPool);
                    if(EncounterModule.oneAppearance){
                        EncounterMap.encounterMapConstantPool.remove(Integer.valueOf(newPokemon));
                    }
                    keys.put(defaultPokemon, newPokemon);
                }
                setPokemon(curCounter, newPokemon, editRom);
                curCounter +=4;
            }
            curCounter += 8;
        }
        return keys;
    }

    public void randomizeMap(EditRom editRom){
        int curCounter = this.startOffset;
        int pokemon;
        if(this.grass){
            for(int i = 1; i <= 12; i++){
                pokemon = editRom.chooseFromList(this.pokemonPool);
                setPokemon(curCounter, pokemon, editRom);
                curCounter += 4;
            }
            curCounter+= 8;
        }
        
        if(this.water){
            for(int i = 1; i <= 5; i ++){
                pokemon = editRom.chooseFromList(this.pokemonPool);
                setPokemon(curCounter, pokemon, editRom);
                curCounter += 4;
            }
            curCounter+= 8;
        }
        
        if(this.tree){
            for(int i = 1; i <= 5; i++){
                pokemon = editRom.chooseFromList(this.pokemonPool);
                setPokemon(curCounter, pokemon, editRom);
                curCounter += 4;
            }
            curCounter+= 8;
        }
        if(this.fishingRod){
            for(int i = 1; i <= 10; i++){
                pokemon = editRom.chooseFromList(this.pokemonPool);
                setPokemon(curCounter, pokemon, editRom);
                curCounter += 4;
            }
        }
    }

    public void setPokemon(int startIndex, int pokemon, EditRom editRom){
        int firstByte = pokemon % 256;
        int secondByte = pokemon / 256;
        editRom.setByte(startIndex, firstByte);
        editRom.setByte(startIndex +1, secondByte);
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
