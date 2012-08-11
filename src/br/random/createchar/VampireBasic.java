package br.random.createchar;

import br.random.*;
import br.random.adapters.*;
import br.random.bean.VampireChar;
import br.random.util.Singleton;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class VampireBasic extends SherlockFragment {
	
	private VampireChar currentchar;
	
	private EditText et_name;
	private EditText et_nature;
	private EditText et_demeanor;
	private Spinner sp_clan;
	private EditText et_generation;
	private EditText et_haven;
	private EditText et_concept;
	
	public static VampireBasic newInstance() {
		VampireBasic frag=new VampireBasic();
		return(frag);
	}
	public static String getTitle() {
		return "Básico";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result=inflater.inflate(R.layout.vampire_basic, container, false);
		
		currentchar = (VampireChar)Singleton.getInstance(getActivity().getApplicationContext()).getChar();
		
		et_name = (EditText)result.findViewById(R.id.et_name);
		et_nature = (EditText)result.findViewById(R.id.et_nature);
		et_demeanor = (EditText)result.findViewById(R.id.et_demeanor);
		sp_clan = (Spinner)result.findViewById(R.id.sp_clan);
		et_generation = (EditText)result.findViewById(R.id.et_generation);
		et_haven = (EditText)result.findViewById(R.id.et_haven);
		et_concept = (EditText)result.findViewById(R.id.et_concept);
		
		sp_clan.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO: tentar fazer.... ao trocar de clã, setar disciplinas
				//Toast.makeText(getActivity().getApplicationContext(), ""+arg2, Toast.LENGTH_SHORT).show();
			}
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
	    return(result);
	}
}