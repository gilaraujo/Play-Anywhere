package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends SherlockActivity {
	private ImageButton ib_profile;
	private ImageButton ib_campaign;
	private ImageButton ib_newgame;
	private ImageButton ib_createchar;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ib_campaign = (ImageButton)findViewById(R.id.ib_campaign);
        ib_campaign.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//campaignButtonClick();
			}
		});
        ib_profile = (ImageButton)findViewById(R.id.ib_profile);
        ib_profile.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				profileButtonClick();
			}
		});
        ib_newgame = (ImageButton)findViewById(R.id.ib_newgame);
        ib_newgame.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				newgameButtonClick();
			}
		});
        ib_createchar = (ImageButton)findViewById(R.id.ib_createchar);
        ib_createchar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				createcharButtonClick();
			}
		});
    }
    private void campaignButtonClick() {
			startActivity(new Intent(this,CampaignList.class));
	};
    private void profileButtonClick() {
			startActivity(new Intent(this,ProfileView.class));
	};
	private void newgameButtonClick() {
		startActivity(new Intent(this,NewGameView.class));
	};
	private void createcharButtonClick() {
		startActivity(new Intent(this,CreateCharView.class));
	};
}