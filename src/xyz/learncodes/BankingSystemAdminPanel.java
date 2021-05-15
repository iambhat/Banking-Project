package xyz.learncodes;

import java.util.Scanner;

public class BankingSystemAdminPanel {
	public static void main(String[] args) {
		BankingSystem ba = new BankingSystemImpl();
		Scanner scn=new Scanner(System.in);
		System.err.println("********* BANKING MANAGEMENT SYSTEM **********\n");
		while(true) {
			System.out.println("**********************************************");
			System.out.println("01 : CREATE ACCOUNT\n02 : DEPOSIT MONEY\n03 : WITHDRAW MONEY\n04 : UPDATE DETAILS\n05 : DELETE ACCOUNT\n06 : DELETE ACCOUNTS\n07 : DISPLAY ACCOUNT");
			System.out.println("08 : DISPLAY ACCOUNTS\n09 : SORT ACCOUNTS\n10 : COUNT OF CUSTOMERS\n11 : EXIT");
			System.out.println("**********************************************");
			System.out.println("Enter Your Choice : ");
			int choice=scn.nextInt();
			switch(choice) {
			case 1:
				ba.createAccount();
				break;
			case 2:
				ba.deposit();				
				break;
			case 3:
				ba.withdraw();
				break;
			case 4:
				ba.updateAccount();
				break;
			case 5:
				ba.deleteAccount();
				break;
			case 6:
				ba.deleteAccounts();
				break;

			case 7:
				ba.displayAccount();
				break;

			case 8:
				ba.displayAccounts();
				break;

			case 9:
				ba.sortAccounts();
				break;

			case 10:
				ba.noOfAccounts();
				break;

			case 11:
				System.out.println("THANK YOU!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
