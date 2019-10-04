package assignment4;

public class DLTest {

	public static void main(String[] args) {
		DList<String> dList = new DList<String>();
		dList.addToLast("A");
		dList.addToLast("B");
		dList.addToLast("C");
		System.out.println(dList);
		
		//Test Case 1: should remove the last node in the list (in this case, C)
		dList.pop();
		System.out.println(dList);
		//Test Case 2: should remove the last node in the list (in this case, B)
		dList.removeLast();
		System.out.println(dList);
		//Test Case 3: should add another node to the end of the list, saying "HI" (list should be: A<=>HI)
		dList.push("HI");
		System.out.println(dList);
		//Test Case 4: should remove the last node in the list (in this case, HI)
		dList.pop();
		System.out.println(dList);
		//Test Case 5: should remove the last node in the list (in this case, A; will make the list empty; should print "Empty list")
		dList.removeLast();
		System.out.println(dList);
		//Test Case 6: should push "another node" node to the previously empty list (list should be: Another node)
		dList.push("Another node");
		System.out.println(dList);
	}

}