package assignment6;

public class BSTInClassExercise {

	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.add("3");
		myTree.add("9");
		myTree.add("2");
		myTree.add("1");
		myTree.add(".5");
		myTree.add("-5");

		System.out.print("All nodes in tree (BF): ");
		myTree.printAllValuesBF();

		System.out.println("Left Most: " + myTree.getLeftMostChild().getInfo());
		System.out.println("Right Most: " + myTree.getRightMostChild().getInfo());

		myTree.printLeaves();
	}

}
