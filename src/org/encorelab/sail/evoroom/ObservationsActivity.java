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
        
        setupCloudView();
        setupNewObservationView();
        setupListView();
        setupDetailsView();
    }

	private void setupCloudView() {
		Button viewObservationsButton = (Button) findViewById(R.id.view_observations_button);
		Button addObservationButton = (Button) findViewById(R.id.add_observation_button);
        viewObservationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_list_view);
            }
        });
        addObservationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_new_observation_view);
            }
        });
		
	}

	private void setupListView() {
		Button backButton = (Button) findViewById(R.id.list_back_button);
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_cloud_view);
            	}
        });
	}

	private void setupNewObservationView() {
		Button newObsBackButton = (Button) findViewById(R.id.new_obs_back_button);
		newObsBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_cloud_view);
            	}
        });

		Button newObsSubmitButton = (Button) findViewById(R.id.new_obs_submit_button);
		newObsSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_details_view);
            	}
        });

		Spinner itemPicker = (Spinner) findViewById(R.id.item_picker);
	    ArrayAdapter<CharSequence> itemAdapter = ArrayAdapter.createFromResource(
	            this, R.array.items, android.R.layout.simple_spinner_item);
	    itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    itemPicker.setAdapter(itemAdapter);
	    
	    // fill the areaPicker spinner with data from the array in selection-lists.xml
	    Spinner areaPicker = (Spinner) findViewById(R.id.area_picker);
	    ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(
	            this, R.array.areas, android.R.layout.simple_spinner_item);
	    areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    areaPicker.setAdapter(areaAdapter);
	}

	private void setupDetailsView() {
		Button detailsBackButton = (Button) findViewById(R.id.details_back_button);
		detailsBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_cloud_view);
            	}
        });
	}
	
	private void changeVis(int vis) {
        findViewById(R.id.observations_cloud_view).setVisibility(View.GONE);
    	findViewById(R.id.observations_new_observation_view).setVisibility(View.GONE);
        findViewById(R.id.observations_list_view).setVisibility(View.GONE);
        findViewById(R.id.observations_details_view).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
	}
}
