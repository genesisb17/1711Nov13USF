package com.revature.io;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	static String filename = "src/logs/samplexml.xml";
	
	public static void main(String[] args) {
		try{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			Element lux = doc.createElement("luxury");
			root.appendChild(lux);
			lux.setAttribute("Company", "Ferrari");
			Element cl = doc.createElement("Clunker");
			cl.setAttribute("Company", "Datsun");
			root.appendChild(cl);
			
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			tr.transform(source, new StreamResult(System.out));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
