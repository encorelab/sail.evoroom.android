package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ObservationsActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observations);
        
        setupModeButtons();
        setupEntryView();
        setupCloudView();
    }
	
	private void setupModeButtons() {
		Button button_to_entry = (Button) findViewById(R.id.button_to_entry);
        button_to_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.observations_entry_view).setVisibility(View.VISIBLE);
                findViewById(R.id.observations_cloud_view).setVisibility(View.GONE);
            }
        });
        
        Button button_to_cloud = (Button) findViewById(R.id.button_to_cloud);
        button_to_cloud.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	findViewById(R.id.observations_entry_view).setVisibility(View.GONE);
                findViewById(R.id.observations_cloud_view).setVisibility(View.VISIBLE);
            }
        });
	}
	
	private void setupEntryView() {
		Spinner colourPicker = (Spinner) findViewById(R.id.colour_picker);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.colours, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    colourPicker.setAdapter(adapter);
	}
	
	private void setupCloudView() {
	}
}
