package xyz.learncodes;

public class Customer 
{
	private String accNo;
	private String name;
	private int age;
	private double balance;
	private double loanBalance;

	
	public Customer(String accNo, String name, int age) {
		this.accNo = accNo;
		this.name = name;
		this.age = age;
	}
	
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}

}

