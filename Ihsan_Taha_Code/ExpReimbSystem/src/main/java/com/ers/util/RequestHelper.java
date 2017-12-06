package com.ers.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper
{
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println(request.getRequestURI());

		switch (request.getRequestURI())
		{
		case "/ExpReimbSystem/GetHeader.view":
			return "partials/userHeader.html";
		case "/ExpReimbSystem/GetMenu.view":
			return "partials/userFunctions.html";
		case "/ExpReimbSystem/GetContent.view":
			return "partials/userContent.html";
		}
		return null;
	}
}
