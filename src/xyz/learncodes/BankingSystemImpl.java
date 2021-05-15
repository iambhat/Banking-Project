package xyz.learncodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import xyz.learncodes.exceptions.*;
import xyz.learncodes.sort.*;

public class BankingSystemImpl implements BankingSystem {

	HashMap<String,Customer> db = new HashMap<String,Customer>();
	Scanner scan = new Scanner(System.in);
	String bName = "SBI";
	int count = 1;
	@Override
	public void createAccount() {
		System.out.println("Enter Name :");	
		String name = scan.next();
		System.out.println("Enter Age :");
		int age = scan.nextInt();

		if(age>18 && age<=60) {
			Customer cust = new Customer(bName+count,name,age);
			db.put(cust.getAccNo(), cust);
			count++;
			System.err.println("BANK ACCOUNT CREATED\n\n");
		}
		else
			System.err.println("AGE MUST BE BETWEEN 18 AND 60\n\n");
	}

	@Override
	public void updateAccount() {
		System.out.println("Enter the Account Number : ");
		String accNo = scan.nextLine();
		if(db.containsKey(accNo)) {
			Customer cust = db.get(accNo);
			System.out.println("**********************************************");
			System.out.println("1 : UPDATE NAME\n2 : UPDATE AGE\n3 : EXIT");
			System.out.println("**********************************************");
			System.out.println("Enter Your Choice : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Name : ");
				String name = scan.nextLine();
				cust.setName(name);
				break;

			case 2:
				System.out.println("Enter the Age : ");
				int age = scan.nextInt();
				if(age>18 && age<=60)
					cust.setAge(age);
				else
					System.err.println("AGE MUST BE BETWEEN 18 AND 60");
				break;
			default:
				System.err.println("INVALID CHOICE\n\n");
			}
		}
		else
			System.err.println("RECORD NOT FOUND FOR ACCOUNT NUMBER "+accNo+"\n\n");
	}

	@Override
	public void deleteAccount() {
		System.out.println("Enter the Account Number : ");
		String accNo = scan.nextLine();
		if(db.containsKey(accNo)) {
			db.remove(accNo);
			System.err.println("CUSTOMER RECORD DELETED\n\n");
		}
		else 
			System.err.println("CUSTOMER RECORD NOT FOUND\n\n");
	}

	@Override
	public void deleteAccounts() {
		if(db.isEmpty()) {
			System.err.println("CUSTOMER RECORD NOT FOUND\n\n");
		}
		else {
			db.clear();
			System.err.println("ALL DATABASE RECORDS ARE CLEARED\n\n");
		}
	}

	@Override
	public void displayAccount() {
		System.out.println("Enter the Account Number :");
		String accNo = scan.nextLine();
		System.out.println("SELECT ACCOUNT TYPE TO VIEW DETAILS :");
		System.out.println("**********************************************");
		System.out.println("1 : SAVINGS ACCOUNT\n2 : LOAN ACCOUNT\n");
		System.out.println("**********************************************");
		System.out.println("Enter your Choice :");
		int choice = scan.nextInt();

		if(db.containsKey(accNo)) {
			Customer cust = db.get(accNo);
			switch(choice) {
			case 1:
				System.out.println("*********** CUSTOMER DETAIL ***********");
				System.out.println("===================================================");
				System.out.println("ACCOUNT_NUMBER\t\tNAME\tAGE\tBALANCE");
				System.out.println("===================================================");
				System.out.println(cust.getAccNo()+"\t\t\t"+cust.getName()+"\t"+cust.getAge()+"\t"+cust.getBalance());
				System.out.println("\n\n");
				break;
			case 2:
				System.out.println("*********** CUSTOMER DETAIL ***********");
				System.out.println("===================================================");
				System.out.println("ACCOUNT_NUMBER\t\tNAME\tAGE\tBALANCE");
				System.out.println("===================================================");
				System.out.println(cust.getAccNo()+"\t\t\t"+cust.getName()+"\t"+cust.getAge()+"\t"+cust.getLoanBalance());
				System.out.println("\n\n");
				break;
			}
		}
		else {
			System.err.println("NO DATA FOUND...\n\n");
		}
	}

	@Override
	public void displayAccounts() {
		if(db.isEmpty()) {
			System.err.println("NO DATA FOUND...\n\n");
		}
		else {
			Set<String> s = db.keySet();
			Iterator<String> i = s.iterator();
			System.out.println("\t\t*********** CUSTOMER DETAILS ***********");
			System.out.println("====================================================================");
			System.out.println("ACCOUNT_NUMBER\t\tNAME\tAGE\tSAVINGS_BALANCE\tLOAN_BALANCE");
			System.out.println("====================================================================");
			while(i.hasNext()) {
				String accNo = i.next();
				Customer cust = db.get(accNo);
				System.out.println(cust.getAccNo()+"\t\t\t"+cust.getName()+"\t"+cust.getAge()+"\t"+cust.getBalance()+"\t\t"+cust.getLoanBalance());
			}
			System.out.println("\n\n");
		}
	}

	@Override
	public void sortAccounts() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		Set<String> s = db.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext()) {
			String accNo =i.next();
			Customer cust = db.get(accNo);
			al.add(cust);
		}
		System.out.println("Sort Customer Based on :");
		System.out.println("**********************************************");
		System.out.println("1 : ACCOUNT NUMBER\n2 : NAME\n3 : AGE\n");
		System.out.println("**********************************************");
		System.out.println("Enter your Choice :");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(al,new SortCustomerByAccNo());
			System.out.println("********* CUSTOMER DETAILS BASED ON ACCOUNT NUMBER *********");
			System.out.println("==============================================================");
			System.out.println("ACCOUNT_NUMBER\t\tNAME\t\tAGE\tBALANCE");
			System.out.println("==============================================================");
			for(Customer c : al)
				System.out.println(c.getAccNo()+"\t\t\t"+c.getName()+"\t\t"+c.getAge()+"\t"+c.getBalance());
			System.out.println("\n\n");
			break;

		case 2:
			Collections.sort(al,new SortCustomerByName());
			System.out.println("*********** CUSTOMER DETAILS BASED ON NAME ***********");
			System.out.println("==============================================================");
			System.out.println("ACCOUNT_NUMBER\t\tNAME\t\tAGE\tBALANCE");
			System.out.println("==============================================================");
			for(Customer c : al)
				System.out.println(c.getAccNo()+"\t\t\t"+c.getName()+"\t\t"+c.getAge()+"\t"+c.getBalance());
			System.out.println("\n\n");
			break;

		case 3:
			Collections.sort(al,new SortCustomerByAge());
			System.out.println("*********** CUSTOMER DETAILS BASED ON AGE ***********");
			System.out.println("==============================================================");
			System.out.println("ACCOUNT_NUMBER\t\tNAME\t\tAGE\tBALANCE");
			System.out.println("==============================================================");
			for(Customer c : al)
				System.out.println(c.getAccNo()+"\t\t\t"+c.getName()+"\t\t"+c.getAge()+"\t"+c.getBalance());
			System.out.println("\n\n");
			break;

		default:
			System.err.println("INVALID CHOICE\n\n");
		}
	}

	@Override
	public void noOfAccounts() {
		System.out.println("===========================================");
		System.out.println("\tNUMBER OF ACCOUNT HOLDERS :");
		System.out.println("===========================================");
		System.out.println("\t\t"+db.size());
	}

	@Override
	public void deposit() {
		System.out.println("Enter the Account Number :");
		String accNo = scan.next();

		if(db.containsKey(accNo)) {
			System.out.println("SELECT ACCOUNT TYPE TO DEPOSIT :");
			System.out.println("**********************************************");
			System.out.println("1 : SAVINGS ACCOUNT\n2 : LOAN ACCOUNT\n");
			System.out.println("**********************************************");
			System.out.println("Enter your Choice :");
			int choice = scan.nextInt();
			Customer cust = db.get(accNo);
			switch(choice) {
			case 1:
				System.out.println("Enter Amount to be Deposited : ");
				double amount = scan.nextDouble();
				double savingBalance = cust.getBalance();
				savingBalance = savingBalance + amount;
				cust.setBalance(savingBalance);
				System.out.println("===================================================");
				System.out.println("DEPOSITED AMOUNT\t TOTAL BALANCE:");
				System.out.println("===================================================");
				System.out.println(amount+" \t\t\t "+cust.getBalance());
				System.out.println("\n\n");
				break;
			case 2:
				double loanBalance = cust.getLoanBalance();
				if(loanBalance>0) {
					System.out.println("Enter amount to be Deposited : ");
					double loanAmount = scan.nextDouble();
					loanBalance = loanBalance - loanAmount;
					cust.setLoanBalance(loanBalance);;
					System.out.println("===================================================");
					System.out.println("DEPOSITED AMOUNT\t TOTAL BALANCE:");
					System.out.println("===================================================");
					System.out.println(loanAmount+" \t\t\t "+cust.getLoanBalance());
					System.out.println("\n\n");
				}
				else 
					System.err.println("YOUR LOAN IS SETTLED!!!\n\n");
				break;
				
			default:System.err.println("INVALID CHOICE!!!");
			}
		}
		else 
			System.err.println("RECORD NOT FOUND FOR ACCOUNT NUMBER : "+accNo+"\n\n");
	}

	@Override
	public void withdraw() {
		System.out.println("Enter the Account Number :");
		String accNo = scan.next();

		if(db.containsKey(accNo)) {
			System.out.println("SELECT ACCOUNT TYPE TO DEPOSIT :");
			System.out.println("**********************************************");
			System.out.println("1 : SAVINGS ACCOUNT\n2 : LOAN ACCOUNT\n");
			System.out.println("**********************************************");
			System.out.println("Enter your Choice :");
			int choice = scan.nextInt();
			Customer cust = db.get(accNo);
			switch(choice) {
			case 1:
				System.out.println("Enter Amount to be Withdrawn : ");
				double savingAmount = scan.nextDouble();
				double savingBalance = cust.getBalance();
				if(savingAmount<=savingBalance && savingBalance>0) {
					savingBalance = savingBalance - savingAmount;
					cust.setBalance(savingBalance);
					System.out.println("===================================================");
					System.out.println("WITHDRAWN AMOUNT\t TOTAL BALANCE:");
					System.out.println("===================================================");
					System.out.println(savingAmount+" \t\t\t "+cust.getBalance());
					System.out.println("\n\n");
				}
				else {
					try {
						InsufficentBalanceException ibe = new InsufficentBalanceException("YOUR ACCOUNT BALANCE IS Rs."+savingBalance);
						throw ibe;
					}catch (Exception e) {
						System.err.println(e.getMessage());
						System.out.println("\n\n");
					}
				}

				break;
			case 2:
				System.out.println("Enter Amount to be Withdrawn : ");
				double loanAmount = scan.nextDouble();
				double loanBalance = cust.getLoanBalance();
				if(loanAmount<=100000) {
					loanBalance = loanBalance + loanAmount;
					cust.setLoanBalance(loanBalance);
					System.out.println("===================================================");
					System.out.println("WITHDRAWN AMOUNT\t TOTAL BALANCE:");
					System.out.println("===================================================");
					System.out.println(loanAmount+" \t\t\t "+cust.getLoanBalance());
					System.out.println("\n\n");
				}
				else {
					try {
						InsufficentBalanceException ibe = new InsufficentBalanceException("MONEY UPTO Rs.1,00,000 ONLY WITHDRAWN FROM LOAN ACCOUNT!!!");
						throw ibe;
					}catch (Exception e) {
						System.err.println(e.getMessage());
						System.out.println("\n\n");
					}
				}
				break;
				
			default:
				System.err.println("INVALID CHOICE!!!");
			}
		}
		else
			System.err.println("RECORD NOT FOUND FOR ACCOUNT NUMBER : "+accNo+"\n\n");
	}
}
