package com.rev.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.rev.soap.HelloSoap")
public class HelloSoapImpl implements HelloSoap{

	@Override
	public String sayHi(String text) {
		System.out.println("SOAP Service: " + text);
		return "hi " 	+ text;
	}

}
