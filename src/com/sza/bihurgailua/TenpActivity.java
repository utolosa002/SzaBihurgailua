package com.sza.bihurgailua;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TenpActivity extends Activity {
	EditText et_cels;
	EditText et_far;
	Button b_itzuli;
	boolean aldatuberria=false;
	boolean aldaketa=true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tenp);
		et_cels = (EditText) findViewById(R.id.et_cels);
		et_far = (EditText) findViewById(R.id.et_far);
		b_itzuli = (Button) findViewById(R.id.b_itzuli);

		et_cels.setText("37.777");
		et_far.setText("100");

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
		 * EditText cels-a
		 */

		et_cels.addTextChangedListener(new TextWatcher() {
			 
			   public void afterTextChanged(Editable s) {
			   }
			 
			   public void beforeTextChanged(CharSequence s, int start, 
			     int count, int after) {
				   if (aldatuberria){
					   aldatuberria=false;
					   aldaketa=false;
				   }else{
					   aldaketa=true;
				   }
			   }
			 
			   public void onTextChanged(CharSequence s, int start, int before, int count) {
				   if (et_cels.length() > 0 && et_cels.getText().toString() != "."&&aldaketa==true) {
						double cZaha = 0;
						try {
							cZaha = Double
									.parseDouble(et_cels.getText().toString());
						} catch (NumberFormatException e) {
							et_cels.setText("0");
						}
						double F = (1.8) * cZaha + 32;
						aldatuberria=true;
						et_far.setText(String.valueOf(F));
						
				   }
			   }
			});
		

		/**
		 * EditText- far
		 */

		et_far.addTextChangedListener(new TextWatcher() {
			 
			   public void afterTextChanged(Editable s) {
			   }
			 
			   public void beforeTextChanged(CharSequence s, int start, 
			     int count, int after) {
				   if (aldatuberria){
					   aldatuberria=false;
					   aldaketa=false;
				   }else{
					   aldaketa=true;
				   }
			   }
			 
			   public void onTextChanged(CharSequence s, int start, int before, int count) {
				   if (et_far.length() > 0 && aldaketa==true) {
						double cFar = 0;
						try {
							cFar = Double.parseDouble(et_far.getText().toString());
						} catch (NumberFormatException e) {
							et_far.setText("0");
						}
						double C = (cFar - 32) / 1.8;
						aldatuberria=true;
						et_cels.setText(String.valueOf(C));
						
				   }
			   }
			});
	}
	
/**
 * 	Atzera botoia;
 */
	@Override
	public void onBackPressed() {
		Intent i_main = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i_main);
		finish();
	}
}