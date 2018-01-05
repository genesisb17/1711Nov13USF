package com.rev.soap;
import javax.jws.WebService;
@WebService
public interface HelloWorld 
{
/*
 * SOAP
 * simple Object Access Protocol
 * -An XML based web service
 * we consume soap via the wsdl-the "contract"
 * an xml doc that can be parsed to create and consume
 * the soap service
 * Apache CXF - Apache Crossfire for JAva, a SOAP framework
 * 2 ways to create a soap service
 * contract first
 * contract last
 * 
 * */
	String sayHi(String text);
	
}
