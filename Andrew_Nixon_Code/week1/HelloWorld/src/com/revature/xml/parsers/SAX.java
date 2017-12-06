package com.revature.xml.parsers;

import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {

	/*
	 * SAX parser SAX = Simple API for XML event based XML parser. it parses xml
	 * file step by step. it is much more suitable for larger XML files
	 */

	static String filename = "src/com/revature/xml/people.xml";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sax = spf.newSAXParser();
		// inner class
		DefaultHandler handler = new DefaultHandler() {
			boolean fn = false;
			boolean ln = false;
			boolean age = false;

			public void startElement(String uri, String localName, String name, Attributes attributes) {
				System.out.println("Start Element: " + name);
				if (name.equalsIgnoreCase("FIRSTNAME")) {
					fn = true;
				}
				if (name.equalsIgnoreCase("LASTNAME")) {
					ln = true;
				}
				if (name.equalsIgnoreCase("AGE")) {
					age = true;
				}
			}

			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("End Element" + qName);
			}

			public void characters(char[] ch, int start, int length) throws SAXException {
				if (fn) {
					System.out.println("First name " + new String(ch, start, length));
					fn = false;
				}
				if (ln) {
					System.out.println("Last name " + new String(ch, start, length));
					ln = false;
				}
				if (age) {
					System.out.println("Age " + new String(ch, start, length));
					age = false;
				}
			}
		};

		sax.parse(filename, handler);
	}
}
