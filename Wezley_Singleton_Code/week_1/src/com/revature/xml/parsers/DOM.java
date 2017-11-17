package com.revature.xml.parsers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {

	/*
	 *  DOM XML Parser in Java
	 *  
	 *  DOM stands for Document Object Model and it represents XML in a tree format,
	 *  where every element represents a tree branch.
	 *  
	 *  A DOM Parser creates an in-memory tree representation of the XML file, then
	 *  parses it. This means that it requires more memory. Due to this, DOM parsing 
	 *  is fast for small XML files, but can be slow with - or may not even load - 
	 *  larger XML files.
	 */
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		
		try {
			// DocumentBuilderFactory is used to create a DocumentBuilder object
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			// DocumentBuilder is used to create a Document object
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Document represents our XML tree
			Document doc = builder.parse(new File(filename));
			
			// optional, but recommended (LOOK INTO WHAT THIS IS)
			doc.normalize();
			
			// get root node
			String root = doc.getDocumentElement().getNodeName();
			
			// get person nodes
			NodeList persons = doc.getElementsByTagName("person");
			
			// iterate through 'persons' to obtain each leaf
			for(int i = 0; i < persons.getLength(); i++) {
				
				// get 'leaves' of the node
				NodeList leaves = persons.item(i).getChildNodes();
				
				for(int j = 0; j < leaves.getLength(); j++) {
					
					if(leaves.item(j).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(leaves.item(j).getTextContent());
					}
				}
				
				System.out.println("--");
				
			}
		}
		
		// thrown by the DocumentBuilder object
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		
		// thrown by the Document object
		catch (SAXException saxe) {
			saxe.printStackTrace();
		}
		
		// thrown by the Document object
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
}
