package panda;

public abstract class Hat {
    protected int width, height;

    protected Hat(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected abstract void drawAt(int left, int bottom);
}
