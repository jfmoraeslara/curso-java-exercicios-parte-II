package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			Account x = new Account(1020, "Alex", 1000.00);
			Account y = new SavingsAccount(1023, "Maria", 1000.00, 0.01);
			
			x.withdraw(50.0);
			y.withdraw(50.0);
			
			System.out.println(x.getBalance());
			System.out.println(y.getBalance());
			
			sc.close();
		}
	}
