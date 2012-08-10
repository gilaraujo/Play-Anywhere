package br.random.createchar;

import br.random.*;
import br.random.adapters.*;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class VampireView extends
    SherlockFragmentActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.vampire_view);

    ViewPager pager=(ViewPager)findViewById(R.id.pager);

    pager.setAdapter(buildAdapter());
  }

  private PagerAdapter buildAdapter() {
    return(new VampireAdapter(this, getSupportFragmentManager()));
  }
}