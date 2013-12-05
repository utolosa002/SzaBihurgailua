package com.sza.bihurgailua;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LuzeraActivity extends Activity {
	EditText et_sarrera;
	TextView et_emaitza;
	String sp_1 = "km";
	String sp_2 = "km";
	String emaitza1="1.0";
	Button b_itzuli;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_luzera);
	    et_sarrera = (EditText) findViewById(R.id.et_sarrera);
	    final TextView et_emaitza = (TextView) findViewById(R.id.tv_emaitza);
		b_itzuli = (Button) findViewById(R.id.b_itzuli);
		et_sarrera.setText("1.0");

		/**
		 * itzuli bottoia
		 */
		b_itzuli.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		
		/**
		 * EditText-a
		 */
		et_sarrera.addTextChangedListener(new TextWatcher() {
			 
			   public void afterTextChanged(Editable s) {
				   emaitza1=kalkulatu();
					et_emaitza.setText(emaitza1);
			   }
			 
			   public void beforeTextChanged(CharSequence s, int start, 
			     int count, int after) {
			   }
			 
			   public void onTextChanged(CharSequence s, int start, 
			     int before, int count) {
				   emaitza1=kalkulatu();
					et_emaitza.setText(emaitza1);
			   }
			  });
	
		/**
		 * spinner hautatzaile
		 */

		final Spinner s1 = (Spinner) findViewById(R.id.spinner_hautatzaile);
		ArrayAdapter<?> adapter1 = ArrayAdapter.createFromResource(this,
				R.array.luzera, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(adapter1);

		s1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				sp_1 = s1.getItemAtPosition(position).toString();
				emaitza1=kalkulatu();
				et_emaitza.setText(emaitza1);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/**
		 * spinner emaitza
		 * 
		 */

		final Spinner s2 = (Spinner) findViewById(R.id.spinner_emaitza);
		ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this,
				R.array.luzera, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(adapter2);

		s2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				sp_2 = s2.getItemAtPosition(position).toString();
				emaitza1=kalkulatu();
				et_emaitza.setText(emaitza1);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}

	public String kalkulatu() {
		// TODO Auto-generated method stub
		String emaitza = "";
		Double d = 0.0;
		try{
			d = Double.parseDouble(et_sarrera.getText().toString());
		} catch (NumberFormatException e) {
			et_sarrera.setText("0");
		}
		if (sp_1.compareTo("m")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza=String.valueOf(d / 1000.0);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d * 100.0);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d / 1000.0);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d / 1609.344);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d / 0.0254);
			}
		}else if (sp_1.compareTo("km")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza = String.valueOf(d);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d * 1000.0);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d * 100000.0);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d * 1000000.0);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d / 1.609344);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d /  0.0000254);
			}
		}else if (sp_1.compareTo("cm")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza = String.valueOf(d/ 100000.0);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d / 100.0);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d * 10.0);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d/160934.4);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d/ 2.54);
			}
		}else if (sp_1.compareTo("mm")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza = String.valueOf(d / 1000000.0);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d/1000.0);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d/ 10.0);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d / 1609344);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d / 25.4);
			}
		}else if (sp_1.compareTo("ml")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza = String.valueOf(d * 1.609344);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d*1609.344);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d* 160934.4);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d * 1609344);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d / 0.000015782828);
			}
		}else if (sp_1.compareTo("inch")==0) {
			if (sp_2.compareTo("km")==0) {
				emaitza = String.valueOf(d * 0.0000254);
			}else if (sp_2.compareTo("m")==0) {
				emaitza = String.valueOf(d*0.0254);
			}else if (sp_2.compareTo("cm")==0) {
				emaitza = String.valueOf(d*2.54);
			}else if (sp_2.compareTo("mm")==0) {
				emaitza = String.valueOf(d*25.4);
			}else if (sp_2.compareTo("ml")==0) {
				emaitza = String.valueOf(d*0.000015782828);
			}else if (sp_2.compareTo("inch")==0) {
				emaitza = String.valueOf(d);
			}
		}
		return emaitza;
	}
	/**
	 * Atzera botoia
	 */
	@Override
	public void onBackPressed() {
		Intent i = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i);
		finish();
	}
}