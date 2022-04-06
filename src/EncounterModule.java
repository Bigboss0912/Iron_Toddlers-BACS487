import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class EncounterModule{
    public static Boolean oneAppearance;
    private EditRom editRom;
    private List<EncounterMap> bankOne = new ArrayList<EncounterMap>();
    private List<EncounterMap> bankTwo = new ArrayList<EncounterMap>();
    private List<EncounterMap> bankThree = new ArrayList<EncounterMap>();
    

    public EncounterModule(EditRom editRom, Boolean allowLegend, Boolean oneAppearance){
        fillBankOne(allowLegend);
        fillBankTwo(allowLegend);
        fillBankThree(allowLegend);
        this.editRom = editRom;
        EncounterModule.oneAppearance = oneAppearance;
    }

    public void randomizeEncounters(){
        for(EncounterMap map: this.bankOne){
            map.randomizeMap(editRom);
        }
        for(EncounterMap map: this.bankTwo){
            map.randomizeMap(editRom);
        }
        for(EncounterMap map: this.bankThree){
            map.randomizeMap(editRom);
        }
    }

    public void randomizeEncountersByArea(){
        for(EncounterMap map: this.bankOne){
            map.oneToOneArea(editRom);
        }
        for(EncounterMap map: this.bankTwo){
            map.oneToOneArea(editRom);
        }
        for(EncounterMap map: this.bankThree){
            map.oneToOneArea(editRom);
        }
    }

    public void randomizeEncountersByPokemon(){
        HashMap<Integer, Integer> keys = new HashMap<Integer, Integer>(150);
        for(EncounterMap map: this.bankOne){
            keys = map.oneToOnePokemon(editRom, keys);
        }
        for(EncounterMap map: this.bankTwo){
            keys = map.oneToOnePokemon(editRom, keys);
        }
        for(EncounterMap map: this.bankThree){
            keys = map.oneToOnePokemon(editRom, keys);
        }
    }

    public void fillBankOne(boolean allowLegend){
        EncounterMap map;
        map = new EncounterMap(1,0, 3962154,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,1, 3962210,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,2, 3962266,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,3, 3962322,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,4, 3962378,false, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,37, 3962454,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,39, 3962510,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,40, 3962566,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,41, 3962622,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,59, 3962678,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,60, 3962734,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,61, 3962790,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,62, 3962846,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,63, 3962902,true, false, true, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,64, 3963034,true, false, true, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,65, 3963166,true, false, true, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,66, 3963298,true, false, true, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,72, 3963430,true, true, true , true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,73, 3963590,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,74, 3963674,true, true, true, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,81, 3963834,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,82, 3963890,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,83, 3963974,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,84, 3964030,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,85, 3964086,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,86, 3964142,true, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,87, 3964274,true, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,90, 3964406,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,91, 3964462,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,92, 3964518,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,93, 3964574,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,94, 3964630,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,95, 3964686,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,97, 3964742,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,98, 3964826,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,99, 3964882,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,100, 3964966,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,103, 3965022,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,104, 3965106,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,105, 3965190,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,106, 3965274,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,107, 3965358,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,108, 3965442,true, false, true, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,109, 3965526,true, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,110, 3965658,true, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,111, 3965790,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,112, 3965846,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,113, 3965902,true, true, false, true, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,121, 3966034,true, false, false, false, allowLegend);
        this.bankOne.add(map); 
        map = new EncounterMap(1,122, 3971778,true, false, false, false, allowLegend);
        this.bankOne.add(map); 

    }

    public void fillBankTwo(boolean allowLegend){
        EncounterMap map;
        map = new EncounterMap(2, 13, 3966090, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 14, 3966146, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 15, 3966202, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 16, 3966258, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 17, 3966314, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 18, 3966370, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 19, 3966426, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 20, 3966482, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 21, 3966538, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 22, 3966594, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 23, 3966650, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 24, 3966706, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 25, 3966762, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 26, 3966818, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 27, 3961762, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 28, 3961818, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 29, 3961874, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 30, 3961930, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 31, 3961986, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 32, 3962042, true, false, false, false, allowLegend);
        this.bankTwo.add(map);
        map = new EncounterMap(2, 33, 3962098, true, false, false, false, allowLegend);
        this.bankTwo.add(map); 

    }

    public void fillBankThree(boolean allowLegend){
        EncounterMap map;
        map = new EncounterMap(3,0,3971018,false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,1,3971094, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,3,3971170, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,5,3971246, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,6,3971322, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,7,3971398, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,8,3971474, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,12,3971550, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,15,3971626, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,16,3971702, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,19,3968610, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,20,3968666, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,21,3968722, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,22,3968778, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,23,3968910, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,24,3968966, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,25,3969098, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,26,3969154, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,27,3969210, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,28,3969266, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,29,3969398, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,30,3969530, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,31,3969662, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,32,3969794, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,33,3969850, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,34,3969906, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,35,3969962, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,36,3970018, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,37,3970074, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,38,3970150, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,39,3970226, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,40,3970358, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,41,3970490, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,42,3970622, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,43,3970754, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,44,3970886, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,45,3966874, true, true, true, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,46,3967034, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,47,3967166, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,48,3967298, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,49,3967430, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,54,3967486, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,55,3967562, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,56,3967638, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,57,3967770, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,58,3967902, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,59,3967978, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,60,3968054, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,61,3968186, true, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,62,3968318, false, true, false, true, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,63,3968394, true, false, false, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,64,3968450, true, false, true, false, allowLegend);
        this.bankThree.add(map);
        map = new EncounterMap(3,65,3968534, false, true, false, true, allowLegend);
        this.bankThree.add(map);


    }

}