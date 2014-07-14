package com.tccrt.chemistryPdf.document.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.tccrt.chemistryPdf.document.BaseDocument;
import com.tccrt.chemistryPdf.model.Chemistry;

public abstract class BaseDocumentImpl implements BaseDocument {
	protected String template;
	private String fileName;
	private String fileLocation;
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
	
	@Override
	public void setChemistry(HashMap<String, Chemistry> chemistry) {
		this.chemistry=chemistry;		
	}

	@Override
	public HashMap<String, Chemistry> getChemistry() {
		return this.chemistry;
	}

}
