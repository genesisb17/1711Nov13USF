package com.revature.xml.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
	
	/*
	 *  SAX XML Parser in Java
	 * 
	 *  SAX stands for Simple API for XML parsing, that is an event based XML parses and
	 *  it parses the XML file step by step. It is much more suitable for larger XML files.
	 *  
	 *  SAX XML parser fires an event when it encounters an opening tag, element, or 
	 *  attribute, and parses accordingly.
	 */
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		
		try {
			// SAXParserFactory is used to create a SAXParser object
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sax = spf.newSAXParser();
			
			/* 
			 *  Example of an inner class; this class will only be used for a single instance.
			 *  
			 *  Java Doc: https://docs.oracle.com/javase/8/docs/api/org/xml/sax/helpers/DefaultHandler.html
			 */
			DefaultHandler handler = new DefaultHandler() {
				
				boolean firstName = false;
				boolean lastName = false;
				boolean age = false;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) {
					
					System.out.println("Start Element: " + qName);
					
					if(qName.equalsIgnoreCase("FIRSTNAME")) { firstName = true; }
					if(qName.equalsIgnoreCase("LASTNAME")) { lastName = true; }
					if(qName.equalsIgnoreCase("AGE")) { age = false; }

				}
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					
					System.out.println("End Element: " + qName + "\n");					
					
				}
				
				public void characters(char[] ch, int start, int length) throws SAXException {
					
					if(firstName) {
						System.out.println("\nFirst Name: " + new String(ch, start, length));
						firstName = false;
					}
					
					if(lastName) {
						System.out.println("Last Name: " + new String(ch, start, length));
						lastName = false;
					}
					
					if(age) {
						System.out.println("Age: " + new String(ch, start, length));
						age = false;
					}
				}
			};
			
			sax.parse(filename, handler);
		} 
		
		// this is a multi-catch block, it uses the OR operator '|'
		catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
