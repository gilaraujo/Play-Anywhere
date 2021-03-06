package br.random.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import br.random.createchar.VampireAbilities;
import br.random.createchar.VampireAdvantages;
import br.random.createchar.VampireAttributes;
import br.random.createchar.VampireBasic;
import br.random.createchar.VampireOther;

public class VampireAdapter extends FragmentPagerAdapter {
Context ctxt=null;

public VampireAdapter(Context ctxt, FragmentManager mgr) {
  super(mgr);
  this.ctxt=ctxt;
}

@Override
public int getCount() {
  return(5);
}

@Override
public Fragment getItem(int position) {
	switch (position) {
		case 0: return VampireBasic.newInstance();
		case 1: return VampireAttributes.newInstance();
		case 2: return VampireAbilities.newInstance();
		case 3: return VampireAdvantages.newInstance();
		case 4: return VampireOther.newInstance();
		default: return VampireBasic.newInstance();
	}
}

@Override
public String getPageTitle(int position) {
	switch (position) {
		case 0: return VampireBasic.getTitle();
		case 1: return VampireAttributes.getTitle();
		case 2: return VampireAbilities.getTitle();
		case 3: return VampireAdvantages.getTitle();
		case 4: return VampireOther.getTitle();
		default: return "Error";
	}
}
}