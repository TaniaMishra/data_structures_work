package assignment6;

import java.util.ArrayList;

public class BSTTEST {
	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.add("3");
		myTree.add("1");
		myTree.add("6");
		myTree.add("2");
		myTree.add("5");
		myTree.add("7");

		System.out.print("All nodes in tree (BF): ");
		myTree.printAllValuesBF();

		ArrayList<BSTNode> path = new ArrayList<BSTNode>();
		myTree.printPaths(myTree.getRoot(), path);
		
		

	}

}
