package com.sza.bihurgailua;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MonetaActivity extends Activity {
	Button b_monetak;

	EditText et_sarrera;
	TextView et_emaitza;
	String st_in = "€";
	String st_out = "€";
	String st_emaitza = "1.0";
	Button b_itzuli;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moneta);
		et_sarrera = (EditText) findViewById(R.id.et_sarrera);
		final TextView et_emaitza = (TextView) findViewById(R.id.tv_emaitza);

		b_itzuli = (Button) findViewById(R.id.b_itzuli);

		et_sarrera.setText("1.0");

		/**
		 * itzuli botoia
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
		ArrayAdapter<?> adapter1 = ArrayAdapter.createFromResource(this,
				R.array.moneta, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_in.setAdapter(adapter1);

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
		ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this,
				R.array.moneta, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_out.setAdapter(adapter2);

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
		if (st_in.compareTo("€") == 0) {
			if (st_out.compareTo("$") == 0) {
				emaitza = String.valueOf(d * 1.3589);
			} else if (st_out.compareTo("€") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("£") == 0) {
				emaitza = String.valueOf(d * 0.82981192);
			}
		} else if (st_in.compareTo("$") == 0) {
			if (st_out.compareTo("$") == 0) {
				emaitza = String.valueOf(d);
			} else if (st_out.compareTo("€") == 0) {
				emaitza = String.valueOf(d * 0.735889322);
			} else if (st_out.compareTo("£") == 0) {
				emaitza = String.valueOf(d * 0.610649731);
			}
		} else if (st_in.compareTo("£") == 0) {
			if (st_out.compareTo("$") == 0) {
				emaitza = String.valueOf(d * 1.6376);
			} else if (st_out.compareTo("€") == 0) {
				emaitza = String.valueOf(d / 1.20509235);
			} else if (st_out.compareTo("£") == 0) {
				emaitza = String.valueOf(d);
			}
		}
		return emaitza;
	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i);
		finish();
	}
}