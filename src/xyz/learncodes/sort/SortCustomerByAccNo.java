package xyz.learncodes.sort;

import java.util.Comparator;

import xyz.learncodes.Customer;

public class SortCustomerByAccNo implements Comparator<Customer>{

	@Override
	public int compare(Customer a, Customer b) {
		return a.getAccNo().compareTo(b.getAccNo());
	}

}
