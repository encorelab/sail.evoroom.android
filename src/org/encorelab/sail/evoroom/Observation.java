package org.encorelab.sail.evoroom;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "observations")
public class Observation {
	// id is generated by the database and set on the object automagically
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(index = true)
	private String item;
	@DatabaseField(index = true)
	private String area;
	@DatabaseField
	private String text;

	Observation() {
		// needed by ormlite
	}
	
	public void setObservationData (String observationItem, String observationArea, String observationText) {
		setItem(observationItem);
		setArea(observationArea);
		setText(observationText);
	}

	public int getId() {
		return id;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return item;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}


}