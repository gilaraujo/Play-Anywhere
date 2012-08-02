package br.random.util;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Convert {
	public static byte[] ImageViewToByteArray(ImageView image) {
    	return DrawableToByteArray(image.getDrawable());
    }
	
	public static byte[] DrawableToByteArray(Drawable image) {
		BitmapDrawable bitDw = ((BitmapDrawable) image);
        Bitmap bitmap = bitDw.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
	}
	
	public static Bitmap ByteArrayToBitmap(byte[] byteArray) {
        Bitmap bitMapImage = BitmapFactory.decodeByteArray(
                byteArray, 0,
                byteArray.length);
        return bitMapImage;
    }
}
