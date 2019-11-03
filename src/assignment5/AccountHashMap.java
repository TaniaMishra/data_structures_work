package assignment5;

import java.util.*;

/**
 * This program demonstrates HashMap
 */

public class AccountHashMap {
	public static void main(String[] args) {
		// HashMap --> stores BankAccount objects.
		Map<String, BankAccount> accountMap = new HashMap<String, BankAccount>();

		// Put mappings into the HashMap --> key = string, account number. value = BankAccount
		accountMap.put("101", new BankAccount(1000));
		accountMap.put("102", new BankAccount(1000));
		accountMap.put("103", new BankAccount(1000));
		
		//Call method to display the accounts with equal balances
		displayAccountsWithEqualBalances(accountMap);
	}
	
	public static void displayAccountsWithEqualBalances(Map<String, BankAccount> accountMap) {
		Set<String> keys = accountMap.keySet();
		Map<String, Double> valueMap = new HashMap<String, Double>();
		for (Map.Entry<String, BankAccount> x : accountMap.entrySet()) {
			valueMap.put(x.getKey(), x.getValue().getBalance());
		}
		ArrayList<Double> balances = new ArrayList<Double>();
		for (Map.Entry<String, Double> x : valueMap.entrySet()) {
			balances.add(x.getValue());
		}
		boolean duplicate = false;
		double tester = balances.remove(0);
		while (balances.size() > 0) {
			if (balances.contains(tester)) {
				duplicate = true;
			}
			if (duplicate == true) {
				ArrayList<String> accountNumbers = new ArrayList<String>();
				for (Map.Entry<String, Double> x : valueMap.entrySet()) {
					if (x.getValue() == tester) {
						accountNumbers.add(x.getKey());
					}
				}
				System.out.print("Account numbers ");
				for (int i = 0; i < accountNumbers.size(); i++) {
					if (i == accountNumbers.size()-1) {
						System.out.print(accountNumbers.get(i) + " ");
					}
					else {
						System.out.print(accountNumbers.get(i) + ", ");
					}
				}
				System.out.print("with equal balance of " + tester + "\n");
				for (int i = balances.size()-1; i >= 0; i--) {
					if (balances.get(i) == tester) {
						balances.remove(i);
					}
				}
			}
			tester = balances.remove(0);
		}
	}
}