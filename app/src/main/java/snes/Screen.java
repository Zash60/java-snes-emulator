package snes;
import com.javasnes.EmulatorView;
public class Screen {
    SNES snes;
    // Mapeamento de teclas simplificado ou removido para toque
    public int[] map = new int[256];
    
    public Screen(SNES snes) {
        this.snes = snes;
    }
    public void repaint() {
        if(snes.androidView != null) {
            snes.androidView.updateFrame(snes.video.screen);
        }
    }
    public void paintImmediately(int x, int y, int w, int h) {
        repaint();
    }
    // Métodos vazios para manter compatibilidade de compilação com Gameboy/NES
    public void requestFocus() {}
}
