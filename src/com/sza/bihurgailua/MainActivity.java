package com.sza.bihurgailua;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b_monetak;
	Button b_luzera;
	Button b_tenperatura;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b_monetak = (Button) findViewById(R.id.b_monetak);
		b_luzera = (Button) findViewById(R.id.b_luzera);
		b_tenperatura = (Button) findViewById(R.id.b_tenp);

		b_luzera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i_luz = new Intent(getApplicationContext(),
						LuzeraActivity.class);
				startActivity(i_luz);
				finish();
			}
		});
		b_tenperatura.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i_tenp = new Intent(getApplicationContext(),
						TenpActivity.class);
				startActivity(i_tenp);
				finish();
			}
		});
		b_monetak.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i_moneta = new Intent(getApplicationContext(),
						MonetaActivity.class);
				startActivity(i_moneta);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, 1, 0, R.string.ikodea).setIcon(
				android.R.drawable.ic_menu_more);
		menu.add(2, 2, 1, R.string.idata).setIcon(
				android.R.drawable.ic_menu_day);
		menu.add(3, 3, 2, R.string.igaia).setIcon(
				android.R.drawable.ic_menu_search);
		menu.add(4, 4, 3, R.string.idev).setIcon(
				android.R.drawable.ic_menu_info_details);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, R.string.kodea, Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(this, R.string.data, Toast.LENGTH_LONG).show();
			break;
		case 3:
			Toast.makeText(this, R.string.gaia, Toast.LENGTH_LONG).show();
			break;
		case 4:
			Toast.makeText(this, R.string.dev, Toast.LENGTH_LONG).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
