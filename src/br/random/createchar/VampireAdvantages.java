package br.random.createchar;

import br.random.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class VampireAdvantages extends SherlockFragment {
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
	private TextView tv_conscience;
	private TextView tv_selfcontrol;
	private TextView tv_courage;
	private TextView tv_disciplineleft;
	private TextView tv_backgroundleft;
	private TextView tv_virtueleft;
	
	public static VampireAdvantages newInstance() {
		VampireAdvantages frag=new VampireAdvantages();
		return(frag);
	}
	public static String getTitle() {
		return "Vantagens";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result=inflater.inflate(R.layout.vampire_advantages, container, false);
		
		findViews(result);
		setEvents();
		initializeFromBundle(savedInstanceState);
		initializeTextFields();

	    return(result);
	}
	private void initializeTextFields() {
		tv_discipline01.setText(""+sb_discipline01.getProgress());
		tv_discipline02.setText(""+sb_discipline02.getProgress());
		tv_discipline03.setText(""+sb_discipline03.getProgress());
		tv_discipline04.setText(""+sb_discipline04.getProgress());
		tv_discipline05.setText(""+sb_discipline05.getProgress());
		tv_background01.setText(""+sb_background01.getProgress());
		tv_background02.setText(""+sb_background02.getProgress());
		tv_background03.setText(""+sb_background03.getProgress());
		tv_background04.setText(""+sb_background04.getProgress());
		tv_background05.setText(""+sb_background05.getProgress());
		tv_conscience.setText(""+sb_conscience.getProgress());
		tv_selfcontrol.setText(""+sb_selfcontrol.getProgress());
		tv_courage.setText(""+sb_courage.getProgress());
		tv_disciplineleft.setText(""+DISCIPLINE_LEFT);
		tv_backgroundleft.setText(""+BACKGROUND_LEFT);
		tv_virtueleft.setText(""+VIRTUE_LEFT);
	}
	private void initializeFromBundle(Bundle savedInstanceState) {
		try {
			sb_discipline01.setProgress(savedInstanceState.getInt("d01"));
		} catch (Exception e) {
			sb_discipline01.setProgress(MIN_DISCIPLINE01);
		}
		try {
			sb_discipline02.setProgress(savedInstanceState.getInt("d02"));
		} catch (Exception e) {
			sb_discipline02.setProgress(MIN_DISCIPLINE02);
		}
		try {
			sb_discipline03.setProgress(savedInstanceState.getInt("d03"));
		} catch (Exception e) {
			sb_discipline03.setProgress(MIN_DISCIPLINE03);
		}
		try {
			sb_discipline04.setProgress(savedInstanceState.getInt("d04"));
		} catch (Exception e) {
			sb_discipline04.setProgress(MIN_DISCIPLINE04);
		}
		try {
			sb_discipline05.setProgress(savedInstanceState.getInt("d05"));
		} catch (Exception e) {
			sb_discipline05.setProgress(MIN_DISCIPLINE05);
		}
		try {
			sb_background01.setProgress(savedInstanceState.getInt("b01"));
		} catch (Exception e) {
			sb_background01.setProgress(MIN_BACKGROUND01);
		}
		try {
			sb_background02.setProgress(savedInstanceState.getInt("b02"));
		} catch (Exception e) {
			sb_background02.setProgress(MIN_BACKGROUND02);
		}
		try {
			sb_background03.setProgress(savedInstanceState.getInt("b03"));
		} catch (Exception e) {
			sb_background03.setProgress(MIN_BACKGROUND03);
		}
		try {
			sb_background04.setProgress(savedInstanceState.getInt("b04"));
		} catch (Exception e) {
			sb_background04.setProgress(MIN_BACKGROUND04);
		}
		try {
			sb_background05.setProgress(savedInstanceState.getInt("b05"));
		} catch (Exception e) {
			sb_background05.setProgress(MIN_BACKGROUND05);
		}
		try {
			sb_conscience.setProgress(savedInstanceState.getInt("con"));
		} catch (Exception e) {
			sb_conscience.setProgress(MIN_CONSCIENCE);
		}
		try {
			sb_selfcontrol.setProgress(savedInstanceState.getInt("sel"));
		} catch (Exception e) {
			sb_selfcontrol.setProgress(MIN_SELFCONTROL);
		}
		try {
			sb_courage.setProgress(savedInstanceState.getInt("cou"));
		} catch (Exception e) {
			sb_courage.setProgress(MIN_COURAGE);
		}

		try {
			DISCIPLINE_LEFT = savedInstanceState.getInt("dis");
		} catch (Exception e) { }
		try {
			BACKGROUND_LEFT = savedInstanceState.getInt("bac");
		} catch (Exception e) { }
		try {
			VIRTUE_LEFT = savedInstanceState.getInt("vir");
		} catch (Exception e) { }
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
	public void onSaveInstanceState(Bundle icicle) {
		try {
	    	icicle.putInt("d01", sb_discipline01.getProgress());
	    	icicle.putInt("d02", sb_discipline02.getProgress());
	    	icicle.putInt("d03", sb_discipline03.getProgress());
	    	icicle.putInt("d04", sb_discipline04.getProgress());
	    	icicle.putInt("d05", sb_discipline05.getProgress());
	    	icicle.putInt("b01", sb_background01.getProgress());
	    	icicle.putInt("b02", sb_background02.getProgress());
	    	icicle.putInt("b03", sb_background03.getProgress());
	    	icicle.putInt("b04", sb_background04.getProgress());
	    	icicle.putInt("b05", sb_background05.getProgress());
	    	icicle.putInt("con", sb_conscience.getProgress());
	    	icicle.putInt("sel", sb_selfcontrol.getProgress());
	    	icicle.putInt("cou", sb_courage.getProgress());
	    	icicle.putInt("dis", DISCIPLINE_LEFT);
	    	icicle.putInt("bac", BACKGROUND_LEFT);
	    	icicle.putInt("vir", VIRTUE_LEFT);
		} catch (Exception e) {
			
		}
	}
}