package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class ObservationsActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentManager.enableDebugLogging(true);
        
        setContentView(R.layout.observations);
        
        
        
        
        Intent intent = new Intent(); 
        intent.setClass(this, ObservationsEntryFragment.class); 
        startActivity(intent);
        
    }
}
