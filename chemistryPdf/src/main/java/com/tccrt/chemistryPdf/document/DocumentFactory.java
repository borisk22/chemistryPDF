package com.tccrt.chemistryPdf.document;

public interface DocumentFactory {
	BaseDocument getDocument(String documentName);
}
