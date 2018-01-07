package com.rev.soap;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	// Endpoint: sayHi(String)
	String sayHi(String text);

}
