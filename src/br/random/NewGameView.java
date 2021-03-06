package br.random;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class NewGameView extends SherlockActivity {
	private EditText et_master;
	private EditText et_campaign;
	private Spinner sp_systems;
	private CheckBox chk_onlyOpen;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        et_master = (EditText)findViewById(R.id.et_master);
        et_campaign = (EditText)findViewById(R.id.et_campaign);
        sp_systems = (Spinner)findViewById(R.id.sp_systems);
        chk_onlyOpen = (CheckBox)findViewById(R.id.chk_onlyopen);
        String[] systems = getResources().getStringArray(R.array.systems);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
        		getApplicationContext(),
        		android.R.layout.simple_spinner_item,
        		systems);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_systems.setAdapter(dataAdapter);
		
		
		Button btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String system = sp_systems.getSelectedItem().toString();
				String master = et_master.getText().toString();
				String campaign = et_campaign.getText().toString();
				boolean onlyOpen = chk_onlyOpen.isChecked();
				
				Bundle bundle = new Bundle();
				bundle.putString("system",system);
				bundle.putString("master", master);
				bundle.putString("campaign", campaign);
				bundle.putBoolean("onlyOpen", onlyOpen);
				
				startActivity(new Intent(getApplicationContext(), GameList.class).putExtras(bundle));
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