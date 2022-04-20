import java.util.Random;

public class StatsModule {

    private EditRom editRom;
    private Random rand = new Random();

    public StatsModule() {
    }

    public StatsModule(EditRom editRom) {
        this.editRom = editRom;
        this.rand = editRom.getRandom();
    }

    public void setEditRom(EditRom newEditRom) {
        this.editRom = newEditRom;
        this.rand = newEditRom.getRandom();
    }

    public byte randStat() {
        int randVal = rand.nextInt(128);
        byte retValue = (byte)randVal;
        return retValue;
    }

    public byte randStatSmall() {
        int randVal = rand.nextInt(80);
        randVal = randVal + 10;
        byte retValue = (byte)randVal;
        return retValue;
    }

    public void randomizePokemonBaseStats() {
        int j = 0;
        int stop = 2443168+6;
        int newJ = 2443168;
        for (int i = 0; i < 387; i++) {
            for (j = newJ; j < stop; j++) {
                editRom.editRom(j, randStat());
            }
            newJ += 28;
            stop = newJ+6;
            if(i == 251) {
                newJ = 2450896;
                stop = newJ+6;
            }

        }
    }

    public void randomizePokemonCatchRateAndBaseExp() {
        int j = 0;
        int stop = 2443176+1;
        int newJ = 2443176;
        for (int i = 0; i < 387; i++) {
            for (j = newJ; j < stop; j++) {
                editRom.editRom(j, randStatSmall());
            }
            newJ += 28;
            stop = newJ+2;
            if(i == 251) {
                newJ = 2450904;
                stop = newJ+2;
            }

        }
    }

    // Randomizes the Pokemon's genderratio, steps2hatch, basehapiness,
    // and growthrate
    public void randomizePokemonMiscStats() {
        int j = 0;
        int stop = 2443184+1;
        int newJ = 2443184;
        for (int i = 0; i < 387; i++) {
            for (j = newJ; j < stop; j++) {
                editRom.editRom(j, randStatSmall());
            }
            newJ += 28;
            stop = newJ+4;
            if(i == 251) {
                newJ = 2450912;
                stop = newJ+4;
            }

        }
    }

    // Randomize base stats by a delta
    public void randomizeBaseStatsByDelta(int delta) {
        int j = 0;
        int stop = 2443168+6;
        int newJ = 2443168;
        int total = 0;
        int hp = 0;
        int attack = 0;
        int def = 0;
        int speed = 0;
        int specialAttck = 0;
        int specialDef = 0;
        int hpRes = 0;
        int attackRes = 0;
        int defRes = 0;
        int speedRes = 0;
        int specialAttckRes = 0;
        int specialDefRes = 0;

        for (int i = 0; i < 387; i++) {

            total = 0;
            int count = 0;
            hp = 0;
            attack = 0;
            def = 0;
            speed = 0;
            specialAttck = 0;
            specialDef = 0;
            hpRes = 0;
            attackRes = 0;
            defRes = 0;
            speedRes = 0;
            specialAttckRes = 0;
            specialDefRes = 0;

            for (int k = newJ; k < stop; k++) {

                if (count == 0) {
                    hp = editRom.getByte(k);
                    hpRes = editRom.getByte(k);
                } else if (count == 1) {
                    attack = editRom.getByte(k);
                    attackRes = editRom.getByte(k);
                } else if (count == 2) {
                    def = editRom.getByte(k);
                    defRes = editRom.getByte(k);
                } else if (count == 3) {
                    speed = editRom.getByte(k);
                    speedRes = editRom.getByte(k);
                } else if (count == 4) {
                    specialAttck = editRom.getByte(k);
                    specialAttckRes = editRom.getByte(k);
                } else if (count == 5) {
                    specialDef = editRom.getByte(k);
                    specialDefRes = editRom.getByte(k);
                }
                total += editRom.getByte(k);
                count++;
            }

            int disTotal = 0;
            while (total != disTotal) {
                disTotal = 0;
                hp = hpRes;
                attack = attackRes;
                def = defRes;
                speed = speedRes;
                specialAttck = specialAttckRes;
                specialDef = specialDefRes;
                for (int m = 0; m < 6; m++) {
                    int randVal = rand.nextInt(delta);
                    randVal += 1;
                    randVal = randVal * (rand.nextBoolean() ? -1 : 1);

                    if (m == 0) {
                        hp += randVal;
                        disTotal += hp;
                    } else if (m == 1) {
                        attack += randVal;
                        disTotal += attack;
                    } else if (m == 2) {
                        def += randVal;
                        disTotal += def;
                    } else if (m == 3) {
                        speed += randVal;
                        disTotal += speed;
                    } else if (m == 4) {
                        specialAttck += randVal;
                        disTotal += specialAttck;
                    } else if (m == 5) {
                        specialDef += randVal;
                        disTotal += specialDef;
                    }
                }
            }

            count = 0;
            for (j = newJ; j < stop; j++) {
                if (count == 0) {
                    editRom.setByte(j, hp);
                } else if (count == 1) {
                    editRom.setByte(j, attack);
                } else if (count == 2) {
                    editRom.setByte(j, def);
                } else if (count == 3) {
                    editRom.setByte(j, speed);
                } else if (count == 4) {
                    editRom.setByte(j, specialAttck);
                } else if (count == 5) {
                    editRom.setByte(j, specialDef);
                }
                count++;
            }
            newJ += 28;
            stop = newJ+6;
            if(i == 251) {
                newJ = 2450896;
                stop = newJ+6;
            }

        }
    }

}
