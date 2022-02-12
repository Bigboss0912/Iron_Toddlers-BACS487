import java.util.Random;

public class TrainerPokemon {

    private EditRom editRom;
    private Random rand = new Random();


    public TrainerPokemon(EditRom editRom) {

        this.editRom = editRom;

    }

    public int randPokemon(int[] arrPokemon) {
        return 0;
    }

    public void setPokemon(int startIndex, int pokemon){
        int firstByte = pokemon % 256;
        int secondByte = pokemon / 256;
        editRom.setByte(startIndex, firstByte);
        editRom.setByte(startIndex +1, secondByte);
    }

    public void randomizeAllTrainerPokemon(String pokemonSetType){

        if (pokemonSetType.equals("All")) {
            int[] arrPokemon = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                                39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56,
                                57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
                                75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
                                93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108,
                                109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123,
                                124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138,
                                139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153,
                                154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168,
                                169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
                                184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198,
                                199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213,
                                214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228,
                                229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243,
                                244, 245, 246, 247, 248, 249, 250, 251, 277, 278, 279, 280, 281, 282, 283,
                                284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298,
                                299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313};
            for (int i = 2335140; i < 2352476; i+=8) {
                int pokemon = randPokemon(arrPokemon);
                setPokemon(i, pokemon);
            }
        }
    }

    public void randomizeAllTrainerPokemonType(String pokemonType) {

        if (pokemonType.equals("Bug")) {
            int[] pokemonArr = {10, 11, 12, 13, 14, 15, 46, 47, 48, 49, 123, 127,
                    165, 166, 167, 168, 193, 204, 205, 212, 213, 214};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Dark")) {
            int [] pokemonArr = {197, 198, 215, 228, 229};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Dragon")) {
            int [] pokemonArr = {147, 148, 149};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Electric")) {
            int [] pokemonArr = {25, 26, 81, 82, 100, 101, 125, 135, 172, 179, 180,
                    181, 239};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Fighting")) {
            int [] pokemonArr = {56, 57, 66, 67, 68, 106, 107, 236, 237};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Fire")) {
            int [] pokemonArr = {4, 5, 6, 37, 38, 58, 59, 77, 78, 126, 136, 155, 156,
                    157, 218, 219, 240};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Ghost")) {
            int [] pokemonArr = {92, 93, 94, 200};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Grass")) {
            int [] pokemonArr = {1, 2, 3, 43, 44, 45, 69, 70, 71, 102, 103, 114, 152,
                    153, 154, 182, 187, 188, 189, 191, 192};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Ground")) {
            int [] pokemonArr = {27, 28, 50, 51, 104, 105, 111, 112, 207, 231, 232};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Ice")) {
            int [] pokemonArr = {124, 220, 221, 225, 238};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Normal")) {
            int [] pokemonArr = {16, 17, 18, 19, 20, 21, 22, 35, 36, 39, 40, 52, 53, 83, 84, 85, 108,
                    113, 115, 128, 132, 133, 137, 143, 161, 162, 163, 164, 173, 174, 175,
                    176, 190, 203, 206, 209, 210, 216, 217, 233, 234, 235, 241, 242};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Poison")) {
            int [] pokemonArr = {23, 24, 29, 30, 31, 32, 33, 34, 41, 42, 88, 89, 109, 110, 169};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Psychic")) {
            int [] pokemonArr = {63, 64, 65, 96, 97, 122, 177, 178, 196, 201, 202};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Rock")) {
            int [] pokemonArr = {74, 75, 76, 95, 138, 139, 140, 141, 142, 185, 246, 247, 248};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Steel")) {
            int [] pokemonArr = {208, 227};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        } else if (pokemonType.equals("Water")) {
            int [] pokemonArr = {7, 8, 9, 54, 55, 60, 61, 62, 72, 73, 79, 80, 86, 87, 90, 91, 98, 99,
                    116, 117, 118, 119, 120, 121, 129, 130, 131, 134, 158, 159, 160, 170,
                    171, 183, 184, 186, 194, 195, 199, 211, 222, 223, 224, 226, 230};
            for (int i = 2335140; i < 2352476; i+=8) {
                editRom.editRom(i, pokemonArr);
            }
        }

    }

    public void randomizeGymLeadersByTheirType() {
        // Todo
    }

}