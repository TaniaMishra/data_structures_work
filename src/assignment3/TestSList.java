package assignment3;

public class TestSList {

	public static void main(String[] args) {
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		//Test insertLast() - expected outcome = C-->B-->A-->LAST-->Last-Last-->Last-Last-Last
		myList.insertLast("LAST");
		myList.insertLast("Last-Last");
		myList.insertLast("Last-Last-Last");
		System.out.println(myList);
		
		SList<String> otherList = new SList<String>();
		otherList.add("A");
		otherList.add("B");
		otherList.add("C");
		otherList.insertLast("LAST");
		otherList.insertLast("Last-Last");
		otherList.insertLast("Last-Last-Last");
		System.out.println(otherList);
		
		//Test equals() - expected outcome = true
		System.out.println("Equals? " + myList.equals(otherList));
		
		//Test removeFirst() - expected outcome = A-->LAST-->Last-Last-->Last-Last-Last
		myList.removeFirst();
		myList.removeFirst();
		System.out.println("\n" + myList);
		System.out.println(otherList); //Same as before (no change)
		System.out.println("Equals? " + myList.equals(otherList));	//Expected outcome = false
		
		//Test remove(T element) - expected outcome = A-->Last-Last-->Last-Last-Last
		myList.remove("LAST");
		System.out.println("\n" + myList);

	}

}