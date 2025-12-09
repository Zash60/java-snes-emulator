package snes;
public class Screen {
    SNES snes;
    public int[] map = new int[256];
    public Screen(SNES snes) { this.snes = snes; }
    public void repaint() { if(snes.androidView != null) snes.androidView.updateFrame(snes.video.screen); }
    public void paintImmediately(int x, int y, int w, int h) { repaint(); }
    public void requestFocus() {}
}
