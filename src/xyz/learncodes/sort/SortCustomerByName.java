package xyz.learncodes.sort;

import java.util.Comparator;

import xyz.learncodes.Customer;

public class SortCustomerByName implements Comparator<Customer>{

	@Override
	public int compare(Customer a, Customer b) {
		return a.getName().compareTo(b.getName());
	}

}
