package snes;
public class Video {
    public int[][] screen;
    SNES snes;
    BGMap[] bg;
    public boolean spritesOn;
    public boolean windowsEnabled;
    public RenderThread renderThread; // Adicionado: Usado pelo PPU

    public Video(SNES snes) {
        this.snes=snes;
        screen=new int[256][224];
        bg=new BGMap[5];
        bg[1]=new BGMap(1); bg[2]=new BGMap(2); bg[3]=new BGMap(3); bg[4]=new BGMap(4);
        renderThread = new RenderThread(); // Mock thread
    }
    public void updateWholeScreen() {}
    public void startScreenRefresh() {}
    public void endScreenRefresh() { snes.screen.repaint(); }
    public void updateLines(int scanline) {}
    public void updateMode() {}
    public void drawBGs() {}
    
    public class BGMap {
        public boolean toggledOn=true;
        public BGMap(int i) {}
        public void updateMode() {}
        public int[][] getAllPixels() { return new int[0][0]; }
    }
    public class RenderThread { // Mock class para satisfazer PPU
        public void endRefresh() {}
        public void startRefresh() {}
        public void render(int l) {}
    }
}
