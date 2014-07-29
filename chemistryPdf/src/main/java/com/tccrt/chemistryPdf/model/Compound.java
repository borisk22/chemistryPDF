package com.tccrt.chemistryPdf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of atoms. It extends StringAtom to have header text.
 * @author boris
 *
 */
public class Compound extends StringAtom {
	
	private List<Chemistry> ingredients=new ArrayList<Chemistry>();

	
	public Compound() { // Header text
		super(null);
		format=null; 
	}
	
	public Compound(String value) { // Header text
		super(value);
		format=null; 
	}
	
	public void clear() {
		this.ingredients.clear();
	}
	
	public void add(Chemistry chemistry) {
		this.ingredients.add(chemistry);
	}
	
	public List<Chemistry> getIngredients() {
		return ingredients;
	}

	
	public void setIngredients(List<Chemistry>  ingredients) {
		this.ingredients = ingredients;
	}



}
