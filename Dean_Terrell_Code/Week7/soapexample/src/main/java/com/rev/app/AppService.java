package com.rev.app;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.rev.soap.HelloWorld;

public class AppService {

	public static void main(String[] args) {
		String servername = "http://localhost";
		String port = "9999";
		String app = "soapinClient";
		String apiEndpoint = "helloWorld";
		
		String url = servername + ":" + port + "/" + app + "/" + apiEndpoint;
		
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(HelloWorld.class);
		beanFactory.setAddress(url);
		HelloWorld service = (HelloWorld) beanFactory.create();
		String response = service.sayHi("Wuzzup");
		System.out.println(response);
	}
}