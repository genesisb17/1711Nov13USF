package com.rev.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	/*
	 * DOM XML Parser in Java:
	 * DOM stands for Document Object Model and it represents 
	 * XML in a tree format, where every element represents a tree 
	 * branch. A DOM parser creates an in-memory tree representation
	 * of the XML file, then parses it. So it requires more memory.
	 * DOM parsing is fast for a small XML file but is slow or 
	 * may not even load larger XML files because it requires 
	 * a lot of memory to create an XML DOM tree.
	 */
	
	static String filename = "src/main/java/com/rev/xml/people.xml";
	
	public static void main(String[] args) {
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			try {
				db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(new File(filename));
			doc.normalize();
			
			//get root node
			String root = doc.getDocumentElement().getNodeName();
			System.out.println(root);
			
			//get persons nodes 
			NodeList persons = doc.getElementsByTagName("person");
			System.out.println(persons.getLength());
			for(int i=0; i<persons.getLength(); i++){
				//** get "leaves" **//
				NodeList leaves = persons.item(i).getChildNodes();
				for(int x = 0; x <leaves.getLength(); x++){
					if(leaves.item(x).getNodeType() == Node.ELEMENT_NODE){
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
