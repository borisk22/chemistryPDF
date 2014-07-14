package com.tccrt.chemistryPdf.model;

import java.text.DecimalFormat;
/**
 * Number atom. Simple usage for ordinary number we wont to write on document.
 * @author boris
 *
 */
public class DecimalAtom extends Atom<Double> {

	public DecimalAtom(Double value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object formatOutput(String format, Double value) {
		DecimalFormat decimalFormat=new DecimalFormat(format);
		return decimalFormat.format(value);
	}

}
