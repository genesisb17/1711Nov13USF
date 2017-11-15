package com.revature.io;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	static String filename = "src/logs/samplexml.xml";
	
	public static void main(String[] args) {
		
		try {
			
			// create XML doc
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();			
			Document doc = dBuilder.newDocument();
			
			// add elemnts:
			
			
			// root element:
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			// other elements
			Element lux = doc.createElement("luxury");
			root.appendChild(lux);
			
			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrary");
			lux.setAttributeNode(attr);
			
			// write the content to xml
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);
			
			
			
			Element broke = doc.createElement("Broke");
			root.appendChild(broke);
			
			Attr attri = doc.createAttribute("company");
			attr.setValue("Toyota");
			lux.setAttributeNode(attri);
			
			// write the content to xml
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer trf = tff.newTransformer();
			DOMSource sourcee = new DOMSource(doc);
			StreamResult resultt = new StreamResult(new File(filename));
			trf.transform(sourcee, resultt);
			StreamResult consoleResultt = new StreamResult(System.out);
			trf.transform(source, consoleResultt);
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
