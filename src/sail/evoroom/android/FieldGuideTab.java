package sail.evoroom.android;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FieldGuideTab extends Activity implements OnClickListener {

	private Button allButton;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.fieldguidetab);

		allButton = (Button) findViewById(R.id.allButton);
//		allButton.setOnClickListener(onClick);
    }
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){  
	    case R.id.allButton:
//			Launch activity;
	    	allButton.setText("TEST");

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
