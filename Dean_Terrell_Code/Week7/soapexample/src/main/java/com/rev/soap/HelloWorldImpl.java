package com.rev.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.rev.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHi(String text) {
		System.out.println("SOAP Service: " + text);
		return "Hi " + text;
	}

}
