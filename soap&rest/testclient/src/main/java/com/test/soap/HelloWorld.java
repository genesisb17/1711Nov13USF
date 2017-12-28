package com.test.soap;

import javax.jws.WebService;




/*
 *  portType: interface name
 *  	operations: methods of the service 
 * 
 */

@WebService
public interface HelloWorld {

	//Look at types tag and look at the properties
	//Look at sayHiReponse to find the return type
	String sayHi(String text);

}
