package assignment4;

public class DeQueTestClass {

	public static void main(String[] args) {
		DeQueDLL deque = new DeQueDLL();
		deque.enqueueFront(5);
		deque.enqueueFront(3);
		deque.enqueueRear(7);
		System.out.println(deque.toString());
		deque.dequeueFront();
		deque.dequeueRear();
		System.out.println(deque.toString());
		deque.dequeueFront();
		System.out.println(deque.toString());
		deque.dequeueRear();
	}

}
