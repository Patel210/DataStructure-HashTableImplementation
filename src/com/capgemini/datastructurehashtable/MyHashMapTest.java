package com.capgemini.datastructurehashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashMapTest {

	@Test
	public void givenASentence_WhenStoredWithWordAsKeyAndFrequencyAsValue_ShouldPassTheHashMapTest() {
		String sentence = "To be or not to be";
		String[] words = sentence.toLowerCase().split(" ");
		MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
		for (String word : words) {
			Integer value = myHashMap.getValue(word);
			if (value == null) {
				value = 1;
			} else {
				value++;
			}
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.getValue("be");
		myHashMap.print();
		assertEquals(2, frequency);
	}

}
