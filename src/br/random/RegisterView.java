package br.random;

import java.util.*;

import br.random.bean.Profile;
import br.random.util.ContactInfo;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.*;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.text.InputType;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.TableLayout.LayoutParams;

public class RegisterView extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        Button cancel = (Button)findViewById(R.id.btn_cancel);
        Button ok = (Button)findViewById(R.id.btn_ok);
        Button addcontact = (Button)findViewById(R.id.btn_addcontact);
        Button addsystem = (Button)findViewById(R.id.btn_addsystem);
        addcontact.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
				final TableRow row = new TableRow(getApplicationContext());
				
				Spinner type = new Spinner(getApplicationContext());
				List<String> list = new ArrayList<String>();
				list.add("Facebook");
				list.add("Twitter");
				list.add("LinkedIn");
				list.add("Skype");
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
				dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				type.setAdapter(dataAdapter);
				type.setId(R.id.sp_type);
				row.addView(type);
				
				EditText contact = new EditText(getApplicationContext());
				contact.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
				contact.setId(R.id.et_contact);
				row.addView(contact);
				
				Button remove = new Button(getApplicationContext());
				remove.setText("Remover");
				remove.setTextSize(10);
				remove.setPadding(0, 0, 0, 0);
				remove.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						contacts.removeView(row);
					}
				});
				row.addView(remove);
				
				contacts.addView(row);
			}
		});
        addsystem.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final TableLayout systems = (TableLayout)findViewById(R.id.tl_systems);
				final TableRow row = new TableRow(getApplicationContext());
				
				Spinner type = new Spinner(getApplicationContext());
				List<String> list = new ArrayList<String>();
				list.add("DnD");
				list.add("Vampire");
				list.add("Mage");
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
				dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				type.setAdapter(dataAdapter);
				type.setId(R.id.sp_type);
				row.addView(type);
				
				Button remove = new Button(getApplicationContext());
				remove.setText("Remover");
				remove.setTextSize(10);
				remove.setPadding(0, 0, 0, 0);
				remove.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						systems.removeView(row);
					}
				});
				row.addView(remove);
				
				systems.addView(row);
			}
		});
        
        cancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
        ok.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
		        EditText name = (EditText)findViewById(R.id.et_name);
		        EditText birthdate = (EditText)findViewById(R.id.et_birthdate);
		        EditText city = (EditText)findViewById(R.id.et_city);
		        EditText nick = (EditText)findViewById(R.id.et_nick);
		        EditText pass = (EditText)findViewById(R.id.et_pass);
		        TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
		        TableLayout systems = (TableLayout)findViewById(R.id.tl_systems);

		        Profile profile = new Profile();
		        profile.setName(name.getText().toString());
		        profile.setBirthdate(birthdate.getText().toString());
		        profile.setCity(city.getText().toString());
		        profile.setNickname(nick.getText().toString());
		        profile.setPassword(pass.getText().toString());
		        
		        List<ContactInfo> contactsData = new ArrayList<ContactInfo>();
		        for(int i = 0; i < contacts.getChildCount(); i++){
		        	TableRow row = (TableRow)contacts.getChildAt(i);
		            Spinner type = (Spinner)row.findViewById(R.id.sp_type);
		            EditText contact = (EditText)row.findViewById(R.id.et_contact);
		            contactsData.add(new ContactInfo(type.getSelectedItemPosition(),contact.getText().toString()));
		        }
		        profile.setContacts(contactsData);
		        
		        List<String> systemsData = new ArrayList<String>();
		        for(int i = 0; i < systems.getChildCount(); i++){
		        	TableRow row = (TableRow)systems.getChildAt(i);
		            Spinner system = (Spinner)row.findViewById(R.id.sp_type);
		            systemsData.add(system.getSelectedItem().toString());
		        }
		        profile.setSystems(systemsData);
		        
				profile.setUserId(profile.save(getApplicationContext()));
		        if (profile.getUserId() != 0) {
		        	Singleton.getInstance(getApplicationContext()).setUser(profile);
		        	startActivity(new Intent(getApplicationContext(), MainActivity.class));
		        } else {
		        	new AlertDialog.Builder( getApplicationContext() )
			    	.setTitle( "Error" )
			    	.setMessage( "Erro criando usu�rio" )
			    	.setNeutralButton( "OK", new DialogInterface.OnClickListener() {
			    		public void onClick(DialogInterface dialog, int which) {
			    		}
			    	})
			    	.show();
		        }
			}
        });
    }
}