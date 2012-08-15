package br.random.createchar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import br.random.R;
import br.random.bean.VampireChar;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireOther extends SherlockFragment {
	
	private VampireChar currentchar;
	private View old;
	
	private int MIN_TRAIT01 = 0;
	private int MAX_TRAIT01 = 5;
	private int MIN_TRAIT02 = 0;
	private int MAX_TRAIT02 = 5;
	private int MIN_TRAIT03 = 0;
	private int MAX_TRAIT03 = 5;
	private int MIN_TRAIT04 = 0;
	private int MAX_TRAIT04 = 5;
	private int MIN_TRAIT05 = 0;
	private int MAX_TRAIT05 = 5;
	private int MIN_HUMANITY = 0;
	private int MAX_HUMANITY = 10;
	private int MIN_WILLPOWER = 0;
	private int MAX_WILLPOWER = 10;
	private int MIN_BLOODPOOL = 0;
	private int MAX_BLOODPOOL = 10;
	private int TRAIT_LEFT = 20;

	private SeekBar sb_trait01;
	private SeekBar sb_trait02;
	private SeekBar sb_trait03;
	private SeekBar sb_trait04;
	private SeekBar sb_trait05;
	private SeekBar sb_humanity;
	private SeekBar sb_willpower;
	private SeekBar sb_willpowercur;
	private SeekBar sb_bloodpool;
	private TextView tv_trait01;
	private TextView tv_trait02;
	private TextView tv_trait03;
	private TextView tv_trait04;
	private TextView tv_trait05;
	private EditText et_trait01;
	private EditText et_trait02;
	private EditText et_trait03;
	private EditText et_trait04;
	private EditText et_trait05;
	private EditText et_weapon01;
	private EditText et_weapon01diff;
	private EditText et_weapon01dam;
	private EditText et_weapon02;
	private EditText et_weapon02diff;
	private EditText et_weapon02dam;
	private EditText et_weapon03;
	private EditText et_weapon03diff;
	private EditText et_weapon03dam;
	private TextView tv_humanity;
	private TextView tv_willpower;
	private TextView tv_willpowercur;
	private TextView tv_bloodpool;
	private TextView tv_traitleft;
	
	public static VampireOther newInstance() {
		VampireOther frag=new VampireOther();
		frag.old = null;
		return(frag);
	}
	public static String getTitle() {
		return "Outros";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) return null;
		View result;
		if (old != null) {
			((FrameLayout)old.getParent()).removeView(old);
			result = old;
		} else {
			result=inflater.inflate(R.layout.vampire_other, container, false);
			old = result;
		}
		Singleton singleton = Singleton.getInstance(getActivity().getApplicationContext());
		currentchar = (VampireChar)singleton.getChar();
		TRAIT_LEFT = 20;
		
		Bundle b = getActivity().getIntent().getExtras();
		
		findViews(result);
		if (b.getBoolean("editable")) {
			setEvents();
		} else {
			setFreeze();
		}
		initializeFields(savedInstanceState);
		
		return(result);
	}
	private void setFreeze() {
		sb_trait01.setEnabled(false);
		sb_trait02.setEnabled(false);
		sb_trait03.setEnabled(false);
		sb_trait04.setEnabled(false);
		sb_trait05.setEnabled(false);
		sb_humanity.setEnabled(false);
		sb_willpower.setEnabled(false);
		sb_willpowercur.setEnabled(false);
		sb_bloodpool.setEnabled(false);
		et_trait01.setEnabled(false);
		et_trait02.setEnabled(false);
		et_trait03.setEnabled(false);
		et_trait04.setEnabled(false);
		et_trait05.setEnabled(false);
		et_weapon01.setEnabled(false);
		et_weapon01diff.setEnabled(false);
		et_weapon01dam.setEnabled(false);
		et_weapon02.setEnabled(false);
		et_weapon02diff.setEnabled(false);
		et_weapon02dam.setEnabled(false);
		et_weapon03.setEnabled(false);
		et_weapon03diff.setEnabled(false);
		et_weapon03dam.setEnabled(false);
	}
	private void initializeTextFields() {
		tv_trait01.setText(""+currentchar.getTrait1val());
		tv_trait02.setText(""+currentchar.getTrait2val());
		tv_trait03.setText(""+currentchar.getTrait3val());
		tv_trait04.setText(""+currentchar.getTrait4val());
		tv_trait05.setText(""+currentchar.getTrait5val());
		et_trait01.setText(currentchar.getTrait1());
		et_trait02.setText(currentchar.getTrait2());
		et_trait03.setText(currentchar.getTrait3());
		et_trait04.setText(currentchar.getTrait4());
		et_trait05.setText(currentchar.getTrait5());
		et_weapon01.setText(currentchar.getWeapon1());
		et_weapon01diff.setText(""+currentchar.getWeapon1diff());
		et_weapon01dam.setText(""+currentchar.getWeapon1dam());
		et_weapon01.setText(currentchar.getWeapon2());
		et_weapon02diff.setText(""+currentchar.getWeapon2diff());
		et_weapon02dam.setText(""+currentchar.getWeapon2dam());
		et_weapon03.setText(currentchar.getWeapon3());
		et_weapon03diff.setText(""+currentchar.getWeapon3diff());
		et_weapon03dam.setText(""+currentchar.getWeapon3dam());
		
		tv_humanity.setText(""+currentchar.getHumanity());
		tv_willpower.setText(""+currentchar.getWillpower());
		tv_willpowercur.setText(""+currentchar.getWillpowercur());
		tv_bloodpool.setText(""+currentchar.getBloodpool());
		tv_traitleft.setText(""+TRAIT_LEFT);
	}
	private void initializeFields(Bundle savedInstanceState) {
		sb_trait01.setProgress(currentchar.getTrait1val());
		sb_trait02.setProgress(currentchar.getTrait2val());
		sb_trait03.setProgress(currentchar.getTrait3val());
		sb_trait04.setProgress(currentchar.getTrait4val());
		sb_trait05.setProgress(currentchar.getTrait5val());
		sb_humanity.setProgress(currentchar.getHumanity());
		sb_willpower.setProgress(currentchar.getWillpower());
		sb_willpowercur.setProgress(currentchar.getWillpowercur());
		sb_bloodpool.setProgress(currentchar.getBloodpool());
		TRAIT_LEFT = 20;
	
		initializeTextFields();
	}
	private void setEvents() {
		sb_trait01.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_TRAIT01) {
							old++;
							seekBar.setProgress(old);
							tv_trait01.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_TRAIT01) {
								old--;
								seekBar.setProgress(old);
								tv_trait01.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_trait02.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_TRAIT02) {
							old++;
							seekBar.setProgress(old);
							tv_trait02.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_TRAIT02) {
								old--;
								seekBar.setProgress(old);
								tv_trait02.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_trait03.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_TRAIT03) {
							old++;
							seekBar.setProgress(old);
							tv_trait03.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_TRAIT03) {
								old--;
								seekBar.setProgress(old);
								tv_trait03.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_trait04.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_TRAIT04) {
							old++;
							seekBar.setProgress(old);
							tv_trait04.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_TRAIT04) {
								old--;
								seekBar.setProgress(old);
								tv_trait04.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_trait05.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_TRAIT05) {
							old++;
							seekBar.setProgress(old);
							tv_trait05.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_TRAIT05) {
								old--;
								seekBar.setProgress(old);
								tv_trait05.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_humanity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_HUMANITY) {
							old++;
							seekBar.setProgress(old);
							tv_humanity.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_HUMANITY) {
								old--;
								seekBar.setProgress(old);
								tv_humanity.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_willpower.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_WILLPOWER) {
							old++;
							seekBar.setProgress(old);
							sb_willpowercur.setProgress(old);
							tv_willpower.setText(""+old);
							tv_willpowercur.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_WILLPOWER) {
								old--;
								seekBar.setProgress(old);
								sb_willpowercur.setProgress(old);
								tv_willpower.setText(""+old);
								tv_willpowercur.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_willpowercur.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_WILLPOWER) {
							old++;
							seekBar.setProgress(old);
							sb_willpower.setProgress(old);
							tv_willpowercur.setText(""+old);
							tv_willpower.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_WILLPOWER) {
								old--;
								seekBar.setProgress(old);
								sb_willpower.setProgress(old);
								tv_willpowercur.setText(""+old);
								tv_willpower.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_bloodpool.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TRAIT_LEFT > 0 && old < MAX_BLOODPOOL) {
							old++;
							seekBar.setProgress(old);
							tv_bloodpool.setText(""+old);
							TRAIT_LEFT--;
							tv_traitleft.setText(""+TRAIT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BLOODPOOL) {
								old--;
								seekBar.setProgress(old);
								tv_bloodpool.setText(""+old);
								TRAIT_LEFT++;
								tv_traitleft.setText(""+TRAIT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
	}
	private void findViews(View result) {
		sb_trait01 = (SeekBar)result.findViewById(R.id.sb_trait01);
		sb_trait02 = (SeekBar)result.findViewById(R.id.sb_trait02);
		sb_trait03 = (SeekBar)result.findViewById(R.id.sb_trait03);
		sb_trait04 = (SeekBar)result.findViewById(R.id.sb_trait04);
		sb_trait05 = (SeekBar)result.findViewById(R.id.sb_trait05);
		sb_humanity = (SeekBar)result.findViewById(R.id.sb_humanity);
		sb_willpower = (SeekBar)result.findViewById(R.id.sb_willpower);
		sb_willpowercur = (SeekBar)result.findViewById(R.id.sb_willpowercur);
		sb_bloodpool = (SeekBar)result.findViewById(R.id.sb_bloodpool);
		et_trait01 = (EditText)result.findViewById(R.id.et_trait01);
		et_trait02 = (EditText)result.findViewById(R.id.et_trait02);
		et_trait03 = (EditText)result.findViewById(R.id.et_trait03);
		et_trait04 = (EditText)result.findViewById(R.id.et_trait04);
		et_trait05 = (EditText)result.findViewById(R.id.et_trait05);
		tv_trait01 = (TextView)result.findViewById(R.id.tv_trait01);
		tv_trait02 = (TextView)result.findViewById(R.id.tv_trait02);
		tv_trait03 = (TextView)result.findViewById(R.id.tv_trait03);
		tv_trait04 = (TextView)result.findViewById(R.id.tv_trait04);
		tv_trait05 = (TextView)result.findViewById(R.id.tv_trait05);
		et_weapon01 = (EditText)result.findViewById(R.id.et_weapon01);
		et_weapon01diff = (EditText)result.findViewById(R.id.et_weapon01diff);
		et_weapon01dam = (EditText)result.findViewById(R.id.et_weapon01dam);
		et_weapon02 = (EditText)result.findViewById(R.id.et_weapon02);
		et_weapon02diff = (EditText)result.findViewById(R.id.et_weapon02diff);
		et_weapon02dam = (EditText)result.findViewById(R.id.et_weapon02dam);
		et_weapon03 = (EditText)result.findViewById(R.id.et_weapon03);
		et_weapon03diff = (EditText)result.findViewById(R.id.et_weapon03diff);
		et_weapon03dam = (EditText)result.findViewById(R.id.et_weapon03dam);
		tv_humanity = (TextView)result.findViewById(R.id.tv_humanity);
		tv_willpower = (TextView)result.findViewById(R.id.tv_willpower);
		tv_willpowercur = (TextView)result.findViewById(R.id.tv_willpowercur);
		tv_bloodpool = (TextView)result.findViewById(R.id.tv_bloodpool);
		tv_traitleft = (TextView)result.findViewById(R.id.tv_traitleft);
	}
	@Override
	public void onPause() {
		super.onPause();
		onSaveInstanceState(new Bundle());
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
		try {
			currentchar.setTrait1val(sb_trait01.getProgress());
			currentchar.setTrait2val(sb_trait02.getProgress());
			currentchar.setTrait3val(sb_trait03.getProgress());
			currentchar.setTrait4val(sb_trait04.getProgress());
			currentchar.setTrait5val(sb_trait05.getProgress());
			currentchar.setTrait1(et_trait01.getText().toString());
			currentchar.setTrait2(et_trait02.getText().toString());
			currentchar.setTrait3(et_trait03.getText().toString());
			currentchar.setTrait4(et_trait04.getText().toString());
			currentchar.setTrait5(et_trait05.getText().toString());
			currentchar.setWeapon1(et_weapon01.getText().toString());
			try {
				currentchar.setWeapon1diff(Integer.parseInt(et_weapon01diff.getText().toString()));
				currentchar.setWeapon1dam(Integer.parseInt(et_weapon01dam.getText().toString()));
			} catch (Exception e) {
				Toast.makeText(getActivity().getApplicationContext(), "A dificuldade e dano da arma 1 devem ser números inteiros", Toast.LENGTH_SHORT).show();
			}
			currentchar.setWeapon2(et_weapon02.getText().toString());
			try {
				currentchar.setWeapon2diff(Integer.parseInt(et_weapon02diff.getText().toString()));
				currentchar.setWeapon2dam(Integer.parseInt(et_weapon02dam.getText().toString()));
			} catch (Exception e) {
				Toast.makeText(getActivity().getApplicationContext(), "A dificuldade e dano da arma 2 devem ser números inteiros", Toast.LENGTH_SHORT).show();
			}
			currentchar.setWeapon3(et_weapon03.getText().toString());
			try {
				currentchar.setWeapon3diff(Integer.parseInt(et_weapon03diff.getText().toString()));
				currentchar.setWeapon3dam(Integer.parseInt(et_weapon03dam.getText().toString()));
			} catch (Exception e) {
				Toast.makeText(getActivity().getApplicationContext(), "A dificuldade e dano da arma 3 devem ser números inteiros", Toast.LENGTH_SHORT).show();
			}
			currentchar.setHumanity(sb_humanity.getProgress());
			currentchar.setWillpower(sb_willpower.getProgress());
			currentchar.setWillpowercur(sb_willpowercur.getProgress());
			currentchar.setBloodpool(sb_bloodpool.getProgress());
			//currentchar.setTraitLeft(TRAIT_LEFT);
		} catch (Exception e) {
			
		}
	}
}