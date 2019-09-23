package assignment3;

import support.LLNode;

public class SList<T> {
	protected LLNode<T> list;
	protected int numElements;
	
	public SList () {
		numElements = 0;
		list = null;
	}

	public LLNode<T> getList() {
		return list;
	}

	public void setList(LLNode<T> list) {
		this.list = list;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}
	
	// adds the element to the front of the list
	public void add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;		
		numElements++;
	}
	
	public String toString() {
		LLNode<T> node = list;
		String result = "";
		while (node != null) {
			result += node.getInfo();
			result += "-->";
			node = node.getLink();
		}
		result = result.substring(0, result.length()-3);
		return result;		
	}
	
	public void insertLast(T element) {
		LLNode<T> temp = list;
		for (int i = 0; i < numElements; i++) {
			//temp = ;
		}
		//LLNode<T> newNode = new LLNode<T>(element);
		
	}
	
	
	

}