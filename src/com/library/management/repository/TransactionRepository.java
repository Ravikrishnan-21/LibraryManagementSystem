package com.library.management.repository;

import java.util.*;
import com.library.management.model.Transaction;

public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
