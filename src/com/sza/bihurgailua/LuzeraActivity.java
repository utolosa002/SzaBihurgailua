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
	String st_in = "km";
	String st_out = "km";
	String st_emaitza = "1.0";
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
				Intent i_itzuli = new Intent(v.getContext(), MainActivity.class);
				startActivity(i_itzuli);
				finish();
			}
		});

		/**
		 * EditText-a
		 */
		et_sarrera.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
				st_emaitza = kalkulatu();
				et_emaitza.setText(st_emaitza);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				st_emaitza = kalkulatu();
				et_emaitza.setText(st_emaitza);
			}
		});

		/**
		 * spinner hautatzaile
		 */

		final Spinner sp_in = (Spinner) findViewById(R.id.spinner_hautatzaile);
		ArrayAdapter<?> adapter_in = ArrayAdapter.createFromResource(this,
				R.array.luzera, android.R.layout.simple_spinner_item);
		adapter_in
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_in.setAdapter(adapter_in);

		sp_in.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				st_in = sp_in.getItemAtPosition(position).toString();
				st_emaitza = kalkulatu();
				et_emaitza.setText(st_emaitza);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/**
		 * spinner emaitza
		 * 
		 */

		final Spinner sp_out = (Spinner) findViewById(R.id.spinner_emaitza);
		ArrayAdapter<?> adapter_out = ArrayAdapter.createFromResource(this,
				R.array.luzera, android.R.layout.simple_spinner_item);
		adapter_out
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_out.setAdapter(adapter_out);

		sp_out.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				st_out = sp_out.getItemAtPosition(position).toString();
				st_emaitza = kalkulatu();
				et_emaitza.setText(st_emaitza);
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
		try {
			d = Double.parseDouble(et_sarrera.getText().toString());
		} catch (NumberFormatException e) {
			et_sarrera.setText("0");
		}
		if (st_in.compareTo("m") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d / 1000.0);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d * 100.0);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d / 1000.0);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d / 1609.344);
			} else if (st_out.compareTo("inch") == 0) {
				emaitza = String.valueOf(d / 0.0254);
			}
		} else if (st_in.compareTo("km") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d * 1000.0);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d * 100000.0);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d * 1000000.0);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d / 1.609344);
			} else if (st_out.compareTo("inch") == 0) {
				emaitza = String.valueOf(d / 0.0000254);
			}
		} else if (st_in.compareTo("cm") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d / 100000.0);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d / 100.0);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d * 10.0);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d / 160934.4);
			} else if (st_out.compareTo("inch") == 0) {
				emaitza = String.valueOf(d / 2.54);
			}
		} else if (st_in.compareTo("mm") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d / 1000000.0);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d / 1000.0);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d / 10.0);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d / 1609344);
			} else if (st_out.compareTo("inch") == 0) {
				emaitza = String.valueOf(d / 25.4);
			}
		} else if (st_in.compareTo("ml") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d * 1.609344);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d * 1609.344);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d * 160934.4);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d * 1609344);
			} else if (st_out.compareTo("inch") == 0) {
				emaitza = String.valueOf(d / 0.000015782828);
			}
		} else if (st_in.compareTo("inch") == 0) {
			if (st_out.compareTo("km") == 0) {
				emaitza = String.valueOf(d * 0.0000254);
			} else if (st_out.compareTo("m") == 0) {
				emaitza = String.valueOf(d * 0.0254);
			} else if (st_out.compareTo("cm") == 0) {
				emaitza = String.valueOf(d * 2.54);
			} else if (st_out.compareTo("mm") == 0) {
				emaitza = String.valueOf(d * 25.4);
			} else if (st_out.compareTo("ml") == 0) {
				emaitza = String.valueOf(d * 0.000015782828);
			} else if (st_out.compareTo("inch") == 0) {
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