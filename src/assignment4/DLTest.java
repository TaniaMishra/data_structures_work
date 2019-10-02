package assignment4;

public class DLTest {

	public static void main(String[] args) {
		DList<String> dList = new DList<String>();
		dList.addToLast("A");
		dList.addToLast("B");
		dList.addToLast("C");
		
		System.out.println("tostring:"+dList);
		
	//	dList.print();	
		
		dList.pop();
		System.out.println("toString: " + dList);
		dList.pop();
		System.out.println("toString: " + dList);
		//dList.pop();
		//System.out.println("toString: " + dList);
		
	}

}