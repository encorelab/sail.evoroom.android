package org.encorelab.sail.evoroom;

import org.encorelab.sail.evoroom.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class EvoroomTabWidget extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Resources res = getResources(); // Resource object to get Drawables

	    // retrieve the TabHost to set up the tabs
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, ObservationsActivity.class);
		spec = tabHost.newTabSpec("observations").setIndicator("Observations",
                res.getDrawable(R.drawable.ic_observations_tab))
            .setContent(intent);
		tabHost.addTab(spec);
		
		// Do the same for the other tabs
		intent = new Intent().setClass(this, FieldGuideActivity.class);
		spec = tabHost.newTabSpec("field_guide").setIndicator("Field Guide",
		                res.getDrawable(R.drawable.ic_field_guide_tab))
		            .setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this, EvolutionConceptsActivity.class);
		spec = tabHost.newTabSpec("evolution_concepts").setIndicator("Evolution Concepts",
		                res.getDrawable(R.drawable.ic_evolution_concepts_tab))
		            .setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setBackgroundResource(R.drawable.background);
		
		tabHost.setCurrentTab(0);
	}
}
