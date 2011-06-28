package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;

public class EvolutionConceptsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.evolution_concepts);
	}

	//override to disable the back button
	public void onBackPressed() {
	   return;
	}
	
}
