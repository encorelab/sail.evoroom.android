//figure out how to redo the onClick for all (instead of doing one for each)

package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

//**********************************************************************************************
	
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

		if (areaSelectorFlag == 1) {
	        image.setImageDrawable(getResources().getDrawable(R.drawable.area_box_sundaland_plant));
			f1.setVisibility(View.VISIBLE);
			f2.setVisibility(View.VISIBLE);
			f3.setVisibility(View.VISIBLE);
			f4.setVisibility(View.VISIBLE);
			f5.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_curtain_fig";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_rafflesia";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_strangler_fig";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_tetrastigma";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_titan_arum";
	            	setupSpeciesDisplayView();
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
			f5.setVisibility(View.VISIBLE);
			f6.setVisibility(View.VISIBLE);
			f7.setVisibility(View.VISIBLE);
			f8.setVisibility(View.VISIBLE);
			f9.setVisibility(View.VISIBLE);
			
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_leopard";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_fig_wasp";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_hornbill";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_orangutan";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_proboscis_monkey";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_rabbit";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f7.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_rhino";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f8.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_tapir";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f9.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sud_tiger";
	            	setupSpeciesDisplayView();
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
	            	speciesSelected = "rafflesia";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "strangler_fig";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "tetrastigma";
	            	setupSpeciesDisplayView();
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
	            	speciesSelected = "borneo_orangutan";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "fig_wasp_borneo";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "helmeted_hornbill";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "grey_hornbill";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "proboscis_monkey";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "rhino_hornbill";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f7.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sunda_leopard";
	            	setupSpeciesDisplayView();
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
	            	speciesSelected = "ficus_benjamina";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "ficus_microcarpa";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "rafflesia";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "tetrastigma";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "amorphophallus_titanum";
	            	setupSpeciesDisplayView();
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
			f7.setVisibility(View.VISIBLE);
			f1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "fig_wasp_sumatra";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "malayan_tapir";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "leaf_monkey";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sumatran_orangutan";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sumatran_rhino";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "striped_rabbit";
	            	setupSpeciesDisplayView();
	            	changeVis(R.id.field_guide_species_display);
	            	}
	        });
			f7.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	speciesSelected = "sunda_leopard";
	            	setupSpeciesDisplayView();
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

		ImageView speciesPhoto = (ImageView) findViewById(R.id.speciesPhoto);
		ImageView speciesDrawn = (ImageView) findViewById(R.id.speciesDrawn);
		TextView familyField, scientificNameField, habitatField, prevalenceField;
		familyField = (TextView) findViewById(R.id.familyField);
		scientificNameField = (TextView) findViewById(R.id.scientificNameField);
		habitatField = (TextView) findViewById(R.id.habitatField);
		prevalenceField = (TextView) findViewById(R.id.prevalenceField);
		TextView commonNameContent, scientificNameContent, familyContent, descriptionContent, habitatContent, prevalenceContent, sourcesContent; 
		commonNameContent = (TextView) findViewById(R.id.commonNameContent);
		scientificNameContent = (TextView) findViewById(R.id.scientificNameContent);
		familyContent = (TextView) findViewById(R.id.familyContent);
		descriptionContent = (TextView) findViewById(R.id.descriptionContent);
		habitatContent = (TextView) findViewById(R.id.habitatContent);
		prevalenceContent = (TextView) findViewById(R.id.prevalenceContent);
		sourcesContent = (TextView) findViewById(R.id.sourcesContent);

		//reset in case of previous Sundaland choices
		scientificNameContent.setVisibility(View.VISIBLE);
		scientificNameField.setVisibility(View.VISIBLE);
		familyField.setText("Family: ");
		habitatField.setVisibility(View.VISIBLE);
		habitatContent.setVisibility(View.VISIBLE);
		prevalenceContent.setVisibility(View.VISIBLE);
		prevalenceField.setVisibility(View.VISIBLE);
		speciesDrawn.setVisibility(View.VISIBLE);

		commonNameContent.setText(" ");
		scientificNameContent.setText(" ");
		familyContent.setText(" ");
		descriptionContent.setText(" ");
		habitatContent.setText(" ");
		prevalenceContent.setText(" ");
		sourcesContent.setText(" ");
		
		if (speciesSelected.equals("rafflesia")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.rafflesia));
			commonNameContent.setText("Rafflesia");
			scientificNameContent.setText("Rafflesia arnoldii");
			familyContent.setText("Rafflesiaceae");
			descriptionContent.setText("The Rafflesia arnoldii is the world's largest flower with a diameter of approximately 1 m and can weigh up to 11 kilograms. It lives as a parasite on the Tetrastigma vine. Similar to fungi, individuals grow as thread-like strands of tissue completely embedded within and in intimate contact with surrounding host cells from which nutrients and water are obtained. This plant produces no leaves, stems or roots and does not have chlorophyll. It can only be seen when it is ready to reproduce. The only part of Rafflesia that is identifiable as distinctly plant-like are the flowers; although, even these are unusual since they attain massive proportions, have a reddish-brown coloration and smell of rotting flesh. It is named after adventurer and founder of the British colony of Singapore, Sir Stamford Raffles.");
			habitatContent.setText("As a parasite it grows on Tetrastigma vine, which grows only in primary (undisturbed) rainforests. It can be found in the jungles of southeast Asia, including the Philippines.");
			prevalenceContent.setText("");
			sourcesContent.setText("Wikipedia, Sabah travel guide, Parasitic Plants: Rafflesia arnoldii, Lost World Arts");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("tetrastigma")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.tetrastigma));
			commonNameContent.setText("Tetrastigma");
			scientificNameContent.setText("Tetrastigma");
			familyContent.setText("Vitaceae");
			descriptionContent.setText("Tetrastigma is a genus of plants in the grape family, Vitaceae. The plants are vines that climb with tendrils and have palmately compound leaves. Species of this genus are notable as being the sole hosts of parasitic plants in the family Rafflesiaceae, one of which, Rafflesia arnoldii, produces the largest flower in the world.");
			habitatContent.setText("The species are found in subtropical and tropical regions of Asia, Malesia, and Australia, where they grow in primary rainforest, gallery forest and monsoon forest and moister woodland.");
			prevalenceContent.setText("");
			sourcesContent.setText("ZipcodeZoo, Flora of Singapore, Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("strangler_fig")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.strangler_fig));
			commonNameContent.setText("Strangler fig");
			scientificNameContent.setText("Ficus kerkhovenii");
			familyContent.setText("Ficus");
			descriptionContent.setText("Ficus kerkhovenii is also known as Johor fig and is a subspecies of Ficus of the Strangler Fig variety. Strangler Fig is the common name for a number of tropical and subtropical plant species, including some banyans and unrelated vines, among many other species. Figs are known as a keystone species in the tropics, since they fruit year round providing a constant source of food for many birds and mammals. Fig-eating animals repay the trees by spreading their seeds and genetics across the forest.");
			habitatContent.setText("The Strangler fig lives in the lowland rainforest of Borneo.");
			prevalenceContent.setText("");
			sourcesContent.setText("Wikipedia, Mongabay");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("amorphophallus_titanum")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.titan_arum));
			commonNameContent.setText("Titan arum");
			scientificNameContent.setText("Amorphophallus titanum");
			familyContent.setText("Araceae");
			descriptionContent.setText("A mature underground corm (tuber) produces a huge aroid bloom (inflorescence) which is usually taller than a man. When it first emerges the spadix is completely enveloped in the spathe and bracts, but as it develops the growth rate of the spadix accelerates rapidly. It is ranked as the largest unbranched inflorescence in the world, which is produced by the largest tuber. A single huge leaf will emerge sometime after the flower resembling a sapling tree. A mature leaf is patterned with irregular pale green blotches and at the apex divides into an umbrella of leaflets up to 49 feet in circumference. The Amorphophallus titanum is difficult to cultivate because it is prone to rotting, does not reliably increase in size and fails to produce seeds or offsets as easily as other species of Amorphophallus. The plants rarely set seeds and have difficulty pollenating, because the female flowers open first and by the time the male florets are producing pollen they are no longer receptive. Each plant contains both flowers and florets. Pollination is believed to be performed by large carrion beetles lured by the powerful odor of decaying flesh. This overpowering stench is released in waves when the flowers are ready for pollination.");
			habitatContent.setText("The Amorphophallus titanum is found in the rainforests of western Sumatra.");
			prevalenceContent.setText("");
			sourcesContent.setText("Virtual Herbarium");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("ficus_benjamina")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.benjamin_fig));
			commonNameContent.setText("Benjamin's fig");
			scientificNameContent.setText("Ficus benjamina");
			familyContent.setText("Moraceae");
			descriptionContent.setText("The Benjamin fig, also known as Weeping Chinese Banyan, weeping fig, is on of the largest flowering ficus plants. Members of the genus are usually treated as a separate tribe within Moraceae because of their unique inflorescence and wasp-dependent system of pollination. It is a topiary tree reaching 30 metres in height, with gracefully drooping branchlets and glossy leaves 6-13 cm long, with an oval with an acuminate tip. In its native range, its small fruit are a favorite food of some birds, such as the Superb Fruit-dove, Wompoo Fruit-dove, Pink-spotted Fruit-dove, Ornate Fruit-dove, Orange-bellied Fruit-dove, Torresian Imperial-pigeon, Purple-tailed Imperial-pigeon. Roots are adventitious, occasionally hanging and its bark is gray and smooth. Its branchlets brown and glabrous.");
			habitatContent.setText("This ficus is located in the southeast Asia forest.");
			prevalenceContent.setText("");
			sourcesContent.setText("ZipcodeZoo, Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("ficus_microcarpa")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.curtain_fig));
			commonNameContent.setText("Curtain fig, Indian laurel fig, laurel fig, Malay banyan");
			scientificNameContent.setText("Ficus microcarpa");
			familyContent.setText("Moraceae");
			descriptionContent.setText("The Ficus microcarpa is very attractive to avian wildlife. Its fruit and leaves are also sought after and eaten by the parrot Aratinga leucophthalmus. Although invasive, its hardiness makes it an important species for the attraction of avian wildlife in urban environments. It is pollinated by the fig wasp, Eupristina verticillata.");
			habitatContent.setText("This ficus is found in Sumatra rainforest.");
			prevalenceContent.setText("");
			sourcesContent.setText("United States Dept. of Agriculture, Ficus images, Wikipedia, Neotropical Entomology");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
//************************************************************************************************
		else if (speciesSelected.equals("striped_rabbit")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.striped_rabbit));
			commonNameContent.setText("Sumatran striped rabbit");
			scientificNameContent.setText("Nesolagus netscheri");
			familyContent.setText("Leporidae");
			descriptionContent.setText("The Sumatran Striped Rabbit is usually about 40 cm (1 ft, 4 in) long. It is gray with brown stripes, with a red tail and rump, and the underside is white. It is nocturnal, resting in the burrows of other animals. It usually eats the stalk and leaves of understory plants, but captive rabbits ate grain, and tropical fruits. It is relatively unknown as it isn't seen often.");
			habitatContent.setText("It lives in forests along the mountainous edges of Sumatr, at altitudes of 600-1400 metres.");
			prevalenceContent.setText("It is critically endangered because of loss of habitat.");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("leaf_monkey")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.mitered_leaf_monkey));
			commonNameContent.setText("Mitered leaf monkey, Sumatran surili");
			scientificNameContent.setText("Presbytis melalophos");
			familyContent.setText("Cercopithecidae");
			descriptionContent.setText("The pollex (thumb) is reduced in this species. The orbits are widely spaced and the hindlimbs are longer as compared to the forelimbs. The average body mass for an adult male mitered leaf-monkey is around 5.9 kilograms, and for the female it is around 5.8 kilograms. This species has a sacculated stomach to assist in the breakdown of cellulose. Infants have a white pelage color with a dark stripe down the back and across the shoulders.");
			habitatContent.setText("This species lives in primary lowland rainforests, hill forests, inland secondary forests, and submontane forests.");
			prevalenceContent.setText("The species is considered Endangered due to ongoing population declines driven by habitat conversion and illegal collecting for the pet trade. Although forest loss has probably exceeded 70% over 3 generations (30 years approximately), the subspecies is tolerant to some degree of conversion such that it is likely to persist in fragmented landscapes over the medium term.");
			sourcesContent.setText("Primata");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("malayan_tapir")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.tapir));
			commonNameContent.setText("Malayan tapir");
			scientificNameContent.setText("Tapirus indicus");
			familyContent.setText("Tapiridae");
			descriptionContent.setText("Also known as the Asian Tapir, the Malayan Tapir (Tapirus indicus) is the largest of the four species of tapir and the only one native to Asia. In the Malay language, the tapir is commonly referred to as \"cipan\", \"tenuk\" or \"badak tampong\". It has notable markings of a light colored patch which extends from its shoulders to its rear. The the rest of its hair is black and tips of ears white; The pattern is for camouflage. It grows to 1.8 to 2.4 meters in length and stands 90 to 107 cm tall. The females are larger than males. They have poor eyesight but excellent sense of small. They communicate with high-pitched squeaks and whistles. They are active at night, eating as soon after sunset or before sunrise.");
			habitatContent.setText("Found in lowland rainforests. They live near water so they can bathe and swim often. They can also climb steep slopes of their habitat.");
			prevalenceContent.setText("The deforestation for agricultural purposes and the damming of rivers for hydroelectric projects have caused flooding of habitat for the tapir.");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("sumatran_orangutan")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.sumatran_orangutan));
			commonNameContent.setText("Sumatran orangutan");
			scientificNameContent.setText("Pongo abelii");
			familyContent.setText("Hominidae");
			descriptionContent.setText("One of two species of orangutans, it is rarer and smaller than Bornean orangutan. The Sumatran and Bornean species diverged 400,000 years ago, but the two islands split at least 21,000 years ago. It has a red-orange coat of hair, and white around the mouth. The Sumatra orangutan grows to a height of 1.4 metres tall and 90 kilograms in males and the females are smaller 90 centimetres and 45 kilograms. These orangutans tend to be more frugivorous (i.e., likes figs and jackfruits) and insectivorous. It will also eat birds' eggs and small vertebrates. It has been observed using tools as it breaks tree branches off and use it dig in tree holes for termites or poke bees nest walls for honey, or to eat fruit. The Sumatra orangutans are more social than Bornean.");
			habitatContent.setText("Lives in rainforest and swamps of Sumatra in the Suaq Balimbing swamp. These organutans are the largest of the tree-dwelling primates.");
			prevalenceContent.setText("There are 7,300 Sumatran organutans that still live in the wild and they are critically endangered. There are no more than 6-7 orangutan's per square kilometer.");
			sourcesContent.setText("Wikipedia, Nature wildlife, Sumatra Orangutan Chapter 2, Know your Orangutan, Primatology");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("sunda_leopard")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.clouded_leopard));
			commonNameContent.setText("Sunda clouded leopard");
			scientificNameContent.setText("Neofelis diardi");
			familyContent.setText("Felidae");
			descriptionContent.setText("The Sunda Clouded Leopard, also known as the Sundaland Clouded Leopard and the Bornean clouded leopard is a medium-sized wild cat found in Borneo and Sumatra. The Sunda clouded leopard is the largest felid in Borneo, and has a stocky build, weighing around 12 to 25 kg (26 to 55 lb). The canine teeth are two inches long, which, in proportion to the skull length, are longer than those of any other extant feline. Its tail can grow to be as long as its body, aiding balance. Its coat is marked with irregularly-shaped, dark-edged ovals which are said to be shaped like clouds, hence its common name. In 2006, it was classified as a separate species, distinct from its continental relative Neofelis nebulosa.");
			habitatContent.setText("Sunda clouded leopards are largely unknown because of their secretive nature. In Borneo, they occur in lowland rainforest, and at lower density, in logged forest. Records in Borneo are below 1,500 m (4,900 ft). In Sumatra, they appear to be more abundant in hilly, montain areas. It is unknown if there are still Sunda clouded leopards on the small Batu Islands close to Sumatra.");
			prevalenceContent.setText("In 2008, the IUCN classified the species as vulnerable, with a total effective population size suspected to be fewer than 10,000 mature individuals, and a decreasing population trend.");
			sourcesContent.setText("New Species Declared: Clouded Leopard found on Borneo and Sumatra, Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("sumatran_rhino")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.sumatran_rhino));
			commonNameContent.setText("Sumatran rhinoceros");
			scientificNameContent.setText("Dicerorhinus sumatrensis");
			familyContent.setText("Rhinocerotidae");
			descriptionContent.setText("The Sumatran rhino lives an estimated 30-45 years in the wild. They are the most vocal of the rhinoceros species as they produce a whistle blowing sound, but the vocalization has unknown purpose. They are solitary creatures except when pairing prior to mating and during child rearing. They are most active when eating at dawn or just after dusk, loves to wallow in mud baths to cool down and rest. In rainy seasons, the rhinos will move to higher elevations and in cooler months in the lower areas. The Sumatran Rhinos are fast and agile; they climb mountains easily and comfortably traverses steep slopes and riverbanks.");
			habitatContent.setText("Sumatran Rhinos live in both lowland and highland secondary rainforest, swamps and the cloud forest. They prefer hilly areas close to water, particularly steep upper valleys with a lot of undergrowth. Known to be in Sumatra, Sabah and Borneo (used to live more places; only six known communities contain Sumatran Rhinos).");
			prevalenceContent.setText("Fewer than 275 individuals remain and seen as critically endangered primarily due to illegal poaching and habitat loss due to hardwood production from the rainforests. The rhino horns are used in amulets for protection and is seen as an aphrodisiac. Although traditional Chinese medicine never used it for this purpose.");
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("sumatran_tiger")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.sumatran_tiger));
			commonNameContent.setText("Sumatran tiger");
			scientificNameContent.setText("Panthera tigris sumatrae");
			familyContent.setText("Felidae");
			descriptionContent.setText("The Sumatran tiger is the smallest of the tiger subspecies. Sumatran male tigers average 2.438m in length and weigh about 120.2kg, while the Sumatran Females average 2.134m in length and weigh about 90.718kg. Their small size helps them move through the jungle. Their wide black stripes patterning is closely spaced, and sometimes double up on each other. These stripes also run down the animal's forelegs, a distinction setting them apart from the Siberian Tiger. The stripping is adapted for camouflage in the tall grass and underbush. Another adaptation is that the Sumatran Tiger's coat is slightly different from the other tiger subspecies. This evolution adaptation to their environment give the them the darkest coat of all tigers. Males are more bearded and maned neck and cheek is developed. They have webbed toes and are fast swimmers because they run their prey into the water. White spots on the back of tiger's ears are called \"eye spots\" or \"predator spots\". These spots are believed to function as false eyes as well as to make it look larger to any predator approaching from behind. This is particularly helpful in keeping the cubs safe. They prey on larger ungulates, wild boar, Malayan tapir, deer, smaller animals fowl, monkeys, fish, and mice.");
			habitatContent.setText("Only found in Sumatra, which provides a varying landscape in which this tiger lives. From peat-moss forest, submountain and mountain forest as well as lowland forest. The agriculture of Sumatra has changed and thus caused problems for the tigers.");
			prevalenceContent.setText("There are no more than 500 tigers left in the wild due to the continual loss of habitat. The deforestation from the production of palm oil and agricultural growth has made habitat for tigers fragmented. There are no more than 500 tigers left in the wild.");
			sourcesContent.setText("Wikipedia, Tiger Homes");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("fig_wasp_sumatra")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.fig_wasp2));
			commonNameContent.setText("Fig wasp");
			scientificNameContent.setText("Eupristina verticillata");
			familyContent.setText("Agaonidae");
			descriptionContent.setText("Also known as the Chinese banyan pollinator wasp, the Eupristina verticillata is a sub species of fig wasps in from the Agaonidae family. They pollinate figs or are otherwise associated with figs in a coevolutional relationship that has been developing for at least 80 million years.");
			sourcesContent.setText("Bugs in the news, Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("fig_wasp_borneo")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.fig_wasp1));
			commonNameContent.setText("Fig wasp");
			scientificNameContent.setText("Agaoninae spp.");
			familyContent.setText("Agaonidae");
			descriptionContent.setText("Fig wasps are most known for their role in pollinating figs (ficus). Fig wasps and figs have had a co-evolutional relationship developed for at least 80 million years. They fly farther than any other insect. Females have normal wings and males are wingless. The males only role is to mate with the female in the fig and then make a tunnel in the fig for the female to fly out. The life cycle of the fig wasp is closely intertwined with fig tree it inhabits. There are two broad categories for fig wasps based on their relation with fig tree: (a) pollinating wasps that have a symbiotic relationship with tree; or (b) non-pollinating wasps that are parasitic. Both life cycles are similar. Fig wasps larvae develop inside the fig (inflorescence) and when it is time to reproduce, the adult female leave the fig tree. They carry pollen from their natal fig to a another tree.");
			habitatContent.setText("Tropical and subtropical areas");
			prevalenceContent.setText("");
			sourcesContent.setText("Figweb, Wikipedia, Figs and Wasps, Fig wasps and their Figs");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("rhino_hornbill")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.rhinoceros_hornbill));
			commonNameContent.setText("Rhinoceros hornbill");
			scientificNameContent.setText("Buceros rhinoceros");
			familyContent.setText("Bucerotidae");
			descriptionContent.setText("The Buceros rhinoceros is one of the largest hornbilled species. The adults being 110-127 cm (43-50 in) long and weigh 2-3 kg (4.4-6.6 lbs). The male has orange or red eyes and the female has whitish eyes. It has a mainly white beak and casque with the tip that curves upwards, but there are orange places here and there. It has white underparts, especially near the tail. The rhinoceros hornbill eats fruit, insects, small reptiles, rodents and smaller birdsThe males pack mud, food, feces in trees for female and eggs. There is a very small hole in the trees to allow males to feed the female and chicks.");
			habitatContent.setText("The rhinoceros hornbill lives in captivity for up to 35 years. It is found in only the highest form of rain forest. This bird lives in the Malay Peninsula, Singapore, Sumatra, Java, and Borneo.");
			prevalenceContent.setText("This species is near threat due to habitat distruction.");
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("helmeted_hornbill")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.helmeted_hornbill));
			commonNameContent.setText("Helmeted hornbill");
			scientificNameContent.setText("Rhinoplax vigil");
			familyContent.setText("Bucerotidae");
			descriptionContent.setText("The helmeted hornbill has a blackish plumage, except for the belly, legs and tail which is white. The tail is long and the two central tail feathers are longer than others. The bird length is 160 cm with a body length 95-120 cm. It has a bare wrinkled throat patch (blue in females and red in males). They have a call that is described as hoots followed by maniacal laughter. It eats mostly fruit (figs) and its beak is casque and is valuable as carving material.");
			habitatContent.setText("The helmeted hornbills are found in the forests of Borneo.");
			prevalenceContent.setText("The helmeted hornbill is evaluated as near threatened on the IUCN Red List due to hunting and loss of habitat.");
			sourcesContent.setText("");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("grey_hornbill")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.malabar_grey_hornbill));
			commonNameContent.setText("Grey hornbill");
			scientificNameContent.setText("Ocyceros griseus");
			familyContent.setText("Bucerotidae");
			descriptionContent.setText("Hornbills are a family of bird found in tropical and subtropical Africa, Asia and Melanesia. They are characterized by a long, down-curved bill which is frequently brightly-colored and sometimes has a casque on the upper mandible. The plumage of hornbills is typically black, grey, white, or brown, although typically offset by bright colours on the bill, or patches of bare coloured skin on the face or wattles. Hornbills are the only birds in which the first two neck vertebrae (the axis and atlas) are fused together; this probably provides a more stable platform for carrying the bill. Both the common English and the scientific name of the family refer to the shape of the bill, \"buceros\" being \"cow horn\" in Greek. The family is omnivorous, feeding on fruit and small animals. They are monogamous breeders nesting in natural cavities in trees and sometimes cliffs. Males are always bigger than the females seen in the wing size. The heavy bill supported by a powerful neck muscles and fused vertebrae is a distinctive feature. The large bill assists in fighting, preening, and constructing the nest, as well as catching prey.");
			habitatContent.setText("The hornbills can be found in the dense forests of Bornea.");
			prevalenceContent.setText("Many Asian species of hornbill are threatened with extinction due to hunting and habitat loss, as they tend to require primary forest.");
			sourcesContent.setText("");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("proboscis_monkey")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.proboscis_monkey));
			commonNameContent.setText("Proboscis monkey");
			scientificNameContent.setText("Nasalis larvatus");
			familyContent.setText("Cercopithecidae");
			descriptionContent.setText("The proboscis monkey or the long-nosed monkey, is known as the bekantan in Malay. It is a reddish-brown arboreal Old World monkey that is endemic to the south-east Asian island of Borneo. The monkey also goes by the Malay name monyet belanda (\"Dutch monkey\"), or even orang belanda (\"Dutchman\"), as Indonesians remarked that the Dutch colonisers often had a similarly large belly and nose. Their large nose (up to 30 cm in length) is a resonating chamber amplifying their warning calls. When the animal becomes agitated its nose swells with blood (making warning calls louder and more intense). The large nose in males is thought to be used to attract females.");
			habitatContent.setText("The Proboscis monkey is endemic to Borneo's low elevation mangrove forests, swamps, and lowland riparian forests. One of the largest populations is found in the Danau Sentarum National Park. It lives in small groups of 10 to 32 animals. Group membership is very flexible, and animals are known to move from group to group quite often.");
			prevalenceContent.setText("The Proboscis monkey is assessed as endangered and its total population has decreased by more than 50% in the 36-40 years to 2008 due to ongoing habitat loss and hunting in some areas. Much of the population is fragmented.");
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
		else if (speciesSelected.equals("borneo_orangutan")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.borneo_orang));
			commonNameContent.setText("Borneo orangutan");
			scientificNameContent.setText("Pongo pygmaeus");
			familyContent.setText("Hominidae");
			descriptionContent.setText("The Bornean orangutan is a species of orangutan native to the island of Borneo. Together with the slightly smaller Sumatran orangutan, it belongs to the only genus of great apes native to Asia. The Bornean orangutan has a life span of up to 35 years in the wild. A survey of wild orangutans found that males are bigger (75 kilograms) than females (50-100 kiograms) Its diet consists of fruit as well as shoots, bark and bird eggs. It also eats insects but to a lesser extent than the Sumatran orangutan. Bornean orangutans have been sighted using spears to catch fish. The Bornean orangutan travels on the ground more than its Sumatran counterpart. It is theorized this may be in part because there is no need to avoid the large predators which only exist in Sumatra, such as the Sumatran Tiger.");
			habitatContent.setText("The Bornean orangutan lives in tropical and subtropical moist broadleaf forests in the Bornean lowlands as well as mountainous areas 1,500 metres (4,900 ft) in elevation. It lives at different heights in the trees and moves large distances to find trees bearing fruit.");
			prevalenceContent.setText("The Bornean orangutan is more common than the Sumatran, with about 54,500 individuals in the wild. They are an endangered species due to habitat destruction and the bushmeat trade. Young orangutans are also captured and sold as pets leaving their mothers dead in the process. The total number of Bornean orangutans is estimated to be less than 14 percent of what it was in the recent past (from around 10,000 years ago until the middle of the twentieth century).");
			sourcesContent.setText("Wikipedia, Animal Diversity Web, OrangutansWWF");
			speciesDrawn.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
		}
