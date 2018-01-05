package com.rev.soap;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	//EndPoint : sayHi(String
	String sayHi(String text);
}
