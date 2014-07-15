package com.tccrt.chemistryPdf.model;

import java.util.HashMap;

import com.tccrt.chemistryPdf.model.Laboratory.FlavorTypes;

/**
 * Basic abstract class for chemistry model objects. 
 * @author boris
 *
 */
public abstract class Chemistry {
	
	private String name;
	private Float x;
	private Float y;
	private Boolean absPositioning=true;		// TODO think about it, to bi considered 
	protected Object formated;					// formated representation of atom value
	protected String format;					// format for example, for date, decimal etc, but also to bee used as metadata for objects like images
	private HashMap<FlavorTypes, Object> flavor=new HashMap<FlavorTypes, Object>();
	
	public void addFlavor(FlavorTypes which, Object flavor) {
		this.flavor.put(which, flavor);
	}
	
	public Object getFlavor(FlavorTypes which, Object defaultFlavor) {
		if (this.flavor.containsKey(which)) {
			return this.flavor.get(which);			
		} else {
			return defaultFlavor;
		}
	}
	
	public String getName() {
		return name;
	}

	public Float getX() {
		return x;
	}

	public Float getY() {
		return y;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Boolean getAbsPositioning() {
		return absPositioning;
	}

	public void setAbsPositioning(Boolean absPositioning) {
		this.absPositioning = absPositioning;
	}
	
	public abstract Object getFormated();	

	public String getFormat() {
		return format;
	}
	
	
	public void setFormat(String format) {
		this.format=format;
	}

	public HashMap<FlavorTypes, Object> getFlavor() {
		return flavor;
	}

	public void setFlavor(HashMap<FlavorTypes, Object> flavor) {
		this.flavor = flavor;
	}
	
}
