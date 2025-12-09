package snes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import java.util.ArrayList;
public class SoundPlayer {
    public static final int SAMPLESIZE = 32000;
    public static final int GAMEBOYSAMPLESIZE = 16000;
    public SNES snes;
    private AudioTrack audioTrack;
    public Object clip; // Dummy para compatibilidade
    
    public SoundPlayer(SNES snes, int bits) {
        this.snes = snes;
        int minBuff = AudioTrack.getMinBufferSize(SAMPLESIZE, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        if (minBuff > 0) {
            audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, SAMPLESIZE, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, minBuff * 4, AudioTrack.MODE_STREAM);
            audioTrack.play();
        }
    }
    public void dumpsound() {
        if (audioTrack == null || snes.dsp.rawsound.isEmpty()) return;
        Integer[] bufferInt = snes.dsp.rawsound.toArray(new Integer[0]);
        byte[] pcmData = new byte[bufferInt.length * 2];
        for (int i = 0; i < bufferInt.length; i++) {
            int sample = bufferInt[i];
            pcmData[i * 2] = (byte) (sample & 0xff);
            pcmData[i * 2 + 1] = (byte) ((sample >> 8) & 0xff);
        }
        audioTrack.write(pcmData, 0, pcmData.length);
        snes.dsp.rawsound.clear();
    }
}
