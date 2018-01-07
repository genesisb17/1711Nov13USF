package com.rev.soap;

import javax.jws.WebService;

/**
 * Exposing a single method called sayHi that has a String as an argument and returns a String
 */
@WebService
public interface HelloWorld {
	/**
	 * 
	 * SOAP: Simple Object Access Protocol	
	 * 	-An XML based Web Service
	 * 
	 * 		How do you figure out how to consume a SOAP WS?
	 * 			-By reading the WSDL: the contract of a SOAP Service
	 * 			WSDL: WebService Definition Language 
	 * 				an xml document that can be parsed to create
	 * 			a consuming java software of the SOAP Service
	 * 			What is apache cxf?
	 *	SOAP Framework: Apache Crossfire for Java
	 *
	 * 2 ways to Create a SOAP Service
	 * 			Contract First - Write the WSDL and generate the service
	 * 			Contract Last - Write the Service and generate the WSDL
	 * 
	 * 		Hit Interface Endpoints
	 * 	-Fault tag: Exceptions
	 * 
	 * -----------------------------------------------------------------
	 * 
	 * 
	 * Rest: Representational State Transfer
	 * 	-An JSON or XML based Web Service
	 *  
	 *  	How do you figure out how to consume a Rest WS?
	 *  		-Documentation based by the Exposing Service
	 *  
	 *  	Hit HTTP endpoints using GET/PUT/POST/DELETE
	 * 
	 */
	
	// Endpoint: sayHi(String)
	String sayHi(String text);
}
