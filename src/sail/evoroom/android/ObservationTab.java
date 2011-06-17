package sail.evoroom.android;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ObservationTab extends ActivityGroup {
	protected static LocalActivityManager mLocalActivityManager;
	Button addObsButton;
	Spinner itemPicker = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.observationtab);
		
		itemPicker = (Spinner) findViewById(R.id.itempicker);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.items, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    itemPicker.setAdapter(adapter);
		
		addObsButton = (Button) findViewById(R.id.addobservationbutton);
		addObsButton.setOnClickListener(onSubmit);
	}

	public void onDestroy() {
		super.onDestroy();
	}
	
	public void replaceContentView(String id, Intent newIntent) {
		View view = getLocalActivityManager().startActivity(id,
				newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView();
		this.setContentView(view);
	}
	
	private View.OnClickListener onSubmit = new View.OnClickListener() {
		public void onClick(View v) {
			Intent observationsEntryIntent = new Intent(v.getContext(),
					ObservationsEntry.class);
			//StringBuffer urlString = new StringBuffer();
			// Activity1 parentActivity = (Activity1)getParent();
			replaceContentView("observationsEntryActivity", observationsEntryIntent);
		}
	};
}