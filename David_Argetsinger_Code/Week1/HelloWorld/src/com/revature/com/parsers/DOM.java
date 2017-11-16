package com.revature.com.parsers;

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
	 * dom xml parser in java
	 * dom stands for doc obj model and it reps
	 * xmlp in tree format where every element reps a tree branch 
	 * a dom parser creates an in-memory tree rep of the xml file
	 * then parses it , it requires more memory
	 * dom parsing is fast for small xml , might not even load larger ones due to large
	 * memory req 
	 */
	static String filename="src/com/revature/com/People.xml";
	public static void main(String[] args) {
		// document represents our xml tree 
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document doc= db.parse(new File(filename));
			doc.normalize();//optional 
			//get root node
			String root=doc.getDocumentElement().getNodeName();
			
			//get persons nodes
			NodeList persons = doc.getElementsByTagName("person");
			for(int i = 0 ; i<persons.getLength(); i++)
			{
				//getleaves
				NodeList leaves=persons.item(i).getChildNodes();
				for(int j= 0; j< leaves.getLength(); j++)
					if (leaves.item(j).getNodeType()==Node.ELEMENT_NODE)
					{
						System.out.println(leaves.item(j).getTextContent());
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
//	public static InputStream getFileInClassPath(String in)
//	{
//	
//	}
}
