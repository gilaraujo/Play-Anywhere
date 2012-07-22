package br.random;

import java.util.*;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.*;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.View.*;
import android.widget.*;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

class ContactInfo {
	private Contacts key;
	private String value;
	public ContactInfo(int key, String value) {
		this.key = Contacts.values()[key];; this.value = value;
	}
	public Contacts getKey() { return this.key; }
	public String getValue() { return this.value; }
}

enum Contacts {
	facebook,
	twitter,
	linkedin,
	skype
}

public class ProfileView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT nickname, experience, evaluation FROM tbprofile WHERE iduser = ?", new String[]{ Singleton.getInstance().getUserId() });
        
        TextView nick = (TextView)findViewById(R.id.nick);
        TextView experience = (TextView)findViewById(R.id.xperience);
        RatingBar evaluation = (RatingBar)findViewById(R.id.evaluation);
        evaluation.setEnabled(false);
    	if (cursor.moveToNext()) {
        	nick.setText(cursor.getString(0));
        	experience.setText("" + cursor.getInt(1));
        	evaluation.setRating(cursor.getFloat(2));
    	}
        
    	LinearLayout systems = (LinearLayout)findViewById(R.id.systems);
    	cursor = db.rawQuery("SELECT DISTINCT c.system FROM tbprofile_campaign pc, tbcampaign c WHERE pc.iduser = ? AND pc.idcampaign = c.idcampaign", new String[]{ Singleton.getInstance().getUserId() });
        while (cursor.moveToNext()) {
        	ImageView image = new ImageView(getApplicationContext());
        	final String system = cursor.getString(0);
        	if (system.equals("DnD")) image.setImageResource(R.drawable.dnd_logo);
        	else if (system.equals("Vampire")) image.setImageResource(R.drawable.vampire_logo);
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
    	
    	cursor = db.rawQuery("SELECT c.idcampaign _id, c.campaign, c.system FROM tbprofile_campaign pc, tbcampaign c WHERE pc.iduser = ? AND pc.idcampaign = c.idcampaign", new String[]{ Singleton.getInstance().getUserId() });
        SimpleCursorAdapter adapter;
        adapter = new SimpleCursorAdapter(
        		this, 
        		R.layout.profile_campaign_item, 
            		cursor, 
        		new String[] {"_id", "campaign", "system"}, 
        		new int[] {R.id.campaign_id, R.id.campaign_name, R.id.btn_system});
        ListView campaigns = (ListView)findViewById(R.id.campaignList);
        
        campaigns.setAdapter(adapter);
        setListViewScrollable(campaigns);
        		
        campaigns.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = ((TextView)arg1.findViewById(R.id.campaign_id)).getText().toString();
				Bundle bundle = new Bundle();
				bundle.putString("campaignId",id);
				startActivity(new Intent(getApplicationContext(), CampaignView.class).putExtras(bundle));
			}
		});

        ArrayList<ContactInfo> contatos = new ArrayList<ContactInfo>();
        cursor = db.rawQuery("SELECT type, contact FROM tbcontact where iduser = ?", new String[]{ Singleton.getInstance().getUserId() });
        while (cursor.moveToNext()) {
        	contatos.add(new ContactInfo(cursor.getInt(0),cursor.getString(1)));
        }
        TableLayout contacts = (TableLayout)findViewById(R.id.contactTable);
        TableRow tr = new TableRow(this);
        int trcount = 0;
    	for (int i=0; i<contatos.size(); i++) {
        	ImageView contact = new ImageView(this);
        	Bitmap bmp;
        	switch (contatos.get(i).getKey()) {
        		case facebook: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_fb); break;
        		case twitter: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tw); break;
        		case linkedin: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_in); break;
        		case skype: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sk); break;
        		default: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_none); break;
        	}
        	contact.setImageBitmap(Bitmap.createScaledBitmap(bmp, (int)(bmp.getWidth() * 0.5), (int)(bmp.getHeight() * 0.5), true));
        	contact.setPadding(2,2,2,2);
        	final String uri = contatos.get(i).getValue();
        	final String contactType = contatos.get(i).getKey().name();
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