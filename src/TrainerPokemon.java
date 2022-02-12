public class TrainerPokemon {

    private EditRom editRom;


    public TrainerPokemon(EditRom editRom) {

        this.editRom = editRom;

    }

    public void setPokemon(int startIndex, int pokemon){
        int firstByte = pokemon % 256;
        int secondByte = pokemon / 256;
        editRom.setByte(startIndex, firstByte);
        editRom.setByte(startIndex +1, secondByte);
    }

    public void randomizeAllTrainerPokemon(String pokemonSetType){

        if (pokemonSetType.equals("All")) {
            int [] allPokemon = {1, 2};
            for (int i = 2335140; i < 2352476; i+=8) {
                setPokemon(i,1);
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