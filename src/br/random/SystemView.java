package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class SystemView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.systemview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView system = (TextView)findViewById(R.id.system);
        
        Bundle b = getIntent().getExtras();
        
        system.setText(b.getString("system"));
    }
}