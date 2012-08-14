package br.random;

import br.random.bean.Profile;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class QuestView extends SherlockActivity {
	private TextView tv_campaign;
	private TextView tv_quest;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_campaign = (TextView)findViewById(R.id.tv_campaign);
        tv_quest = (TextView)findViewById(R.id.tv_quest);
        
        Bundle b = getIntent().getExtras();
        Profile user = Singleton.getInstance(getApplicationContext()).getUser();
        if (user.isInQuest(getApplicationContext(), b.getString("group"), b.getString("quest"))) {
        	tv_campaign.setText(b.getString("group"));
            tv_quest.setText(b.getString("quest"));
        } else {
        	tv_campaign.setText("Você não tem permissão para visualizar este conteúdo");
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