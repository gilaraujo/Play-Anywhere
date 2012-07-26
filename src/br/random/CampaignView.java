package br.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.random.bean.Campaign;
import br.random.bean.Quest;
import br.random.bean.Scenario;
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
        Campaign c = Campaign.getById(getApplicationContext(), Integer.parseInt(b.getString("campaignId")));
        master.setText(c.getMasterName());
        campaign.setText(c.getName());
        
        ArrayList<Map<String,String>> scenarioList = new ArrayList<Map<String,String>>();
        List<Scenario> campScenarios = c.getScenarios();
        for (int i=0; i<campScenarios.size(); i++) {
        	Map<String,String> element = new HashMap<String,String>();
        	element.put("_id", ""+campScenarios.get(i).getCampaignId());
        	element.put("name",campScenarios.get(i).getName());
        	element.put("description", campScenarios.get(i).getDescription());
        	scenarioList.add(element);
        }
        
        SimpleAdapter scenariosAdapter;
        scenariosAdapter = new SimpleAdapter(
        		this, 
        		scenarioList,
        		R.layout.campaign_list_item_simple, 
        		new String[] {"_id", "name", "description"}, 
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
        
        ArrayList<Map<String,String>> questList = new ArrayList<Map<String,String>>();
        List<Quest> campQuests = c.getQuests();
        for (int i=0; i<campQuests.size(); i++) {
        	Map<String,String> element = new HashMap<String,String>();
        	element.put("_id", ""+campQuests.get(i).getCampaignId());
        	element.put("name",campQuests.get(i).getName());
        	element.put("description", campQuests.get(i).getDescription());
        	questList.add(element);
        }
        SimpleAdapter questsAdapter;
        questsAdapter = new SimpleAdapter(
        		this, 
        		questList,
        		R.layout.campaign_list_item_simple, 
        		new String[] {"_id", "name", "description"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name, R.id.tv_description});
        acts.setAdapter(questsAdapter);
        
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