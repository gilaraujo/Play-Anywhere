package br.random;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton campaignButton = (ImageButton)findViewById(R.id.ib_campaign);
        campaignButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//campaignButtonClick();
			}
		});
        ImageButton profileButton = (ImageButton)findViewById(R.id.ib_profile);
        profileButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				profileButtonClick();
			}
		});
        ImageButton newgameButton = (ImageButton)findViewById(R.id.ib_newGame);
        newgameButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				newgameButtonClick();
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
}