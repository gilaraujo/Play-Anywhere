package br.random;

import java.util.*;

import br.random.bean.Profile;
import br.random.util.ContactInfo;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.*;
import android.content.res.Configuration;
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
        
        final TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
        final TableLayout systems = (TableLayout)findViewById(R.id.tl_systems);
        
        int size;
        try {
        	size = savedInstanceState.getInt("contactSize");
        } catch (Exception e) {
        	size = 0;
        }
        for (int i=0; i<size; i++) {
        	addContact(contacts, savedInstanceState.getInt("ctype"+i), savedInstanceState.getString("ctext"+i));
        }
        try {
        	size = savedInstanceState.getInt("systemSize");
        } catch (Exception e) {
        	size = 0;
        }
        for (int i=0; i<size; i++) {
        	addSystem(systems, savedInstanceState.getInt("stype"+i));
        }
        Button cancel = (Button)findViewById(R.id.btn_cancel);
        Button ok = (Button)findViewById(R.id.btn_ok);
        Button addcontact = (Button)findViewById(R.id.btn_addcontact);
        Button addsystem = (Button)findViewById(R.id.btn_addsystem);
        addcontact.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				addContact(contacts, 0, "");
			}
		});
        addsystem.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				addSystem(systems, 0);
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
		            if (type.getSelectedItemPosition() > 0)
		            	contactsData.add(new ContactInfo(type.getSelectedItemPosition(),contact.getText().toString()));
		        }
		        profile.setContacts(contactsData);
		        
		        List<String> systemsData = new ArrayList<String>();
		        for(int i = 0; i < systems.getChildCount(); i++){
		        	TableRow row = (TableRow)systems.getChildAt(i);
		            Spinner system = (Spinner)row.findViewById(R.id.sp_type);
		            if (system.getSelectedItemPosition() > 0)
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
			    	.setMessage( "Erro criando usuário" )
			    	.setNeutralButton( "OK", new DialogInterface.OnClickListener() {
			    		public void onClick(DialogInterface dialog, int which) {
			    		}
			    	})
			    	.show();
		        }
			}
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle icicle) {
    	List<String> list = new ArrayList<String>();
    	TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
    	for (int i=0; i<contacts.getChildCount(); i++) {
    		TableRow row = (TableRow)contacts.getChildAt(i);
    		String type = ""+((Spinner)row.findViewById(R.id.sp_type)).getSelectedItemPosition();
    		String text = ((EditText)row.findViewById(R.id.et_contact)).getText().toString();
    		list.add(type);
    		list.add(text);
    	}
    	icicle.putInt("contactSize", list.size() / 2);
    	for (int i=0; i<list.size() / 2; i++) {
    		icicle.putInt("ctype"+i, Integer.parseInt(list.get(2*i)));
    		icicle.putString("ctext"+i, list.get(2*i+1));
    	}
    	list = new ArrayList<String>();
    	TableLayout systems = (TableLayout)findViewById(R.id.tl_systems);
    	for (int i=0; i<systems.getChildCount(); i++) {
    		TableRow row = (TableRow)systems.getChildAt(i);
    		String type = ""+((Spinner)row.findViewById(R.id.sp_type)).getSelectedItemPosition();
    		list.add(type);
    	}
    	icicle.putInt("systemSize", list.size());
    	for (int i=0; i<list.size(); i++) {
    		icicle.putInt("stype"+i, Integer.parseInt(list.get(i)));
    	}
    }
    private void addContact(final TableLayout contacts, int ctype, String ctext) {
    	final TableRow row = new TableRow(getApplicationContext());
    	row.setId(R.id.tableRow1);
    	Spinner type = new Spinner(getApplicationContext());
		
    	String[] contact_types = getResources().getStringArray(R.array.contacts);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
        		getApplicationContext(),
        		android.R.layout.simple_spinner_item,
        		contact_types);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		type.setAdapter(dataAdapter);
		type.setId(R.id.sp_type);
		type.setSelection(ctype);
		row.addView(type);
		EditText contact = new EditText(getApplicationContext());
		contact.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
		contact.setId(R.id.et_contact);
		contact.setText(ctext);
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
    private void addSystem(final TableLayout systems, int stype) {
    	final TableRow row = new TableRow(getApplicationContext());
		Spinner type = new Spinner(getApplicationContext());
		
		String[] system_types = getResources().getStringArray(R.array.systems);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
        		getApplicationContext(),
        		android.R.layout.simple_spinner_item,
        		system_types);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		type.setAdapter(dataAdapter);
		
		type.setId(R.id.sp_type);
		type.setSelection(stype);
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
}