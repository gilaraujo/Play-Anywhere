package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class MessageView extends SherlockActivity {
	private TextView tv_message;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_message = (TextView)findViewById(R.id.message);
        
        Bundle b = getIntent().getExtras();
        
        tv_message.setText(b.getString("message"));
    }
}