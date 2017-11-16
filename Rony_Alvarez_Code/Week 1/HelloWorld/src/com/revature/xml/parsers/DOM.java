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

	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		
		/*
		 * DOM XML Parser in Java
		 * It represents XML in a tree format, where every element represents a tree branch
		 * a DOM parser creates an in-memory tree representation of XML file, the parses it,
		 * so it requires more memory.
		 * DOM parsniig is fast for a small XML file bu it is sloww or may not even load larger files. 
		 */
		
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
			doc.normalize(); // optional but recommended
			
			// get root node
			String root = doc.getDocumentElement().getNodeName();
			
			// get person nodes
			NodeList persons = doc.getElementsByTagName("person");
			
			for(int i = 0; i < persons.getLength(); i++) {
				
				NodeList leaves = persons.item(i).getChildNodes();
				for(int x = 0; x < leaves.getLength(); x++) {
					
					if(leaves.item(x).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(leaves.item(x).getTextContent());
					}
					
				}
				
				System.out.println("--");
				
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
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
