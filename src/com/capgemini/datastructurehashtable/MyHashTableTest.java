package com.capgemini.datastructurehashtable;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class MyHashTableTest {

	@Test
	public void givenAPara_WhenAddedUsingHashTable_ShouldReturnTheFrequencyOfParticularWord() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because "
				+ "they keep putting themselves deliberately into paranoid avoidable situations";
		String[] words = sentence.toLowerCase().split(" ");
		MyHashTable<String, Integer> myHashTable = new MyHashTable<String, Integer>();
		for (String word : words) {
			Integer value = myHashTable.getValue(word);
			if (value == null) {
				value = 1;
			} else {
				value++;
			}
			myHashTable.add(word, value);
		}
		Integer frequency = myHashTable.getValue("paranoid");
		assertEquals(3, (int) frequency);
	}

}
