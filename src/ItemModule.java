public class ItemModule {

    private EditRom editRom;

    public ItemModule (EditRom editRom) {
        this.editRom = editRom;
    }

    public void randomizeItems() {
        editRom.editRom(0,0,0);
    }

    public void randomizeItems(byte[] possibleValues) {
        editRom.editRom(0,0,0);
    }
}
