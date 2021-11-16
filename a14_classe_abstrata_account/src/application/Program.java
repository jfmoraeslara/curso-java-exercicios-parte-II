package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.00, 500.00));
		list.add(new SavingsAccount(1003, "Bob", 800.00, 0.01));
		list.add(new BusinessAccount(1004, "Anna", 600.00, 300.00));
		
		double sum = 0.0;
		for (Account acc: list) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f\n", sum);
		
		for (Account acc: list) {
			acc.deposit(10.0);
		}
		for (Account acc: list) {
			System.out.printf("Update balance for account %d: %.2f\n", acc.getNumber(), acc.getBalance());
		}		
		
		sc.close();
	}
}
