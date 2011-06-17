package org.encorelab.sail.evoroom;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ObservationsEntryFragment extends Fragment {

	Spinner colourPicker = null;

	public static ObservationsEntryFragment newInstance() {
		ObservationsEntryFragment oe = new ObservationsEntryFragment();
		return oe;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.observations_entry, container, false);
		
		colourPicker = (Spinner) v.findViewById(R.id.colour_picker);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this.getActivity(), R.array.colours, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    colourPicker.setAdapter(adapter);
	    
	    return v;
	}
}
