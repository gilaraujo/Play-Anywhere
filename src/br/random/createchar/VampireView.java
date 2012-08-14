package br.random.createchar;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
import android.widget.Toast;
import br.random.MainActivity;
import br.random.R;
import br.random.adapters.VampireAdapter;
import br.random.bean.Char;
import br.random.bean.VampireChar;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class VampireView extends
    SherlockFragmentActivity {
	private ViewPager pager;
	private VampireChar currentchar;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.vampire_view);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    pager=(ViewPager)findViewById(R.id.pager);
    if (Singleton.getInstance(getApplicationContext()).getChar() == null)
    	Singleton.getInstance(getApplicationContext()).setChar(new VampireChar());
    currentchar = (VampireChar)Singleton.getInstance(getApplicationContext()).getChar(); 
    
    
    
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    pager.setAdapter(buildAdapter());
  }

  private PagerAdapter buildAdapter() {
    return(new VampireAdapter(this, getSupportFragmentManager()));
  }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getSupportMenuInflater();
      inflater.inflate(R.menu.createchar_vampire, menu);
      return true;
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
          case android.R.id.home:
              startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
              return true;
          case R.id.menu_save:
        	  saveFragmentState((FragmentPagerAdapter) pager.getAdapter());
        	  if (currentchar.isValid()) {
        		  if (currentchar.save(getApplicationContext(), Singleton.getInstance(getApplicationContext()).getUser().getUserId()) != -1) {
        			  Singleton.getInstance(getApplicationContext()).setChar(null);
        			  currentchar = null;
        			  Toast.makeText(getApplicationContext(), "Personagem criado com sucesso!", Toast.LENGTH_LONG).show();
        			  startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        		  } else {
        			  Toast.makeText(getApplicationContext(), "Erro ao inserir valores no banco de dados!", Toast.LENGTH_SHORT).show();
        		  }
        	  }
        	  else {
        		  Toast.makeText(getApplicationContext(), "Ainda há pontos para serem distribuídos.\nPor favor, verifique!", Toast.LENGTH_LONG).show();
        	  }
     		  return true;
     	      default:
              return super.onOptionsItemSelected(item);
      }
  }
  private void saveFragmentState(FragmentPagerAdapter adapter) {
	  
	  FragmentManager fragManager = getSupportFragmentManager();
		int count = adapter.getCount();
		
		for (int i=0; i<count; i++) {
			Fragment fragment = fragManager.findFragmentByTag("android:switcher:"+R.id.pager+":"+i);
			if(fragment != null) {
				if(fragment.getView() != null) {
					fragment.onSaveInstanceState(new Bundle());
				}
			}
		}
	}
}