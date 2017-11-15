package com.rev.main;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapInfo {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		System.out.println("This is a Map (Hashmap in this case) from Integer to String.");
		
		System.out.println("We can add entries to it.");
		map.put(0, "Tucan");
		map.put(1, "Maccaw");
		map.put(2, "Flamingo");
		map.put(3, "Cardinal");
		map.put(4, "Robin");
		map.put(5, "Sparrow");
		
		System.out.println("Or add them on the condition that the key doens't exist.");
		map.putIfAbsent(3, "Parrot");
		
		System.out.println("We can also remove elements.");
		map.remove(0);
		
		System.out.println("Or replace them.");
		map.replace(5, "Crow");
		
		System.out.println("Once we have our map we have options for traversing it.");
		System.out.println("Does this map have the key 3? " + (map.containsKey(3) ? "yes" : "no"));
		System.out.println("Does this map contain the value 'Robin'? " + (map.containsValue("Robin") ? "yes" : "no"));
		System.out.println("Does this map contain the value 'Bat'? " + (map.containsValue("Bat") ? "yes" : "no"));
		
		System.out.println("The contents of this map are:");
		map.keySet().stream().forEach(i -> System.out.println(i + " : " + map.get(i)));
		
		System.out.println("As you can see, it has " + map.size() + " entries.");
		
		System.out.println("You can get all of the values as a collection if you wish.");
		map.values().stream().forEach(System.out::println);
		
		System.out.println("or get all of the entries (key value pairs) as a set:");
		for(Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
		}
	}
}
