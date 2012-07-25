package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class FullImage extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        ImageView image = (ImageView)findViewById(R.id.iv_fullimage);
        
        Bundle b = getIntent().getExtras();
        Bitmap img = BitmapFactory.decodeByteArray(b.getByteArray("image"),0,b.getInt("length"));
        
        
        image.setImageBitmap(img);
    }
}