package fr.g123k.deviceapps.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class DrawableUtils {

    public static Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap = null;
        try {
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                int j = drawable.getIntrinsicWidth();
                int k = drawable.getIntrinsicHeight();
                int i = j;
                if (j <= 0) {
                    i = 1;
                }
                j = k;
                if (k <= 0) {
                    j = 1;
                }
                bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
