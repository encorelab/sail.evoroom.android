package org.encorelab.sail.evoroom;

import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ObservationsActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	Spinner itemPicker = null;
	Spinner areaPicker = null;
	private EditText observationText = null;
	
	TextView newObsItemContent = null;
	
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
//		Button allFilterButton = (Button) findViewById(R.id.all_filter_button);
//		Button sundalandFilterButton = (Button) findViewById(R.id.sundaland_filter_button);
//		Button borneoFilterButton = (Button) findViewById(R.id.borneo_filter_button);
//		Button sumatraFilterButton = (Button) findViewById(R.id.sumatra_filter_button);
//		Button backButton = (Button) findViewById(R.id.list_back_button);
//		
//		allFilterButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	//do something
//            }
//        });
//		sundalandFilterButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	//do something
//            	}
//        });
//		borneoFilterButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	//do something
//            	}
//        });
//		sumatraFilterButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	//do something
//            	}
//        });
//		backButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	changeVis(R.id.observations_cloud_view);
//            	}
//        });
//		
	}

	private void setupNewObservationView() {

		newObsItemContent = (TextView) findViewById(R.id.observation_text);
		Button newObsBackButton = (Button) findViewById(R.id.new_obs_cancel_button);
		Button newObsSubmitButton = (Button) findViewById(R.id.new_obs_submit_button);
		itemPicker = (Spinner) findViewById(R.id.item_picker);
		areaPicker = (Spinner) findViewById(R.id.area_picker);
		observationText = (EditText) findViewById(R.id.observation_text);
		
	    ArrayAdapter<CharSequence> itemAdapter = ArrayAdapter.createFromResource(
	            this, R.array.items, android.R.layout.simple_spinner_item);
	    itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    itemPicker.setAdapter(itemAdapter);
	    // fill the areaPicker spinner with data from the array in selection-lists.xml
	    ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(
	            this, R.array.areas, android.R.layout.simple_spinner_item);
	    areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    areaPicker.setAdapter(areaAdapter);
	    
		newObsSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Observation obs = new Observation();
            	String itemText = (String) itemPicker.getSelectedItem();
            	String areaText = (String) areaPicker.getSelectedItem();
            	String obsText = observationText.getText().toString();
            	obs.setObservationData(itemText, areaText, obsText);
            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
            	try {
					observationDao.create(obs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// close the database connection
				getHelper().close();

            	newObsItemContent.setText("");
            	changeVis(R.id.observations_details_view);
            	}
        });
		
		newObsBackButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
            	newObsItemContent.setText("");
            	changeVis(R.id.observations_details_view);
			}
		});
	}

	
	private void setupDetailsView() {
		Button detailsBackButton = (Button) findViewById(R.id.details_back_button);
		detailsBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_cloud_view);
            	}
        });

		//Observation obs = GET THE SELECTED OBSERVATION FROM THE DB
		ImageView detailsAreaImage = (ImageView) findViewById(R.id.details_selected_item_area);
		TextView detailsTitle = (TextView) findViewById(R.id.details_selected_item_text);
		TextView detailsContent = (TextView) findViewById(R.id.details_selected_item_content);
		//TextView detailsTags = (TextView) findViewById(R.id.details_selected_item_tags);

//		if (obs.getArea() == "Sundaland") {
//			detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sud_tag));
//		}
//		else if (obs.getArea() == "Borneo") {
//			detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.bor_tag));
//		}
//		else {
//			detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sum_tag));
//		}
//		detailsTitle.setText(obs.getItem());
//		detailsContent.setText(obs.getText());
		
	}
	
	private void changeVis(int vis) {
        findViewById(R.id.observations_cloud_view).setVisibility(View.GONE);
    	findViewById(R.id.observations_new_observation_view).setVisibility(View.GONE);
        findViewById(R.id.observations_list_view).setVisibility(View.GONE);
        findViewById(R.id.observations_details_view).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
	}
}
