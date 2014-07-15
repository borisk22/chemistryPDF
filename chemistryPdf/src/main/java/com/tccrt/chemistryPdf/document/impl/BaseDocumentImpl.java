package com.tccrt.chemistryPdf.document.impl;

import java.util.HashMap;

import com.tccrt.chemistryPdf.document.BaseDocument;
import com.tccrt.chemistryPdf.model.Chemistry;

public abstract class BaseDocumentImpl implements BaseDocument {
	protected String template;
	protected String fileName;
	protected String fileLocation;	
	
	protected HashMap<String, Chemistry> chemistry=new HashMap<String, Chemistry>();

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	

}
