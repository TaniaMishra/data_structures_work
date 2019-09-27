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
		LLNode<T> newNode = new LLNode<T>(element);
		if (temp != null) {
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
			numElements++;
		}
		else {
			list = newNode;
		}
	}

	public boolean equals(Object other) {
		boolean result;
		int count = 0;
		if (other.toString().equals(this.toString())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void removeFirst() {
		if (list != null) {
			LLNode<T> newFirst = list.getLink();
			list.setLink(null);
			list = newFirst;
		}
	}
	
	public void remove(T element) {
		if (list != null) {
			LLNode<T> temp = list;
			LLNode<T> removeElement = new LLNode<T>(element);
			LLNode<T> previous = null;
			while (temp.getLink() != null) {
				if (temp.getInfo().equals(removeElement.getInfo())) {
					LLNode<T> placeholder = temp.getLink();
					temp.setLink(null);
					temp = placeholder;
					previous.setLink(temp);
					break;
				}
				previous = temp;
				temp = temp.getLink();
			}
		}
	}
}