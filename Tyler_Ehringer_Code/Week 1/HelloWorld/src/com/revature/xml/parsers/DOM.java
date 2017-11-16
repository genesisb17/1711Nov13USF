package com.revature.xml.parsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {

	/*
	 * Dom xml parser in Java:
	 * Dom stands for document object model and it represents xml in a tree format,
	 * where every element represents a tree branch.
	 * 
	 */
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
			doc.normalize();
			
			String root = doc.getDocumentElement().getNodeName();
			NodeList persons = doc.getElementsByTagName("person");
			for(int i = 0; i < persons.getLength(); i++) {
				NodeList leaves = persons.item(i).getChildNodes();
				for(int j = 0; j < leaves.getLength(); j++) {
					if(leaves.item(j).getNodeType() == Node.ELEMENT_NODE) 
						System.out.println(leaves.item(j).getTextContent());
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
