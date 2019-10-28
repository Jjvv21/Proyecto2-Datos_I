package Logica;



import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import Interfaz.Main;

public class LeerPdf {

	public void PdfReader(File file) throws IOException {
		 try (PDDocument document = PDDocument.load(file)) {

	            document.getClass();

	            if (!document.isEncrypted()) {
				
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	                String pdfFileInText = tStripper.getText(document);
	                Main.texto.setText(pdfFileInText);
	             

	            }

	        }

	    }
		
	
}
