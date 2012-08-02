package br.random;

import br.random.adapters.*;
import br.random.util.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.*;

import br.random.bean.Profile;
import br.random.util.ContactInfo;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.*;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class RegisterView extends SherlockActivity {
	
	private Uri mImageCaptureUri;
	private ImageView mImageView;
	private boolean hasProfileImage = false;
	
	private static final int PICK_FROM_CAMERA = 1;
	private static final int CROP_FROM_CAMERA = 2;
	private static final int PICK_FROM_FILE = 3;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        final TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
        final TableLayout systems = (TableLayout)findViewById(R.id.tl_systems);
        
        try {
        	hasProfileImage = savedInstanceState.getBoolean("hasProfileImage");
        } catch (Exception e) {
        }
        
        if (hasProfileImage) {
        	try {
	        	byte[] image = savedInstanceState.getByteArray("profile");
	        	ImageView iv_profile = (ImageView)findViewById(R.id.iv_profile);
	        	iv_profile.setImageBitmap(Convert.ByteArrayToBitmap(image));
	        } catch (Exception e) {
	        }
        }
        
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
		        ImageView picture = (ImageView)findViewById(R.id.iv_profile);

		        Profile profile = new Profile();
		        profile.setName(name.getText().toString());
		        profile.setBirthdate(birthdate.getText().toString());
		        profile.setCity(city.getText().toString());
		        profile.setNickname(nick.getText().toString());
		        profile.setPassword(pass.getText().toString());
		        profile.setPicture(Convert.ImageViewToByteArray(picture));
		        
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
        final String [] items			= new String [] {"Take from camera", "Select from gallery"};				
		ArrayAdapter<String> adapter	= new ArrayAdapter<String> (this, android.R.layout.select_dialog_item,items);
		AlertDialog.Builder builder		= new AlertDialog.Builder(this);
		
		builder.setTitle("Select Image");
		builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
			public void onClick( DialogInterface dialog, int item ) { //pick from camera
				if (item == 0) {
					Intent intent 	 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					
					mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
									   "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));

					intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

					try {
						intent.putExtra("return-data", true);
						
						startActivityForResult(intent, PICK_FROM_CAMERA);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
				} else { //pick from file
					Intent intent = new Intent();
					
	                intent.setType("image/*");
	                intent.setAction(Intent.ACTION_GET_CONTENT);
	                
	                startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
				}
			}
		} );
		
		final AlertDialog dialog = builder.create();
		
		Button button 	= (Button) findViewById(R.id.btn_choosepic);
		mImageView		= (ImageView) findViewById(R.id.iv_profile);
		
		button.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				dialog.show();
			}
		});
    }
    @Override
    protected void onSaveInstanceState(Bundle icicle) {
    	List<String> list = new ArrayList<String>();
    	TableLayout contacts = (TableLayout)findViewById(R.id.tl_contacts);
    	ImageView profile = (ImageView)findViewById(R.id.iv_profile);
    	
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
    	icicle.putBoolean("hasProfileImage", hasProfileImage);
    	if (hasProfileImage) icicle.putByteArray("profile", Convert.ImageViewToByteArray(profile));
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
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode != RESULT_OK) return;
	   
	    switch (requestCode) {
		    case PICK_FROM_CAMERA:
		    	doCrop();
		    	
		    	break;
		    	
		    case PICK_FROM_FILE: 
		    	mImageCaptureUri = data.getData();
		    	
		    	doCrop();
	    
		    	break;	    	
	    
		    case CROP_FROM_CAMERA:	    	
		        Bundle extras = data.getExtras();
	
		        if (extras != null) {	        	
		            Bitmap photo = extras.getParcelable("data");
		            
		            mImageView.setImageBitmap(photo);
		            hasProfileImage = true;
		        }
	
		        File f = new File(mImageCaptureUri.getPath());            
		        
		        if (f.exists()) f.delete();
	
		        break;

	    }
	}
    
    private void doCrop() {
		final ArrayList<CropOption> cropOptions = new ArrayList<CropOption>();
    	
    	Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");
        
        List<ResolveInfo> list = getPackageManager().queryIntentActivities( intent, 0 );
        
        int size = list.size();
        
        if (size == 0) {	        
        	Toast.makeText(this, "Aplicativo para corte de imagem não encontrado", Toast.LENGTH_SHORT).show();
        	
            return;
        } else {
        	intent.setData(mImageCaptureUri);
            
            intent.putExtra("outputX", 200);
            intent.putExtra("outputY", 200);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", true);
            
        	if (size == 1) {
        		Intent i 		= new Intent(intent);
	        	ResolveInfo res	= list.get(0);
	        	
	        	i.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
	        	
	        	startActivityForResult(i, CROP_FROM_CAMERA);
        	} else {
		        for (ResolveInfo res : list) {
		        	final CropOption co = new CropOption();
		        	
		        	co.title 	= getPackageManager().getApplicationLabel(res.activityInfo.applicationInfo);
		        	co.icon		= getPackageManager().getApplicationIcon(res.activityInfo.applicationInfo);
		        	co.appIntent= new Intent(intent);
		        	
		        	co.appIntent.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
		        	
		            cropOptions.add(co);
		        }
	        
		        CropOptionAdapter adapter = new CropOptionAdapter(getApplicationContext(), cropOptions);
		        
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setTitle("Choose Crop App");
		        builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
		            public void onClick( DialogInterface dialog, int item ) {
		                startActivityForResult( cropOptions.get(item).appIntent, CROP_FROM_CAMERA);
		            }
		        });
	        
		        builder.setOnCancelListener( new DialogInterface.OnCancelListener() {
		            public void onCancel( DialogInterface dialog ) {
		               
		                if (mImageCaptureUri != null ) {
		                    getContentResolver().delete(mImageCaptureUri, null, null );
		                    mImageCaptureUri = null;
		                }
		            }
		        } );
		        
		        AlertDialog alert = builder.create();
		        
		        alert.show();
        	}
        }
	}
}