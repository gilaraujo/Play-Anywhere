package br.random.createchar;

import br.random.*;
import br.random.bean.VampireChar;
import br.random.util.Singleton;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireAbilities extends SherlockFragment {
	
	private VampireChar currentchar;
	private View old;
	
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
	
	private int TALENT_LEFT;
	private int SKILL_LEFT;
	private int KNOWLEDGE_LEFT;

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
		if (container == null) return null;
		View result;
		if (old != null) {
			((FrameLayout)old.getParent()).removeView(old);
			result = old;
		} else {
			result=inflater.inflate(R.layout.vampire_abilities, container, false);
			old = result;
		}
		Singleton singleton = Singleton.getInstance(getActivity().getApplicationContext());
		currentchar = (VampireChar)singleton.getChar();
		TALENT_LEFT = currentchar.getTalentLeft();
		SKILL_LEFT = currentchar.getSkillLeft();
		KNOWLEDGE_LEFT = currentchar.getKnowledgeLeft();
		
		findViews(result);
		setEvents();
		initializeFields(savedInstanceState);
		
	    return(result);
	}
	private void initializeTextFields() {
		tv_acting.setText(""+currentchar.getActing());
		tv_alertness.setText(""+currentchar.getAlertness());
		tv_athletics.setText(""+currentchar.getAthletics());
		tv_brawl.setText(""+currentchar.getBrawl());
		tv_dodge.setText(""+currentchar.getDodge());
		tv_empathy.setText(""+currentchar.getEmpathy());
		tv_intimidation.setText(""+currentchar.getIntimidation());
		tv_leadership.setText(""+currentchar.getLeadership());
		tv_streetwise.setText(""+currentchar.getStreetwise());
		tv_subterfuge.setText(""+currentchar.getSubterfuge());
		tv_animalken.setText(""+currentchar.getAnimalken());
		tv_drive.setText(""+currentchar.getDrive());
		tv_etiquette.setText(""+currentchar.getEtiquette());
		tv_firearms.setText(""+currentchar.getFirearms());
		tv_melee.setText(""+currentchar.getMelee());
		tv_music.setText(""+currentchar.getMusic());
		tv_repair.setText(""+currentchar.getRepair());
		tv_security.setText(""+currentchar.getSecurity());
		tv_stealth.setText(""+currentchar.getStealth());
		tv_survival.setText(""+currentchar.getSurvival());
		tv_bureaucracy.setText(""+currentchar.getBureaucracy());
		tv_computer.setText(""+currentchar.getComputer());
		tv_finance.setText(""+currentchar.getFinance());
		tv_investigation.setText(""+currentchar.getInvestigation());
		tv_law.setText(""+currentchar.getLaw());
		tv_linguistics.setText(""+currentchar.getLinguistics());
		tv_medicine.setText(""+currentchar.getMedicine());
		tv_occult.setText(""+currentchar.getOccult());
		tv_politics.setText(""+currentchar.getPolitics());
		tv_science.setText(""+currentchar.getScience());
		tv_talentleft.setText(""+TALENT_LEFT);
		tv_skillleft.setText(""+SKILL_LEFT);
		tv_knowledgeleft.setText(""+KNOWLEDGE_LEFT);
	}
	private void initializeFields(Bundle savedInstanceState) {
		sb_acting.setProgress(currentchar.getActing());
		sb_alertness.setProgress(currentchar.getAlertness());
		sb_athletics.setProgress(currentchar.getAthletics());
		sb_brawl.setProgress(currentchar.getBrawl());
		sb_dodge.setProgress(currentchar.getDodge());
		sb_empathy.setProgress(currentchar.getEmpathy());
		sb_intimidation.setProgress(currentchar.getIntimidation());
		sb_leadership.setProgress(currentchar.getLeadership());
		sb_streetwise.setProgress(currentchar.getStreetwise());
		sb_subterfuge.setProgress(currentchar.getSubterfuge());
		sb_animalken.setProgress(currentchar.getAnimalken());
		sb_drive.setProgress(currentchar.getDrive());
		sb_etiquette.setProgress(currentchar.getEtiquette());
		sb_firearms.setProgress(currentchar.getFirearms());
		sb_melee.setProgress(currentchar.getMelee());
		sb_music.setProgress(currentchar.getMusic());
		sb_repair.setProgress(currentchar.getRepair());
		sb_security.setProgress(currentchar.getSecurity());
		sb_stealth.setProgress(currentchar.getStealth());
		sb_survival.setProgress(currentchar.getSurvival());
		sb_bureaucracy.setProgress(currentchar.getBureaucracy());
		sb_computer.setProgress(currentchar.getComputer());
		sb_finance.setProgress(currentchar.getFinance());
		sb_investigation.setProgress(currentchar.getInvestigation());
		sb_law.setProgress(currentchar.getLaw());
		sb_linguistics.setProgress(currentchar.getLinguistics());
		sb_medicine.setProgress(currentchar.getMedicine());
		sb_occult.setProgress(currentchar.getOccult());
		sb_politics.setProgress(currentchar.getPolitics());
		sb_science.setProgress(currentchar.getScience());
		TALENT_LEFT = currentchar.getTalentLeft();
		SKILL_LEFT = currentchar.getSkillLeft();
		KNOWLEDGE_LEFT = currentchar.getKnowledgeLeft();
		
		initializeTextFields();
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
	public void onPause() {
		super.onPause();
		onSaveInstanceState(new Bundle());
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
		try {
			currentchar.setActing(sb_acting.getProgress());
			currentchar.setAlertness(sb_alertness.getProgress());
			currentchar.setAthletics(sb_athletics.getProgress());
			currentchar.setBrawl(sb_brawl.getProgress());
			currentchar.setDodge(sb_dodge.getProgress());
			currentchar.setEmpathy(sb_empathy.getProgress());
			currentchar.setIntimidation(sb_intimidation.getProgress());
			currentchar.setLeadership(sb_leadership.getProgress());
			currentchar.setStreetwise(sb_streetwise.getProgress());
			currentchar.setSubterfuge(sb_subterfuge.getProgress());
			currentchar.setAnimalken(sb_animalken.getProgress());
			currentchar.setDrive(sb_drive.getProgress());
			currentchar.setEtiquette(sb_etiquette.getProgress());
			currentchar.setFirearms(sb_firearms.getProgress());
			currentchar.setMelee(sb_melee.getProgress());
			currentchar.setMusic(sb_music.getProgress());
			currentchar.setRepair(sb_repair.getProgress());
			currentchar.setSecurity(sb_security.getProgress());
			currentchar.setStealth(sb_stealth.getProgress());
			currentchar.setSurvival(sb_survival.getProgress());
			currentchar.setBureaucracy(sb_bureaucracy.getProgress());
			currentchar.setComputer(sb_computer.getProgress());
			currentchar.setFinance(sb_finance.getProgress());
			currentchar.setInvestigation(sb_investigation.getProgress());
			currentchar.setLaw(sb_law.getProgress());
			currentchar.setLinguistics(sb_linguistics.getProgress());
			currentchar.setMedicine(sb_medicine.getProgress());
			currentchar.setOccult(sb_occult.getProgress());
			currentchar.setPolitics(sb_politics.getProgress());
			currentchar.setScience(sb_science.getProgress());
			currentchar.setTalentLeft(TALENT_LEFT);
			currentchar.setSkillLeft(SKILL_LEFT);
			currentchar.setKnowledgeLeft(KNOWLEDGE_LEFT);
		} catch (Exception e) {
			
		}
	}
}