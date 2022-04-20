import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class ItemModule {

    private EditRom editRom;

    public ItemModule (EditRom editRom) {
        this.editRom = editRom;
    }

    public void setEditRom(EditRom editRom){
        this.editRom = editRom;
    }

    // Array of items excluding key items, HMs, and unknown items
    public int[] getUsableItems(){
        return new int[] {
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,63,64,65,66,67,68,69,70,71,73,
            74,75,76,77,78,79,80,81,83,84,85,86,93,94,95,96,97,98,103,104,106,107,108,109,110,111,133,134,135,
            136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,
            160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,179,180,181,182,183,184,185,186,
            187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,
            211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,254,255,256,257,258,289,290,291,292,
            293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,
            317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338
        };
    }

    public int[] getAllItems() {
        return new int[] {
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,63,64,65,66,67,68,69,70,71,73,
            74,75,76,77,78,79,80,81,83,84,85,86,93,94,95,96,97,98,103,104,106,107,108,109,110,111,133,134,135,
            136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,
            160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,179,180,181,182,183,184,185,186,
            187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,
            211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,254,255,256,257,258,259,260,261,262,
            289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,
            313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,

            //key items
            263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,
            287,288,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,
            371,372,373,374,375,376,

            //HMS
            339,340,341,342,343,344,345,346
        };
    }

    
    int[] allItems = getUsableItems();

    public int get_item_index() {

        Random rd = new Random();
        int usable_items_array_size = allItems.length;

        int item_index = rd.nextInt(usable_items_array_size);
        return Math.abs(allItems[item_index]);
    }

    public void get_Bike_Early() {
        editRom.editRom(1464156,26);
        editRom.editRom(1464157,0);
        editRom.editRom(1464158,128);
        editRom.editRom(1464159,3);
        editRom.editRom(1464160,1);
        editRom.editRom(1464161,26);
        editRom.editRom(1464162,1);
        editRom.editRom(1464163,128);
        editRom.editRom(1464164,1);
        editRom.editRom(1464165,0);
        editRom.editRom(1464166,9);
        editRom.editRom(1464167,1);
        editRom.editRom(1464168,2);
    }

    public void randomize_Mart_Items_Viridian_City() {
        int first_item_index = 1483416;
        int last_item_index  = 1483422;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            int item_index = Math.abs(get_item_index());
            editRom.editRom(i,item_index,item_index - 1); 
        }
    }

    
    public void randomize_Items_Viridian_City_Mart() {
        int first_item_index = 1483416;
        int last_item_index  = 1483422;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);        
        }
    }


    public void randomize_Items_Pewter_City_Mart() {
        int first_item_index = 1484552;
        int last_item_index  = 1484566;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);        
        }
    }

    public void randomize_Items_Cerulean_City_Mart() {
        int first_item_index = 1486040;
        int last_item_index  = 1486056;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);            
        }
    }

    public void randomize_Items_Lavender_Town_Mart() {
        int first_item_index = 1487760;
        int last_item_index  = 1487776;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);      
        }
    }

    public void randomize_Items_Vermilion_City_Mart() {
        int first_item_index = 1488524;
        int last_item_index  = 1488536;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }

    public void randomize_Items_Celadon_City_Mart() {
        int first_item_index = 1489720;
        int last_item_index  = 1489734;

        int second_mart_first_item_index = 1489780;
        int second_mart_last_item_index  = 1489790;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }

        for (int i = second_mart_first_item_index; i <= second_mart_last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }


    public void randomize_Items_Saffron_City_Mart() {
        int first_item_index = 1503196;
        int last_item_index  = 1503206;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Fuschia_City_Mart() {
        int first_item_index = 1496344;
        int last_item_index  = 1496354;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Cinnabar_Island_Mart() {
        int first_item_index = 1501768;
        int last_item_index  = 1501780;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Pokemon_League_Mart() {
        int first_item_index = 1501940;
        int last_item_index  = 1501952;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Three_Island_Mart() {
        int first_item_index = 1513652;
        int last_item_index  = 1513662;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Four_Island_Mart() {
        int first_item_index = 1514708;
        int last_item_index  = 1514722;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Six_Island_Mart() {
        int first_item_index = 1515148;
        int last_item_index  = 1515162;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }   
    
    public void randomize_Items_Seven_Island_Mart() {
        int first_item_index = 1510232;
        int last_item_index  = 1510248;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_Items_Trainer_Tower_Mart() {
        int first_item_index = 1460664;
        int last_item_index  = 1460680;

        for (int i = first_item_index; i <= last_item_index; i+=2) {
            editRom.editRom(i, allItems);          
        }
    }    
    
    public void randomize_All_Cities() {


        randomize_Items_Celadon_City_Mart();
        randomize_Items_Cerulean_City_Mart();
        randomize_Items_Cinnabar_Island_Mart();
        randomize_Items_Four_Island_Mart();
        randomize_Items_Fuschia_City_Mart();
        randomize_Items_Lavender_Town_Mart();
        randomize_Items_Pewter_City_Mart();
        randomize_Items_Pokemon_League_Mart();
        randomize_Items_Saffron_City_Mart();
        randomize_Items_Seven_Island_Mart();
        randomize_Items_Six_Island_Mart();
        randomize_Items_Three_Island_Mart();
        randomize_Items_Trainer_Tower_Mart();
        randomize_Items_Vermilion_City_Mart();
        randomize_Items_Viridian_City_Mart();
    }

    public void randomize_Ground_Items() {
        ArrayList<Integer> ground_item_indexes = new ArrayList<Integer>();
        Collections.addAll(ground_item_indexes, 
            1829827, 
            1829554,
            1829944,
            1829931,
            1828410,
            1829632,
            1828540,
            1829788,
            1829801,
            1828787,
            1828813,
            1828423,
            1828436,
            1829957,
            1829970,
            1829983,
            1829996,
            1830009,
            1830022,
            1830035,
            1830048,
            1830087,
            1830100,
            1830074,
            1830139,
            1830113,
            1828267, //Viridian Forest 1
            1828280, //Viridian Forest 2
            1828293, //Viridian Forest 3
            1829580, //Viridian Forest 4
            1828371, //Mt Moon 1.1 1
            1828358, //Mt Moon 1.1 2
            1828345, //Mt Moon 1.1 3
            1828332, //Mt Moon 1.1 4
            1828319, //Mt Moon 1.1 5
            1828306, //Mt Moon 1.1 6
            1828397, //Mt Moon 1.3 1
            1829593, //Mt Moon 1.3 2
            1828606, //Mt Moon 1.3 3
            1828384, //Mt Moon 1.3 4
            1828527, //SS Anne 1.10
            1828449, //SS Anne 1.13
            1828462, //SS Anne 1.19
            1828475, //SS Anne 1.21
            1828488, //SS Anne 1.25
            1828501, //SS Anne 1.26
            1828514, //SS Anne 1.28
            1829333, //Victory Road 1.39 1
            1829346, //Victory Road 1.39 2
            1829359, //Victory Road 1.40 1
            1829372, //Victory Road 1.40 2
            1829385, //Victory Road 1.40 3
            1829411, //Victory Road 1.41 1
            1829424, //Victory Road 1.41 2
            1828618, //Rocket Hideout 1.43 1
            1828605, //Rocket Hideout 1.43 2
            1828592, //Rocket Hideout 1.43 3
            1828579, //Rocket Hideout 1.43 4
            1828631, //Rocket Hideout 1.44 1
            1828644, //Rocket Hideout 1.44 2
            1829840, //Rocket Hideout 1.44 3
            1828657, //Rocket Hideout 1.45 1
            1828670, //Rocket Hideout 1.45 2
            1828683, //Rocket Hideout 1.45 3
            1828969, //Silph Co 1.49
            1828982, //Silph Co 1.50 1
            1828995, //Silph Co 1.50 2
            1829008, //Silph Co 1.50 3
            1830412, //Silph Co 1.50 4
            1829021, //Silph Co 1.51 1
            1829034, //Silph Co 1.51 2
            1829047, //Silph Co 1.51 3
            1829060, //Silph Co 1.52 1
            1829073, //Silph Co 1.52 2
            1829086, //Silph Co 1.53 1
            1829099, //Silph Co 1.53 2
            1829710, //Silph Co 1.54
            1829112, //Silph Co 1.56 1
            1829125, //Silph Co 1.56 2 
            1829138, //Silph Co 1.56 3
            1829723, //Silph Co 1.57
            1829736, //Pokemon Mansion 1.59 1
            1829216, //Pokemon Mansion 1.59 2
            1829229, //Pokemon Mansion 1.59 3
            1829242, //Pokemon Mansion 1.60 1
            1829749, //Pokemon Mansion 1.60 2
            1829762, //Pokemon Mansion 1.60 3
            1829255, //Pokemon Mansion 1.61 1
            1829268, //Pokemon Mansion 1.61 2
            1829281, //Pokemon Mansion 1.62 1
            1829294, //Pokemon Mansion 1.62 2
            1829307, //Pokemon Mansion 1.62 3
            1829320, //Pokemon Mansion 1.62 4
            1828826, //Safari Zone 1.63
            1828839, //Safari Zone 1.64 1
            1828852, //Safari Zone 1.64 2
            1828865, //Safari Zone 1.64 3
            1828878, //Safari Zone 1.64 4
            1828891, //Safari Zone 1.65 1
            1828904, //Safari Zone 1.65 2
            1829853, //Safari Zone 1.65 3
            1828943, //Safari Zone 1.66 1
            1828956, //Safari Zone 1.66 2
            1828930, //Safari Zone 1.66 3
            1828917, //Safari Zone 1.66 4
            1829437, //Cerulean Cave 1.72 1
            1829450, //Cerulean Cave 1.72 2
            1829463, //Cerulean Cave 1.72 3
            1829476, //Cerulean Cave 1.73 1
            1829489, //Cerulean Cave 1.73 2
            1829502, //Cerulean Cave 1.73 3
            1829515, //Cerulean Cave 1.74 1
            1829528, //Cerulean Cave 1.74 2
            1829645, //Rock Tunnel 1.81 1
            1829658, //Rock Tunnel 1.81 2
            1829671, //Rock Tunnel 1.81 3
            1829684, //Rock Tunnel 1.82 1
            1829697, //Rock Tunnel 1.82 2
            1829866, //Seafoam Islands 1.83
            1829879, //Seafoam Islands 1.84 1
            1829892, //Seafoam Islands 1.84 2
            1829905, //Seafoam Islands 1.85
            1829918, //Seafoam Islands 1.87
            1828696, //Pokemon Tower 1.90
            1828709, //Pokemon Tower 1.91 1
            1828722, //Pokemon Tower 1.91 2
            1828735, //Pokemon Tower 1.91 3
            1828748, //Pokemon Tower 1.92 1
            1829814, //Pokemon Tower 1.92 2
            1828761, //Pokemon Tower 1.93 1
            1828774, //Pokemon Tower 1.93 2
            1829151, //Power Plant 1
            1829164, //Power Plant 2
            1829177, //Power Plant 3
            1829190, //Power Plant 4
            1829203, //Power Plant 5
            1830217, //Mt Ember 1.97 1
            1830204, //Mt Ember 1.97 2
            1830191, //Mt Ember 1.97 3
            1830152, //Berry Forest 1
            1830165, //Berry Forest 2
            1830178, //Berry Forest 3
            1830230, //Icefall Cave 1.111 1
            1830256, //Icefall Cave 1.112 1
            1830269, //Icefall Cave 1.112 2
            1830321, //Rocket Warehouse 1
            1830308, //Rocket Warehouse 2
            1830295, //Rocket Warehouse 3
            1830282, //Rocket Warehouse 4
            1830334, //Lost Cave 2.22 
            1830347, //Lost Cave 2.23
            1830360, //Lost Cave 2.24
            1830373, //Lost Cave 2.25
            1830386, //Lost Cave 2.26
            1829541, //Fushia City 11.7
            1830399 //Sevault Canyon 42.0







            
            );

        for (int i = 0; i < ground_item_indexes.size(); i++) {
            int index = ground_item_indexes.get(i);
            editRom.editRom(index, allItems);
            System.out.println("RANDOMIZED GROUND ITEM");
        }
    }
    
}
