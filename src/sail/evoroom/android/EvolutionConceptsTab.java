package sail.evoroom.android;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EvolutionConceptsTab extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.evolutionconceptstab);

		TextView textBox = null;

		textBox = (TextView) findViewById(R.id.evoConceptsText);
		textBox.setText("TEST");

	}
}