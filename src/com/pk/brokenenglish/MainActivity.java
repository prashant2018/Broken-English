package com.pk.brokenenglish;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AdView adView = (AdView)this.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
		   .build();
		adView.loadAd(adRequest);
	}
public void game(View view)
{
	i=new Intent(this,Play.class);
	startActivity(i);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void info(View view)
	{
		Intent i=new Intent(this,Info.class);
		startActivity(i);
	}
	public void rate(View view)
	{
		Intent intent = new Intent();
	    intent.setAction(Intent.ACTION_VIEW);
	    intent.addCategory(Intent.CATEGORY_BROWSABLE);
	    intent.setData(Uri.parse("http://about.me/pk.jsr30"));
	    startActivity(intent);
	}
	public void share(View view)
	{
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Can You Beat My Score ? Play \"Broken English\" . Download : ");
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
	}
	@Override
	public void onBackPressed ()
	{       
	    Intent intent = new Intent(Intent.ACTION_MAIN);
	    intent.addCategory(Intent.CATEGORY_HOME);
	    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
