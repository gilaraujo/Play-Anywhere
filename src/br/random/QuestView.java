package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class QuestView extends SherlockActivity {
	private TextView tv_campaign;
	private TextView tv_quest;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_campaign = (TextView)findViewById(R.id.tv_campaign);
        tv_quest = (TextView)findViewById(R.id.tv_quest);
        
        Bundle b = getIntent().getExtras();
        
        tv_campaign.setText(b.getString("group"));
        tv_quest.setText(b.getString("quest"));
    }
}