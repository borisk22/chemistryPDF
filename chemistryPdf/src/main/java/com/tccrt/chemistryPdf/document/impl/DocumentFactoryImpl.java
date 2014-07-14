package com.tccrt.chemistryPdf.document.impl;

import java.util.HashMap;

import com.tccrt.chemistryPdf.document.BaseDocument;
import com.tccrt.chemistryPdf.document.DocumentFactory;

/**
 * 
 * @author boris
 *
 */
public class DocumentFactoryImpl implements DocumentFactory {

	private HashMap<String, BaseDocument> documentMapCache;
	
	@Override
	public BaseDocument getDocument(String documentName)  {
		if (documentMapCache.containsKey(documentName)) {
			return documentMapCache.get(documentName);
		} else {
			// TODO initialize one and put/get it form cache
			return null;
		}
	}

	public HashMap<String, BaseDocument> getDocumentMapCache() {
		return documentMapCache;
	}

	public void setDocumentMapCache(HashMap<String, BaseDocument> documentMapCache) {
		this.documentMapCache = documentMapCache;
	}

}
