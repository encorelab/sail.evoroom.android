package sail.evoroom.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ObservationsEntry extends Activity {
	Spinner itemPicker = null;
	//private Spinner areaPicker = null;
	Button backButton = null;
	EditText enterObservation = null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.observationsentry);
		
		backButton = (Button) findViewById(R.id.backbutton);
		backButton.setOnClickListener(onBack);
		
		enterObservation = (EditText) findViewById(R.id.enterObservation);
	
		itemPicker = (Spinner) findViewById(R.id.itempicker);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.items, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    itemPicker.setAdapter(adapter);
	}
	
	public void onDestroy() {
		super.onDestroy();
	}
	
	private View.OnClickListener onBack = new View.OnClickListener() {
		public void onClick(View v) {
			Intent parentIntent = new Intent(v.getContext(), ObservationTab.class);
			StringBuffer urlString = new StringBuffer();
			ObservationTab parentActivity = (ObservationTab)getParent();
			parentActivity.replaceContentView("observationParentTab", parentIntent);
		}
	};
}
