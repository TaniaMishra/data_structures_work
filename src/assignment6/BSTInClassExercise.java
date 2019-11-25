package assignment6;

public class BSTInClassExercise {

	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.add("3");
		myTree.add("6");
		myTree.add("1");

		myTree.printAllValuesBF();
		myTree.printLeaves();
	}

}
