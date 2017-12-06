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
	 * Document Object model
	 * it represents xml in a tree format where every elemetn represents a branch. A DOM parser 
	 * creates an in memory  tree representaton of the xml then parses it. so it requires more 
	 * memory. DOM parsing is fast for a small xml file but is slow for larger files because of
	 * the memory for the tree.
	 */
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
			doc.normalize(); // optional but recommended
			
			//get root node
			String root = doc.getDocumentElement().getNodeName();
			
			//get persons nodes
			NodeList persons = doc.getElementsByTagName("person");
			for (int i = 0; i<persons.getLength(); i++) {
				NodeList leaves = persons.item(i).getChildNodes();
				for (int j = 0; j < leaves.getLength(); j++) {
					if (leaves.item(j).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(leaves.item(j).getTextContent());
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
	
	//public static InputStream getFileInClassPath(String)

}
