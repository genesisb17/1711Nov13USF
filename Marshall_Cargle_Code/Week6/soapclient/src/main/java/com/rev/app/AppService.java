package com.rev.app;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.rev.soap.HelloWorld;

public class AppService {

	public static void main(String[] args) {
		String servername="http://localhost";
		String port = "9999";
		String app = "soap";
		String apiEndpoint="helloWorld";
		
		String url= servername+":"+port+"/"+app+"/"+apiEndpoint;
		//http://localhost:9999/soap/helloWorld
		/*
		 * Factory for creating JAX-WS proxies, this class provides
		 * access to internal properties.
		 */
		//configure service
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(url);
		
		//consume SOAP service
		HelloWorld service = (HelloWorld) beanFactory.create();
		String response = service.sayHi("Hello Alpha");
		System.out.println(response);
	}

}
