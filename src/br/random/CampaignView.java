package br.random;

import br.random.dao.DatabaseHelper;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class CampaignView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView campaign = (TextView)findViewById(R.id.tv_campaign);
        TextView master = (TextView)findViewById(R.id.tv_master);
        ListView scenarios = (ListView)findViewById(R.id.lv_scenarios);
        ListView acts = (ListView)findViewById(R.id.lv_acts);
        
        setListViewScrollable(acts);
        setListViewScrollable(scenarios);
        
        Bundle b = getIntent().getExtras();  
        SQLiteDatabase db = (new DatabaseHelper(getApplicationContext())).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT master, campaign FROM tbcampaign where idcampaign = ?", new String[]{ b.getString("campaignId") });
        cursor.moveToNext();
        master.setText(cursor.getString(0));
        campaign.setText(cursor.getString(1));
        
        
        cursor = db.rawQuery("SELECT idcampaign _id, scenarioname, description FROM tbscenario where idcampaign = ?", new String[]{ b.getString("campaignId") });
        SimpleCursorAdapter scenariosAdapter;
        scenariosAdapter = new SimpleCursorAdapter(
        		this, 
        		R.layout.campaign_list_item_simple, 
        		cursor, 
        		new String[] {"_id", "scenarioname", "description"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name, R.id.tv_description});
        scenarios.setAdapter(scenariosAdapter);
        
        scenarios.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Bundle bundle = new Bundle();
				bundle.putString("message",((TextView)arg1.findViewById(R.id.tv_description)).getText().toString());
				startActivity(new Intent(getApplicationContext(), MessageView.class).putExtras(bundle));
			}
		});
        
        cursor = db.rawQuery("SELECT idcampaign _id, questname FROM tbquests where idcampaign = ?", new String[]{ b.getString("campaignId") });
        SimpleCursorAdapter actsAdapter;
        actsAdapter = new SimpleCursorAdapter(
        		this, 
        		R.layout.campaign_list_item_simple, 
        		cursor, 
        		new String[] {"_id", "questname"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name});
        acts.setAdapter(actsAdapter);
        
        acts.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String group = (((TextView)arg1.findViewById(R.id.tv_campaign_id)).getText().toString());
				String quest = (((TextView)arg1.findViewById(R.id.tv_campaign_name)).getText().toString());
				Bundle bundle = new Bundle();
				bundle.putString("group", group);
				bundle.putString("quest",quest);
				startActivity(new Intent(getApplicationContext(), QuestView.class).putExtras(bundle));
			}
		});
        db.close();
    }
    private void setListViewScrollable(final ListView list) {
    	list.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
			     int listViewTouchAction = event.getAction();
	                if (listViewTouchAction == MotionEvent.ACTION_DOWN)
	                {
	                    list.scrollBy(0, 1);
	                }
	                return false;
	           }
        });
    }
}