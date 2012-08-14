package br.random;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class CreateCharView extends SherlockActivity {
	private LinearLayout ll_systems;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createchar_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        ll_systems = (LinearLayout)findViewById(R.id.ll_systems);
    	String[] systems = getResources().getStringArray(R.array.systems);
        for (int i=0; i<systems.length; i++){
        	ImageView image = new ImageView(getApplicationContext());
        	final String system = systems[i];
        	if (system.equals("DnD")) image.setImageResource(R.drawable.dnd_logo);
        	else if (system.equals("Vampire")) image.setImageResource(R.drawable.vampire_logo);
        	else if (system.equals("Mage")) image.setImageResource(R.drawable.mage_logo);
        	int width = (int) (120 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
        	int height = (int) (70 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
        	image.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					try {
						startActivity(new Intent(getApplicationContext(), Class.forName("br.random.createchar."+system+"View")));
					} catch (ClassNotFoundException e) {
						Toast.makeText(getApplicationContext(), "Sistema de jogo não disponível: "+system, Toast.LENGTH_SHORT).show();
					}
				}
			});
        	ll_systems.addView(image,width,height);
        }
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