package org.encorelab.sail.evoroom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
//import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
//import com.j256.ormlite.support.ConnectionSource;
//import com.j256.ormlite.table.TableUtils;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ObservationsActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	//for newObsView
	Spinner itemPicker = null;
	Spinner areaPicker = null;
	private EditText observationText = null;

	Observation currentObs = null;
	boolean allFlag = true;				// awk flag to allow all items to be listed in setupListView()
	
	List<Observation> obsList = new ArrayList<Observation>();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observations);

        // can't get this to work without declaring it in each method, shouldn't be necessary
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

//*************************************************************************************	
	private void setupCloudView() {
		Button viewObservationsButton = (Button) findViewById(R.id.view_observations_button);
		Button addObservationButton = (Button) findViewById(R.id.add_observation_button);
		Button faunaLeopardButton, faunaFigWaspButton, faunaHornbillButton, faunaMonkeyButton, faunaOrangutanButton, faunaRabbitButton, faunaRhinoButton, faunaTapirButton, faunaTigerButton;
		Button floraFigButton, floraTetraButton, floraRafflButton, floraTitanButton, floraEnvirButton, floraOtherButton;
		faunaLeopardButton = (Button) findViewById(R.id.fauna_leopard_btn);
		faunaFigWaspButton = (Button) findViewById(R.id.fauna_fig_wasp_btn);
		faunaHornbillButton = (Button) findViewById(R.id.fauna_hornbill_btn);
		faunaMonkeyButton = (Button) findViewById(R.id.fauna_monkey_btn);
		faunaOrangutanButton = (Button) findViewById(R.id.fauna_orangutan_btn);
		faunaRabbitButton = (Button) findViewById(R.id.fauna_rabbit_btn);
		faunaRhinoButton = (Button) findViewById(R.id.fauna_rhino_btn);
		faunaTapirButton = (Button) findViewById(R.id.fauna_tapir_btn);
		faunaTigerButton = (Button) findViewById(R.id.fauna_tiger_btn);
		floraFigButton = (Button) findViewById(R.id.flora_fig_btn);
		floraTetraButton = (Button) findViewById(R.id.flora_tetra_btn);
		floraRafflButton = (Button) findViewById(R.id.flora_raffl_btn);
		floraTitanButton = (Button) findViewById(R.id.flora_titan_btn);
		floraEnvirButton = (Button) findViewById(R.id.flora_envir_btn);
		floraOtherButton = (Button) findViewById(R.id.flora_other_btn);

		int fontSize;
		if ((fontSize = getFontSizeIncrementer("Clouded leopard")) > 0) {
			faunaLeopardButton.setVisibility(View.VISIBLE);
			faunaLeopardButton.setTextSize(fontSize);
		} else {
			faunaLeopardButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Fig wasp")) > 0) {
			faunaFigWaspButton.setVisibility(View.VISIBLE);
			faunaFigWaspButton.setTextSize(fontSize);
		} else {
			faunaFigWaspButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Hornbill")) > 0) {
			faunaHornbillButton.setVisibility(View.VISIBLE);
			faunaHornbillButton.setTextSize(fontSize);
		} else {
			faunaHornbillButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Monkey")) > 0) {
			faunaMonkeyButton.setVisibility(View.VISIBLE);
			faunaMonkeyButton.setTextSize(fontSize);
		} else {
			faunaMonkeyButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Orangutan")) > 0) {
			faunaOrangutanButton.setVisibility(View.VISIBLE);
			faunaOrangutanButton.setTextSize(fontSize);
		} else {
			faunaOrangutanButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Rabbit")) > 0) {
			faunaRabbitButton.setVisibility(View.VISIBLE);
			faunaRabbitButton.setTextSize(fontSize);
		} else {
			faunaRabbitButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Rhinoceros")) > 0) {
			faunaRhinoButton.setVisibility(View.VISIBLE);
			faunaRhinoButton.setTextSize(fontSize);
		} else {
			faunaRhinoButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Tapir")) > 0) {
			faunaTapirButton.setVisibility(View.VISIBLE);
			faunaTapirButton.setTextSize(fontSize);
		} else {
			faunaTapirButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Tiger")) > 0) {
			faunaTigerButton.setVisibility(View.VISIBLE);
			faunaTigerButton.setTextSize(fontSize);
		} else {
			faunaTigerButton.setVisibility(View.GONE);
		}

		if ((fontSize = getFontSizeIncrementer("Fig")) > 0) {
			floraFigButton.setVisibility(View.VISIBLE);
			floraFigButton.setTextSize(fontSize);
		} else {
			floraFigButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Tetrastigma")) > 0) {
			floraTetraButton.setVisibility(View.VISIBLE);
			floraTetraButton.setTextSize(fontSize);
		} else {
			floraTetraButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Rafflesia")) > 0) {
			floraRafflButton.setVisibility(View.VISIBLE);
			floraRafflButton.setTextSize(fontSize);
		} else {
			floraTetraButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Titan arum")) > 0) {
			floraTitanButton.setVisibility(View.VISIBLE);
			floraTitanButton.setTextSize(fontSize);
		} else {
			floraTitanButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Environment")) > 0) {
			floraEnvirButton.setVisibility(View.VISIBLE);
			floraEnvirButton.setTextSize(fontSize);
		} else {
			floraEnvirButton.setVisibility(View.GONE);
		}
		if ((fontSize = getFontSizeIncrementer("Other")) > 0) {
			floraOtherButton.setVisibility(View.VISIBLE);
			floraOtherButton.setTextSize(fontSize);
		} else {
			floraOtherButton.setVisibility(View.GONE);
		}

        viewObservationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	allFlag = true;
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaLeopardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Clouded leopard");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaFigWaspButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Fig wasp");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaHornbillButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Hornbill");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaMonkeyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Monkey");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaOrangutanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Orangutan");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaRabbitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Rabbit");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaRhinoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Rhinoceros");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaTapirButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Tapir");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        faunaTigerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Tiger");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraFigButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Fig");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraTetraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Tetrastigma");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraRafflButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Rafflesia");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraTitanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Titan arum");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraEnvirButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Environment");
            	setupListView();
            	changeVis(R.id.observations_list_view);
            }
        });
        floraOtherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	updateList("Other");
            	setupListView();
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
		final CheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9;
		check1 = (CheckBox) findViewById(R.id.check1);
		check2 = (CheckBox) findViewById(R.id.check2);
		check3 = (CheckBox) findViewById(R.id.check3);
		check4 = (CheckBox) findViewById(R.id.check4);
		check5 = (CheckBox) findViewById(R.id.check5);
		check6 = (CheckBox) findViewById(R.id.check6);
		check7 = (CheckBox) findViewById(R.id.check7);
		check8 = (CheckBox) findViewById(R.id.check8);
		check9 = (CheckBox) findViewById(R.id.check9);
		
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
            	String tagsText = "";
            	Boolean boxChecked = false;
            	
            	if (check1.isChecked()) {
            		tagsText += "sexual selection" ;
            		boxChecked = true;
            	}
            	if (check2.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "bottleneck";
            		}
            		else {
            			tagsText += ", bottleneck";
            		}
            		boxChecked = true;
            	}
            	if (check3.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "reproductive isolation";
            		}
            		else {
            			tagsText += ", reproductive isolation";
            		}
            		boxChecked = true;
            	}
            	if (check4.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "natural selection";
            		}
            		else {
            			tagsText += ", natural selection";
            		}
            		boxChecked = true;
            	}
            	if (check5.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "founder effect";
            		}
            		else {
            			tagsText += ", founder effect";
            		}
            		boxChecked = true;
            	}
            	if (check6.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "adaption";
            		}
            		else {
            			tagsText += ", adaption";
            		}
            		boxChecked = true;
            	}
            	if (check7.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "coevolution";
            		}
            		else {
            			tagsText += ", coevolution";
            		}
            		boxChecked = true;
            	}
            	if (check8.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "gene flow";
            		}
            		else {
            			tagsText += ", gene flow";
            		}
            		boxChecked = true;
            	}
            	if (check9.isChecked()) {
            		if (tagsText.isEmpty()) {
            			tagsText += "other";
            		}
            		else {
            			tagsText += ", other";
            		}
            		boxChecked = true;
            	}
            	
            	if (!obsText.equals("") && boxChecked == true) {
            	
	            	obs.setObservationData(itemText, areaText, obsText, tagsText);
	            	
	            	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
	            	try {
						observationDao.create(obs);
					} catch (SQLException e) {
						e.printStackTrace();
					}
	
					//adds the obs to the array adapter, may not be necessary
					obsList.add(obs);
					
					//clear everything and change views
					observationText.setText("");
					check1.setChecked(false);
					check2.setChecked(false);
					check3.setChecked(false);
					check4.setChecked(false);
					check5.setChecked(false);
					check6.setChecked(false);
					check7.setChecked(false);
					check8.setChecked(false);
					check9.setChecked(false);
					setupListView();
	            	changeVis(R.id.observations_list_view);
            	}
            	else {
    				Toast toast = Toast.makeText(ObservationsActivity.this, "Please fill out all fields and choose tags", Toast.LENGTH_LONG);
    				toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
    				toast.show();
            	}
            }
        });
		
		newObsBackButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				observationText.setText("");
				setupCloudView();
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

		if (allFlag == true) {
	    	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
	    	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
	    	try {
				statementBuilder.orderBy("item", true);
				
				//clear the list and repopulate from db based on criteria 
				obsList.clear();
				obsList = observationDao.query(statementBuilder.prepare());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		observationAdapter listAdapter = new observationAdapter();
		listOfObservations.setAdapter(listAdapter);
		listOfObservations.setOnItemClickListener(onListClick);

		allFilterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	allFlag = true;
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
					allFlag = false;
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
					allFlag = false;
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
					allFlag = false;
					setupListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	setupCloudView();
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
		TextView detailsTags = (TextView) findViewById(R.id.details_selected_item_tags);

		//this check is for the first pass in onCreate, where the object is null
		if (currentObs != null) {
	
			if (currentObs.getArea().equals("Sundaland")) {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sud_tag));
			}
			else if (currentObs.getArea().equals("Borneo")) {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.bor_tag));
			}
			else if (currentObs.getArea().equals("Sumatra")) {
				detailsAreaImage.setImageDrawable(getResources().getDrawable(R.drawable.sum_tag));
			}
			detailsTitle.setText(currentObs.getItem());
			detailsContent.setText(currentObs.getText());
			detailsTags.setText(currentObs.getTags());
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

    private int getFontSizeIncrementer(String s) {
    	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
    	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
    	try {
			statementBuilder.orderBy("item", true).where().eq("item", s);
			 
			obsList.clear();
			obsList = observationDao.query(statementBuilder.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int fontSize = obsList.size();
		
		if (fontSize == 0) {
			return 0;
		}
		else {
			if (fontSize  > 6) {
				return (12 + 6*6);				
			}
			else {
				return (12 + obsList.size()*6);
			}
		}
	}
	
    private void updateList(String s) {
    	Dao<Observation, Integer> observationDao = getHelper().getObservationDao();
    	QueryBuilder<Observation, Integer> statementBuilder = observationDao.queryBuilder();
    	try {
			statementBuilder.orderBy("item", true).where().eq("item", s);
			
			//clear the list and repopulate from db based on criteria 
			obsList.clear();
			obsList = observationDao.query(statementBuilder.prepare());
			allFlag = false;
			setupListView();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
