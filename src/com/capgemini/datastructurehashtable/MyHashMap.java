package com.capgemini.datastructurehashtable;


public class MyHashMap<K, V> {
	MyLinkedList<K> myLinkedList;

	public MyHashMap() {
		myLinkedList = new MyLinkedList<>();
	}

	/**
	 * @param key
	 * @return
	 * To get Value of a particular Key in HashMap
	 */
	public V getValue(K key) {
		MyMapNode<K, V> mapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (mapNode != null) {
			return mapNode.getValue();
		} else {
			return null;
		}
	}

	/**
	 * @param key
	 * @param value
	 *  Adding K,V pair to the map
	 */
	public void add(K key, V value) {
		MyMapNode<K, V> mapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (mapNode == null) {
			mapNode = new MyMapNode<K, V>(key, value);
			myLinkedList.append(mapNode);
		} else {
			mapNode.setValue(value);
		}
	}

	/**
	 * To print HashMap
	 */
	public void print() {
		StringBuffer print = new StringBuffer("{");
		MyMapNode pointerNode = (MyMapNode) myLinkedList.getHead();
		while (pointerNode.getNext() != null) {
			print.append(pointerNode.getKey() + "=" + pointerNode.getValue() + ", ");
			pointerNode = (MyMapNode) pointerNode.getNext();
		}
		print.append(pointerNode.getKey() + "=" + pointerNode.getValue() + "}");
		System.out.println(print);
	}
}
