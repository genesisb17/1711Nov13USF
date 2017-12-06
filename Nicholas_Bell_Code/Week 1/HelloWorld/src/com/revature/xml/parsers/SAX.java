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
	 * SAX XML PARSER
	 * SAX stands for Simple API for XML Parsing
	 * Thisis an event based XML parser and it parses
	 * the XML file step by step. it is much more suitable
	 * for larger xml files. Sax xml parser fires  an event
	 * when it encounters an opening tag, elements or attribute
	 * and parses accordingly
	 */
	static String filename = "src/com/revature/xml/people.xml";
	public static void main(String[] args) {
		
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sax = spf.newSAXParser();
			
			
			//we want a class w/ a specific implementation that we aren't using anywhere else
			//so this will be an example of an inner class
			
			/*
			 * 
			 * 
			 */
			
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				boolean age = false;
				
												//uniform resource identifier
				public void startElement(String uri, String localName, String name,
						Attributes attributes) {
					
					
					System.out.println("Start Element: " + name);
					if(name.equalsIgnoreCase("FIRSTNAME")) 	fn = true;
					if(name.equalsIgnoreCase("LASTNAME")) 	ln = true;
					if(name.equalsIgnoreCase("AGE")) 	    age = true;
					
					
				}
				
				
				public void endElement(String uri, String LocalName, String qName)
				throws SAXException{
					System.out.println("End Element " + qName);
				}
				
				public void characters(char ch[], int start, int length) 
						throws SAXException{
					if(fn) {
						System.out.println("Firstname: " + new String(ch, start, length));
						fn = false;
					}
					if(ln) {
						System.out.println("Lastname: " + new String(ch, start, length));
						ln = false;						
					}
					if(age) {
						System.out.println("Age " + new String(ch, start, length));
						age = false;					
					}
				}	
			};//end inner class
			
			sax.parse(filename, handler);
			
			
			
			
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
