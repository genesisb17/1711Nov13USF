package com.rev.soap;
import javax.jws.WebService;

@WebService(endpointInterface="com.rev.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHi(String text) {
		// TODO Auto-generated method stub
		return "hu"+text;
				}

}
