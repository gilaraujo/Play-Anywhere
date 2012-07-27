package br.random;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import br.random.bean.Profile;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class LoginActivity extends SherlockActivity {
    EditText username,password;
	TextView message;
    Button ok, register;
    ImageView fbLogin;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username=(EditText)findViewById(R.id.et_username);
        password=(EditText)findViewById(R.id.et_password);
        ok=(Button)findViewById(R.id.btn_login);
        register=(Button)findViewById(R.id.btn_register);
        fbLogin=(ImageView)findViewById(R.id.iv_facebook);
        fbLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), FbLogin.class));
			}
		});

        ok.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
                    
            	ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            	postParameters.add(new BasicNameValuePair("username", username.getText().toString()));
            	postParameters.add(new BasicNameValuePair("password", password.getText().toString()));

            	String response = null;
            	try {
            	    //response = CustomHttpClient.executeHttpPost("<target page url>", postParameters);
            	    //response = "1";
            	    //String res=response.toString();
            	    //res= res.replaceAll("\\s+","");
            		//if(res.equals("1")) {
            	    //	Singleton.getInstance(getApplication()).setUserId(Integer.parseInt(res));
            	    //	startActivity(new Intent(getApplicationContext(), MainActivity.class));
            	    //}
            	    //else
            	    //	message.setText("Sorry!! Incorrect Username or Password");
            		Profile profile = Profile.getByNickAndPass(getApplicationContext(), username.getText().toString(), password.getText().toString());
            		if (profile != null) {
            			Singleton.getInstance(getApplication()).setUser(profile);
            			startActivity(new Intent(getApplicationContext(), MainActivity.class));
            		} else {
            			Toast.makeText(getApplicationContext(), "Nickname ou senha inválidos", Toast.LENGTH_LONG).show();
            		}
            	} catch (Exception e) {
            		username.setText(e.toString());
            	}

            }
        });
        register.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), RegisterView.class));
			}
		});
    }
}
