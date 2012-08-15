package br.random;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.random.bean.Campaign;
import br.random.bean.Char;
import br.random.bean.Profile;
import br.random.bean.Quest;
import br.random.bean.Scenario;
import br.random.dao.DatabaseHelper;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

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
	private TextView tv_campaign;
	private TextView tv_master;
	private ListView lv_scenarios;
	private ListView lv_acts;
	private ImageView iv_campaignstatus;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_campaign = (TextView)findViewById(R.id.tv_campaign);
        tv_master = (TextView)findViewById(R.id.tv_master);
        lv_scenarios = (ListView)findViewById(R.id.lv_scenarios);
        lv_acts = (ListView)findViewById(R.id.lv_acts);
        iv_campaignstatus = (ImageView)findViewById(R.id.iv_campaignstatus);
        
        setListViewScrollable(lv_acts);
        setListViewScrollable(lv_scenarios);
        
        Bundle b = getIntent().getExtras();  
        final Campaign c = Campaign.getById(getApplicationContext(), Integer.parseInt(b.getString("campaignId")));
        tv_master.setText(c.getMasterName());
        tv_campaign.setText(c.getName());
        
        final Profile user = Singleton.getInstance(getApplicationContext()).getUser();
        if (user.isInCampaign(b.getString("campaignId"))) {
        	iv_campaignstatus.setImageResource(R.drawable.btn_participating);
        	iv_campaignstatus.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Char ch = Char.getByUserAndCampaign(getApplicationContext(), user.getUserId(), c.getCampaignId());
					if (ch != null) {
						try {
							Class cl = Class.forName("br.random.bean."+c.getSystem()+"Char");
							Method m = cl.getDeclaredMethod("getByCharId", Context.class, int.class);
							Char campaignchar = (Char)m.invoke(null,getApplicationContext(),ch.getCharid());
							if (campaignchar != null) {
								Singleton.getInstance(getApplicationContext()).setChar(campaignchar);
								Bundle b = new Bundle();
								b.putBoolean("editable",false);
								startActivity(new Intent(getApplicationContext(), Class.forName("br.random.createchar."+c.getSystem()+"View")).putExtras(b));
							} else throw new Exception();
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), "Não foi possível carregar a página de exibição de personagem.", Toast.LENGTH_SHORT).show();
						}
					} else {
						Toast.makeText(getApplicationContext(), "Não foi possível carregar o personagem desta campanha.", Toast.LENGTH_SHORT).show();
					}
				}
			});
        } else {
        	if (user.isPendingInCampaign(b.getString("campaignId"))) {
        		iv_campaignstatus.setImageResource(R.drawable.btn_pending);
        		iv_campaignstatus.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "Sua participação está aguardando aprovação do mestre da campanha.", Toast.LENGTH_SHORT).show();
					}
				});
        	} else {
        		if (!c.isOpen()) {
        			iv_campaignstatus.setImageResource(R.drawable.btn_closed);
        			iv_campaignstatus.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Toast.makeText(getApplicationContext(), "Esta campanha está fechada para novos membros.", Toast.LENGTH_SHORT).show();
						}
					});
        		}
        		else {
        			iv_campaignstatus.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Bundle bundle = new Bundle();
							bundle.putString("system", c.getSystem());
							bundle.putInt("campaignid", c.getCampaignId());
							startActivity(new Intent(getApplicationContext(), ChooseCharView.class).putExtras(bundle));
						}
        			});
        		}
        	}
        }
        
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
        lv_scenarios.setAdapter(scenariosAdapter);
        
        lv_scenarios.setOnItemClickListener(new OnItemClickListener() {
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
        lv_acts.setAdapter(questsAdapter);
        
        lv_acts.setOnItemClickListener(new OnItemClickListener() {
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
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	      switch (item.getItemId()) {
	          case android.R.id.home:
	              startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
	              return true;
		      default:
	              return super.onOptionsItemSelected(item);
	      }
	  }
}