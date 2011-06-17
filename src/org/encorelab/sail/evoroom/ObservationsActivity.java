package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class ObservationsActivity extends Activity {
	ViewFlipper flipper;
	Spinner colourPicker = null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observations);
        
        setupFlipper();
        
        colourPicker = (Spinner) findViewById(R.id.colour_picker);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.colours, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    colourPicker.setAdapter(adapter);
    }
	
	private void setupFlipper() {
		flipper = (ViewFlipper) findViewById(R.id.observations);
        
        Button button_to_next = (Button) findViewById(R.id.button_to_prev);
        Button button_to_prev = (Button) findViewById(R.id.button_to_next);
        
        button_to_prev.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				flipper.showPrevious();
			}
		});
        
        button_to_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				flipper.showNext();
			}
		});
	}
}
