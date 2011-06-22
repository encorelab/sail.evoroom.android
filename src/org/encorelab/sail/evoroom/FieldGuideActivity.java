//figure out how to redo the onClick for all (instead of doing one for each)

package org.encorelab.sail.evoroom;

import android.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FieldGuideActivity extends Activity {
	
// flag to mark button selected in field_guide_area_selector
	int areaSelectorFlag = 0;
// flag to mark the selected flora or fauna in field_guide_species_selector
	String speciesSelected = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.field_guide);
        
        setupAreaSelectorView();
        setupSpeciesSelectorView();
        setupSpeciesDisplayView();
	}


	private void setupAreaSelectorView() {
		Button sundalandFloraButton = (Button) findViewById(R.id.sundalandFloraButton);
		sundalandFloraButton.setText(Html.fromHtml("<b>Sundaland Flora</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                areaSelectorFlag = 1;
                setupSpeciesSelectorView();
                changeVis(R.id.field_guide_species_selector);
            }
        });
		Button sundalandFaunaButton = (Button) findViewById(R.id.sundalandFaunaButton);
		sundalandFaunaButton.setText(Html.fromHtml("<b>Sundaland Fauna</b>" +  "<br />" + 
        	"<small>2 million years ago</small>"));
		sundalandFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 2;
                setupSpeciesSelectorView();
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button borneoFloraButton = (Button) findViewById(R.id.borneoFloraButton);
		borneoFloraButton.setText(Html.fromHtml("<b>Borneo Flora</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		borneoFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 3;
                setupSpeciesSelectorView();
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button borneoFaunaButton = (Button) findViewById(R.id.borneoFaunaButton);
		borneoFaunaButton.setText(Html.fromHtml("<b>Borneo Fauna</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		borneoFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 4;
                setupSpeciesSelectorView();
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button sumatraFloraButton = (Button) findViewById(R.id.sumatraFloraButton);
		sumatraFloraButton.setText(Html.fromHtml("<b>Sumatra Flora</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		sumatraFloraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 5;
                setupSpeciesSelectorView();
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button sumatraFaunaButton = (Button) findViewById(R.id.sumatraFaunaButton);
		sumatraFaunaButton.setText(Html.fromHtml("<b>Sumatra Fauna</b>" +  "<br />" + 
        	"<small>200 years ago</small>"));
		sumatraFaunaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 6;
                setupSpeciesSelectorView();
            	changeVis(R.id.field_guide_species_selector);
            }
        });
		Button allButton = (Button) findViewById(R.id.allButton);
		allButton.setText(Html.fromHtml("<b>All areas</b>"));
		allButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	areaSelectorFlag = 7;
                setupSpeciesSelectorView();
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

		// in future we might want to use a custom LayoutInflator here (see junked code at the bottom). This stuff is not dynamic/large enough to warrent it		
		ImageView image = (ImageView) findViewById(R.id.speciesSelector);   // generic layout, set to correct image during if loop below
		Button f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14;   // invisible buttons overlaying the image
		f1 = (Button) findViewById(R.id.f1);									// not all buttons used for each image
		f2 = (Button) findViewById(R.id.f2);
		f3 = (Button) findViewById(R.id.f3);
		f4 = (Button) findViewById(R.id.f4);
		f5 = (Button) findViewById(R.id.f5);
		f6 = (Button) findViewById(R.id.f6);
		f7 = (Button) findViewById(R.id.f7);
		f8 = (Button) findViewById(R.id.f8);
		f9 = (Button) findViewById(R.id.f9);
		f10 = (Button) findViewById(R.id.f10);
		f11 = (Button) findViewById(R.id.f11);
		f12 = (Button) findViewById(R.id.f12);
		f13 = (Button) findViewById(R.id.f13);
		f14 = (Button) findViewById(R.id.f14);
		
		// clear all buttons		
//		for (int x=0; x<14; x++) {
//			String btnClear = "f" + Integer.toString(x+1);
//			.setVisibility(View.GONE);
			f1.setVisibility(View.GONE);
			f2.setVisibility(View.GONE);
			f3.setVisibility(View.GONE);
			f4.setVisibility(View.GONE);
			f5.setVisibility(View.GONE);
			f6.setVisibility(View.GONE);
			f7.setVisibility(View.GONE);
			f8.setVisibility(View.GONE);
			f9.setVisibility(View.GONE);
			f10.setVisibility(View.GONE);
			f11.setVisibility(View.GONE);
			f12.setVisibility(View.GONE);
			f13.setVisibility(View.GONE);
			f14.setVisibility(View.GONE);
//		}

		if (areaSelectorFlag == 1) {
	        image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_sundaland_plant));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });

		}
		else if (areaSelectorFlag == 2) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_sundaland_animal));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f4.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
		}
		else if (areaSelectorFlag == 3) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_borneo_plant));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
		}
		else if (areaSelectorFlag == 4) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_borneo_animal));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f4.setVisibility(View.VISIBLE);
			f5.setVisibility(View.VISIBLE);
			f6.setVisibility(View.VISIBLE);
			f7.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f7.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });

		}
		else if (areaSelectorFlag == 5) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_sumatra_plant));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f4.setVisibility(View.VISIBLE);
			f5.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
		}
		else if (areaSelectorFlag == 6) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_sumatra_animal));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f4.setVisibility(View.VISIBLE);
			f5.setVisibility(View.VISIBLE);
			f6.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "striped_rabbit";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "";
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
		}
		else {
			image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_all));
		}
	}
    
	private void setupSpeciesDisplayView() {
		Button backButton = (Button) findViewById(R.id.displayBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	changeVis(R.id.field_guide_species_selector);
            }
        });

		ImageView image = (ImageView) findViewById(R.id.speciesPhoto);
		TextView commonName, scientificName, family, description, habitat, prevelence;
		TextView commonNameContent, scientificNameContent, familyContent, descriptionContent, habitatContent, prevelenceContent; 
		commonName = (TextView) findViewById(R.id.commonNameField);
		commonNameContent = (TextView) findViewById(R.id.commonNameContent);
		scientificName = (TextView) findViewById(R.id.scientificNameField);
		scientificNameContent = (TextView) findViewById(R.id.scientificNameContent);
		family = (TextView) findViewById(R.id.familyField);
		familyContent = (TextView) findViewById(R.id.familyContent);
		description = (TextView) findViewById(R.id.descriptionField);
		descriptionContent = (TextView) findViewById(R.id.descriptionContent);
		habitat = (TextView) findViewById(R.id.habitatField);
		habitatContent = (TextView) findViewById(R.id.habitatContent);
		prevelence = (TextView) findViewById(R.id.prevelenceField);
		prevelenceContent = (TextView) findViewById(R.id.prevelenceContent);
		
		if (speciesSelected.equals("striped_rabbit")) {
			image.setImageDrawable(getResources().getDrawable(R.drawable.striped_rabbit));
			commonNameContent.setText("Sumatra short-eared rabbit");
			scientificNameContent.setText("Nesolagus netscheri");
			familyContent.setText("Leporidae");
			descriptionContent.setText("The Sumatran Striped Rabbit is usually about 40 cm (1 ft, 4 in) long. It is gray with brown stripes, with a red tail and rump, and the underside is white. It lives in forests at altitudes of 600-1400 metres. It is nocturnal, resting in the burrows of other animals. It usually eats the stalk and leaves of understory plants, but captive rabbits ate grain, and tropical fruits");
			habitatContent.setText("Exists in forests along the mountainous edge of Sumatra");
			prevelenceContent.setText("Critically endangered because of loss of habitat");
//			image.setImageDrawable(getResources().getDrawable(R.drawable.cartoon_striped_rabbit));
		}

		
	}

	private void changeVis(int vis) {
        findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
    	findViewById(R.id.field_guide_species_selector).setVisibility(View.GONE);
        findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
	}
	
}




