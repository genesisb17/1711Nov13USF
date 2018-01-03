package com.revature.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.test.soap.HelloWorld;

public class AppService {
	
	public static void main(String[] args) {
		/*
		 * Setup for ApacheCXF SOAP Client 
		 * 
		 */
		String servername="http://172.16.19.194";
		String port = "8021";
		String app = "soapservice";
		String apiEndpoint = "helloWorld";
		
		String url = servername + ":" + port + "/" + app + "/" + apiEndpoint;
	//	String serviceURL = "http://localhost:8050/soapservicedemo/HelloWorld";
		
		//Configuration setup
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(url);
		
		/*
		 * Consume the SOAP Web Service
		 */
		
		HelloWorld helloWorldService = (HelloWorld) beanFactory.create();
		String response = helloWorldService.sayHi("Genesis");
		System.out.println(response);
	}

}
