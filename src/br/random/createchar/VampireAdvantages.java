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
import br.random.R;
import br.random.bean.VampireChar;
import br.random.util.Singleton;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireAdvantages extends SherlockFragment {
	
	private VampireChar currentchar;
	private View old;
	
	private int MIN_DISCIPLINE01 = 0;
	private int MAX_DISCIPLINE01 = 5;
	private int MIN_DISCIPLINE02 = 0;
	private int MAX_DISCIPLINE02 = 5;
	private int MIN_DISCIPLINE03 = 0;
	private int MAX_DISCIPLINE03 = 5;
	private int MIN_DISCIPLINE04 = 0;
	private int MAX_DISCIPLINE04 = 5;
	private int MIN_DISCIPLINE05 = 0;
	private int MAX_DISCIPLINE05 = 5;
	private int MIN_BACKGROUND01 = 0;
	private int MAX_BACKGROUND01 = 5;
	private int MIN_BACKGROUND02 = 0;
	private int MAX_BACKGROUND02 = 5;
	private int MIN_BACKGROUND03 = 0;
	private int MAX_BACKGROUND03 = 5;
	private int MIN_BACKGROUND04 = 0;
	private int MAX_BACKGROUND04 = 5;
	private int MIN_BACKGROUND05 = 0;
	private int MAX_BACKGROUND05 = 5;
	private int MIN_CONSCIENCE = 1;
	private int MAX_CONSCIENCE = 5;
	private int MIN_SELFCONTROL = 1;
	private int MAX_SELFCONTROL = 5;
	private int MIN_COURAGE = 1;
	private int MAX_COURAGE = 5;
	private int DISCIPLINE_LEFT = 3;
	private int BACKGROUND_LEFT = 5;
	private int VIRTUE_LEFT = 7;

	private SeekBar sb_discipline01;
	private SeekBar sb_discipline02;
	private SeekBar sb_discipline03;
	private SeekBar sb_discipline04;
	private SeekBar sb_discipline05;
	private SeekBar sb_background01;
	private SeekBar sb_background02;
	private SeekBar sb_background03;
	private SeekBar sb_background04;
	private SeekBar sb_background05;
	private SeekBar sb_conscience;
	private SeekBar sb_selfcontrol;
	private SeekBar sb_courage;
	private TextView tv_discipline01;
	private TextView tv_discipline02;
	private TextView tv_discipline03;
	private TextView tv_discipline04;
	private TextView tv_discipline05;
	private TextView tv_background01;
	private TextView tv_background02;
	private TextView tv_background03;
	private TextView tv_background04;
	private TextView tv_background05;
	private EditText et_discipline01;
	private EditText et_discipline02;
	private EditText et_discipline03;
	private EditText et_discipline04;
	private EditText et_discipline05;
	private EditText et_background01;
	private EditText et_background02;
	private EditText et_background03;
	private EditText et_background04;
	private EditText et_background05;
	private TextView tv_conscience;
	private TextView tv_selfcontrol;
	private TextView tv_courage;
	private TextView tv_disciplineleft;
	private TextView tv_backgroundleft;
	private TextView tv_virtueleft;
	
	public static VampireAdvantages newInstance() {
		VampireAdvantages frag=new VampireAdvantages();
		frag.old = null;
		return(frag);
	}
	public static String getTitle() {
		return "Vantagens";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) return null;
		View result;
		if (old != null) {
			((FrameLayout)old.getParent()).removeView(old);
			result = old;
		} else {
			result=inflater.inflate(R.layout.vampire_advantages, container, false);
			old = result;
		}
		Singleton singleton = Singleton.getInstance(getActivity().getApplicationContext());
		currentchar = (VampireChar)singleton.getChar();
		DISCIPLINE_LEFT = currentchar.getDisciplineLeft();
		BACKGROUND_LEFT = currentchar.getBackgroundLeft();
		VIRTUE_LEFT = currentchar.getVirtueLeft();
		
		findViews(result);
		setEvents();
		initializeFields(savedInstanceState);
		
		return(result);
	}
	private void initializeTextFields() {
		tv_discipline01.setText(""+currentchar.getDiscipline1val());
		tv_discipline02.setText(""+currentchar.getDiscipline2val());
		tv_discipline03.setText(""+currentchar.getDiscipline3val());
		tv_discipline04.setText(""+currentchar.getDiscipline4val());
		tv_discipline05.setText(""+currentchar.getDiscipline5val());
		tv_background01.setText(""+currentchar.getBackground1val());
		tv_background02.setText(""+currentchar.getBackground2val());
		tv_background03.setText(""+currentchar.getBackground3val());
		tv_background04.setText(""+currentchar.getBackground4val());
		tv_background05.setText(""+currentchar.getBackground5val());
		et_discipline01.setText(currentchar.getDiscipline1());
		et_discipline02.setText(currentchar.getDiscipline2());
		et_discipline03.setText(currentchar.getDiscipline3());
		et_discipline04.setText(currentchar.getDiscipline4());
		et_discipline05.setText(currentchar.getDiscipline5());
		et_background01.setText(currentchar.getBackground1());
		et_background02.setText(currentchar.getBackground2());
		et_background03.setText(currentchar.getBackground3());
		et_background04.setText(currentchar.getBackground4());
		et_background05.setText(currentchar.getBackground5());
		tv_conscience.setText(""+currentchar.getConscience());
		tv_selfcontrol.setText(""+currentchar.getSelfcontrol());
		tv_courage.setText(""+currentchar.getCourage());
		tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
		tv_backgroundleft.setText(""+BACKGROUND_LEFT);
		tv_virtueleft.setText(""+VIRTUE_LEFT);
	}
	private void initializeFields(Bundle savedInstanceState) {
		sb_discipline01.setProgress(currentchar.getDiscipline1val());
		sb_discipline02.setProgress(currentchar.getDiscipline2val());
		sb_discipline03.setProgress(currentchar.getDiscipline3val());
		sb_discipline04.setProgress(currentchar.getDiscipline4val());
		sb_discipline05.setProgress(currentchar.getDiscipline5val());
		sb_background01.setProgress(currentchar.getBackground1val());
		sb_background02.setProgress(currentchar.getBackground2val());
		sb_background03.setProgress(currentchar.getBackground3val());
		sb_background04.setProgress(currentchar.getBackground4val());
		sb_background05.setProgress(currentchar.getBackground5val());
		sb_conscience.setProgress(currentchar.getConscience());
		sb_selfcontrol.setProgress(currentchar.getSelfcontrol());
		sb_courage.setProgress(currentchar.getCourage());
		DISCIPLINE_LEFT = currentchar.getDisciplineLeft();
		BACKGROUND_LEFT = currentchar.getBackgroundLeft();
		VIRTUE_LEFT = currentchar.getVirtueLeft();
	
		initializeTextFields();
	}
	private void setEvents() {
		sb_discipline01.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (DISCIPLINE_LEFT > 0 && old < MAX_DISCIPLINE01) {
							old++;
							seekBar.setProgress(old);
							tv_discipline01.setText(""+old);
							DISCIPLINE_LEFT--;
							tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DISCIPLINE01) {
								old--;
								seekBar.setProgress(old);
								tv_discipline01.setText(""+old);
								DISCIPLINE_LEFT++;
								tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_discipline02.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (DISCIPLINE_LEFT > 0 && old < MAX_DISCIPLINE02) {
							old++;
							seekBar.setProgress(old);
							tv_discipline02.setText(""+old);
							DISCIPLINE_LEFT--;
							tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DISCIPLINE02) {
								old--;
								seekBar.setProgress(old);
								tv_discipline02.setText(""+old);
								DISCIPLINE_LEFT++;
								tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_discipline03.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (DISCIPLINE_LEFT > 0 && old < MAX_DISCIPLINE03) {
							old++;
							seekBar.setProgress(old);
							tv_discipline03.setText(""+old);
							DISCIPLINE_LEFT--;
							tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DISCIPLINE03) {
								old--;
								seekBar.setProgress(old);
								tv_discipline03.setText(""+old);
								DISCIPLINE_LEFT++;
								tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_discipline04.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (DISCIPLINE_LEFT > 0 && old < MAX_DISCIPLINE04) {
							old++;
							seekBar.setProgress(old);
							tv_discipline04.setText(""+old);
							DISCIPLINE_LEFT--;
							tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DISCIPLINE04) {
								old--;
								seekBar.setProgress(old);
								tv_discipline04.setText(""+old);
								DISCIPLINE_LEFT++;
								tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_discipline05.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (DISCIPLINE_LEFT > 0 && old < MAX_DISCIPLINE05) {
							old++;
							seekBar.setProgress(old);
							tv_discipline05.setText(""+old);
							DISCIPLINE_LEFT--;
							tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_DISCIPLINE05) {
								old--;
								seekBar.setProgress(old);
								tv_discipline05.setText(""+old);
								DISCIPLINE_LEFT++;
								tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_background01.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (BACKGROUND_LEFT > 0 && old < MAX_BACKGROUND01) {
							old++;
							seekBar.setProgress(old);
							tv_background01.setText(""+old);
							BACKGROUND_LEFT--;
							tv_backgroundleft.setText(""+BACKGROUND_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BACKGROUND01) {
								old--;
								seekBar.setProgress(old);
								tv_background01.setText(""+old);
								BACKGROUND_LEFT++;
								tv_backgroundleft.setText(""+BACKGROUND_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_background02.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (BACKGROUND_LEFT > 0 && old < MAX_BACKGROUND02) {
							old++;
							seekBar.setProgress(old);
							tv_background02.setText(""+old);
							BACKGROUND_LEFT--;
							tv_backgroundleft.setText(""+BACKGROUND_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BACKGROUND02) {
								old--;
								seekBar.setProgress(old);
								tv_background02.setText(""+old);
								BACKGROUND_LEFT++;
								tv_backgroundleft.setText(""+BACKGROUND_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_background03.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (BACKGROUND_LEFT > 0 && old < MAX_BACKGROUND03) {
							old++;
							seekBar.setProgress(old);
							tv_background03.setText(""+old);
							BACKGROUND_LEFT--;
							tv_backgroundleft.setText(""+BACKGROUND_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BACKGROUND03) {
								old--;
								seekBar.setProgress(old);
								tv_background03.setText(""+old);
								BACKGROUND_LEFT++;
								tv_backgroundleft.setText(""+BACKGROUND_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_background04.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (BACKGROUND_LEFT > 0 && old < MAX_BACKGROUND04) {
							old++;
							seekBar.setProgress(old);
							tv_background04.setText(""+old);
							BACKGROUND_LEFT--;
							tv_backgroundleft.setText(""+BACKGROUND_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BACKGROUND04) {
								old--;
								seekBar.setProgress(old);
								tv_background04.setText(""+old);
								BACKGROUND_LEFT++;
								tv_backgroundleft.setText(""+BACKGROUND_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_background05.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (BACKGROUND_LEFT > 0 && old < MAX_BACKGROUND05) {
							old++;
							seekBar.setProgress(old);
							tv_background05.setText(""+old);
							BACKGROUND_LEFT--;
							tv_backgroundleft.setText(""+BACKGROUND_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_BACKGROUND05) {
								old--;
								seekBar.setProgress(old);
								tv_background05.setText(""+old);
								BACKGROUND_LEFT++;
								tv_backgroundleft.setText(""+BACKGROUND_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_conscience.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (VIRTUE_LEFT > 0 && old < MAX_CONSCIENCE) {
							old++;
							seekBar.setProgress(old);
							tv_conscience.setText(""+old);
							VIRTUE_LEFT--;
							tv_virtueleft.setText(""+VIRTUE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_CONSCIENCE) {
								old--;
								seekBar.setProgress(old);
								tv_conscience.setText(""+old);
								VIRTUE_LEFT++;
								tv_virtueleft.setText(""+VIRTUE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_selfcontrol.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (VIRTUE_LEFT > 0 && old < MAX_SELFCONTROL) {
							old++;
							seekBar.setProgress(old);
							tv_selfcontrol.setText(""+old);
							VIRTUE_LEFT--;
							tv_virtueleft.setText(""+VIRTUE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_SELFCONTROL) {
								old--;
								seekBar.setProgress(old);
								tv_selfcontrol.setText(""+old);
								VIRTUE_LEFT++;
								tv_virtueleft.setText(""+VIRTUE_LEFT);
							} else {
								seekBar.setProgress(old);
							}
						}
					}
				}
			}
		});
		sb_courage.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			private int old = 0;
			public void onStopTrackingTouch(SeekBar seekBar) { }
			public void onStartTrackingTouch(SeekBar seekBar) {
				old = seekBar.getProgress();
			}
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if (fromUser) {
					if (progress > old) {
						if (VIRTUE_LEFT > 0 && old < MAX_COURAGE) {
							old++;
							seekBar.setProgress(old);
							tv_courage.setText(""+old);
							VIRTUE_LEFT--;
							tv_virtueleft.setText(""+VIRTUE_LEFT);
						} else {
							seekBar.setProgress(old);
						}
					} else {
						if (progress < old) {
							if (old > MIN_COURAGE) {
								old--;
								seekBar.setProgress(old);
								tv_courage.setText(""+old);
								VIRTUE_LEFT++;
								tv_virtueleft.setText(""+VIRTUE_LEFT);
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
		sb_discipline01 = (SeekBar)result.findViewById(R.id.sb_discipline01);
		sb_discipline02 = (SeekBar)result.findViewById(R.id.sb_discipline02);
		sb_discipline03 = (SeekBar)result.findViewById(R.id.sb_discipline03);
		sb_discipline04 = (SeekBar)result.findViewById(R.id.sb_discipline04);
		sb_discipline05 = (SeekBar)result.findViewById(R.id.sb_discipline05);
		sb_background01 = (SeekBar)result.findViewById(R.id.sb_background01);
		sb_background02 = (SeekBar)result.findViewById(R.id.sb_background02);
		sb_background03 = (SeekBar)result.findViewById(R.id.sb_background03);
		sb_background04 = (SeekBar)result.findViewById(R.id.sb_background04);
		sb_background05 = (SeekBar)result.findViewById(R.id.sb_background05);
		sb_conscience = (SeekBar)result.findViewById(R.id.sb_conscience);
		sb_selfcontrol = (SeekBar)result.findViewById(R.id.sb_selfcontrol);
		sb_courage = (SeekBar)result.findViewById(R.id.sb_courage);
		et_discipline01 = (EditText)result.findViewById(R.id.et_discipline01);
		et_discipline02 = (EditText)result.findViewById(R.id.et_discipline02);
		et_discipline03 = (EditText)result.findViewById(R.id.et_discipline03);
		et_discipline04 = (EditText)result.findViewById(R.id.et_discipline04);
		et_discipline05 = (EditText)result.findViewById(R.id.et_discipline05);
		et_background01 = (EditText)result.findViewById(R.id.et_background01);
		et_background02 = (EditText)result.findViewById(R.id.et_background02);
		et_background03 = (EditText)result.findViewById(R.id.et_background03);
		et_background04 = (EditText)result.findViewById(R.id.et_background04);
		et_background05 = (EditText)result.findViewById(R.id.et_background05);
		tv_discipline01 = (TextView)result.findViewById(R.id.tv_discipline01);
		tv_discipline02 = (TextView)result.findViewById(R.id.tv_discipline02);
		tv_discipline03 = (TextView)result.findViewById(R.id.tv_discipline03);
		tv_discipline04 = (TextView)result.findViewById(R.id.tv_discipline04);
		tv_discipline05 = (TextView)result.findViewById(R.id.tv_discipline05);
		tv_background01 = (TextView)result.findViewById(R.id.tv_background01);
		tv_background02 = (TextView)result.findViewById(R.id.tv_background02);
		tv_background03 = (TextView)result.findViewById(R.id.tv_background03);
		tv_background04 = (TextView)result.findViewById(R.id.tv_background04);
		tv_background05 = (TextView)result.findViewById(R.id.tv_background05);
		tv_conscience = (TextView)result.findViewById(R.id.tv_conscience);
		tv_selfcontrol = (TextView)result.findViewById(R.id.tv_selfcontrol);
		tv_courage = (TextView)result.findViewById(R.id.tv_courage);
		tv_disciplineleft = (TextView)result.findViewById(R.id.tv_disciplineleft);
		tv_backgroundleft = (TextView)result.findViewById(R.id.tv_backgroundleft);
		tv_virtueleft = (TextView)result.findViewById(R.id.tv_virtueleft);
	}
	@Override
	public void onResume() {
		super.onResume();
		et_discipline01.setText(currentchar.getDiscipline1());
		et_discipline02.setText(currentchar.getDiscipline2());
		et_discipline03.setText(currentchar.getDiscipline3());
	}
	@Override
	public void onPause() {
		super.onPause();
		onSaveInstanceState(new Bundle());
	}
	@Override
	public void onSaveInstanceState(Bundle icicle) {
		try {
			currentchar.setDiscipline1val(sb_discipline01.getProgress());
			currentchar.setDiscipline2val(sb_discipline02.getProgress());
			currentchar.setDiscipline3val(sb_discipline03.getProgress());
			currentchar.setDiscipline4val(sb_discipline04.getProgress());
			currentchar.setDiscipline5val(sb_discipline05.getProgress());
			currentchar.setBackground1val(sb_background01.getProgress());
			currentchar.setBackground2val(sb_background02.getProgress());
			currentchar.setBackground3val(sb_background03.getProgress());
			currentchar.setBackground4val(sb_background04.getProgress());
			currentchar.setBackground5val(sb_background05.getProgress());
			currentchar.setDiscipline1(et_discipline01.getText().toString());
			currentchar.setDiscipline2(et_discipline02.getText().toString());
			currentchar.setDiscipline3(et_discipline03.getText().toString());
			currentchar.setDiscipline4(et_discipline04.getText().toString());
			currentchar.setDiscipline5(et_discipline05.getText().toString());
			currentchar.setBackground1(et_background01.getText().toString());
			currentchar.setBackground2(et_background02.getText().toString());
			currentchar.setBackground3(et_background03.getText().toString());
			currentchar.setBackground4(et_background04.getText().toString());
			currentchar.setBackground5(et_background05.getText().toString());
			currentchar.setConscience(sb_conscience.getProgress());
			currentchar.setSelfcontrol(sb_selfcontrol.getProgress());
			currentchar.setCourage(sb_courage.getProgress());
			currentchar.setDisciplineLeft(DISCIPLINE_LEFT);
			currentchar.setBackgroundLeft(BACKGROUND_LEFT);
			currentchar.setVirtueLeft(VIRTUE_LEFT);
		} catch (Exception e) {
			
		}
	}
}