package assignment4;

public class DeQueDLL<T> implements DequeInterface<T> {
	
	protected DLLNode<T> front, rear;      // reference to the front and rear of this deque
	protected int numElements = 0; 			// number of elements in this deque

	public DeQueDLL() {
		front = null;
		rear = null;
	}

	public void enqueueFront(T element) {
		DLLNode<T> elem = new DLLNode<T>(element);
		if (numElements == 0) {
			front = elem;
			rear = elem;
			elem.setBack(null);
			elem.setForward(null);
		}
		else {
			elem.setForward(front);
			elem.setBack(null);
			front = elem;
		}
		
	}

	public void enqueueRear(T element) {
		// TODO Auto-generated method stub
		
	}

	public T dequeueFront() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	public T dequeueRear() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}