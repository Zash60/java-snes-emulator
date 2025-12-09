package com.javasnes;
import android.app.Activity;
import android.os.Bundle;
import snes.SNES;
import java.io.InputStream;
import java.io.IOException;

public class MainActivity extends Activity {
    private SNES snes;
    private EmulatorView emulatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        emulatorView = new EmulatorView(this);
        setContentView(emulatorView);

        new Thread(() -> {
            snes = new SNES(emulatorView);
            
            // Ler ROM da pasta assets
            try {
                InputStream is = getAssets().open("game.smc");
                byte[] romData = new byte[is.available()];
                is.read(romData);
                is.close();
                
                // Carregar no emulador
                snes.loadRom(romData);
                snes.mainLoop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
