package com.tccrt.chemistryPdf.model;

/**
 * Pure text atoms. Simple usage for ordinary text we wont to write on document-
 * @author boris
 *
 */
public class StringAtom extends Atom<String> {

	public StringAtom(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object formatOutput(String format, String value) {
		return String.format(format, value);
	}

}
