package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FieldGuideActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.field_guide);
        
        setupButtons();
        setupAreaSelectorView();
        setupSpeciesSelectorView();
        setupSpeciesDisplayView();

	}

    private void setupButtons() {
    	//this is likely where the back button (bar) will go
    }


	private void setupAreaSelectorView() {
//		private Button sundalandFloraButton;
//		private Button sundalandFaunaButton;
//		private Button borneoFloraButton;
//		private Button borneoFaunaButton;
//		private Button sumatraFloraButton;
//		private Button sumatraFaunaButton;
//		private Button allButton;

		Button sundalandFloraButton = (Button) findViewById(R.id.sundalandFloraButton);
		sundalandFloraButton.setText(Html.fromHtml("<b>Sundaland Flora</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.field_guide_species_selector).setVisibility(View.VISIBLE);
                findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
                findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
            }
        });
		Button sundalandFaunaButton = (Button) findViewById(R.id.sundalandFaunaButton);
		sundalandFaunaButton.setText(Html.fromHtml("<b>Sundaland Fauna</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.field_guide_species_selector).setVisibility(View.VISIBLE);
                findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
                findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
            }
        });

//		Button sundalandFloraButton = (Button) findViewById(R.id.sundalandFloraButton);
//		sundalandFloraButton.setOnClickListener(this);
//		sundalandFloraButton.setText(Html.fromHtml("<b>Sundaland Flora</b>" +  "<br />" + 
//		            "<small>2 million years ago</small>"));
//		Button sundalandFaunaButton = (Button) findViewById(R.id.sundalandFaunaButton);
//		sundalandFaunaButton.setOnClickListener(this);
//		sundalandFaunaButton.setText(Html.fromHtml("<b>Sundaland Fauna</b>" +  "<br />" + 
//		            "<small>2 million years ago</small>"));
//		Button borneoFloraButton = (Button) findViewById(R.id.borneoFloraButton);
//		borneoFloraButton.setOnClickListener(this);
//		borneoFloraButton.setText(Html.fromHtml("<b>Borneo Flora</b>" +  "<br />" + 
//        			"<small>200 years ago</small>"));
//		Button borneoFaunaButton = (Button) findViewById(R.id.borneoFaunaButton);
//		borneoFaunaButton.setOnClickListener(this);
//		borneoFaunaButton.setText(Html.fromHtml("<b>Borneo Fauna</b>" +  "<br />" + 
//        			"<small>200 years ago</small>"));
//		Button sumatraFloraButton = (Button) findViewById(R.id.sumatraFloraButton);
//		sumatraFloraButton.setOnClickListener(this);
//		sumatraFloraButton.setText(Html.fromHtml("<b>Sumatra Flora</b>" +  "<br />" + 
//					"<small>200 years ago</small>"));
//		Button sumatraFaunaButton = (Button) findViewById(R.id.sumatraFaunaButton);
//		sumatraFaunaButton.setOnClickListener(this);
//		sumatraFaunaButton.setText(Html.fromHtml("<b>Sumatra Fauna</b>" +  "<br />" + 
//					"<small>200 years ago</small>"));
//		Button allButton = (Button) findViewById(R.id.allButton);
//		allButton.setOnClickListener(this);
//		allButton.setText(Html.fromHtml("<b>All areas</b>"));
//        	
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			switch(v.getId()){  
//			case R.id.sundalandFloraButton:
//	            findViewById(R.id.field_guide_species_selector).setVisibility(View.VISIBLE);
//	            findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
//	            findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
//	            break;
//			case R.id.sundalandFaunaButton:
//				// launch activity;
//				sundalandFaunaButton.setText("SundaFauna");
//				break;
//			case R.id.borneoFloraButton:
//				// launch activity;
//				borneoFloraButton.setText("bornFlora");
//				break;
//			case R.id.borneoFaunaButton:
//				// launch activity;
//				borneoFaunaButton.setText("bornFauna");
//				break;
//			case R.id.sumatraFloraButton:
//				// launch activity;
//				sumatraFloraButton.setText("sumatraFlora");
//				break;
//			case R.id.sumatraFaunaButton:
//				// launch activity;
//				sumatraFaunaButton.setText("sumatraFauna");
//				break;
//			case R.id.allButton:
//				// Launch activity;
//		    	allButton.setText("all");
//
//			}
//		}
		
	}
	
	private void setupSpeciesSelectorView() {
		
	}
    
	private void setupSpeciesDisplayView() {
		
	}

}
