package br.random;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends SherlockActivity {
    EditText un,pw;
	TextView error;
    Button ok;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);
        un=(EditText)findViewById(R.id.et_un);
        pw=(EditText)findViewById(R.id.et_pw);
        ok=(Button)findViewById(R.id.btn_login);
        error=(TextView)findViewById(R.id.tv_error);

        ok.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
                    
            	ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            	postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
            	postParameters.add(new BasicNameValuePair("password", pw.getText().toString()));

            	String response = null;
            	try {
            	    //response = CustomHttpClient.executeHttpPost("<target page url>", postParameters);
            	    response = "1";
            	    String res=response.toString();
            	    res= res.replaceAll("\\s+","");
            	    if(res.equals("1")) {
            	    	Singleton.getInstance().setUserId(res);
            	    	startActivity(new Intent(getApplicationContext(), MainActivity.class));
            	    }
            	    else
            	    	error.setText("Sorry!! Incorrect Username or Password");
            	} catch (Exception e) {
            		un.setText(e.toString());
            	}

            }
        });
    }
}
