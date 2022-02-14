import java.util.Random;

public class TrainerPokemon {

    private EditRom editRom;


    public TrainerPokemon(EditRom editRom) {

        this.editRom = editRom;

    }

    public int randPokemon(int[] arrPokemon) {
        int rand = new Random().nextInt(arrPokemon.length);
        return arrPokemon[rand];
    }

    public void setPokemon(int startIndex, int pokemon){
        int firstByte = pokemon % 256;
        int secondByte = pokemon / 256;
        editRom.setByte(startIndex, firstByte);
        editRom.setByte(startIndex +1, secondByte);
    }

    public void randomizeAllTrainers(int[] arrPokemon) {
        for (int i = 2335140; i < 2352476; i+=8) {
            int pokemon = randPokemon(arrPokemon);
            setPokemon(i, pokemon);
        }
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
                                299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313,
                                314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328,
                                329, 330, 331, 332, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344,
                                345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359,
                                360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374,
                                375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389,
                                390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404,
                                405, 406, 407, 408, 409, 410, 411};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonSetType.equals("No Legendary")) {
            int[] arrPokemon = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                                39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56,
                                57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
                                75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
                                93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108,
                                109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123,
                                124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138,
                                139, 140, 141, 142, 143, 147, 148, 149, 152, 153,
                                154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168,
                                169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
                                184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198,
                                199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213,
                                214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228,
                                229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242,
                                246, 247, 248, 277, 278, 279, 280, 281, 282, 283,
                                284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298,
                                299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313,
                                314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328,
                                329, 330, 331, 332, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344,
                                345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359,
                                360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374,
                                375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389,
                                390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 411};
            randomizeAllTrainers(arrPokemon);
        }
    }

    public void randomizeAllTrainerPokemonTypeAllPokemon(String pokemonType) {
        if (pokemonType.equals("Bug")) {
            int[] arrPokemon = {10, 11, 12, 13, 14, 15, 46, 47, 48, 49, 123, 127,
                                165, 166, 167, 168, 193, 204, 205, 212, 213, 214, 290, 291,
                                292, 293, 294, 301, 302, 303, 311, 312, 386, 387};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Dark")) {
            int [] arrPokemon = {197, 198, 215, 228, 229, 286, 287, 322, 376};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Dragon")) {
            int [] arrPokemon = {147, 148, 149, 359, 395, 396, 397, 406, 407, 408};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Electric")) {
            int [] arrPokemon = {25, 26, 81, 82, 100, 101, 125, 135, 172, 179, 180,
                    181, 239, 243, 337, 338, 353, 354};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Fighting")) {
            int [] arrPokemon = {56, 57, 66, 67, 68, 106, 107, 236, 237, 335, 336, 356, 357};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Fire")) {
            int [] arrPokemon = {4, 5, 6, 37, 38, 58, 59, 77, 78, 126, 136, 155, 156,
                    157, 218, 219, 240, 244, 250, 280, 281, 282, 321, 339, 340};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Ghost")) {
            int [] arrPokemon = {92, 93, 94, 200, 361, 362, 377, 378};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Grass")) {
            int [] arrPokemon = {1, 2, 3, 43, 44, 45, 69, 70, 71, 102, 103, 114, 152,
                                153, 154, 182, 187, 188, 189, 191, 192, 277, 278, 279,
                                298, 299, 300, 306, 307, 344, 345, 363, 369};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Ground")) {
            int [] arrPokemon = {27, 28, 50, 51, 104, 105, 111, 112, 207, 231, 232, 318,
                                319, 332, 333, 334, 405};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Ice")) {
            int [] arrPokemon = {124, 220, 221, 225, 238, 341, 342, 343, 346, 347, 402};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Normal")) {
            int [] arrPokemon = {16, 17, 18, 19, 20, 21, 22, 35, 36, 39, 40, 52, 53, 83, 84, 85, 108,
                    113, 115, 128, 132, 133, 137, 143, 161, 162, 163, 164, 173, 174, 175,
                    176, 190, 203, 206, 209, 210, 216, 217, 233, 234, 235, 241, 242};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Poison")) {
            int [] arrPokemon = {23, 24, 29, 30, 31, 32, 33, 34, 41, 42, 88, 89, 109, 110, 169, 367,
                                368, 379};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Psychic")) {
            int [] arrPokemon = {63, 64, 65, 96, 97, 122, 177, 178, 196, 201, 202, 251, 252, 352, 360,
                                392, 393, 394, 409, 410, 411};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Rock")) {
            int [] arrPokemon = {74, 75, 76, 95, 138, 139, 140, 141, 142, 185, 246, 247, 248, 320, 348, 349,
                                381, 388, 389, 390, 391, 401};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Steel")) {
            int [] arrPokemon = {208, 227, 355, 382, 383, 384, 398, 399, 400, 403};
            randomizeAllTrainers(arrPokemon);
        } else if (pokemonType.equals("Water")) {
            int [] arrPokemon = {7, 8, 9, 54, 55, 60, 61, 62, 72, 73, 79, 80, 86, 87, 90, 91, 98, 99,
                                116, 117, 118, 119, 120, 121, 129, 130, 131, 134, 158, 159, 160, 170,
                                171, 183, 184, 186, 194, 195, 199, 211, 222, 223, 224, 226, 230, 245, 249, 283,
                                284, 285, 295, 296, 297, 309, 310, 313, 314, 323, 324, 325, 326, 327, 328, 329,
                                330, 331, 373, 374, 375, 404};
            randomizeAllTrainers(arrPokemon);
        }

    }

    public void randomizeGymLeadersByTheirType(String pokemonSetType) {
        // Todo
        if (pokemonSetType.equals("All")) {
            int[] arrBrockPokemon = {74, 75, 76, 95, 138, 139, 140, 141, 142, 185, 246, 247, 248, 320, 348, 349,
                                    381, 388, 389, 390, 391, 401};
            int[] arrMistyPokemon = {7, 8, 9, 54, 55, 60, 61, 62, 72, 73, 79, 80, 86, 87, 90, 91, 98, 99,
                                    116, 117, 118, 119, 120, 121, 129, 130, 131, 134, 158, 159, 160, 170,
                                    171, 183, 184, 186, 194, 195, 199, 211, 222, 223, 224, 226, 230, 245, 249, 283,
                                    284, 285, 295, 296, 297, 309, 310, 313, 314, 323, 324, 325, 326, 327, 328, 329,
                                    330, 331, 373, 374, 375, 404};
            int[] arrLtSurgePokemon = {25, 26, 81, 82, 100, 101, 125, 135, 172, 179, 180, 181, 239, 243, 337, 338, 353, 354};
            int[] arrErikaPokemon = {1, 2, 3, 43, 44, 45, 69, 70, 71, 102, 103, 114, 152,
                                    153, 154, 182, 187, 188, 189, 191, 192, 277, 278, 279,
                                    298, 299, 300, 306, 307, 344, 345, 363, 369};
            int[] arrKogaPokemon = {23, 24, 29, 30, 31, 32, 33, 34, 41, 42, 88, 89, 109, 110, 169, 367,
                                    368, 379};
            int[] arrSabrinaPokemon = {63, 64, 65, 96, 97, 122, 177, 178, 196, 201, 202, 251, 252, 352, 360, 392, 393, 394, 409, 410, 411};
            int[] arrBlainePokemon = {4, 5, 6, 37, 38, 58, 59, 77, 78, 126, 136, 155, 156,
                                        157, 218, 219, 240, 244, 250, 280, 281, 282, 321, 339, 340};
            int[] arrGiovanniPokemon = {27, 28, 50, 51, 104, 105, 111, 112, 207, 231, 232, 318,
                                        319, 332, 333, 334, 405};

            setPokemon(2344468, randPokemon(arrMistyPokemon));
            setPokemon((2344468+8), randPokemon(arrMistyPokemon));

            setPokemon(2344496, randPokemon(arrMistyPokemon));
            setPokemon(2344528, randPokemon(arrLtSurgePokemon));
            setPokemon(2344576, randPokemon(arrErikaPokemon));
            setPokemon(2344624, randPokemon(arrKogaPokemon));
            setPokemon(2344752, randPokemon(arrSabrinaPokemon));
            setPokemon(2344688, randPokemon(arrBlainePokemon));
            setPokemon(2341640, randPokemon(arrGiovanniPokemon));
        }
    }

}