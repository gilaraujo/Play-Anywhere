package br.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.random.bean.Campaign;
import br.random.bean.Char;
import br.random.bean.Profile;
import br.random.bean.VampireChar;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.*;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class ChooseCharView extends SherlockActivity {
	private Profile user;
	private String system;
	private int campaignid;
	private LinearLayout ll_system;
	private ListView lv_chars;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosechar_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = Singleton.getInstance(getApplicationContext()).getUser();
        
        findViews();
        
        Bundle b = getIntent().getExtras();
        
        campaignid = b.getInt("campaignid");
        ImageView image = new ImageView(getApplicationContext());
        system = b.getString("system");
    	if (system.equals("DnD")) image.setImageResource(R.drawable.dnd_logo);
    	else if (system.equals("Vampire")) image.setImageResource(R.drawable.vampire_logo);
    	else if (system.equals("Mage")) image.setImageResource(R.drawable.mage_logo);
    	int width = (int) (120 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
    	int height = (int) (70 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
    	LinearLayout ll_button = new LinearLayout(getApplicationContext());
    	Button button = new Button(getApplicationContext());
    	button.setText("Criar Novo");
    	button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					startActivity(new Intent(getApplicationContext(), Class.forName("br.random.createchar."+system+"View")));
				} catch (ClassNotFoundException e) {
					Toast.makeText(getApplicationContext(), "Sistema de jogo não disponível: "+system, Toast.LENGTH_SHORT).show();
				}
			}
		});
    	ll_system.addView(image,width,height);
    	ll_button.setGravity(Gravity.RIGHT);
    	ll_button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    	ll_button.addView(button);
    	ll_system.addView(ll_button);
    	
    	
    	List<Char> list = Char.getByUserAndSystem(getApplicationContext(),user.getUserId(),system);
    	ArrayList<Map<String,String>> charList = new ArrayList<Map<String,String>>();
        for (int i=0; i<list.size(); i++) {
        	Map<String,String> element = new HashMap<String,String>();
        	element.put("_id", ""+list.get(i).getCharid());
        	element.put("name",list.get(i).getName());
        	charList.add(element);
        }
    	SimpleAdapter adapter;
        adapter = new SimpleAdapter(
        		this,
        		charList,
        		R.layout.char_list_item_simple, 
            	new String[] {"_id", "name" }, 
        		new int[] {R.id.tv_char_id, R.id.tv_char_name });
        
        lv_chars.setAdapter(adapter);
        lv_chars.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int charid = Integer.parseInt(((TextView)arg1.findViewById(R.id.tv_char_id)).getText().toString());
				String charname = ((TextView)arg1.findViewById(R.id.tv_char_name)).getText().toString();
				if (Campaign.requestParticipation(getApplicationContext(),campaignid,user.getUserId(),charid,charname)) {
					user.getPendings().add(Campaign.getById(getApplicationContext(), campaignid));
					Toast.makeText(getApplicationContext(), "Uma solicitação de participação foi enviada ao mestre da campanha", Toast.LENGTH_LONG).show();
					startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
				} else {
					Toast.makeText(getApplicationContext(), "Não foi possível requisitar participação", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    private void findViews() {
    	ll_system = (LinearLayout)findViewById(R.id.ll_system);
    	lv_chars = (ListView)findViewById(R.id.lv_chars);
    }
    @Override
    public void onResume() {
    	Bundle b = new Bundle();
    	b.putString("system",system);
    	onCreate(b);
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