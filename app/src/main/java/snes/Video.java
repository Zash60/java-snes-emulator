package snes;
public class Video {
    public int[][] screen;
    SNES snes;
    BGMap[] bg;
    public boolean spritesOn;
    public boolean windowsEnabled;
    public Video(SNES snes) {
        this.snes=snes;
        screen=new int[256][224];
        bg=new BGMap[5];
        bg[1]=new BGMap(1); bg[2]=new BGMap(2); bg[3]=new BGMap(3); bg[4]=new BGMap(4);
        spritesOn=true;
        windowsEnabled=true;
    }
    public void updateWholeScreen() {}
    public void startScreenRefresh() {}
    public void endScreenRefresh() { snes.screen.repaint(); }
    public void updateLines(int scanline) {}
    public void updateMode() {}
    public void drawBGs() {} // Removido código de BGGUI
    
    public class BGMap {
        public boolean toggledOn=true;
        public BGMap(int i) {}
        public void updateMode() {}
        public int[][] getAllPixels() { return new int[0][0]; }
    }
}
