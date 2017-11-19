package com.revature.xml.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX {

	static String fileName = "src/com/revature/xml/users.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sax = spf.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
			boolean firstName = false, lastName = false, userName = false, passWord = false, balance = false;
			public void startElement(String uri, String location, String name, Attributes attributes) {
				if (name.equalsIgnoreCase("FIRSTNAME"))
					firstName = true;
				if (name.equalsIgnoreCase("LASTNAME"))
					lastName = true;
				if (name.equalsIgnoreCase("USERNAME"))
					userName = true;
				if (name.equalsIgnoreCase("PASSWORD"))
					passWord = true;
				if (name.equalsIgnoreCase("BALANCE"))
					balance = true;
			}
			
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("");
			}
			
			public void characters(char[] ch, int start, int length) {
				if (firstName) {
					System.out.println(new String(ch, start, length));
					firstName = false;
				}
				if (lastName) {
					System.out.println(new String(ch, start, length));
					lastName = false;
				}
				if (userName) {
					System.out.println(new String(ch, start, length));
					userName = false;
				}
				if (passWord) {
					System.out.println(new String(ch, start, length));
					passWord = false;
				}
				if (balance) {
					System.out.println(new String(ch, start, length));
					balance = false;
				}
			}
		};
		
		sax.parse(fileName, handler);
	}

}
