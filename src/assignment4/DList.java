package assignment4;

import support.DLLNode;

public class DList<T> {

	private DLLNode<T> header;
	private DLLNode<T> trailer;
	private int size;

	public DList() {
		header = null;
		trailer = null;
		size = 0;
	}

	public DLLNode<T> getHeader() {
		return header;
	}

	public DLLNode<T> getTrailer() {
		return trailer;
	}

	public int getSize() {
		return size;
	}

	// add element to the front of the list
	public void addToFront(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);

		if (header == null) {
			header = newNode;
		}
		if (trailer == null)
			trailer = newNode;
		else {
			newNode.setForward(header);
			header.setBack(newNode);
			header = newNode;
		}
		size++;

	}

	// add element to the end of the list
	public void addToLast(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);
		newNode.setForward(null);

		if (trailer == null) {
			trailer = newNode;
			header = newNode;
		} else {
			trailer.setForward(newNode);
			newNode.setBack(trailer);
			trailer = newNode;
		}

		size++;
	}

	public boolean isEmpty() {
		return header == null;
	}

	public String toString() {
		DLLNode<T> node = header;
		String result = "";
		if (header == null) {
			result = "Empty List";
		}
		else {
			while (node != null) {
				result += node.getInfo();
				result += "<=>";
				node = (DLLNode<T>) node.getForward();
			}
			result = result.substring(0, result.length() - 3);
		}
		return result;
	}

	public void print() {
		DLLNode<T> v = header;
		while (v != null) {
			System.out.println(v.getInfo());
			v = v.getForward();
		}
	}

	public void removeLast() {		//time complexity: O(1)
		this.pop();
	}
	
	public void push(T element) {		//time complexity: O(1)
		this.addToLast(element);
	}
	
	public void pop() {		//time complexity: O(1)
		if (header != null && trailer != null) {
			if (trailer != header) {
				DLLNode<T> newLast = trailer.getBack();
				newLast.setForward(null);
				trailer.setBack(null);
				trailer = newLast;
			}
			else {
				header = null;
				trailer = null;
				//System.out.println("List should now be empty.");
			}
			size--;
		}
	}
	
}