//************************************************************************************************************************
		else if (speciesSelected.equals("sud_orangutan")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Orangutan");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Pongo");
			descriptionContent.setText("Orangutans are the only exclusively Asian genus of extant great ape. The largest living arboreal animals, they have longer arms than the other, more terrestrial, great apes. They are among the most intelligent primates and use a variety of sophisticated tools, also making sleeping nests each night from branches and foliage. Their hair is typically reddish-brown, instead of the brown or black hair typical of other great apes.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_leopard")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Clouded leopard");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Neofelis");
			descriptionContent.setText("Clouded leopards have a tan or tawny coat, and are distinctively marked with large, irregularly-shaped, dark-edged ellipses which are said to be shaped like clouds. This unique appearance gave the cat both its common and scientific species name nebulosus, which is Latin for \"cloudy\".");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("IUCN, National Zoo, Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_fig_wasp")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Fig wasp");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Agaonidae");
			descriptionContent.setText("Fig wasps pollinate figs (ficus) and have a co-evolutional relationship developed for at least 80 million years. They fly farther than any other insect. The females have normal wings and the males are wingless. Their only task is to mate with female (in the fig) and make a tunnel in the fig for the female to fly out. Life cycle of the fig wasp is closely intertwined with that of the fig tree it inhabits. The wasps that inhabit a particular tree can be loosely divided into two groups; pollinating and non-pollinating. The pollinating variety forms a mutually beneficial symbiosis with the tree, whereas the non-pollinating variety is parasitic. Both life cycles, however, are very similar. Fig wasp larvae develop inside a fig inflorescence, and to reproduce, the short-lived adult female. As wasps disperse they carry pollen from their natal fig to another tree.");
			habitatContent.setText("These fig wasps live in the tropical and subtropical areas of Sundaland.");
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Figweb, Wikipedia, Figs and Wasps, Fig wasps and their Figs");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_proboscis_monkey")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Proboscis monkey");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Cercopithecidae");
			descriptionContent.setText("The proboscis monkey (long-nosed monkey), is known as the bekantan in Malay. It is a reddish-brown arboreal Old World monkey that is endemic to the south-east Asian island of Borneo. Although the pig-tailed langur has traditionally also been included in this genus - a treatment still preferred by some. The monkey also goes by the Malay name monyet belanda (\"Dutch monkey\"), or even orang belanda (\"Dutchman\"), as Indonesians remarked that the Dutch colonisers often had a similarly large belly and nose (large nose can be 30 cm in length or 7 inches); the nose is a resonating chamber amplifying their warning calls; and when the animal becomes agitated its nose swells with blood (making warning calls louder and more intense).");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_hornbill")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Hornbill");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Bucerotidae");
			descriptionContent.setText("The most distinctive feature of the hornbills is the heavy bill, supported by powerful neck muscles as well as by the fused vertebrae. The large bill assists in fighting, preening, and constructing the nest, as well as catching prey. A feature unique to the hornbills is the casque, a hollow structure that runs along the upper mandible. In some species it is barely perceptible and appears to serve no function beyond reinforcing the bill. In other species it is quite large, is reinforced with bone, and has openings between the hollow centre allowing serve as a resonator for calls.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_tiger")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Tiger");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Felidae");
			descriptionContent.setText("The tiger (Panthera tigris), a member of the Felidae family, is the largest of the four \"big cats\" in the genus Panthera. The tiger is native to much of eastern and southern Asia, and is an apex predator and an obligate carnivore. Aside from their great bulk and power, their most recognisable feature is a pattern of dark vertical stripes that overlays near-white to reddish-orange fur, with lighter underparts.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_rhino")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Rhinoceros");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Rhinocerotidae");
			descriptionContent.setText("The Rhinocertoidae of Sundaland lives an estimated 30-45 years in the wild. They are the most vocal of the rhinoceros species as they produce a whistle blowing sound, but the vocalization has unknown purpose. They are solitary creatures except when pairing prior to mating and during child rearing. They are most active when eating at dawn or just after dusk, loves to wallow in mud baths to cool down and rest. In rainy seasons, the rhinos will move to higher elevations and in cooler months in the lower areas. These rhinos are fast and agile; they climb mountains easily and comfortably traverses steep slopes and riverbanks.");
			habitatContent.setText("These rhinos live in both lowland and highland secondary rainforest, swamps and the cloud forest. They prefer hilly areas close to water, particularly steep upper valleys with a lot of undergrowth.");
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_tapir")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Tapir");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Tapiridae");
			descriptionContent.setText("Also known as the Asian Tapir, the Malayan Tapir (Tapirus indicus) is the largest of the four species of tapir and the only one native to Asia. In the Malay language, the tapir is commonly referred to as \"cipan\", \"tenuk\" or \"badak tampong\". It has notable markings of a light colored patch which extends from its shoulders to its rear. The the rest of its hair is black and tips of ears white; The pattern is for camouflage. It grows to 1.8 to 2.4 meters in length and stands 90 to 107 cm tall. The females are larger than males. They have poor eyesight but excellent sense of small. They communicate with high-pitched squeaks and whistles. They are active at night, eating as soon after sunset or before sunrise.");
			habitatContent.setText("Found in lowland rainforests. They live near water so they can bathe and swim often. They can also climb steep slopes of their habitat.");
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_rabbit")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Rabbit");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Leporidae");
			descriptionContent.setText("Leporids are small to moderately sized mammals, adapted for rapid movement. They have long hind legs, with four toes on each foot, and shorter fore legs, with five toes each. The soles of their feet are hairy, to improve grip while running, and they have strong claws on all of their toes. Leporids also have distinctive, elongated and mobile ears, and they have an excellent sense of hearing. Their eyes are large, and their night vision is good, reflecting their primarily nocturnal or crepuscular mode of living.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_rafflesia")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Rafflesia");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Rafflesia");
			descriptionContent.setText("This flower has a diameter of approximately 1 m (3 ft) and weight of up to 11 kilograms (24 lb). It lives as a parasite on an unknown vine, which grows only in primary (undisturbed) rainforests. Similar to fungi, individuals grow as thread-like strands of tissue completely embedded within and in intimate contact with surrounding host cells from which nutrients and water are obtained. This plant produces no leaves, stems or roots and does not have chlorophyll. It can only be seen when it is ready to reproduce. The only part of the corpse flower that is identifiable as distinctly plant-like are the flowers; although, even these are unusual since they attain massive proportions, have a reddish-brown coloration and smell of rotting flesh.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia, Sabah travel guide, Parasitic Plants: Rafflesia arnoldii, Lost World Arts");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_strangler_fig")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Strangler fig");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Ficus");
			descriptionContent.setText("Strangler fig is the common name for a number of tropical and subtropical plant species, including some banyans and unrelated vines, among many other species. Figs are known as a keystone species in the tropics, since they fruit year round providing a constant source of food for many birds and mammals. Fig-eating animals repay the trees by spreading their seeds and genetics across the forest.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Wikipedia, Mongabay");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_tetrastigma")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Tetrastigma");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Tetrastigma");
			descriptionContent.setText("The grape vine climb with tendrils and have palmately compound leaves. A species of the grape vine is notable as being the sole host of the parasitic corpse flower.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("ZipcodeZoo, Flora of Singapore, Wikipedia");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_curtain_fig")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Curtain fig");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Ficus");
			descriptionContent.setText("In some parts of its introduced range, it is very attractive to avian wildlife. Although invasive, its hardiness makes it an important species for the attraction of avian wildlife in urban environments. It is pollinated by the a species of the fig wasp.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("United States Dept. of Agriculture, Ficus images, Wikipedia, Neotropical Entomology");
			speciesDrawn.setVisibility(View.GONE);
		}
		else if (speciesSelected.equals("sud_titan_arum")) {
			speciesPhoto.setImageDrawable(getResources().getDrawable(R.drawable.drawn_sumatran_rabbit));
			commonNameContent.setText("Titan arum");
			scientificNameContent.setVisibility(View.GONE);
			scientificNameField.setVisibility(View.GONE);
			familyField.setText("Genus: ");
			familyContent.setText("Amorphophallus");
			descriptionContent.setText("A mature underground corm (tuber) produces a huge aroid bloom (inflorescence) which is usually taller than a man. Pollination of the tall corpse flower is believed to be performed by large carrion beetles lured by the powerful odor of decaying flesh. This overpowering stench is released in waves when the flowers are ready for pollination.");
			habitatField.setVisibility(View.GONE);
			habitatContent.setVisibility(View.GONE);
			prevalenceContent.setVisibility(View.GONE);
			prevalenceField.setVisibility(View.GONE);
			sourcesContent.setText("Virtual Herbarium");
			speciesDrawn.setVisibility(View.GONE);
		}
		else {
			commonNameContent.setText("");
			scientificNameContent.setText("");
			familyContent.setText("");
			descriptionContent.setText("");
			habitatContent.setText("");
			prevalenceContent.setText("");
			sourcesContent.setText("");
		}

	}

	private void changeVis(int vis) {
        findViewById(R.id.field_guide_area_selector).setVisibility(View.GONE);
    	findViewById(R.id.field_guide_species_selector).setVisibility(View.GONE);
        findViewById(R.id.field_guide_species_display).setVisibility(View.GONE);
        findViewById(vis).setVisibility(View.VISIBLE);
	}

	//override to disable the back button
	public void onBackPressed() {
	   return;
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
