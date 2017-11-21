package com.revature.searchers;

import java.util.HashMap;

@FunctionalInterface
public interface Searchable {

	public void search(HashMap<String, int[]> userInput);
	
}
