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
	 * DOM XML Parser in Java:
	 * DOM stands for Document Object Model and it represents XML in a tree 
	 * format, where every element represents a tree branch. A DOM parser creates 
	 * an in-memory tree representation of the XML file, then parses it. So it 
	 * requires more memory. DOM parsing is fast for a small XML file but slow for 
	 * for large XML files because it requires more memory.
	 */
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
			doc.normalize();
			
			//Get root node
			String root = doc.getDocumentElement().getNodeName();
			
			//Get persons node
			NodeList persons = doc.getElementsByTagName("person");
			
			for(int i = 0; i < persons.getLength(); i++){
				
				NodeList leaves = persons.item(i).getChildNodes();
				
				for(int j = 0; j < leaves.getLength(); j++){
					if(leaves.item(j).getNodeType() == Node.ELEMENT_NODE)
						System.out.println(leaves.item(j).getTextContent());
				}
				System.out.println("-------------------------------------");
			}
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
//	public static InputStream getFile(String s){
//		
//		
//	}
}
