package assignment3;

public class TestSList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
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
		
		System.out.println("Equals? " + myList.equals(otherList));
	}

}