package snes;
public class NES {
    SNES snes;
    public int[][] frame;
    public static final int SCREEN_WIDTH=256,SCREEN_HEIGHT=240;
    public NES(SNES snes) { this.snes = snes; frame = new int[SCREEN_WIDTH][SCREEN_HEIGHT]; }
    public void loadCartridge(String f) {}
    public void reset() {}
    public void mainLoop() {}
    public byte readByte(int a) { return 0; }
    public void writeByte(int a, byte v) {}
    public void keydown(char k) {}
    public void keyup(char k) {}
    public void docycles(int c) {}
}
