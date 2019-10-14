package assignment4;

/**Deque (double ended queue) class that implements the DequeInterface and uses DLLNode
 * @author 22mishrt
 */
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
	
	/** Adds the given element onto the front of the deque.
	 * @throws QueueOverflowException
	 * @param T element
	 */
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

	/** Adds the given element onto the rear of the deque.
	 * @throws QueueOverflowException
	 * @param T element
	 */
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
	
	/** Removes the first element of the deque.
	 * @throws QueueUnderflowException
	 * @returns T element (the element removed from the deque)
	 */
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

	/** Removes the last element of the deque.
	 * @throws QueueUnderflowException
	 * @returns T element (the element removed from the deque)
	 */
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

	/** Checks if deque is full
	 * @returns boolean (true == full, false == not full)
	 */
	public boolean isFull() {
		if (numElements == maxSize) {
			return true;
		}
		else {
			return false;
		}
	}

	/** Checks if deque is empty
	 * @returns boolean (true == empty, false == not empty)
	 */
	public boolean isEmpty() {
		if (numElements == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/** Returns the size
	 * @returns numElements
	 */
	public int size() {
		return numElements;
	}
	
	/** Converts deque into a string
	 * @returns String (holds all the values in the deque with "<-->" between each value)
	 */
	public String toString() {
		String info;
		if (numElements == 0) {
			info = null;
		}
		else {
			info = front.getInfo() + "";
			DLLNode<T> temp = front.getForward();
			while (temp != null) {
				info += "<-->";
				info += temp.getInfo();
				temp = temp.getForward();
			}
		}
		return info;
	}

}