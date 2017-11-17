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
			
			// create XML document
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			// add elements:
			
			
			// root element:
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			// other elements:
			Element lux = doc.createElement("luxury");
			Element standard = doc.createElement("standard");
			root.appendChild(lux);
			root.appendChild(standard);
			
			Attr attr1 = doc.createAttribute("company");
			attr1.setValue("Ferrari");
			lux.setAttributeNode(attr1);
			
			Attr attr2 = doc.createAttribute("company");
			attr2.setValue("Toyota");
			standard.setAttributeNode(attr2);
			
			
			
			// write the content to the xml file
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			t.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			t.transform(source, consoleResult);
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
