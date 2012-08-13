package br.random.createchar;

import br.random.*;
import br.random.bean.VampireChar;
import br.random.util.Singleton;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireAttributes extends SherlockFragment {
	
	private VampireChar currentchar;
	private View old;
	
	private int MIN_STRENGTH = 1;
	private int MAX_STRENGTH = 5;
	private int MIN_DEXTERITY = 1;
	private int MAX_DEXTERITY = 5;
	private int MIN_STAMINA = 1;
	private int MAX_STAMINA = 5;
	private int MIN_CHARISMA = 1;
	private int MAX_CHARISMA = 5;
	private int MIN_MANIPULATION = 1;
	private int MAX_MANIPULATION = 5;
	private int MIN_APPEARANCE = 1;
	private int MAX_APPEARANCE = 5;
	private int MIN_PERCEPTION = 1;
	private int MAX_PERCEPTION = 5;
	private int MIN_INTELLIGENCE = 1;
	private int MAX_INTELLIGENCE = 5;
	private int MIN_WITS = 1;
	private int MAX_WITS = 5;
	
	private int PHYSIC_LEFT;
	private int SOCIAL_LEFT;
	private int MENTAL_LEFT;

	private SeekBar sb_strength;
	private SeekBar sb_dexterity;
	private SeekBar sb_stamina;
	private SeekBar sb_charisma;
	private SeekBar sb_manipulation;
	private SeekBar sb_appearance;
	private SeekBar sb_perception;
	private SeekBar sb_intelligence;
	private SeekBar sb_wits;
	private TextView tv_strength;
	private TextView tv_dexterity;
	private TextView tv_stamina;
	private TextView tv_charisma;
	private TextView tv_manipulation;
	private TextView tv_appearance;
	private TextView tv_perception;
	private TextView tv_intelligence;
	private TextView tv_wits;
	private TextView tv_physicleft;
	private TextView tv_socialleft;
	private TextView tv_mentalleft;
	
	public static VampireAttributes newInstance() {
		VampireAttributes frag=new VampireAttributes();
		return(frag);
	}
	public static String getTitle() {
		return "Atributos";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) return null;
		View result;
		if (old != null) {
			((FrameLayout)old.getParent()).removeView(old);
			result = old;
		} else {
			result=inflater.inflate(R.layout.vampire_attributes, container, false);
			old = result;
		}
		Singleton singleton = Singleton.getInstance(getActivity().getApplicationContext());
		currentchar = (VampireChar)singleton.getChar();
		PHYSIC_LEFT = currentchar.getPhysicLeft();
		SOCIAL_LEFT = currentchar.getSocialLeft();
		MENTAL_LEFT = currentchar.getMentalLeft();
		
		findViews(result);
		setEvents();
		initializeFields(savedInstanceState);

	    return(result);
	}
	private void initializeTextFields() {
		tv_strength.setText(""+currentchar.getStrength());
		tv_dexterity.setText(""+currentchar.getDexterity());
		tv_stamina.setText(""+currentchar.getStamina());
		tv_charisma.setText(""+currentchar.getCharisma());
		tv_manipulation.setText(""+currentchar.getManipulation());
		tv_appearance.setText(""+currentchar.getAppearance());
		tv_perception.setText(""+currentchar.getPerception());
		tv_intelligence.setText(""+currentchar.getIntelligence());
		tv_wits.setText(""+currentchar.getWits());
		tv_physicleft.setText(""+PHYSIC_LEFT);
		tv_socialleft.setText(""+SOCIAL_LEFT);
		tv_mentalleft.setText(""+MENTAL_LEFT);
	}
	private void initializeFields(Bundle savedInstanceState) {
		sb_strength.setProgress(currentchar.getStrength());
		sb_dexterity.setProgress(currentchar.getDexterity());
		sb_stamina.setProgress(currentchar.getStamina());
		sb_charisma.setProgress(currentchar.getCharisma());
		sb_manipulation.setProgress(currentchar.getManipulation());
		sb_appearance.setProgress(currentchar.getAppearance());
		sb_perception.setProgress(currentchar.getPerception());
		sb_intelligence.setProgress(currentchar.getIntelligence());
		sb_wits.setProgress(currentchar.getWits());
		PHYSIC_LEFT = currentchar.getPhysicLeft();
		SOCIAL_LEFT = currentchar.getSocialLeft();
		MENTAL_LEFT = currentchar.getMentalLeft();
		
		initializeTextFields();
	}
	private void setEvents() {
		sb_strength.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (PHYSIC_LEFT > 0 && old < MAX_STRENGTH) {
							old++;
							seekBar.setProgress(old);
							tv_strength.setText(""+old);
							PHYSIC_LEFT--;
							tv_physicleft.setText(""+PHYSIC_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_STRENGTH) {
								old--;
								seekBar.setProgress(old);
								tv_strength.setText(""+old);
								PHYSIC_LEFT++;
								tv_physicleft.setText(""+PHYSIC_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_dexterity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) { 
					if (progress > old) {
						if (PHYSIC_LEFT > 0 && old < MAX_DEXTERITY) {
							old++;
							seekBar.setProgress(old);
							tv_dexterity.setText(""+old);
							PHYSIC_LEFT--;
							tv_physicleft.setText(""+PHYSIC_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DEXTERITY) {
								old--;
								seekBar.setProgress(old);
								tv_dexterity.setText(""+old);
								PHYSIC_LEFT++;
								tv_physicleft.setText(""+PHYSIC_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_stamina.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (PHYSIC_LEFT > 0 && old < MAX_STAMINA) {
							old++;
							seekBar.setProgress(old);
							tv_stamina.setText(""+old);
							PHYSIC_LEFT--;
							tv_physicleft.setText(""+PHYSIC_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_STAMINA) {
								old--;
								seekBar.setProgress(old);
								tv_stamina.setText(""+old);
								PHYSIC_LEFT++;
								tv_physicleft.setText(""+PHYSIC_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_charisma.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SOCIAL_LEFT > 0 && old < MAX_CHARISMA) {
							old++;
							seekBar.setProgress(old);
							tv_charisma.setText(""+old);
							SOCIAL_LEFT--;
							tv_socialleft.setText(""+SOCIAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_CHARISMA) {
								old--;
								seekBar.setProgress(old);
								tv_charisma.setText(""+old);
								SOCIAL_LEFT++;
								tv_socialleft.setText(""+SOCIAL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_manipulation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SOCIAL_LEFT > 0 && old < MAX_MANIPULATION) {
							old++;
							seekBar.setProgress(old);
							tv_manipulation.setText(""+old);
							SOCIAL_LEFT--;
							tv_socialleft.setText(""+SOCIAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_MANIPULATION) {
								old--;
								seekBar.setProgress(old);
								tv_manipulation.setText(""+old);
								SOCIAL_LEFT++;
								tv_socialleft.setText(""+SOCIAL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_appearance.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SOCIAL_LEFT > 0 && old < MAX_APPEARANCE) {
							old++;
							seekBar.setProgress(old);
							tv_appearance.setText(""+old);
							SOCIAL_LEFT--;
							tv_socialleft.setText(""+SOCIAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_APPEARANCE) {
								old--;
								seekBar.setProgress(old);
								tv_appearance.setText(""+old);
								SOCIAL_LEFT++;
								tv_socialleft.setText(""+SOCIAL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_perception.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (MENTAL_LEFT > 0 && old < MAX_PERCEPTION) {
							old++;
							seekBar.setProgress(old);
							tv_perception.setText(""+old);
							MENTAL_LEFT--;
							tv_mentalleft.setText(""+MENTAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_PERCEPTION) {
								old--;
								seekBar.setProgress(old);
								tv_perception.setText(""+old);
								MENTAL_LEFT++;
								tv_mentalleft.setText(""+MENTAL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_intelligence.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (MENTAL_LEFT > 0 && old < MAX_INTELLIGENCE) {
							old++;
							seekBar.setProgress(old);
							tv_intelligence.setText(""+old);
							MENTAL_LEFT--;
							tv_mentalleft.setText(""+MENTAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_INTELLIGENCE) {
								old--;
								seekBar.setProgress(old);
								tv_intelligence.setText(""+old);
								MENTAL_LEFT++;
								tv_mentalleft.setText(""+MENTAL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_wits.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (MENTAL_LEFT > 0 && old < MAX_WITS) {
							old++;
							seekBar.setProgress(old);
							tv_wits.setText(""+old);
							MENTAL_LEFT--;
							tv_mentalleft.setText(""+MENTAL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_WITS) {
								old--;
								seekBar.setProgress(old);
								tv_wits.setText(""+old);
								MENTAL_LEFT++;
								tv_mentalleft.setText(""+MENTAL_LEFT);
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
		sb_strength = (SeekBar)result.findViewById(R.id.sb_strength);
		sb_dexterity = (SeekBar)result.findViewById(R.id.sb_dexterity);
		sb_stamina = (SeekBar)result.findViewById(R.id.sb_stamina);
		sb_charisma = (SeekBar)result.findViewById(R.id.sb_charisma);
		sb_manipulation = (SeekBar)result.findViewById(R.id.sb_manipulation);
		sb_appearance = (SeekBar)result.findViewById(R.id.sb_appearance);
		sb_perception = (SeekBar)result.findViewById(R.id.sb_perception);
		sb_intelligence = (SeekBar)result.findViewById(R.id.sb_intelligence);
		sb_wits = (SeekBar)result.findViewById(R.id.sb_wits);
		tv_strength = (TextView)result.findViewById(R.id.tv_strength);
		tv_dexterity = (TextView)result.findViewById(R.id.tv_dexterity);
		tv_stamina = (TextView)result.findViewById(R.id.tv_stamina);
		tv_charisma = (TextView)result.findViewById(R.id.tv_charisma);
		tv_manipulation = (TextView)result.findViewById(R.id.tv_manipulation);
		tv_appearance = (TextView)result.findViewById(R.id.tv_appearance);
		tv_perception = (TextView)result.findViewById(R.id.tv_perception);
		tv_intelligence = (TextView)result.findViewById(R.id.tv_intelligence);
		tv_wits = (TextView)result.findViewById(R.id.tv_wits);
		tv_physicleft = (TextView)result.findViewById(R.id.tv_physicleft);
		tv_socialleft = (TextView)result.findViewById(R.id.tv_socialleft);
		tv_mentalleft = (TextView)result.findViewById(R.id.tv_mentalleft);
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
			try {
			currentchar.setStrength(sb_strength.getProgress());
			currentchar.setDexterity(sb_dexterity.getProgress());
			currentchar.setStamina(sb_stamina.getProgress());
			currentchar.setCharisma(sb_charisma.getProgress());
			currentchar.setManipulation(sb_manipulation.getProgress());
			currentchar.setAppearance(sb_appearance.getProgress());
			currentchar.setPerception(sb_perception.getProgress());
			currentchar.setIntelligence(sb_intelligence.getProgress());
			currentchar.setWits(sb_wits.getProgress());
			currentchar.setPhysicLeft(PHYSIC_LEFT);
			currentchar.setSocialLeft(SOCIAL_LEFT);
			currentchar.setMentalLeft(MENTAL_LEFT);
		} catch (Exception e) {
			
		}
	}
}