package com.soap.endpoint;

import javax.jws.WebService;

/*
 * 
 * SOAP: Simple Object Access Protocol	
 * 	-An XML based Web Service
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
 */
@WebService
public interface End {
	
	double add(int... x);
	String respond(String text);

}
