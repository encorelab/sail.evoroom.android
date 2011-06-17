package org.encorelab.sail.evoroom;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FieldGuideActivity extends Activity implements OnClickListener {
	
	private Button sundalandFloraButton;
	private Button sundalandFaunaButton;
	private Button borneoFloraButton;
	private Button borneoFaunaButton;
	private Button sumatraFloraButton;
	private Button sumatraFaunaButton;
	private Button allButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.field_guide);
		
		sundalandFloraButton = (Button) findViewById(R.id.sundalandFloraButton);
		sundalandFloraButton.setOnClickListener(this);
		sundalandFloraButton.setText(Html.fromHtml("<b>Sundaland Flora</b>" +  "<br />" + 
		            "<small>2 million years ago</small>"));
		sundalandFaunaButton = (Button) findViewById(R.id.sundalandFaunaButton);
		sundalandFaunaButton.setOnClickListener(this);
		sundalandFaunaButton.setText(Html.fromHtml("<b>Sundaland Fauna</b>" +  "<br />" + 
		            "<small>2 million years ago</small>"));
		borneoFloraButton = (Button) findViewById(R.id.borneoFloraButton);
		borneoFloraButton.setOnClickListener(this);
		borneoFloraButton.setText(Html.fromHtml("<b>Borneo Flora</b>" +  "<br />" + 
        			"<small>200 years ago</small>"));
		borneoFaunaButton = (Button) findViewById(R.id.borneoFaunaButton);
		borneoFaunaButton.setOnClickListener(this);
		borneoFaunaButton.setText(Html.fromHtml("<b>Borneo Fauna</b>" +  "<br />" + 
        			"<small>200 years ago</small>"));
		sumatraFloraButton = (Button) findViewById(R.id.sumatraFloraButton);
		sumatraFloraButton.setOnClickListener(this);
		sumatraFloraButton.setText(Html.fromHtml("<b>Sumatra Flora</b>" +  "<br />" + 
					"<small>200 years ago</small>"));
		sumatraFaunaButton = (Button) findViewById(R.id.sumatraFaunaButton);
		sumatraFaunaButton.setOnClickListener(this);
		sumatraFaunaButton.setText(Html.fromHtml("<b>Sumatra Fauna</b>" +  "<br />" + 
					"<small>200 years ago</small>"));
		allButton = (Button) findViewById(R.id.allButton);
		allButton.setOnClickListener(this);
		allButton.setText(Html.fromHtml("<b>All areas</b>"));
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){  
		case R.id.sundalandFloraButton:
			// launch activity;
			sundalandFloraButton.setText("SundaFlora");
			break;
		case R.id.sundalandFaunaButton:
			// launch activity;
			sundalandFaunaButton.setText("SundaFauna");
			break;
		case R.id.borneoFloraButton:
			// launch activity;
			borneoFloraButton.setText("bornFlora");
			break;
		case R.id.borneoFaunaButton:
			// launch activity;
			borneoFaunaButton.setText("bornFauna");
			break;
		case R.id.sumatraFloraButton:
			// launch activity;
			sumatraFloraButton.setText("sumatraFlora");
			break;
		case R.id.sumatraFaunaButton:
			// launch activity;
			sumatraFaunaButton.setText("sumatraFauna");
			break;
		case R.id.allButton:
			// Launch activity;
	    	allButton.setText("all");

		}
	}

}
