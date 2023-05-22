package com.oversizedcanoe.plugins.applistcapacitor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import java.io.ByteArrayOutputStream;
import java.security.InvalidParameterException;
import java.util.Base64;

public class Utilities {

    public static void validateQuery(AppListQueryParams queryParams) throws InvalidParameterException {
        if (queryParams == null) {
            throw new InvalidParameterException("Parameter 'queryParams' is required.");
        }
    }

    public static String drawableToBase64String(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

        String result = "data:image/png;base64,";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            result += Base64.getEncoder().encodeToString(stream.toByteArray());
        }

        return result;
    }
}
