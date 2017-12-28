package com.test.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.test.soap.HelloWorld" )
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHi(String text) {
		System.out.println("SOAP-WS-SayHi arg:" + text );
		return "Hi " + text; 
	}

}
