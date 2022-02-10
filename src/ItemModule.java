import java.util.ArrayList;
import java.util.Random;



public class ItemModule {

    private EditRom editRom;

    public ItemModule (EditRom editRom) {
        this.editRom = editRom;
    }

    // Array of items excluding key items, HMs, and unknown items
    public int[] getUsableItems(){
        return new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
        30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,63,64,65,66,67,68,69,70,71,73,
        74,75,76,77,78,79,80,81,83,84,85,86,93,94,95,96,97,98,103,104,106,107,108,109,110,111,133,134,135,
        136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,
        160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,179,180,181,182,183,184,185,186,
        187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,
        211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,254,255,256,257,258,289,290,291,292,
        293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,
        317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338};
    }

    
    int[] allItems = getUsableItems();

    public int get_item_index() {

        Random rd = new Random();
        int usable_items_array_size = allItems.length;

        int item_index = rd.nextInt(usable_items_array_size);
        return Math.abs(allItems[item_index]);
    }

    public void get_Bike() {
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
}
