package assignment4;

import java.util.Scanner;

public class DeQueAssignment4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DeQueDLL deque = new DeQueDLL();
		System.out.println("Choose an operation - 1: insert, 2: delete, 3: quit");
		int number = input.nextInt();	//number for which operation to choose
		while (number != 3) {
			//Insert value (option 1)
			if (number == 1) {
				System.out.println("Enter the value you want to insert in the deque:");
				int inputValue = input.nextInt();		//value to insert
				if (deque.isFull()) {					//if deque is full, display message
					System.out.println("Deque is full, more values cannot be inserted at this moment.");
				}
				else if (deque.isEmpty()) {				//if deque is empty, enqueue the value
					try {
						deque.enqueueFront(inputValue);
					}
					catch (QueueOverflowException error) {
						System.out.println(error.getMessage());
					}
				}
				else {
					String[] values = deque.toString().split("<-->");		//array of all values in deque as Strings
					if (Integer.parseInt(values[0]) >= inputValue) {		//if value should go before first element in deque, enqueue to front
						try {
							deque.enqueueFront(inputValue);
						}
						catch (QueueOverflowException error) {
							System.out.println(error.getMessage());
						}
					}
					else if (Integer.parseInt(values[deque.size()-1]) <= inputValue) {		//if value should go after last element in deque, enqueue to rear
						try {
							deque.enqueueRear(inputValue);
						}
						catch (QueueOverflowException error) {
							System.out.println(error.getMessage());
						}
					}
					else {								//else if value should go somewhere in the middle
						int insertIndex = 0;			//holds at what index the value should be inserted
						int size = deque.size();		//holds size
						for (int i = 0; i < size; i++) {		//finds the insertIndex & dequeues everything until that point
							if (Integer.parseInt(values[i]) > inputValue) {
								insertIndex = i;
								break;
							}
							try {
								deque.dequeueFront();
							}
							catch (QueueUnderflowException error) {
								System.out.println(error.getMessage());
							}
						}
						try {										//enqueues the value to the front
							deque.enqueueFront(inputValue);
						}
						catch (QueueOverflowException error) {
							System.out.println(error.getMessage());
						}
						for (int i = insertIndex-1; i >= 0; i--) {		//enqueues each element from insertIndex-1 to 0 from the array back into deque after adding new value
							try {
								deque.enqueueFront(values[i]);
							}
							catch (QueueOverflowException error) {
								System.out.println(error.getMessage());
							}
						}
					}
				}
			}
			//Delete value (option 2)
			else if (number == 2) {
				System.out.println("Enter the value you want to delete from the deque:");
				int inputValue = input.nextInt();			//value to delete
				if (deque.size() == 0) {					//if deque is empty, display message
					System.out.println("Attempted to dequeue on an empty deque. Try again.");
				}
				else {
					String[] values = deque.toString().split("<-->");		//array of all values in deque as Strings
					if (Integer.parseInt(values[0]) == inputValue) {		//if delete value is equal to first element, dequeue the first element
						try {
							deque.dequeueFront();
						}
						catch (QueueUnderflowException error) {
							System.out.println(error.getMessage());
						}
					}
					else {
						int deleteIndex = 0;			//index of element to delete
						int size = deque.size();		//holds size of deque
						for (int i = 0; i < size; i++) {					//finds deleteIndex & dequeues until that point & dequeues the value to delete
							if (Integer.parseInt(values[i]) == inputValue) {
								deleteIndex = i;
								try {
									deque.dequeueFront();
								}
								catch (QueueUnderflowException error) {
									System.out.println(error.getMessage());
								}
								break;
							}
							try {
								deque.dequeueFront();
							}
							catch (QueueUnderflowException error) {
								System.out.println(error.getMessage());
							}
						}
						if (deleteIndex != 0) {							//if the delete value was in the array, enqueue the rest of the elements back to the deque
							for (int i = deleteIndex-1; i >= 0; i--) {
								try {
									deque.enqueueFront(values[i]);
								}
								catch (QueueOverflowException error) {
									System.out.println(error.getMessage());
								}
							}
						}
						else {											//if the delete value was not in the array, enqueue the rest of the elements back to the deque & print message
							for (int i = 0; i < size; i++) {
								try{
									deque.enqueueRear(values[i]);
								}
								catch (QueueOverflowException error) {
									System.out.println(error.getMessage());
								}
							}
							System.out.println(inputValue + " not found in the deque.");
						}
					}
				}
			}
			System.out.println("Deque: " + deque.toString() + "\n");		//print deque
			//repeatedly ask for value from user
			System.out.println("Choose an operation - 1: insert, 2: delete, 3: quit");
			number = input.nextInt();
		}
		//Quit (option 3)
		System.out.println("Goodbye!!");
	}

}
