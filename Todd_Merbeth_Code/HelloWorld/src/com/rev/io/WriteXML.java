package com.rev.io;

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
			//create XML doc
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc =  dBuilder.newDocument();
			
			//add elements:
			
			//root element:
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			//other elements:
			Element lux = doc.createElement("luxury");
			root.appendChild(lux);
			
			Element econ = doc.createElement("economy");
			root.appendChild(econ);
			
			Element toy = doc.createElement("toy");
			root.appendChild(toy);
			
			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrari");
			lux.setAttributeNode(attr);
			
			Attr attr2 = doc.createAttribute("company");
			attr2.setValue("Toyota");
			econ.setAttributeNode(attr2);
			
			Attr attr3 = doc.createAttribute("company");
			attr3.setValue("HotWheels");
			toy.setAttributeNode(attr3);
			
			
			//write content to xml
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source,  result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
