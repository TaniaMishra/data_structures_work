package assignment5;

import java.util.*;

/** Class that uses hashmaps to store BankAccounts
 * @author Tania
 */
public class AccountHashMap {
	public static void main(String[] args) {
		// HashMap --> stores BankAccount objects.
		Map<String, BankAccount> accountMap = new HashMap<String, BankAccount>();

		// Put mappings into the HashMap --> key = string, account number. value = BankAccount
		accountMap.put("101", new BankAccount(28147));
		accountMap.put("102", new BankAccount(28147));
		accountMap.put("103", new BankAccount(28147));
		accountMap.put("104", new BankAccount(28147));
		accountMap.put("105", new BankAccount(28147));
		accountMap.put("106", new BankAccount(28147));

		
		//Call method to display the accounts with equal balances
		displayAccountsWithEqualBalances(accountMap);
	}
	
/*Prints out the accounts with equal balances
 * @param hashmap of account numbers (string) and BankAccounts
 * output: prints data to console
 */
	public static void displayAccountsWithEqualBalances(Map<String, BankAccount> accountMap) {
		//get a hashmap with the account value (key) and balance (value)
		Map<String, Double> valueMap = new HashMap<String, Double>();
		for (Map.Entry<String, BankAccount> x : accountMap.entrySet()) {
			valueMap.put(x.getKey(), x.getValue().getBalance());
		}
		//create an array list of the balances
		ArrayList<Double> balances = new ArrayList<Double>();
		for (Map.Entry<String, Double> x : valueMap.entrySet()) {
			balances.add(x.getValue());
		}
		boolean duplicate = false;				//used to check if the balance is a duplicate
		double tester = balances.remove(0);		//start with the first element of the array list and remove that from the array list
		//keep going through until everything is gone from the array list of balances
		while (balances.size() > 0) {
			if (balances.contains(tester)) {		//if the rest of the array list contains the first element that was removed, there is at least one duplicate in the array list
				duplicate = true;
			}
			if (duplicate == true) {
				ArrayList<String> accountNumbers = new ArrayList<String>();		//account numbers of the duplicates
				for (Map.Entry<String, Double> x : valueMap.entrySet()) {
					if (x.getValue() == tester) {				//if the balance is equal to the tester balance, add the key to the account number arrayList
						accountNumbers.add(x.getKey());
					}
				}
				//print out data ("Account numbers #, #, # with equal balance of $")
				System.out.print("Account numbers ");
				for (int i = 0; i < accountNumbers.size(); i++) {
					if (i == accountNumbers.size()-1) {
						System.out.print(accountNumbers.get(i) + " ");
					}
					else {
						System.out.print(accountNumbers.get(i) + ", ");
					}
				}
				System.out.print("with equal balance of $" + tester + "\n");
				//remove all of the duplicates from the balances array list (so that they aren't checked for again)
				for (int i = balances.size()-1; i >= 0; i--) {
					if (balances.get(i) == tester) {
						balances.remove(i);
					}
				}
			}
			//if there are more elements in the array list, remove the first one and set it as the new tester, loop through again
			if (balances.size() > 0) {
				tester = balances.remove(0);
			}
		}
	}
}