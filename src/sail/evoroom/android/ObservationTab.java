package sail.evoroom.android;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class ObservationTab extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

	    Resources res = getResources(); // Resource object to get Drawables

	    // retrieve the TabHost to set up the tabs
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		// set up the tabs with name and icon
		intent = new Intent().setClass(this, ObservationsCloud.class);
		spec = tabHost.newTabSpec("observations").setIndicator("Observations", res.getDrawable(R.drawable.observationtab)).setContent(intent);
		tabHost.addTab(spec);
		
//		intent = new Intent().setClass(this, FieldGuideTab.class);
//		spec = tabHost.newTabSpec("fieldGuide").setIndicator("Field Guide", res.getDrawable(R.drawable.fieldguidetab)).setContent(intent);
//		tabHost.addTab(spec);
//		
//		intent = new Intent().setClass(this, EvolutionConceptsTab.class);
//		spec = tabHost.newTabSpec("evolutionconceptstab").setIndicator("Evolution Concepts", res.getDrawable(R.drawable.evolutionconceptstab)).setContent(intent);
//		tabHost.addTab(spec);

		// set background picture
		tabHost.setBackgroundResource(R.drawable.background);


		// To receive messages in the inquiry tab we set it current
		// and then switch to the observation tab
		getTabHost().setCurrentTab(0);
	}

	public void onDestroy() {
		super.onDestroy();
	}
}