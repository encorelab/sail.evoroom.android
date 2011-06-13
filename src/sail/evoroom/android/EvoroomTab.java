package sail.evoroom.android;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TabHost;

public class EvoroomTab extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, ObservationTab.class);
		spec = tabHost.newTabSpec("observation").setIndicator("Observations").setContent(intent);
		tabHost.addTab(spec);
		intent = new Intent().setClass(this, FieldGuideTab.class);
		spec = tabHost.newTabSpec("fieldGuide").setIndicator("Field Guide").setContent(intent);
		tabHost.addTab(spec);
		intent = new Intent().setClass(this, EvolutionConceptsTab.class);
		spec = tabHost.newTabSpec("evolutionConcepts").setIndicator("Evolution Concepts").setContent(intent);
		tabHost.addTab(spec);

		// To receive messages in the inquiry tab we set it current
		// and then switch to the observation tab
		getTabHost().setCurrentTab(1);

	}

	public void onDestroy() {
		super.onDestroy();
		// HelioroomTab.nt.disconnect();
		// HelioroomTab.nt.interrupt();
	}

}
