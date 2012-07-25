package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class MessageView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView message = (TextView)findViewById(R.id.message);
        
        Bundle b = getIntent().getExtras();
        
        message.setText(b.getString("message"));
    }
}