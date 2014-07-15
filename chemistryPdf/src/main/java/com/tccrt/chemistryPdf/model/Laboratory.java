package com.tccrt.chemistryPdf.model;

import java.util.HashMap;

import javax.annotation.Resource;

/**
 * Basic interface for documents which will render chemistry objects
 * @author boris
 *
 */
public interface Laboratory {
	public  enum FlavorTypes {FontSize, FontStyle};
	void spill();
	HashMap<String, Chemistry> getChemistry();
	void setChemistry(HashMap<String, Chemistry> chemistry);
	void setDefaultFlavors(HashMap<FlavorTypes, Object> defaultFlavors);
	HashMap<FlavorTypes, Object> getDefaultFlavors();
}
