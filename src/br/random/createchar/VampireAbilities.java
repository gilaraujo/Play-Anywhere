package br.random.createchar;

import br.random.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireAbilities extends SherlockFragment {
	
	private int MIN_ACTING = 0;
	private int MAX_ACTING = 5;
	private int MIN_ALERTNESS = 0;
	private int MAX_ALERTNESS = 5;
	private int MIN_ATHLETICS = 0;
	private int MAX_ATHLETICS = 5;
	private int MIN_BRAWL = 0;
	private int MAX_BRAWL = 5;
	private int MIN_DODGE = 0;
	private int MAX_DODGE = 5;
	private int MIN_EMPATHY = 0;
	private int MAX_EMPATHY = 5;
	private int MIN_INTIMIDATION = 0;
	private int MAX_INTIMIDATION = 5;
	private int MIN_LEADERSHIP = 0;
	private int MAX_LEADERSHIP = 5;
	private int MIN_STREETWISE = 0;
	private int MAX_STREETWISE = 5;
	private int MIN_SUBTERFUGE= 0;
	private int MIN_ANIMALKEN = 0;
	private int MAX_ANIMALKEN = 5;
	private int MIN_DRIVE = 0;
	private int MAX_DRIVE = 5;
	private int MIN_ETIQUETTE = 0;
	private int MAX_ETIQUETTE = 5;
	private int MIN_FIREARMS = 0;
	private int MAX_FIREARMS = 5;
	private int MIN_MELEE = 0;
	private int MAX_MELEE = 5;
	private int MIN_MUSIC = 0;
	private int MAX_MUSIC = 5;
	private int MIN_REPAIR = 0;
	private int MAX_REPAIR = 5;
	private int MIN_SECURITY = 0;
	private int MAX_SECURITY = 5;
	private int MIN_STEALTH = 0;
	private int MAX_STEALTH = 5;
	private int MIN_SURVIVAL= 0;
	private int MAX_SURVIVAL = 5;
	private int MAX_SUBTERFUGE = 5;
	private int MIN_BUREAUCRACY = 0;
	private int MAX_BUREAUCRACY = 5;
	private int MIN_COMPUTER = 0;
	private int MAX_COMPUTER = 5;
	private int MIN_FINANCE = 0;
	private int MAX_FINANCE = 5;
	private int MIN_INVESTIGATION = 0;
	private int MAX_INVESTIGATION = 5;
	private int MIN_LAW = 0;
	private int MAX_LAW = 5;
	private int MIN_LINGUISTICS = 0;
	private int MAX_LINGUISTICS = 5;
	private int MIN_MEDICINE = 0;
	private int MAX_MEDICINE = 5;
	private int MIN_OCCULT = 0;
	private int MAX_OCCULT = 5;
	private int MIN_POLITICS = 0;
	private int MAX_POLITICS = 5;
	private int MIN_SCIENCE= 0;
	private int MAX_SCIENCE = 5;
	private int TALENT_LEFT = 13;
	private int SKILL_LEFT = 9;
	private int KNOWLEDGE_LEFT = 5;

	private SeekBar sb_acting;
	private SeekBar sb_alertness;
	private SeekBar sb_athletics;
	private SeekBar sb_brawl;
	private SeekBar sb_dodge;
	private SeekBar sb_empathy;
	private SeekBar sb_intimidation;
	private SeekBar sb_leadership;
	private SeekBar sb_streetwise;
	private SeekBar sb_subterfuge;
	private SeekBar sb_animalken;
	private SeekBar sb_drive;
	private SeekBar sb_etiquette;
	private SeekBar sb_firearms;
	private SeekBar sb_melee;
	private SeekBar sb_music;
	private SeekBar sb_repair;
	private SeekBar sb_security;
	private SeekBar sb_stealth;
	private SeekBar sb_survival;
	private SeekBar sb_bureaucracy;
	private SeekBar sb_computer;
	private SeekBar sb_finance;
	private SeekBar sb_investigation;
	private SeekBar sb_law;
	private SeekBar sb_linguistics;
	private SeekBar sb_medicine;
	private SeekBar sb_occult;
	private SeekBar sb_politics;
	private SeekBar sb_science;
	private TextView tv_acting;
	private TextView tv_alertness;
	private TextView tv_athletics;
	private TextView tv_brawl;
	private TextView tv_dodge;
	private TextView tv_empathy;
	private TextView tv_intimidation;
	private TextView tv_leadership;
	private TextView tv_streetwise;
	private TextView tv_subterfuge;
	private TextView tv_animalken;
	private TextView tv_drive;
	private TextView tv_etiquette;
	private TextView tv_firearms;
	private TextView tv_melee;
	private TextView tv_music;
	private TextView tv_repair;
	private TextView tv_security;
	private TextView tv_stealth;
	private TextView tv_survival;
	private TextView tv_bureaucracy;
	private TextView tv_computer;
	private TextView tv_finance;
	private TextView tv_investigation;
	private TextView tv_law;
	private TextView tv_linguistics;
	private TextView tv_medicine;
	private TextView tv_occult;
	private TextView tv_politics;
	private TextView tv_science;
	private TextView tv_talentleft;
	private TextView tv_skillleft;
	private TextView tv_knowledgeleft;
	
	public static VampireAbilities newInstance() {
		VampireAbilities frag=new VampireAbilities();
		return(frag);
	}
	public static String getTitle() {
		return "Habilidades";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result=inflater.inflate(R.layout.vampire_abilities, container, false);
		
		findViews(result);
		setEvents();
		initializeFromBundle(savedInstanceState);
		initializeTextFields();
		
	    return(result);
	}
	private void initializeTextFields() {
		tv_acting.setText(""+sb_acting.getProgress());
		tv_alertness.setText(""+sb_alertness.getProgress());
		tv_athletics.setText(""+sb_athletics.getProgress());
		tv_brawl.setText(""+sb_brawl.getProgress());
		tv_dodge.setText(""+sb_dodge.getProgress());
		tv_empathy.setText(""+sb_empathy.getProgress());
		tv_intimidation.setText(""+sb_intimidation.getProgress());
		tv_leadership.setText(""+sb_leadership.getProgress());
		tv_streetwise.setText(""+sb_streetwise.getProgress());
		tv_subterfuge.setText(""+sb_subterfuge.getProgress());
		tv_animalken.setText(""+sb_animalken.getProgress());
		tv_drive.setText(""+sb_drive.getProgress());
		tv_etiquette.setText(""+sb_etiquette.getProgress());
		tv_firearms.setText(""+sb_firearms.getProgress());
		tv_melee.setText(""+sb_melee.getProgress());
		tv_music.setText(""+sb_music.getProgress());
		tv_repair.setText(""+sb_repair.getProgress());
		tv_security.setText(""+sb_security.getProgress());
		tv_stealth.setText(""+sb_stealth.getProgress());
		tv_survival.setText(""+sb_survival.getProgress());
		tv_bureaucracy.setText(""+sb_bureaucracy.getProgress());
		tv_computer.setText(""+sb_computer.getProgress());
		tv_finance.setText(""+sb_finance.getProgress());
		tv_investigation.setText(""+sb_investigation.getProgress());
		tv_law.setText(""+sb_law.getProgress());
		tv_linguistics.setText(""+sb_linguistics.getProgress());
		tv_medicine.setText(""+sb_medicine.getProgress());
		tv_occult.setText(""+sb_occult.getProgress());
		tv_politics.setText(""+sb_politics.getProgress());
		tv_science.setText(""+sb_science.getProgress());
		tv_talentleft.setText(""+TALENT_LEFT);
		tv_skillleft.setText(""+SKILL_LEFT);
		tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
	}
	private void initializeFromBundle(Bundle savedInstanceState) {
		try {
			sb_acting.setProgress(savedInstanceState.getInt("act"));
		} catch (Exception e) {
			sb_acting.setProgress(MIN_ACTING);
		}
		try {
			sb_alertness.setProgress(savedInstanceState.getInt("ale"));
		} catch (Exception e) {
			sb_alertness.setProgress(MIN_ALERTNESS);
		}
		try {
			sb_athletics.setProgress(savedInstanceState.getInt("ath"));
		} catch (Exception e) {
			sb_athletics.setProgress(MIN_ATHLETICS);
		}
		try {
			sb_brawl.setProgress(savedInstanceState.getInt("bra"));
		} catch (Exception e) {
			sb_brawl.setProgress(MIN_BRAWL);
		}
		try {
			sb_dodge.setProgress(savedInstanceState.getInt("dod"));
		} catch (Exception e) {
			sb_dodge.setProgress(MIN_DODGE);
		}
		try {
			sb_empathy.setProgress(savedInstanceState.getInt("emp"));
		} catch (Exception e) {
			sb_empathy.setProgress(MIN_EMPATHY);
		}
		try {
			sb_intimidation.setProgress(savedInstanceState.getInt("itm"));
		} catch (Exception e) {
			sb_intimidation.setProgress(MIN_INTIMIDATION);
		}
		try {
			sb_leadership.setProgress(savedInstanceState.getInt("lea"));
		} catch (Exception e) {
			sb_leadership.setProgress(MIN_LEADERSHIP);
		}
		try {
			sb_streetwise.setProgress(savedInstanceState.getInt("str"));
		} catch (Exception e) {
			sb_streetwise.setProgress(MIN_STREETWISE);
		}
		try {
			sb_subterfuge.setProgress(savedInstanceState.getInt("sub"));
		} catch (Exception e) {
			sb_subterfuge.setProgress(MIN_SUBTERFUGE);
		}
		try {
			sb_animalken.setProgress(savedInstanceState.getInt("ani"));
		} catch (Exception e) {
			sb_animalken.setProgress(MIN_ANIMALKEN);
		}
		try {
			sb_drive.setProgress(savedInstanceState.getInt("dri"));
		} catch (Exception e) {
			sb_drive.setProgress(MIN_DRIVE);
		}
		try {
			sb_etiquette.setProgress(savedInstanceState.getInt("eti"));
		} catch (Exception e) {
			sb_etiquette.setProgress(MIN_ETIQUETTE);
		}
		try {
			sb_firearms.setProgress(savedInstanceState.getInt("fir"));
		} catch (Exception e) {
			sb_firearms.setProgress(MIN_FIREARMS);
		}
		try {
			sb_melee.setProgress(savedInstanceState.getInt("mel"));
		} catch (Exception e) {
			sb_melee.setProgress(MIN_MELEE);
		}
		try {
			sb_music.setProgress(savedInstanceState.getInt("mus"));
		} catch (Exception e) {
			sb_music.setProgress(MIN_MUSIC);
		}
		try {
			sb_repair.setProgress(savedInstanceState.getInt("rep"));
		} catch (Exception e) {
			sb_repair.setProgress(MIN_REPAIR);
		}
		try {
			sb_security.setProgress(savedInstanceState.getInt("sec"));
		} catch (Exception e) {
			sb_security.setProgress(MIN_SECURITY);
		}
		try {
			sb_stealth.setProgress(savedInstanceState.getInt("ste"));
		} catch (Exception e) {
			sb_stealth.setProgress(MIN_STEALTH);
		}
		try {
			sb_survival.setProgress(savedInstanceState.getInt("sur"));
		} catch (Exception e) {
			sb_survival.setProgress(MIN_SURVIVAL);
		}
		try {
			sb_bureaucracy.setProgress(savedInstanceState.getInt("bur"));
		} catch (Exception e) {
			sb_bureaucracy.setProgress(MIN_BUREAUCRACY);
		}
		try {
			sb_computer.setProgress(savedInstanceState.getInt("com"));
		} catch (Exception e) {
			sb_computer.setProgress(MIN_COMPUTER);
		}
		try {
			sb_finance.setProgress(savedInstanceState.getInt("fin"));
		} catch (Exception e) {
			sb_finance.setProgress(MIN_FINANCE);
		}
		try {
			sb_investigation.setProgress(savedInstanceState.getInt("inv"));
		} catch (Exception e) {
			sb_investigation.setProgress(MIN_INVESTIGATION);
		}
		try {
			sb_law.setProgress(savedInstanceState.getInt("law"));
		} catch (Exception e) {
			sb_law.setProgress(MIN_LAW);
		}
		try {
			sb_linguistics.setProgress(savedInstanceState.getInt("lin"));
		} catch (Exception e) {
			sb_linguistics.setProgress(MIN_LINGUISTICS);
		}
		try {
			sb_medicine.setProgress(savedInstanceState.getInt("med"));
		} catch (Exception e) {
			sb_medicine.setProgress(MIN_MEDICINE);
		}
		try {
			sb_occult.setProgress(savedInstanceState.getInt("occ"));
		} catch (Exception e) {
			sb_occult.setProgress(MIN_OCCULT);
		}
		try {
			sb_politics.setProgress(savedInstanceState.getInt("pol"));
		} catch (Exception e) {
			sb_politics.setProgress(MIN_POLITICS);
		}
		try {
			sb_science.setProgress(savedInstanceState.getInt("sci"));
		} catch (Exception e) {
			sb_science.setProgress(MIN_SCIENCE);
		}
		try {
			TALENT_LEFT = savedInstanceState.getInt("tal");
		} catch (Exception e) { }
		try {
			SKILL_LEFT = savedInstanceState.getInt("ski");
		} catch (Exception e) { }
		try {
			KNOWLEDGE_LEFT = savedInstanceState.getInt("kno");
		} catch (Exception e) { }
	}
	private void findViews(View result) {
		sb_acting = (SeekBar)result.findViewById(R.id.sb_acting);
		sb_alertness = (SeekBar)result.findViewById(R.id.sb_alertness);
		sb_athletics = (SeekBar)result.findViewById(R.id.sb_athletics);
		sb_brawl = (SeekBar)result.findViewById(R.id.sb_brawl);
		sb_dodge = (SeekBar)result.findViewById(R.id.sb_dodge);
		sb_empathy = (SeekBar)result.findViewById(R.id.sb_empathy);
		sb_intimidation = (SeekBar)result.findViewById(R.id.sb_intimidation);
		sb_leadership = (SeekBar)result.findViewById(R.id.sb_leadership);
		sb_streetwise = (SeekBar)result.findViewById(R.id.sb_streetwise);
		sb_subterfuge = (SeekBar)result.findViewById(R.id.sb_subterfuge);
		sb_animalken = (SeekBar)result.findViewById(R.id.sb_animalken);
		sb_drive = (SeekBar)result.findViewById(R.id.sb_drive);
		sb_etiquette = (SeekBar)result.findViewById(R.id.sb_etiquette);
		sb_firearms = (SeekBar)result.findViewById(R.id.sb_firearms);
		sb_melee = (SeekBar)result.findViewById(R.id.sb_melee);
		sb_music = (SeekBar)result.findViewById(R.id.sb_music);
		sb_repair = (SeekBar)result.findViewById(R.id.sb_repair);
		sb_security = (SeekBar)result.findViewById(R.id.sb_security);
		sb_stealth = (SeekBar)result.findViewById(R.id.sb_stealth);
		sb_survival = (SeekBar)result.findViewById(R.id.sb_survival);
		sb_bureaucracy = (SeekBar)result.findViewById(R.id.sb_bureaucracy);
		sb_computer = (SeekBar)result.findViewById(R.id.sb_computer);
		sb_finance = (SeekBar)result.findViewById(R.id.sb_finance);
		sb_investigation = (SeekBar)result.findViewById(R.id.sb_investigation);
		sb_law = (SeekBar)result.findViewById(R.id.sb_law);
		sb_linguistics = (SeekBar)result.findViewById(R.id.sb_linguistics);
		sb_medicine = (SeekBar)result.findViewById(R.id.sb_medicine);
		sb_occult = (SeekBar)result.findViewById(R.id.sb_occult);
		sb_politics = (SeekBar)result.findViewById(R.id.sb_politics);
		sb_science = (SeekBar)result.findViewById(R.id.sb_science);
		tv_acting = (TextView)result.findViewById(R.id.tv_acting);
		tv_alertness = (TextView)result.findViewById(R.id.tv_alertness);
		tv_athletics = (TextView)result.findViewById(R.id.tv_athletics);
		tv_brawl = (TextView)result.findViewById(R.id.tv_brawl);
		tv_dodge = (TextView)result.findViewById(R.id.tv_dodge);
		tv_empathy = (TextView)result.findViewById(R.id.tv_empathy);
		tv_intimidation = (TextView)result.findViewById(R.id.tv_intimidation);
		tv_leadership = (TextView)result.findViewById(R.id.tv_leadership);
		tv_streetwise = (TextView)result.findViewById(R.id.tv_streetwise);
		tv_subterfuge = (TextView)result.findViewById(R.id.tv_subterfuge);
		tv_animalken = (TextView)result.findViewById(R.id.tv_animalken);
		tv_drive = (TextView)result.findViewById(R.id.tv_drive);
		tv_etiquette = (TextView)result.findViewById(R.id.tv_etiquette);
		tv_firearms = (TextView)result.findViewById(R.id.tv_firearms);
		tv_melee = (TextView)result.findViewById(R.id.tv_melee);
		tv_music = (TextView)result.findViewById(R.id.tv_music);
		tv_repair = (TextView)result.findViewById(R.id.tv_repair);
		tv_security = (TextView)result.findViewById(R.id.tv_security);
		tv_stealth = (TextView)result.findViewById(R.id.tv_stealth);
		tv_survival = (TextView)result.findViewById(R.id.tv_survival);
		tv_bureaucracy = (TextView)result.findViewById(R.id.tv_bureaucracy);
		tv_computer = (TextView)result.findViewById(R.id.tv_computer);
		tv_finance = (TextView)result.findViewById(R.id.tv_finance);
		tv_investigation = (TextView)result.findViewById(R.id.tv_investigation);
		tv_law = (TextView)result.findViewById(R.id.tv_law);
		tv_linguistics = (TextView)result.findViewById(R.id.tv_linguistics);
		tv_medicine = (TextView)result.findViewById(R.id.tv_medicine);
		tv_occult = (TextView)result.findViewById(R.id.tv_occult);
		tv_politics = (TextView)result.findViewById(R.id.tv_politics);
		tv_science = (TextView)result.findViewById(R.id.tv_science);
		tv_talentleft = (TextView)result.findViewById(R.id.tv_talentleft);
		tv_skillleft = (TextView)result.findViewById(R.id.tv_skillleft);
		tv_knowledgeleft = (TextView)result.findViewById(R.id.tv_knowledgeleft);
	}
	private void setEvents() {
		sb_acting.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_ACTING) {
							old++;
							seekBar.setProgress(old);
							tv_acting.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_ACTING) {
								old--;
								seekBar.setProgress(old);
								tv_acting.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_alertness.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) { 
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_ALERTNESS) {
							old++;
							seekBar.setProgress(old);
							tv_alertness.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_ALERTNESS) {
								old--;
								seekBar.setProgress(old);
								tv_alertness.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_athletics.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_ATHLETICS) {
							old++;
							seekBar.setProgress(old);
							tv_athletics.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_ATHLETICS) {
								old--;
								seekBar.setProgress(old);
								tv_athletics.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_brawl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_BRAWL) {
							old++;
							seekBar.setProgress(old);
							tv_brawl.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BRAWL) {
								old--;
								seekBar.setProgress(old);
								tv_brawl.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_dodge.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_DODGE) {
							old++;
							seekBar.setProgress(old);
							tv_dodge.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DODGE) {
								old--;
								seekBar.setProgress(old);
								tv_dodge.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_empathy.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_EMPATHY) {
							old++;
							seekBar.setProgress(old);
							tv_empathy.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_EMPATHY) {
								old--;
								seekBar.setProgress(old);
								tv_empathy.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_intimidation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_INTIMIDATION) {
							old++;
							seekBar.setProgress(old);
							tv_intimidation.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_INTIMIDATION) {
								old--;
								seekBar.setProgress(old);
								tv_intimidation.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_leadership.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_LEADERSHIP) {
							old++;
							seekBar.setProgress(old);
							tv_leadership.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_LEADERSHIP) {
								old--;
								seekBar.setProgress(old);
								tv_leadership.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_streetwise.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_STREETWISE) {
							old++;
							seekBar.setProgress(old);
							tv_streetwise.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_STREETWISE) {
								old--;
								seekBar.setProgress(old);
								tv_streetwise.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_subterfuge.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (TALENT_LEFT > 0 && old < MAX_SUBTERFUGE) {
							old++;
							seekBar.setProgress(old);
							tv_subterfuge.setText(""+old);
							TALENT_LEFT--;
							tv_talentleft.setText(""+TALENT_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_SUBTERFUGE) {
								old--;
								seekBar.setProgress(old);
								tv_subterfuge.setText(""+old);
								TALENT_LEFT++;
								tv_talentleft.setText(""+TALENT_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_animalken.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_ANIMALKEN) {
							old++;
							seekBar.setProgress(old);
							tv_animalken.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_ANIMALKEN) {
								old--;
								seekBar.setProgress(old);
								tv_animalken.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_drive.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) { 
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_DRIVE) {
							old++;
							seekBar.setProgress(old);
							tv_drive.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DRIVE) {
								old--;
								seekBar.setProgress(old);
								tv_drive.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_etiquette.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_ETIQUETTE) {
							old++;
							seekBar.setProgress(old);
							tv_etiquette.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_ETIQUETTE) {
								old--;
								seekBar.setProgress(old);
								tv_etiquette.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_firearms.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_FIREARMS) {
							old++;
							seekBar.setProgress(old);
							tv_firearms.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_FIREARMS) {
								old--;
								seekBar.setProgress(old);
								tv_firearms.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_melee.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_MELEE) {
							old++;
							seekBar.setProgress(old);
							tv_melee.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_MELEE) {
								old--;
								seekBar.setProgress(old);
								tv_melee.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_music.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_MUSIC) {
							old++;
							seekBar.setProgress(old);
							tv_music.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_MUSIC) {
								old--;
								seekBar.setProgress(old);
								tv_music.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_repair.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_REPAIR) {
							old++;
							seekBar.setProgress(old);
							tv_repair.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_REPAIR) {
								old--;
								seekBar.setProgress(old);
								tv_repair.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_security.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_SECURITY) {
							old++;
							seekBar.setProgress(old);
							tv_security.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_SECURITY) {
								old--;
								seekBar.setProgress(old);
								tv_security.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_stealth.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_STEALTH) {
							old++;
							seekBar.setProgress(old);
							tv_stealth.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_STEALTH) {
								old--;
								seekBar.setProgress(old);
								tv_stealth.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_survival.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (SKILL_LEFT > 0 && old < MAX_SURVIVAL) {
							old++;
							seekBar.setProgress(old);
							tv_survival.setText(""+old);
							SKILL_LEFT--;
							tv_skillleft.setText(""+SKILL_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_SURVIVAL) {
								old--;
								seekBar.setProgress(old);
								tv_survival.setText(""+old);
								SKILL_LEFT++;
								tv_skillleft.setText(""+SKILL_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_bureaucracy.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_BUREAUCRACY) {
							old++;
							seekBar.setProgress(old);
							tv_bureaucracy.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BUREAUCRACY) {
								old--;
								seekBar.setProgress(old);
								tv_bureaucracy.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_computer.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) { 
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_COMPUTER) {
							old++;
							seekBar.setProgress(old);
							tv_computer.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_COMPUTER) {
								old--;
								seekBar.setProgress(old);
								tv_computer.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_finance.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_FINANCE) {
							old++;
							seekBar.setProgress(old);
							tv_finance.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_FINANCE) {
								old--;
								seekBar.setProgress(old);
								tv_finance.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_investigation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_INVESTIGATION) {
							old++;
							seekBar.setProgress(old);
							tv_investigation.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_INVESTIGATION) {
								old--;
								seekBar.setProgress(old);
								tv_investigation.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_law.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_LAW) {
							old++;
							seekBar.setProgress(old);
							tv_law.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_LAW) {
								old--;
								seekBar.setProgress(old);
								tv_law.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_linguistics.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_LINGUISTICS) {
							old++;
							seekBar.setProgress(old);
							tv_linguistics.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_LINGUISTICS) {
								old--;
								seekBar.setProgress(old);
								tv_linguistics.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_medicine.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_MEDICINE) {
							old++;
							seekBar.setProgress(old);
							tv_medicine.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_MEDICINE) {
								old--;
								seekBar.setProgress(old);
								tv_medicine.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_occult.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_OCCULT) {
							old++;
							seekBar.setProgress(old);
							tv_occult.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_OCCULT) {
								old--;
								seekBar.setProgress(old);
								tv_occult.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_politics.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_POLITICS) {
							old++;
							seekBar.setProgress(old);
							tv_politics.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_POLITICS) {
								old--;
								seekBar.setProgress(old);
								tv_politics.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_science.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (KNOWLEDGE_LEFT > 0 && old < MAX_SCIENCE) {
							old++;
							seekBar.setProgress(old);
							tv_science.setText(""+old);
							KNOWLEDGE_LEFT--;
							tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_SCIENCE) {
								old--;
								seekBar.setProgress(old);
								tv_science.setText(""+old);
								KNOWLEDGE_LEFT++;
								tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
		try {
	    	icicle.putInt("act", sb_acting.getProgress());
	    	icicle.putInt("ale", sb_alertness.getProgress());
	    	icicle.putInt("ath", sb_athletics.getProgress());
	    	icicle.putInt("bra", sb_brawl.getProgress());
	    	icicle.putInt("dod", sb_dodge.getProgress());
	    	icicle.putInt("emp", sb_empathy.getProgress());
	    	icicle.putInt("itm", sb_intimidation.getProgress());
	    	icicle.putInt("lea", sb_leadership.getProgress());
	    	icicle.putInt("str", sb_streetwise.getProgress());
	    	icicle.putInt("sub", sb_subterfuge.getProgress());
	    	icicle.putInt("ani", sb_animalken.getProgress());
	    	icicle.putInt("dri", sb_drive.getProgress());
	    	icicle.putInt("eti", sb_etiquette.getProgress());
	    	icicle.putInt("fir", sb_firearms.getProgress());
	    	icicle.putInt("mel", sb_melee.getProgress());
	    	icicle.putInt("mus", sb_music.getProgress());
	    	icicle.putInt("rep", sb_repair.getProgress());
	    	icicle.putInt("sec", sb_security.getProgress());
	    	icicle.putInt("ste", sb_stealth.getProgress());
	    	icicle.putInt("sur", sb_survival.getProgress());
	    	icicle.putInt("bur", sb_bureaucracy.getProgress());
	    	icicle.putInt("com", sb_computer.getProgress());
	    	icicle.putInt("fin", sb_finance.getProgress());
	    	icicle.putInt("inv", sb_investigation.getProgress());
	    	icicle.putInt("law", sb_law.getProgress());
	    	icicle.putInt("lin", sb_linguistics.getProgress());
	    	icicle.putInt("med", sb_medicine.getProgress());
	    	icicle.putInt("occ", sb_occult.getProgress());
	    	icicle.putInt("pol", sb_politics.getProgress());
	    	icicle.putInt("sci", sb_science.getProgress());
	    	icicle.putInt("tal", TALENT_LEFT);
	    	icicle.putInt("ski", SKILL_LEFT);
	    	icicle.putInt("kno", KNOWLEDGE_LEFT);
		} catch (Exception e) {
			
		}
	}
}