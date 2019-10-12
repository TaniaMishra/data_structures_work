package assignment4;

public class DeQueDLL<T> implements DequeInterface<T> {
	
	protected DLLNode<T> front, rear;      // reference to the front and rear of this deque
	protected int numElements = 0; 			// number of elements in this deque
	protected int maxSize;

	public DeQueDLL() {
		front = null;
		rear = null;
		maxSize = 50;
	}
	public DeQueDLL(int max) {
		front = null;
		rear = null;
		maxSize = max;
	}

	public void enqueueFront(T element) throws QueueOverflowException{
		DLLNode<T> elem = new DLLNode<T>(element);
		if (isFull()) {
			throw new QueueOverflowException("attempted enqueueFront on full dequeue");
		}
		else if (isEmpty()) {
			front = elem;
			rear = elem;
			elem.setBack(null);
			elem.setForward(null);
		}
		else {
			elem.setForward(front);
			elem.setBack(null);
			front.setBack(elem);
			front = elem;
		}
		numElements++;
	}

	public void enqueueRear(T element) throws QueueOverflowException{
		DLLNode<T> elem = new DLLNode<T>(element);
		if (isFull()) {
			throw new QueueOverflowException("attempted enqueueRear on full dequeue");
		}
		else if (isEmpty()) {
			front = elem;
			rear = elem;
			elem.setBack(null);
			elem.setForward(null);
		}
		else {
			elem.setForward(null);
			elem.setBack(rear);
			rear.setForward(elem);
			rear = elem;
		}
		numElements++;
	}

	public T dequeueFront() throws QueueUnderflowException {
		DLLNode<T> element = front;
		if (isEmpty()) {
			throw new QueueUnderflowException("attempted dequeueFront() on empty deque");
		}
		else if (numElements == 1) {
			front = null;
			rear = null;
			numElements--;
		}
		else {
			DLLNode<T> temp = front.getForward();
			temp.setBack(null);
			front = temp;
			numElements--;
		}
		return (T)element;
	}

	public T dequeueRear() throws QueueUnderflowException {
		DLLNode<T> element = rear;
		if (isEmpty()) {
			throw new QueueUnderflowException("attempted dequeueRear() on empty deque");
		}
		else if (numElements == 1) {
			front = null;
			rear = null;
			numElements--;
		}
		else {
			DLLNode<T> temp = rear.getBack();
			temp.setForward(null);
			rear = temp;
			numElements--;
		}
		return (T)element;
	}

	public boolean isFull() {
		if (numElements == maxSize) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (numElements == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return numElements;
	}
	
	public String toString() {
		String info;
		if (numElements == 0) {
			info = null;
		}
		else {
			info = front.toString() + "<-->";
			DLLNode<T> temp = front;
			for (int i = 1; i < numElements; i++) {
				temp = temp.getForward();
				info += temp.toString();
				info += "<-->";
			}
		}
		return info;
	}

}