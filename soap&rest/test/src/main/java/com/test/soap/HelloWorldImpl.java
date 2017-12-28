package com.test.soap;

import javax.jws.WebService;

import com.test.orm.Hello;
import com.test.orm.dao;

@WebService(endpointInterface="com.test.soap.HelloWorld" )
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHi(String text) {
		System.out.println("SOAP-WS-SayHi arg:" + text );
		dao dao = new dao();
		Hello hello = new Hello();
		hello.setText(text);
		dao.addText(hello);
		return "Hi " + text; 
	}

}
