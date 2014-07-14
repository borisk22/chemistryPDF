package com.tccrt.chemistryPdf.model;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * DateTime atom. Simple usage for date and/or time we wont to write on document.
 * @author boris
 *
 */
public class DateAtom extends Atom<Date> {

	public DateAtom(Date value) {
		super(value);
		// default format
		setFormat("dd.MM.yyyy");
	}

	@Override
	protected Object formatOutput(String format, Date value) {
		SimpleDateFormat dateFormat=new SimpleDateFormat(format);
		return dateFormat.format(value);
	}

}
