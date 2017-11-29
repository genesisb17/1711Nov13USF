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
	 * SAX XML Parser in Java: SAX stands for Simple API for XML Parsing. This is an
	 * event based XML parser and it parses the XML file step by step. It is much
	 * more suitable for larger XML files. SAX XML parser fires an event when it
	 * encounters an opening tag, element, or attribute, and parses accordingly.
	 */

	static String fileName = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		// 1. Obtain and configure a SAX based parser
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		// 2. Obtain an object for the SAX parser
		SAXParser sax = spf.newSAXParser();

		// 3. Implement a default handler for the SAX handler class
		DefaultHandler handler = new DefaultHandler() {
			
			// The following are for the elements in the XML file
			boolean fn = false, ln = false, age = false;

			// A. This method is called every time the parser finds an open tag '<' and identifies which tag by assigning an open flag
			public void startElement(String uri, String location, String name, Attributes attributes) {
				System.out.println("Start Element: " + name);
				if (name.equalsIgnoreCase("FIRSTNAME"))
					fn = true;
				if (name.equalsIgnoreCase("LASTNAME"))
					ln = true;
				if (name.equalsIgnoreCase("AGE"))
					age = true;
			}

			// B. 
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("End Element " + qName);
			}

			// C. Print data stored in between '<' and '>' tags
			public void characters(char ch[], int start, int length) throws SAXException {
				if (fn) {
					System.out.println("Firstname " + new String(ch, start, length));
					fn = false;
				}
				if (ln) {
					System.out.println("Lastname " + new String(ch, start, length));
					ln = false;
				}

				if (age) {
					System.out.println("Age " + new String(ch, start, length));
					age = false;
				}

			}
		};
		
		sax.parse(fileName,  handler);

	}

}
