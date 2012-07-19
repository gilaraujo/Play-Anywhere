package br.random;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockExpandableListActivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class Testt extends SherlockExpandableListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setContentView(R.layout.main);
        
        CampaignExpAdapter gea = new CampaignExpAdapter(this);
        
        ArrayList<String> quests = new ArrayList<String>();
        quests.add("Quest 1");
        quests.add("Quest 2");
        quests.add("Quest 3");
        gea.AddGroup(new String[] {"1","Story1","Name1"}, quests);
        
        quests = new ArrayList<String>();
        quests.add("Quest 4");
        quests.add("Quest 5");
        gea.AddGroup(new String[] {"2","Story2","Name2"}, quests);
        quests = new ArrayList<String>();
        quests.add("Quest 6");
        quests.add("Quest 7");
        gea.AddGroup(new String[] {"3","Story3","Name3"}, quests);
        quests = new ArrayList<String>();
        quests.add("Quest 8");
        quests.add("Quest 9");
        gea.AddGroup(new String[] {"4","Story4","Name4"}, quests);
        quests = new ArrayList<String>();
        quests.add("Quest 10");
        quests.add("Quest 11");
        gea.AddGroup(new String[] {"5","Story5","Name5"}, quests);
        quests = new ArrayList<String>();
        quests.add("Quest 12");
        quests.add("Quest 13");
        gea.AddGroup(new String[] {"6","Story6","Name6"}, quests);
        
        setListAdapter(gea);
        ExpandableListView elv = getExpandableListView();
        elv.setTextFilterEnabled(true);
        //listview.setOnItemClickListener(OnClickingListItem());
    }
}