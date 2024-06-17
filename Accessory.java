package panda;

public abstract class Accessory {
    protected int width, height;

    protected Accessory(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected abstract void drawAt(int left, int bottom);
}
