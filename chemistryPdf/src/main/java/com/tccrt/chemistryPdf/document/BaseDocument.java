package com.tccrt.chemistryPdf.document;

import com.tccrt.chemistryPdf.model.Laboratory;

public interface BaseDocument extends Laboratory {
	void loadTemplate(); // TODO add stream overloads
	void init();
	void save();
	
	public String getTemplate();

	public void setTemplate(String template);

	public String getFileName();

	public void setFileName(String fileName);

	public String getFileLocation();

	public void setFileLocation(String fileLocation);
	
}
