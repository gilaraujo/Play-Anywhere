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
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

class ContactInfo {
	private Contacts key;
	private String value;
	public ContactInfo(Contacts key, String value) {
		this.key = key; this.value = value;
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
        TextView nick = (TextView)findViewById(R.id.nick);
        nick.setText("nick name");
        TextView experience = (TextView)findViewById(R.id.experience);
        experience.setText("1000");
        RatingBar evaluation = (RatingBar)findViewById(R.id.evaluation);
        evaluation.setEnabled(false);
        evaluation.setRating(3.5f);
        
        ArrayList<ContactInfo> contatos = new ArrayList<ContactInfo>();
        contatos.add(new ContactInfo(Contacts.facebook,"http://www.facebook.com/gilson.araujo"));
        contatos.add(new ContactInfo(Contacts.twitter,"www.twitter.com/bladaum"));
        contatos.add(new ContactInfo(Contacts.linkedin,"http://www.linkedin.com/gilson.araujo"));
        contatos.add(new ContactInfo(Contacts.skype,"bladaum"));
        
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT idcampaign _id, campaign FROM tbcampaign", new String[]{ });
        
        SimpleCursorAdapter adapter;
        adapter = new SimpleCursorAdapter(
        		this, 
        		R.layout.campaign_list_item_simple, 
        		cursor, 
        		new String[] {"_id", "campaign"}, 
        		new int[] {R.id.campaign_id, R.id.campaign_name});
        ListView campaigns = (ListView)findViewById(R.id.campaignList);
        campaigns.setAdapter(adapter);
        campaigns.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = ((TextView)arg1.findViewById(R.id.campaign_id)).getText().toString();
				startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("http://www.nossosite.com/campaign/" + id + ".html")));
			}
		});

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
    }
}