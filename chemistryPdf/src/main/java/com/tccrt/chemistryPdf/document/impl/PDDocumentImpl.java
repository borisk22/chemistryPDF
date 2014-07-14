package com.tccrt.chemistryPdf.document.impl;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.tccrt.chemistryPdf.document.BaseDocument;
import com.tccrt.chemistryPdf.model.Chemistry;
import com.tccrt.chemistryPdf.model.Compound;

/**
 * Apache PDFBox implementation of chemistryPDF document.
 * @author boris
 *
 */
public class PDDocumentImpl extends BaseDocumentImpl implements BaseDocument {

	private PDDocument pdDocument;		
	private PDPage page;
	//
	private String fileName;
	private String fileLocation;
	//
	
	//
	PDFont font = PDType1Font.HELVETICA_BOLD; // TODO this will go in Atom class
	//
	private PDPageContentStream contentStream;
	
	public void init() {
		if (template!=null) {
			loadTemplate();
			page=(PDPage) pdDocument.getDocumentCatalog().getAllPages().get(0);
		} else {
			COSDictionary pageDic=new COSDictionary();
			pageDic.setItem(COSName.SIZE, PDPage.PAGE_SIZE_A4);
			pdDocument = new PDDocument();
			page = new PDPage(pageDic);
			pdDocument.addPage( page );
		}
		try {
			contentStream = new PDPageContentStream(pdDocument, page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
	}

	protected void spillInternal(Chemistry atom, Boolean radical) {
		try {
			if (radical) {
				contentStream.beginText();
			}
			contentStream.setFont( font, 12 ); // TODO property in atom
			contentStream.moveTextPositionByAmount(atom.getX(), atom.getY());
			contentStream.drawString((String) atom.getFormated());  // TODO only text atoms for now	
			if (radical && !(atom instanceof Compound)) {
				contentStream.endText();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	protected void stopSpilling() {
		try {
			contentStream.endText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void spill() {
		for (Chemistry what : chemistry.values()) {
			spillInternal(what, what.getAbsPositioning());
			if (what instanceof Compound) {
				Compound compund=(Compound)what;
				for (Chemistry chemistry : compund.getIngredients()) {
					spillInternal(chemistry, false);  // absolute positioning ignored
				}
				stopSpilling();
			}
		}
	}

	public PDDocument getPdDocument() {
		return pdDocument;
	}

	public void setPdDocument(PDDocument pdDocument) {
		this.pdDocument = pdDocument;
	}

	@Override
	public void loadTemplate() {
		File templatePDF=new File(template);
		try {
			pdDocument=pdDocument.load(templatePDF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void save() {
		try {
			contentStream.close();
			pdDocument.save(fileLocation+fileName);
			pdDocument.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
