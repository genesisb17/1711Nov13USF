package com.revature.com.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
/*
 * Sax xml parser in java
 * sax is simple api for xml parsing 
 * this is even based xml parser and it parses
 * the xml file step by step 
 * it's better for larger giles sax xml parser fries and even when it encounters an opening 
 * tag or attribute and parses accordingly 
 * 
 */
	static String filename="src/com/revature/com/People.xml";
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

			SAXParserFactory spf= SAXParserFactory.newInstance();
			SAXParser sax= spf.newSAXParser();
			// sax parser needs a file and how it handles the xml ! could've made a handler 
			DefaultHandler handler = new DefaultHandler(){
			//innerclass , calss inside of a class  good encapsulation, as it has no worth outside of this class
				boolean fn=false;
				boolean ln=false;
				boolean age=false;
				public void startElement(String uri, String localName, String name, Attributes attributes)
				{
					System.out.println("Start Element " + name);
					if(name.equalsIgnoreCase("FIRSTNAME"))fn=true;
					if(name.equalsIgnoreCase("LASTNAME"))ln=true;
					if(name.equalsIgnoreCase("AGE"))age=true;
					
				}
				public void endElement(String uri, String localName, String qName) throws SAXException
				{
					System.out.println("End Element " + qName);
				}
				public void characters(char ch[], int start, int length) throws SAXException
				{
					if(fn){
					System.out.println("Firstname: "+ new String(ch,start,length));
					fn=false;
					}
					if(ln){
					System.out.println("Lastname: "+ new String(ch,start,length));
					ln=false;
					}
					if(age){
					System.out.println("Age: "+ new String(ch,start,length));
					age=false;
					}
				}
			};
			sax.parse(filename, handler);
	}
}
