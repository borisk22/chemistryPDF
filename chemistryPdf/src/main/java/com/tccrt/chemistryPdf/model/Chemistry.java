package com.tccrt.chemistryPdf.model;

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
	
}
