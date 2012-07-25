package br.random;

import org.json.JSONObject;

import br.random.*;
import br.random.bean.Profile;
import br.random.util.Singleton;
import br.random.util.facebookintegration.*;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

//*************************************************************
//*************************************************************
// Login
//*************************************************************
//*************************************************************
public class FbLogin extends Activity {
	
	public static final String mAPP_ID = "391720480888525";
	public Facebook mFacebook = new Facebook(mAPP_ID);
	
	//**********************************************
	// onCreate
	//**********************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fblogin_busy_view);
        if( !mFacebook.isSessionValid() ) {
			Toast.makeText(FbLogin.this, "Authorizing", Toast.LENGTH_SHORT).show();
			mFacebook.authorize(FbLogin.this, new String[] { "" }, new LoginDialogListener());
			}
		else {
			Toast.makeText( FbLogin.this, "Has valid session", Toast.LENGTH_SHORT).show();
			try {
				new GetFacebookData().execute("");
				}
			catch( Exception error ) {
					error.printStackTrace();
				}
			}
        SessionStore.restore(mFacebook, this);
    	}
    
    
    //***********************************************************
	// onActivityResult
	//***********************************************************
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFacebook.authorizeCallback(requestCode, resultCode, data);
    	}
    
    
    //----------------------------------------------
    // loginButtonListener
    //----------------------------------------------
    	private class GetFacebookData extends AsyncTask<String, Void, Profile> {

            @Override
            protected Profile doInBackground(String... params) {
            	Profile ret = new Profile();
				try {
					Bundle b = new Bundle();
					b.putString("fields", "third_party_id,name,birthday,location,id");
					JSONObject json = Util.parseJson(mFacebook.request("me",b));
	    			ret.setNickname(json.getString("name"));
	    			ret.setName(json.getString("name"));
	    			try {
	    				ret.setBirthdate(json.getString("birthday"));
	    			} catch (Exception ex) {
	    				ret.setBirthdate("");
	    			}
	    			ret.setCity(json.getJSONObject("location").getString("name"));
	    			ret.setFbid(json.getInt("id"));
	    			ret.setPassword(json.getString("third_party_id"));
	    			ret.setEvaluation(0f);
	    			ret.setExperience(0);
	    			return ret;
				} catch (Exception e) {
					e.printStackTrace();
					ret.setUserId(0);
					return ret;
				}
		    }
            @Override
            protected void onPostExecute(Profile result) {
            	if (result.getFbid() == 0) {
            		Toast.makeText( FbLogin.this, "N�o foi poss�vel registrar com o facebook", Toast.LENGTH_SHORT).show();
            	} else {
            		Profile alreadyExists = Profile.getByFbid(getApplicationContext(),result.getFbid());
            		if (alreadyExists == null) {
            			result.save(getApplicationContext());
            		} else {
            			result = alreadyExists;
            		}
            		Singleton.getInstance(getApplicationContext()).setUser(result);
            		startActivity(new Intent(getApplicationContext(), MainActivity.class));
            	}
            }
      }
	//***********************************************************************
	//***********************************************************************
	// LoginDialogListener
	//***********************************************************************
	//***********************************************************************
	public final class LoginDialogListener implements DialogListener {
		public void onComplete(Bundle values) {
			try {
				//The user has logged in, so now you can query and use their Facebook info
	    		new GetFacebookData().execute("");
				SessionStore.save(mFacebook, FbLogin.this);
				}
			catch( Exception error ) {
				Toast.makeText( FbLogin.this, error.toString(), Toast.LENGTH_SHORT).show();
				}
			}
		
		public void onFacebookError(FacebookError error) {
			Toast.makeText( FbLogin.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
		    }
		
		public void onError(DialogError error) {
			Toast.makeText( FbLogin.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
			}
		 
        public void onCancel() {
        	Toast.makeText( FbLogin.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
			}
		}
	
	}