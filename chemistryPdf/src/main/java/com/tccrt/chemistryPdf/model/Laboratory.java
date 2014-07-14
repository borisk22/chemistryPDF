package com.tccrt.chemistryPdf.model;

import java.util.HashMap;

/**
 * Basic interface for documents which will render chemistry objects
 * @author boris
 *
 */
public interface Laboratory {
	void spill();
	void setChemistry(HashMap<String, Chemistry> chemistry);
	HashMap<String, Chemistry> getChemistry();
}
