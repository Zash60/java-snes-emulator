package com.javasnes;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
public class EmulatorView extends View {
    private Bitmap bitmap;
    private int[] pixels;
    private final int WIDTH = 256;
    private final int HEIGHT = 224;
    public EmulatorView(Context context) {
        super(context);
        bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.RGB_565);
        pixels = new int[WIDTH * HEIGHT];
    }
    public void updateFrame(int[][] screenBuffer) {
        int index = 0;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x < screenBuffer.length && y < screenBuffer[0].length) {
                    pixels[index++] = screenBuffer[x][y] | 0xFF000000;
                } else { pixels[index++] = 0xFF000000; }
            }
        }
        post(() -> {
            bitmap.setPixels(pixels, 0, WIDTH, 0, 0, WIDTH, HEIGHT);
            invalidate();
        });
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, null, new android.graphics.Rect(0, 0, getWidth(), getHeight()), null);
    }
}
