package com.tccrt.chemistryPdf.model;

/**
 * Basic abstract atom class. It enables formating and storing of real value.
 * @author boris
 *
 * @param <T>
 */

public abstract class Atom<T> extends Chemistry {
	
	private T value;
			
	public Atom(T value) {
		super();
		this.value = value;
		this.formated=null; // is to be calculated
	}

	public T getValue() {
		return value;
	}
	
	public Object getFormated() {
		if (formated==null) {			
			if (format!=null && value!=null) { 
				formated=formatOutput(format, value);
				return formated;
			}
		}
		return value;
	}
		
	protected abstract Object formatOutput(String format, T value);


	public void setValue(T value) {
		this.value = value;		
	}
	
	

	
	
}