//THIS IS AN EXAMPLE OF HOW TO DO THE onClick CORRECTLY FOR MULTIPLE LISTENERS
//
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


//EXAMPLE CODE FROM DECLARING BUTTONS INLINE, AND THEN STYLING THEM
//
//Button topLeftButton = (Button) findViewById(R.id.topLeftButton);
//Button topRightButton = (Button) findViewById(R.id.topRightButton);
//Button f3 = (Button) findViewById(R.id.genericLeftButton);
//f3.setHeight(291);
//f3.setWidth(286);
//Button f4 = (Button) findViewById(R.id.genericRightButton);
//f4.setHeight(291);
//f4.setWidth(286);
//
//RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT);
//p1.addRule(RelativeLayout.BELOW, R.id.topLeftButton);
//p1.addRule(RelativeLayout.ALIGN_LEFT, R.id.topLeftButton);
//f3.setLayoutParams(p1);
//
//RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT);
//p2.addRule(RelativeLayout.BELOW, R.id.topRightButton);
//p2.addRule(RelativeLayout.ALIGN_RIGHT, topRightButton.getId());
//f4.setLayoutParams(p2);
//
//Button f5 = new Button(this);
//f5.setHeight(291);
//f5.setWidth(286);
//RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT);
//p3.addRule(RelativeLayout.BELOW, f3.getId());
//p3.addRule(RelativeLayout.ALIGN_LEFT, f3.getId());
//f5.setLayoutParams(p3);
//
//Button f6 = new Button(this);
//f6.setHeight(291);
//f6.setWidth(286);
//RelativeLayout.LayoutParams p4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT);
//p4.addRule(RelativeLayout.BELOW, f4.getId());
//p4.addRule(RelativeLayout.ALIGN_RIGHT, f4.getId());
//f6.setLayoutParams(p4);
//
//LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout02);
//layout.addView(f5);
