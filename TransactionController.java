package com.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Customer;
import com.demo.model.Transaction;

@RestController
public class TransactionController {

	@GetMapping("/transactionByUser")
	public Customer transactions(@RequestParam(value = "name") String name) {
		Customer customer = new Customer();
		if("andrey".equalsIgnoreCase(name)) {
		List<Transaction> transactions = getData();
		customer.setTransactions(transactions.size());
		customer.setId(12);
		customer.setName("andrey");

		double totalAount = transactions.stream().collect(Collectors.summingDouble(Transaction::getAmount));
		double doubleNumber = totalAount / 100;
		int intPart = (int) doubleNumber;
		int points = intPart * 2;

		double remainder = doubleNumber - intPart;
		if (remainder >= 0.5) {
			points = points + 1;
		}
		customer.setPoints(points);}

		return customer;
	}

	private List<Transaction> getData() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(100);
		transaction.setId("1");
		transactions.add(transaction);
		Transaction transaction1 = new Transaction();
		transaction1.setAmount(150);
		transaction1.setId("2");
		transactions.add(transaction1);
		return transactions;

	}

}
