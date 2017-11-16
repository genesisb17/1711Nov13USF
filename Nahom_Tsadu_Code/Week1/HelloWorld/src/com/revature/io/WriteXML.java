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
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			Element lux = doc.createElement("luxury");
			Element eco = doc.createElement("economy");
			root.appendChild(lux);
			root.appendChild(eco);
			
			lux.setAttribute("make", "Ferrari");
			eco.setAttribute("make", "Honda");
			
			//write content to xml
			streamDOM(doc);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void streamDOM(Document d){
		try{
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer();
			DOMSource source = new DOMSource(d);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
