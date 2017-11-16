package com.revature.xml.parsers;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
	
	String filename = "src/com/revature/xml/people.xml":
	
	/*
	 * SAX XML Parser in Java
	 * SAX stands for Simple API for XML Parsing
	 * This is an event based XML parser and it parses the XML
	 * file step by step.
	 */

	public static void main(String[] args) {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser sax = spf.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				boolean age = false;
				
				public void startElement(String uri, String localName, String name, Attributes attributes ) {
					
					System.out.println("Start Element: " + name);
					if(name.equalsIgnoreCase("FIRSTNAME")) fn = true;
					if(name.equalsIgnoreCase("LASTNAME")) ln = true;
					if(name.equalsIgnoreCase("AGE")) age = true;
										
				}
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println("End Element" + qName);
				}
				
				public void characters(char[] ch, int start, int length) throws SAXException {
					if(fn) {
						System.out.println("Firstname " + new String(ch, start, length));
						fn = false;
					}
					if(ln) {
						System.out.println("Lastname " + new String(ch, start, length));
						fn = false;
					}
					if(age) {
						System.out.println("Age " + new String(ch, start, length));
						fn = false;
					}
				}
			};
					
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
