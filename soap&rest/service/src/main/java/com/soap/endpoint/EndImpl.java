package com.soap.endpoint;

import javax.jws.WebService;

@WebService(endpointInterface="com.soap.endpoint.End")
public class EndImpl implements End {

	@Override
	public double add(int... x) {
		double sum = 0.0;
		for(int i:x) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}

	@Override
	public String respond(String text) {
		return "HELLO WE ARE IN THE SOAP SERVICE METHOD! " + text;
	}

}
