package com.revature.xml.parsers;

import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class SAX {

	/*
	 *  SAX XML Parser in Java
	 *  SAX stands for simple api for xml PArsing
	 *  This is a n event based xml parser and it parses 
	 *  the xml file step by step. it is much more suitable 
	 *  for larger xml files. SAX XML parser fires an event
	 *  when it encounters an openeing tag, element, or attribute,
	 *   and parses accordingly
	 */
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args)  
			throws ParserConfigurationException, SAXException, IOException {


			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sax = spf.newSAXParser();
			
			//inner class
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				boolean age = false;
				
				public void startElement(String uri, String localName, String name, Attributes attributes){
					System.out.println("Start Element: " + name);
					if(name.equalsIgnoreCase("FIRSTNAME")) fn = true;
					if(name.equalsIgnoreCase("LASTNAME")) ln = true;
					if(name.equalsIgnoreCase("AGE")) age = true;
				}
				
				public void endElement(String uri, String localName, String qName) 
				throws SAXException{
					System.out.println("End Element" + qName);				
				}
				
				public void characters(char ch[], int start, int length) throws SAXException{
					if(fn) {
						System.out.print("First name " + new String(ch, start, length));
						fn = false;
					}
					if(ln) {
						System.out.print("Last name " + new String(ch, start, length));
						ln = false;
					}
					if(age) {
						System.out.print("Age " + new String(ch, start,length));
						age = false;
					}
				}
				
			};
			
			sax.parse(filename, handler);
				
	}

}
