package br.random;


import br.random.util.*;
import br.random.bean.Profile;
import br.random.dao.*;
import java.util.*;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;


public class ProfileView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView nick = (TextView)findViewById(R.id.tv_nick);
        TextView experience = (TextView)findViewById(R.id.tv_xperience);
        RatingBar evaluation = (RatingBar)findViewById(R.id.rb_evaluation);
        ImageView img = (ImageView)findViewById(R.id.iv_player);
        
        img.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			}
		});
        evaluation.setEnabled(false);
        Profile user = Singleton.getInstance(getApplicationContext()).getUser();
    	if (user.getUserId() != 0) {
        	nick.setText(user.getNickname());
        	experience.setText(""+user.getExperience());
        	evaluation.setRating(user.getEvaluation());
    	}
        
    	LinearLayout systems = (LinearLayout)findViewById(R.id.ll_systems);
    	SQLiteDatabase db = (new DatabaseHelper(getApplicationContext())).getWritableDatabase();
        List<String> userSystems = user.getSystems();
        for (int i=0; i<userSystems.size(); i++){
        	ImageView image = new ImageView(getApplicationContext());
        	final String system = userSystems.get(i);
        	if (system.equals("DnD")) image.setImageResource(R.drawable.dnd_logo);
        	else if (system.equals("Vampire")) image.setImageResource(R.drawable.vampire_logo);
        	else if (system.equals("Mage")) image.setImageResource(R.drawable.mage_logo);
        	int width = (int) (120 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
        	int height = (int) (70 * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
        	image.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Bundle bundle = new Bundle();
					bundle.putString("system",system);
					startActivity(new Intent(getApplicationContext(), SystemView.class).putExtras(bundle));
				}
			});
        	systems.addView(image,width,height);
        }
    	
    	Cursor cursor = db.rawQuery("SELECT c.idcampaign _id, c.campaign, c.system FROM tbprofile_campaign pc, tbcampaign c WHERE pc.iduser = ? AND pc.idcampaign = c.idcampaign", new String[]{ ""+Singleton.getInstance(getApplicationContext()).getUser().getUserId() });
        SimpleCursorAdapter adapter;
        adapter = new SimpleCursorAdapter(
        		this, 
        		R.layout.profile_campaign_item, 
            		cursor, 
        		new String[] {"_id", "campaign", "system"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name, R.id.btn_system});
        ListView campaigns = (ListView)findViewById(R.id.lv_campaign);
        
        campaigns.setAdapter(adapter);
        setListViewScrollable(campaigns);
        		
        campaigns.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = ((TextView)arg1.findViewById(R.id.tv_campaign_id)).getText().toString();
				Bundle bundle = new Bundle();
				bundle.putString("campaignId",id);
				startActivity(new Intent(getApplicationContext(), CampaignView.class).putExtras(bundle));
			}
		});

        List<ContactInfo> userContacts = user.getContacts();
        
        TableLayout contacts = (TableLayout)findViewById(R.id.tl_contact);
        TableRow tr = new TableRow(this);
        int trcount = 0;
    	for (int i=0; i<userContacts.size(); i++) {
        	ImageView contact = new ImageView(this);
        	Bitmap bmp;
        	switch (userContacts.get(i).getKey()) {
        		case facebook: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_fb); break;
        		case twitter: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tw); break;
        		case linkedin: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_in); break;
        		case skype: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sk); break;
        		default: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_none); break;
        	}
        	contact.setImageBitmap(Bitmap.createScaledBitmap(bmp, (int)(bmp.getWidth() * 0.5), (int)(bmp.getHeight() * 0.5), true));
        	contact.setPadding(2,2,2,2);
        	final String uri = userContacts.get(i).getValue();
        	final String contactType = userContacts.get(i).getKey().name();
        	contact.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (!uri.startsWith("http://") && !uri.startsWith("https://") && !uri.startsWith("www.")) {
						new AlertDialog.Builder(v.getContext())
						.setTitle("Contact Info")
						.setMessage(contactType + ": " + uri)
						.setNeutralButton( "OK", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								return ;
							}
						})
						.show();
					}
					else if (uri.startsWith("www.")) {
						startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("http://" + uri)));
					}
					else startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse(uri)));
				}
			});
        	tr.addView(contact);
        	trcount++;
        	if (trcount % 3 == 0) {
        		contacts.addView(tr);
        		tr = new TableRow(this);
        	}
        }
    	if (trcount % 3 != 0) contacts.addView(tr);
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