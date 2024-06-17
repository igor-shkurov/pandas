package panda;

public abstract class Flag extends Accessory {
    protected Flag(int width, int height) {
        super(width, height);
    }

    protected abstract void drawAt(int left, int bottom);
}
