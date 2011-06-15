package sail.evoroom.android;


import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FieldGuideTab extends Activity implements OnClickListener {

	private Button sundalandButton;
	private Button borneoButton;
	private Button sumatraButton;
	private Button allButton;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.fieldguidetab);

		sundalandButton = (Button) findViewById(R.id.sundalandButton);
		sundalandButton.setOnClickListener(this);
		sundalandButton.setText(Html.fromHtml("<b>Sundaland Flora & Fauna</b>" +  "<br />" + 
		            "<small>2 million years ago</small>"));
		borneoButton = (Button) findViewById(R.id.borneoButton);
		borneoButton.setOnClickListener(this);
		borneoButton.setText(Html.fromHtml("<b>Borneo Flora & Fauna</b>" +  "<br />" + 
        			"<small>200 years ago</small>"));
		sumatraButton = (Button) findViewById(R.id.sumatraButton);
		sumatraButton.setOnClickListener(this);
		sumatraButton.setText(Html.fromHtml("<b>Sumatra Flora & Fauna</b>" +  "<br />" + 
					"<small>200 years ago</small>"));
		allButton = (Button) findViewById(R.id.allButton);
		allButton.setOnClickListener(this);
		allButton.setText(Html.fromHtml("<b>All areas</b>"));
    }
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){  
		case R.id.sundalandButton:
//			launch activity;
			sundalandButton.setText("Sunda");
			break;
		case R.id.borneoButton:
//			launch activity;
			borneoButton.setText("born");
			break;
		case R.id.sumatraButton:
//			launch activity;
			sumatraButton.setText("sumatra");
			break;
		case R.id.allButton:
//			Launch activity;
	    	allButton.setText("all");
	    	break;
		}
	}
}
			
			
//			private View.OnClickListener onClick = new View.OnClickListener() {
//			public void onClick(View v) {
//		    
//			switch(v.getId()){  
//		    case R.id.redPre:
//			}
//		};
	//}
