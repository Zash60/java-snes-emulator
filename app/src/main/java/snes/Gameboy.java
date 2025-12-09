package snes;
public class Gameboy {
    SNES snes;
    public Z80 z80;
    public int[][] frame = new int[160][144];
    public Gameboy(SNES snes) { this.snes = snes; this.z80 = new Z80(snes); }
    public void loadCartridge(String f) {}
    public void reset() {}
    public void mainLoop() {}
    public void saveSAV() {}
    public byte memory_read(int a) { return 0; }
    public void memory_write(int a, byte v) {}
    public String dumpGameboyState() { return ""; }
    public void loadGameboyState(String s) {}
    public void keydown(char k) {}
    public void keyup(char k) {}
}
