package br.random;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockExpandableListActivity;

import br.random.DatabaseHelper;
import android.content.Intent;
import android.database.*;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class CampaignList extends SherlockExpandableListActivity {
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected SimpleExpandableListAdapter adapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaignlist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        db = (new DatabaseHelper(this)).getWritableDatabase();
        cursor = db.rawQuery("SELECT idcampaign, campaign, charname FROM tbcampaign", new String[]{ });
        
        CampaignExpAdapter gea = new CampaignExpAdapter(this);
        ArrayList<String> quests;
        
        while (cursor.moveToNext()) {
        	Cursor cursor2 = db.rawQuery("SELECT questname FROM tbquests where idcampaign = ?", new String[]{ ""+cursor.getInt(0) });
			
			quests = new ArrayList<String>();
	        while (cursor2.moveToNext()) {
	        	quests.add(cursor2.getString(0));
	        }
	        gea.AddGroup(new String[] {""+cursor.getInt(0),cursor.getString(1),cursor.getString(2)}, quests);
	 	}
        setListAdapter(gea);
        ExpandableListView elv = getExpandableListView();
        elv.setTextFilterEnabled(true);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
				String group = (String)parent.getExpandableListAdapter().getGroup(groupPosition);
				String quest = (String)parent.getExpandableListAdapter().getChild(groupPosition,childPosition);
				Bundle bundle = new Bundle();
				bundle.putString("group", group);
				bundle.putString("quest",quest);
				startActivity(new Intent(getApplicationContext(), QuestView.class).putExtras(bundle));
				return false;
			}
		});
		db.close();
	}
}