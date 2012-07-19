package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class QuestView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView campaign = (TextView)findViewById(R.id.campaign);
        TextView quest = (TextView)findViewById(R.id.quest);
        
        Bundle b = getIntent().getExtras();
        
        campaign.setText(b.getString("group"));
        quest.setText(b.getString("quest"));
    }
}