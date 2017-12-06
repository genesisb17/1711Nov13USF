package com.revature.xml.parsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {

		/*
		 * DOM XML parser in Java:
		 * DOM stands for document object model and it represents
		 *  XML in a tree format where every element represents a tree 
		 *  branch. a dom parser creates an in-memory tree representation
		 *  and parses it. So, it requires more memory.
		 * Dom parsing is fast for small xml files, but is slow 
		 * and may not even load larger xml files because it requires 
		 * a lot of memory to create the DOM tree
		 */
		
	
	
	static String filename = "src/com/revature/xml/people.xml";
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
			//look at doc.normalize
			doc.normalize();//optional but recommended
			
			//get root node
			String root = doc.getDocumentElement().getNodeName();
			
			//get persons nodes
			NodeList persons = doc.getElementsByTagName("person");
			for (int i = 0; i< persons.getLength(); i++) {
				//get leaves
				NodeList leaves = persons.item(i).getChildNodes();
				for( int x = 0 ; x < leaves.getLength(); x++) {
					if(leaves.item(x).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(leaves.item(x).getTextContent());
					}
				}
				System.out.println("--");
			}
			
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
