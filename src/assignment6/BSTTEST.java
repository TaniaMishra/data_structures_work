package assignment6;

import java.util.ArrayList;

public class BSTTEST {
	public static void main(String[] args) {
		//Tree 1:
		BinarySearchTree myTree1 = new BinarySearchTree();
		myTree1.add("3");
		myTree1.add("1");
		myTree1.add("6");
		myTree1.add("2");
		myTree1.add("5");
		myTree1.add("7");

		//Tree 2:
		BinarySearchTree myTree2 = new BinarySearchTree();
		myTree2.add("3");
		myTree2.add("1.5");
		myTree2.add("6");
		myTree2.add("2.3");
		myTree2.add("5.7");
		myTree2.add("7");

		//Tree 3:
		BinarySearchTree myTree3 = new BinarySearchTree();
		myTree3.add("3");
		myTree3.add("1");
		myTree3.add("6");
		myTree3.add("-7");
		myTree3.add("2");
		myTree3.add("5");

		//Tree 4:
		BinarySearchTree myTree4 = new BinarySearchTree();
		myTree4.add("3");
		myTree4.add("2");
		myTree4.add("9");
		myTree4.add("1");
		myTree4.add(".5");
		myTree4.add("-5");
		
		System.out.println("****** Testing printPaths() method ********");
		ArrayList<BSTNode> path = new ArrayList<BSTNode>();
		//tree 1
		System.out.print("All nodes in tree 1 (BF): ");
		myTree1.printAllValuesBF();
		myTree1.printPaths(myTree1.getRoot(), path);
		//tree 2
		System.out.print("All nodes in tree 2 (BF): ");
		myTree2.printAllValuesBF();
		myTree2.printPaths(myTree2.getRoot(), path);
		//tree 3
		System.out.print("All nodes in tree 3 (BF): ");
		myTree3.printAllValuesBF();
		myTree3.printPaths(myTree3.getRoot(), path);
		//tree 4
		System.out.print("All nodes in tree 4 (BF): ");
		myTree4.printAllValuesBF();
		myTree4.printPaths(myTree4.getRoot(), path);
				
		
		System.out.println("****** Testing getSecondLargest() method ********");
		System.out.println("Tree 1: " + myTree1.getSecondLargest().getInfo());
		System.out.println("Tree 2: " + myTree2.getSecondLargest().getInfo());
		System.out.println("Tree 3: " + myTree3.getSecondLargest().getInfo());
		System.out.println("Tree 4: " + myTree4.getSecondLargest().getInfo());

	}

}
