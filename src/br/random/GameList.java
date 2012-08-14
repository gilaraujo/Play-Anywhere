package br.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.random.bean.Campaign;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class GameList extends SherlockListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        Bundle b = getIntent().getExtras();
        String system = b.getString("system");
        String master = b.getString("master");
        String name = b.getString("campaign");
        boolean onlyOpen = b.getBoolean("onlyOpen");
        List<Campaign> list = Campaign.getByCriteria(getApplicationContext(), system, master, name, onlyOpen);
        
        ArrayList<Map<String,String>> campaignList = new ArrayList<Map<String,String>>();
        for (int i=0; i<list.size(); i++) {
        	Map<String,String> element = new HashMap<String,String>();
        	element.put("_id", ""+list.get(i).getCampaignId());
        	element.put("name",list.get(i).getName());
        	element.put("master", list.get(i).getMasterName());
        	element.put("system", list.get(i).getSystem());
        	campaignList.add(element);
        }
    	SimpleAdapter adapter;
        adapter = new SimpleAdapter(
        		this,
        		campaignList,
        		R.layout.campaign_list_item, 
            	new String[] {"_id", "name", "master", "system"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name, R.id.tv_master_name, R.id.btn_system });
        
        setListAdapter(adapter);
        
        getListView().setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView campaignId = (TextView)arg1.findViewById(R.id.tv_campaign_id);
				Bundle bundle = new Bundle();
				bundle.putString("campaignId",campaignId.getText().toString());
				startActivity(new Intent(getApplicationContext(), CampaignView.class).putExtras(bundle));
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