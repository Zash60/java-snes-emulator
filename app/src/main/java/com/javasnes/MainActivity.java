package com.javasnes;
import android.app.Activity;
import android.os.Bundle;
import snes.SNES;
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
            snes.initializeSNES();
            snes.mainLoop();
        }).start();
    }
}
