//figure out how to redo the onClick for all (instead of doing one for each)

package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
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
    	//this is likely where the back button (bar) will go (no need?)
    }


	private void setupAreaSelectorView() {
		Button sundalandFloraButton = (Button) findViewById(R.id.sundalandFloraButton);
		sundalandFloraButton.setText(Html.fromHtml("<b>Sundaland Flora</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
                //set a flag here? They will get unwieldy pretty quickly.
                //it will be better to put these 3 lines + flag into another function and call that
            }
        });
		Button sundalandFaunaButton = (Button) findViewById(R.id.sundalandFaunaButton);
		sundalandFaunaButton.setText(Html.fromHtml("<b>Sundaland Fauna</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button borneoFloraButton = (Button) findViewById(R.id.borneoFloraButton);
		borneoFloraButton.setText(Html.fromHtml("<b>Borneo Flora</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		borneoFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button borneoFaunaButton = (Button) findViewById(R.id.borneoFaunaButton);
		borneoFaunaButton.setText(Html.fromHtml("<b>Borneo Fauna</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		borneoFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button sumatraFloraButton = (Button) findViewById(R.id.sumatraFloraButton);
		sumatraFloraButton.setText(Html.fromHtml("<b>Sumatra Flora</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		sumatraFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button sumatraFaunaButton = (Button) findViewById(R.id.sumatraFaunaButton);
		sumatraFaunaButton.setText(Html.fromHtml("<b>Sumatra Fauna</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		sumatraFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button allButton = (Button) findViewById(R.id.allButton);
		allButton.setText(Html.fromHtml("<b>All areas</b>"));
		allButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            	}
        });

		
	}
	
	private void setupSpeciesSelectorView() {
		Button backButton = (Button) findViewById(R.id.selectorBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_area_selector);            }
        });
		Button forwardButton = (Button) findViewById(R.id.forwardButton);
		forwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_display);
            	}
        });
		Button forwardButton2 = (Button) findViewById(R.id.forwardButton2);
		forwardButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_display);
            	}
        });
		Button forwardButton3 = (Button) findViewById(R.id.forwardButton3);
		forwardButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_display);
            }
        });
	}
    
	private void setupSpeciesDisplayView() {
		Button backButton = (Button) findViewById(R.id.displayBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });
	}

	private void changeVis(int vis) {
        findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
    	findViewById(R.id.field_guide_species_selector).setVisibility(View.GONE);
        findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
        //or is it String? Or View?
	}
	
	//maybe also a checkVis()?
}





//@Override
//public void onClick(View v) {
//	// TODO Auto-generated method stub
//	switch(v.getId()){  
//	case R.id.sundalandFloraButton:
//        findViewById(R.id.field_guide_species_selector).setVisibility(View.VISIBLE);
//        findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
//        findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
//        break;
//	case R.id.sundalandFaunaButton:
//		// launch activity;
//		sundalandFaunaButton.setText("SundaFauna");
//		break;
//	case R.id.borneoFloraButton:
//		// launch activity;
//		borneoFloraButton.setText("bornFlora");
//		break;
//	case R.id.borneoFaunaButton:
//		// launch activity;
//		borneoFaunaButton.setText("bornFauna");
//		break;
//	case R.id.sumatraFloraButton:
//		// launch activity;
//		sumatraFloraButton.setText("sumatraFlora");
//		break;
//	case R.id.sumatraFaunaButton:
//		// launch activity;
//		sumatraFaunaButton.setText("sumatraFauna");
//		break;
//	case R.id.allButton:
//		// Launch activity;
//    	allButton.setText("all");
//
//	}
//}
