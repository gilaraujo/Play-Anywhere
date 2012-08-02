package br.random;


import br.random.util.*;
import br.random.bean.Campaign;
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
	private TextView tv_nick;
	private TextView tv_experience;
	private RatingBar rb_evaluation;
	private ImageView iv_picture;
	private ListView lv_campaigns;
	private TableLayout tl_contacts;
	private LinearLayout ll_systems;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        tv_nick = (TextView)findViewById(R.id.tv_nick);
        tv_experience = (TextView)findViewById(R.id.tv_xperience);
        rb_evaluation = (RatingBar)findViewById(R.id.rb_evaluation);
        iv_picture = (ImageView)findViewById(R.id.iv_picture);
        lv_campaigns = (ListView)findViewById(R.id.lv_campaign);
        tl_contacts = (TableLayout)findViewById(R.id.tl_contact);
        
        iv_picture.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}
		});
        rb_evaluation.setEnabled(false);
        Profile user = Singleton.getInstance(getApplicationContext()).getUser();
    	if (user.getUserId() != 0) {
        	tv_nick.setText(user.getNickname());
        	tv_experience.setText(""+user.getExperience());
        	rb_evaluation.setRating(user.getEvaluation());
        	if (user.getPicture() != null) iv_picture.setImageBitmap(Convert.ByteArrayToBitmap(user.getPicture()));
    	}
        
    	ll_systems = (LinearLayout)findViewById(R.id.ll_systems);
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
        	ll_systems.addView(image,width,height);
        }
    	
    	ArrayList<Map<String,String>> campaignList = new ArrayList<Map<String,String>>();
        List<Campaign> userCampaigns = user.getCampaigns();
        for (int i=0; i<userCampaigns.size(); i++) {
        	Map<String,String> element = new HashMap<String,String>();
        	element.put("_id", ""+userCampaigns.get(i).getCampaignId());
        	element.put("name",userCampaigns.get(i).getName());
        	element.put("master",userCampaigns.get(i).getMasterName());
        	element.put("system", userCampaigns.get(i).getSystem());
        	campaignList.add(element);
        }
    	SimpleAdapter adapter;
        adapter = new SimpleAdapter(
        		this,
        		campaignList,
        		R.layout.campaign_list_item, 
            	new String[] {"_id", "name", "master", "system"}, 
        		new int[] {R.id.tv_campaign_id, R.id.tv_campaign_name, R.id.tv_master_name, R.id.btn_system});
        
        lv_campaigns.setAdapter(adapter);
        setListViewScrollable(lv_campaigns);
        		
        lv_campaigns.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = ((TextView)arg1.findViewById(R.id.tv_campaign_id)).getText().toString();
				Bundle bundle = new Bundle();
				bundle.putString("campaignId",id);
				startActivity(new Intent(getApplicationContext(), CampaignView.class).putExtras(bundle));
			}
		});

        List<ContactInfo> userContacts = user.getContacts();
        
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
        		tl_contacts.addView(tr);
        		tr = new TableRow(this);
        	}
        }
    	if (trcount % 3 != 0) tl_contacts.addView(tr);
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