package Logica;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import Interfaz.Main;
import Interfaz.PantallaDeTexto;

public class LeerDocx {	

	
	public void SetText(File file) {
		String Text = "";
		try {
			XWPFDocument document = new XWPFDocument(new FileInputStream(file.getAbsolutePath()));
			XWPFWordExtractor textExtractor = new XWPFWordExtractor(document);
			Text = textExtractor.getText();
				
			
		}catch(Exception e){
			System.out.println(e);
		}
		Main.texto.setText(Text);
		
	}
}
