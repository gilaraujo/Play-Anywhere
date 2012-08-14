package br.random.createchar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;
import br.random.R;
import br.random.bean.VampireChar;
import br.random.util.Clans;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireBasic extends SherlockFragment {
	
	private VampireChar currentchar;
	private View old;
	
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
		if (container == null) return null;
		View result;
		if (old != null) {
			((FrameLayout)old.getParent()).removeView(old);
			result = old;
		} else {
			result=inflater.inflate(R.layout.vampire_basic, container, false);
			old = result;
		}
		Singleton singleton = Singleton.getInstance(getActivity().getApplicationContext());
		currentchar = (VampireChar)singleton.getChar();
		
		findViews(result);
		setEvents();
		initializeFields(savedInstanceState);
		
	    return(result);
	}
	private void findViews(View result) {
		et_name = (EditText)result.findViewById(R.id.et_name);
		et_nature = (EditText)result.findViewById(R.id.et_nature);
		et_demeanor = (EditText)result.findViewById(R.id.et_demeanor);
		sp_clan = (Spinner)result.findViewById(R.id.sp_clan);
		et_generation = (EditText)result.findViewById(R.id.et_generation);
		et_haven = (EditText)result.findViewById(R.id.et_haven);
		et_concept = (EditText)result.findViewById(R.id.et_concept);
	}
	private void setEvents() {
		sp_clan.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				String discipline1 = "";
				String discipline2 = "";
				String discipline3 = "";
				switch (Clans.values()[arg2]) {
					case nenhum: 	break;
					case Brujah: 	discipline1 = "Rapidez";
								 	discipline2 = "Potência";
								 	discipline3 = "Presença";
								 	break;
					case Gangrel:	discipline1 = "Animalismo";
									discipline2 = "Fortitude";
									discipline3 = "Potência";
									break;
					case Malkavian:	discipline1 = "Auspício";
									discipline2 = "Dominação";
									discipline3 = "Ofuscação";
									break;
					case Nosferatu:	discipline1 = "Animalismo";
									discipline2 = "Ofuscação";
									discipline3 = "Potência";
									//int appearance = currentchar.getAppearance();
									//currentchar.setSocialLeft(currentchar.getSocialLeft()+appearance-1);
									//currentchar.setAppearance(0);
									break;
					case Toreador:	discipline1 = "Auspício";
									discipline2 = "Rapidez";
									discipline3 = "Potência";
									break;
					case Tremere:	discipline1 = "Auspício";
									discipline2 = "Dominação";
									discipline3 = "Taumaturgia";
									break;
					case Ventrue:	discipline1 = "Dominação";
									discipline2 = "Fortitude";
									discipline3 = "Presença";
									break;
					default:		break;
				}
				currentchar.setDiscipline1(discipline1);
				currentchar.setDiscipline2(discipline2);
				currentchar.setDiscipline3(discipline3);
			}
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	private void initializeFields(Bundle savedInstanceState) {
		et_name.setText(currentchar.getName());
		et_nature.setText(currentchar.getNature());
		et_demeanor.setText(currentchar.getDemeanor());
		if (!currentchar.getClan().equals("") && !currentchar.getClan().equals("Selecione")) sp_clan.setSelection(Clans.valueOf(currentchar.getClan()).ordinal());
		else sp_clan.setSelection(0);
		et_generation.setText(""+currentchar.getGeneration());
		et_haven.setText(currentchar.getHaven());
		et_concept.setText(currentchar.getConcept());
	}
	@Override
	public void onPause() {
		super.onPause();
		onSaveInstanceState(new Bundle());
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
		try {
			currentchar.setName(et_name.getText().toString());
			currentchar.setNature(et_nature.getText().toString());
			currentchar.setDemeanor(et_demeanor.getText().toString());
			currentchar.setClan(sp_clan.getSelectedItem().toString());
			currentchar.setGeneration(Integer.parseInt(et_generation.getText().toString()));
			currentchar.setHaven(et_haven.getText().toString());
			currentchar.setConcept(et_concept.getText().toString());
		} catch (Exception e) {
			
		}
	}
}