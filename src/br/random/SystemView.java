package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class SystemView extends SherlockActivity {
	private TextView tv_system;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_system = (TextView)findViewById(R.id.tv_system);
        
        Bundle b = getIntent().getExtras();
        
        tv_system.setText(b.getString("system"));
    }
}