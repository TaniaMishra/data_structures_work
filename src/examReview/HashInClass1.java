package examReview;

public class HashInClass1 {
	private Integer[] hashTable;
	
	public HashInClass1() {
		hashTable = new Integer[20];
	}
	
	private int hashFunction(int input) {
		int hashedValue = input % 20;
		return hashedValue;
	}
	
	private void linearProbing(int key, int input) {
		for (int i = key+1; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				hashTable[i] = input;
				return;
			}
		}
	}
	
	public void add(int input) {
		int key = hashFunction(input);
		if (hashTable[key] == null) {
			hashTable[key] = input;
		}
		else {
			linearProbing(key, input);
		}
	}
}
