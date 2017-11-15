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
	static String filename="src/logs/samplexml";
	
	
	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.newDocument();
			// add element
			
			//root element 
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			
			//other lements
			Element lux = doc.createElement("luxury");
			root.appendChild(lux);

			Element poor = doc.createElement("commoner");
			root.appendChild(poor);
			
			
			Attr attrs = doc.createAttribute("company");
			attrs.setValue("Toyota");
			poor.setAttributeNode(attrs);
			
			
			
			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrari");
			lux.setAttributeNode(attr);
			
//			
//			Element root2 = doc.createElement("motorcycles");
//			doc.appendChild(root2);

		
			
			
			//write the content to xml
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr= tf.newTransformer();
			DOMSource source= new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
