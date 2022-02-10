import java.util.List;
import java.util.ArrayList;

public class EncounterModule{
    private EditRom editRom;
    private List<EncounterMap> bankOne = new ArrayList<EncounterMap>();
    private List<EncounterMap> bankTwo = new ArrayList<EncounterMap>();
    private List<EncounterMap> bankThree = new ArrayList<EncounterMap>();

    private static int bankOneStartOffset = 3962154;
    private static int bankTwoStartOffset = 3966090;
    private static int bankThreeStartOffset = 3971018;


    public List<EncounterMap> fillBankTwo(){
        EncounterMap map;
        for(int i = 13 ; i <= 33; i++){
            //maps 13-33 have the same value, only grass encounters.
            map = new EncounterMap(2, i, true, false, false, false);
            this.bankTwo.add(map);
        }

        int curOffset = bankTwoStartOffset;
        for(EncounterMap mapLoop: bankTwo){
            mapLoop.setOffset(curOffset);
            curOffset += mapLoop.getByteLength();
        }

        return bankTwo;
    }

    public static void main(String args[]){
        EncounterModule module = new EncounterModule();
        List<EncounterMap> test = module.fillBankTwo();
        for(EncounterMap map : test){
            System.out.println(map);
        }
    }

}