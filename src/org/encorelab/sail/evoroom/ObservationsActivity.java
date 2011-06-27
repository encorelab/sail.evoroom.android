package org.encorelab.sail.evoroom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ObservationsActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	//for newObsView
	Spinner itemPicker = null;
	Spinner areaPicker = null;
	private EditText observationText = null;

	private Dao<Observation, Integer> observationDao;
	Observation currentObs = null;
	
	List<Observation> obsList = new ArrayList<Observation>();
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observations);

        Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
    	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
    	try {
			statementBuilder.orderBy("item", true);
			obsList.clear();
			obsList = observationDao.query(statementBuilder.prepare());
			setupListView();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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


//********************************************************************************************

	private void setupNewObservationView() {

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

				//adds the obs to the array adapter
				obsList.add(obs);
				
				observationText.setText("");
				setupListView();
            	changeVis(R.id.observations_list_view);
            	}
        });
		
		newObsBackButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				observationText.setText("");
				//there may be a need to call setupCloudView() here
            	changeVis(R.id.observations_cloud_view);
			}
		});
	}

//********************************************************************************************
	
	private void setupListView() {
		Button allFilterButton = (Button) findViewById(R.id.all_filter_button);
		Button sundalandFilterButton = (Button) findViewById(R.id.sundaland_filter_button);
		Button borneoFilterButton = (Button) findViewById(R.id.borneo_filter_button);
		Button sumatraFilterButton = (Button) findViewById(R.id.sumatra_filter_button);
		Button backButton = (Button) findViewById(R.id.list_back_button);
		ListView listOfObservations = (ListView) findViewById(R.id.list_of_observations);

		observationAdapter listAdapter = new observationAdapter();
		listOfObservations.setAdapter(listAdapter);
		listOfObservations.setOnItemClickListener(onListClick);

		allFilterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
            	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
            	try {
					statementBuilder.orderBy("item", true);
					
					//clear the list and repopulate from db based on criteria 
					obsList.clear();
					obsList = observationDao.query(statementBuilder.prepare());
					setupListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				setupListView();
            }
        });
		sundalandFilterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
            	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
            	try {
					statementBuilder.orderBy("item", true).where().eq("area", "Sundaland");
					
					//clear the list and repopulate from db based on criteria 
					obsList.clear();
					obsList = observationDao.query(statementBuilder.prepare());
					setupListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });
		borneoFilterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
            	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
            	try {
					statementBuilder.orderBy("item", true).where().eq("area", "Borneo");
					
					obsList.clear();
					obsList = observationDao.query(statementBuilder.prepare());
					setupListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });
		sumatraFilterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
            	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
            	try {
					statementBuilder.orderBy("item", true).where().eq("area", "Sumatra");

					obsList.clear();
					obsList = observationDao.query(statementBuilder.prepare());
					setupListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_cloud_view);
            	}
        });
		
	}

//********************************************************************************************
	
	private void setupDetailsView() {
		Button detailsBackButton = (Button) findViewById(R.id.details_back_button);
		detailsBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.observations_list_view);
            	}
        });

		ImageView detailsAreaImage = (ImageView) findViewById(R.id.details_selected_item_area);
		TextView detailsTitle = (TextView) findViewById(R.id.details_selected_item_text);
		TextView detailsContent = (TextView) findViewById(R.id.details_selected_item_content);
		//TextView detailsTags = (TextView) findViewById(R.id.details_selected_item_tags);

		//this check is for the first pass in onCreate, where the object is null
		if (currentObs != null) {
	
			if (currentObs.getArea() == "Sundaland") {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sud_tag));
			}
			else if (currentObs.getArea() == "Borneo") {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.bor_tag));
			}
			else {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sum_tag));
			}
			detailsTitle.setText(currentObs.getItem());
			detailsContent.setText(currentObs.getText());
		}

	}

//********************************************************************************************
//HELPER FUNCTIONS
	
	private void changeVis(int vis) {
        findViewById(R.id.observations_cloud_view).setVisibility(View.GONE);
    	findViewById(R.id.observations_new_observation_view).setVisibility(View.GONE);
        findViewById(R.id.observations_list_view).setVisibility(View.GONE);
        findViewById(R.id.observations_details_view).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
	}

	
	class observationAdapter extends ArrayAdapter<Observation> {
		observationAdapter() {
			super(ObservationsActivity.this, R.layout.row, obsList);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			observationHolder holder = null;

			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row, parent, false);
				holder = new observationHolder(row);
				row.setTag(holder);
			} else {
				holder = (observationHolder) row.getTag();
			}

			holder.populateFrom(obsList.get(position));

			return (row);
		}
	}

	
	static class observationHolder {
		private TextView content = null;
		private View row = null;
		private ImageView tag = null;

		observationHolder(View row) {
			this.row = row;
			content = (TextView) row.findViewById(R.id.titleRow);
			tag = (ImageView) row.findViewById(R.id.areaTag);
		}

		void populateFrom(Observation obs) {
			content.setText(obs.getItem() + " - " + obs.getText());
			if (obs.getArea().equals("Sundaland")) {
				tag.setImageResource(R.drawable.sud_tag);	
			}
			else if (obs.getArea().equals("Borneo")) {
				tag.setImageResource(R.drawable.bor_tag);
			}
			else {
				tag.setImageResource(R.drawable.sum_tag);
			}
		}
	}

	private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			currentObs = obsList.get(position);
			setupDetailsView();
			changeVis(R.id.observations_details_view);
		}
	};

	//override to disable the back button
	public void onBackPressed() {
	   return;
	}

}
