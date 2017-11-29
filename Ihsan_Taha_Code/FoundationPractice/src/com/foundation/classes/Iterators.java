package com.foundation.classes;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Iterators {

	public static void main(String[] args) {

		// Fail-fast example with ArrayList
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);

		Iterator<Integer> arrayListIterator = arrayList.iterator();

		while (arrayListIterator.hasNext()) {
			try {
				arrayList.add(99);
				System.out.println(arrayListIterator.next());
			} catch (ConcurrentModificationException e) {
				e.printStackTrace();
				break;
			}
		}

		
		// LinkedList Methods
		LinkedList<Character> charLinkedList = new LinkedList<>();
		charLinkedList.add('r');
		charLinkedList.add('o');
		charLinkedList.add('t');
		charLinkedList.add('a');
		charLinkedList.add('x');
		charLinkedList.add('e');
		charLinkedList.add('t');
		charLinkedList.add('I');

		ListIterator<Character> charListIterator = charLinkedList.listIterator();

		while (charListIterator.hasNext()) {
			charListIterator.next();
		}

		while (charListIterator.hasPrevious()) {
			if (charListIterator.previousIndex() == 4) {
				charLinkedList.set(4,'r');
			}
			System.out.println("Index "  + charListIterator.previousIndex() + ": " + charListIterator.previous());
		}
		
		
		
		// Fail-Safe example with ConcurrentHashMap
		Map<String, String> phoneMap = new ConcurrentHashMap<>();
		phoneMap.put("Apple", "iPhone");
		phoneMap.put("Google", "Pixel 2");
		phoneMap.put("Samsung", "S8");

		Set<String> phoneSet = phoneMap.keySet();
		Iterator<String> phoneSetIterator = phoneSet.iterator();

		while (phoneSetIterator.hasNext()) {
			phoneMap.put("Sony", "Xperia");
			System.out.println(phoneSetIterator.next());
		}
	}
}
