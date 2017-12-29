package com.rev.soap;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	String sayHi(String text);
}
