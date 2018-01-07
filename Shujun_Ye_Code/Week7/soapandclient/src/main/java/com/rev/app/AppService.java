package com.rev.app;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.rev.soap.HelloWorld;

public class AppService {
	
	public static void main(String[] args) {
		
		// Setup for ApacheCXF SOAP Client
		String servername="http://localhost";
		String port = "9999";
		String app = "soapclient";
		String apiEndpoint = "HelloWorld";
		
		// String serviceURL = "http://localhost:9999/soapclient/HelloWorld";
		String url = servername + ":" + port + "/" + app + "/" + apiEndpoint;
		
		// Configuration setup
		// JaxWsProxyFactoryBean: Factory for creating JAX-WS proxies.
		// This class provides access to the internal properties used to set-up proxies.
		// Using it provides more control than the standard JAX-WS APIs.
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(url);
		
		// Consume the SOAP Web Service
		HelloWorld helloWorldService = (HelloWorld) beanFactory.create();
		String response = helloWorldService.sayHi("Shujun");
		System.out.println(response);
	}

}
