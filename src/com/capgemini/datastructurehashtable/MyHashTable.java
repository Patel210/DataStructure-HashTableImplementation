package com.capgemini.datastructurehashtable;

public class MyHashTable<K, V> {
	private final int MY_BUCKET_SIZE;
	private MyLinkedList<K>[] myLinkedLists;

	public MyHashTable() {
		MY_BUCKET_SIZE = 10;
		myLinkedLists = new MyLinkedList[MY_BUCKET_SIZE];
		for (int i = 0; i < MY_BUCKET_SIZE; i++) {
			myLinkedLists[i] = null;
		}
	}

	/**
	 * @param key
	 * @return To get Index of array based on hash code
	 */
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % MY_BUCKET_SIZE;
	}

	/**
	 * @param key
	 * @param value Adding Key Value Pair to the HashTable using Hash Code
	 */
	public void add(K key, V value) {
		int index = getIndex(key);
		MyLinkedList<K> myLinkedList = myLinkedLists[index];
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<K>();
			myLinkedLists[index] = myLinkedList;
			myLinkedList.append(new MyMapNode(key, value));
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			if (myMapNode == null) {
				myLinkedList.append(new MyMapNode(key, value));
			} else {
				myMapNode.setValue(value);
			}
		}
	}

	/**
	 * @param key
	 * @param value Adding K,V pair to the map
	 */
	public V getValue(K key) {
		int index = getIndex(key);
		MyLinkedList<K> myLinkedList = myLinkedLists[index];
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			return (myMapNode == null) ? null : myMapNode.getValue();
		}
	}
}
