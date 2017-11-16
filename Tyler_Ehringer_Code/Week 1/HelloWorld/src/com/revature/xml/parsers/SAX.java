package com.revature.xml.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
	
	static String filename = "src/com/revature/xml/people.xml";
	
	public static void main(String[] args) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				boolean age = false;
				
				public void startElement(String uri, String localName, String name, Attributes attributes) {
					System.out.println("Start Element: " + name);
					if(name.equalsIgnoreCase("firstname")) fn = true;
					if(name.equalsIgnoreCase("lastname")) ln = true;
					if(name.equalsIgnoreCase("age")) age = true;					
				}
				public void endElement(String uri, String localName, String qName) throws SAXException{
					System.out.println("End element " + qName);
				}
				public void characters(char[] ch, int start, int length) throws SAXException{
					if(fn) {
						System.out.println("Firstname " + new String(ch, start, length));
						fn = false;
					}if(ln) {
						System.out.println("Lastname " + new String(ch, start, length));
						ln = false;
					}if(age) {
						System.out.println("Age " + new String(ch, start, length));
						age = false;
					}
				}
			};
			
			sp.parse(filename, handler);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
