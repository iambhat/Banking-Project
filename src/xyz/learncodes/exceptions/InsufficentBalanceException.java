package xyz.learncodes.exceptions;

public class InsufficentBalanceException extends Exception{
	private String msg;

	public InsufficentBalanceException(String msg) {
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}

}
 