package com.pk.brokenenglish;




import java.util.Random;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class Play extends ActionBarActivity {

TextView tv,tv1,tv2,sc;
words word;
String p;
int no[],score;
static int high=0,inert=0;
int c,temp;
Vibrator v;
private Scene scene1, scene2;
private Transition transition;
LinearLayout drop_layout;
ObjectAnimator animation;
Animation slidel;
ProgressBar pb;
MediaPlayer mp;
Button yesbut,nobut;
String MyPREFERENCES="high_score";
public PublisherInterstitialAd interstitial;
public PublisherAdRequest adRequestI;
//SharedPreferences.Editor  editor;
//SharedPreferences sharedpreferences,prefs;
Drawable drawable;
RelativeLayout bg;
Random back;
Boolean sl,s;
static String colors[]={"#315da0","#e03458","#6c6567","#27c4c6","#da034f","#893b67","#657ebc","#315da0"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		AdView adView = (AdView)this.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
		   .build();
		adView.loadAd(adRequest);
		
		interstitial = new PublisherInterstitialAd(this);
		interstitial.setAdUnitId("ca-app-pub-7166295480563138/3626215601");
		adRequestI = new PublisherAdRequest.Builder().build();
		interstitial.loadAd(adRequestI);
		
		
		SharedPreferences pre = getSharedPreferences("mynew", MODE_PRIVATE); 
		inert=pre.getInt("ads", inert);
		SharedPreferences shared = getSharedPreferences("mynew", Context.MODE_PRIVATE);
		Editor editors = shared.edit();
        if(inert==201)
        	inert=0;
        //for ads
        inert++;
		editors.putInt("ads", inert);
		editors.commit();
		
       	Typeface face = Typeface.createFromAsset(getAssets(),"font1.ttf");
		back=new Random();
		sl=false;
	    bg=(RelativeLayout)findViewById(R.id.base);
	   
	    int ran = back.nextInt(7-1)+1+1;
	    Log.v("color",""+ran);
	    bg.getBackground().setColorFilter(Color.parseColor(colors[ran]), PorterDuff.Mode.SRC);
		s=false;
		word=new words();
		tv = (TextView)findViewById(R.id.textView1);
		sc = (TextView)findViewById(R.id.textView2);
		tv.setTypeface(face);
		sc.setTypeface(face);
		drop_layout = (LinearLayout)findViewById(R.id.drop);
		yesbut=(Button)findViewById(R.id.yesbut);
		nobut=(Button)findViewById(R.id.nobut);
		tv1=(TextView)findViewById(R.id.tv11);
		tv2=(TextView)findViewById(R.id.tv22);
			
		 pb=(ProgressBar)findViewById(R.id.progressbar);
		 mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
		       Resources res = getResources();
			   Drawable drawable = res.getDrawable(R.drawable.background);
			   pb.setProgress(2500);   // Main Progress
			   pb.setSecondaryProgress(5000);// Secondary Progress
			   pb.setMax(10000);
			   
			   pb.setProgressDrawable(drawable);
			   animation = ObjectAnimator.ofInt(pb, "progress",10000,5000,2500,0);
			   animation.setDuration(1100);
		   	   pb.setProgress(10000);
			   slidel = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
	  
		call();
		repeat();
		
	}
	
public void call()
{   
	int backnum=back.nextInt(7);
	//bg.setBackgroundColor(colors[backnum]);
	word.shuffle();
	 c=0;
}
public void repeat()
{
	
	
	if(c==(word.len))
		tv.setText("winner");
	else
	{
		
	 temp=word.num[c];
	 p=word.s[temp];
	 tv.setText(p);
	 sc.setText(""+c);
	 Log.v("words",p);
	 } 
	if(sl)
	tv.startAnimation(slidel);
	sl=true;
	}
public void yes(View view)
{
	if(temp%2!=0)
	{
		if(s)
		{
			
		mp.stop();
		mp.reset();
		mp.release();
		
		}
		 mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
		mp.start();
		s=true;
		Log.v("Value",""+c);
		c++;
		repeat();
		bar();
		
		
	}
	else
	{   
		displayInterstitial();
		hs();
		ani();
	    
	    Log.v("Value",""+c+" "+inert);
	    
	    
		
		
		
	}
}
public void no(View view)
{
	if(temp%2==0)
	{
		c++;
		if(s)
		{
			
			mp.stop();
			mp.reset();
			mp.release();
			
		}
		 mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
			mp.start();
			s=true;
		repeat();
		bar();
		Log.v("Value",""+c);
		
		
	}
	else
	{
		displayInterstitial();
		hs();
		ani();
		
				Log.v("Value",""+c);
	
		
	}
}
private void displayInterstitial() {
	if(interstitial.isLoaded() && inert%6==0)
		interstitial.show();
	
}

public void ani()
{
	//drop_layout.setY(100);
	//yesbut.setVisibility(View.GONE);
	//nobut.setVisibility(View.GONE);
	tv.setVisibility(View.GONE);
	yesbut.setClickable(false);
	nobut.setClickable(false);
	drop_layout.setVisibility(View.VISIBLE);
	
    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake); 
    Animation slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
    findViewById(R.id.base).startAnimation(shake); 
	v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	v.vibrate(250);
	drop_layout.animate().translationY(100);
	drop_layout.startAnimation(slide);
	animation.cancel();
	
}
public void again(View view)
{
	Intent i=new Intent(Play.this,Play.class);
	startActivity(i);
	finish();
	
	
	}
public void home(View view)
{
	Intent i=new Intent(this,MainActivity.class);
	startActivity(i);
}
public void hs()
{
	
	
	SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE); 
	high= prefs.getInt("high1",high);
	
	
	
	SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	Editor editor = sharedpreferences.edit();
	
	if(c>high)
	high=c;
		
	editor.putInt("high1", high);
	editor.commit();
	tv1.setText(""+c);
	tv2.setText(""+high);
	//editor.clear();
	
	
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	public void share(View view)
	{
		ShareScreenshot ss=new ShareScreenshot(Play.this);
		ss.shareImage();
	}
	
	public void bar()
	{
		
		
		   animation.setInterpolator(new LinearInterpolator());
  animation.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) { 
      	//pb.setProgress(5);
      }
      @Override
      public void onAnimationEnd(Animator animator) {
      	 
   	     hs();
  		 ani();
  		 //call();
          //do something when the countdown is complete
      }
      @Override
      public void onAnimationCancel(Animator animator) {
    // pb.setProgress(0);
      }
      @Override
      public void onAnimationRepeat(Animator animator) { 
      	//pb.setProgress(5);
      }
  });

animation.start();
	}

	@Override
	public void onBackPressed() {
	}
}

