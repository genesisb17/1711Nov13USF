package com.rev.run;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.util.ConnectionFactory;
import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();
	static DAO dao = new FileDAO();

	public static void main(String[] args) {
		while(true) {
			service.run();
		}
	}

	
}










