package br.random;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class Testt extends ExpandableListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        GamesExpAdapter gea = new GamesExpAdapter(this);
        
        ArrayList<String> models = new ArrayList<String>();
        models.add("NZ 666 Kshatriya");
        models.add("Unicorn");
        models.add("Sinanju");
        gea.AddGroup("Unicorn", models);
        
        models = new ArrayList<String>();
        models.add("DeathScythe");
        models.add("Altron");
        models.add("HeavyArms");
        models.add("SandRock");
        models.add("Epyon");
        models.add("ZERO");
        gea.AddGroup("Wing", models);
        
        setListAdapter(gea);
        ExpandableListView elv = getExpandableListView();
        elv.setTextFilterEnabled(true);
        //listview.setOnItemClickListener(OnClickingListItem());
    }
}