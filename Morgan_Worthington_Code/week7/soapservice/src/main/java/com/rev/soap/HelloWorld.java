package com.rev.soap;

import javax.jws.WebService;

//SERVICE ENDPOINT INTERFACE
@WebService
public interface HelloWorld {

	/*
	 * SOAP: Simple Object Access Protocol
	 * - An XML based web service
	 * - we consume SOAP via the WSDL - the "contract"
	 * of our service
	 * - the WSDL = Web Service Definition Language
	 * - an XML doc that can be parsed to create and 
	 * 	 consume the SOAP service
	 * - Apache CXF - Apache Crossfire for Java, a SOAP framework
	 * 2 ways to create a SOAP service
	 * - contract first
	 * - contract last
	 */
	
	//Endpoint : sayHi(String)
	String sayHi(String text);
}
