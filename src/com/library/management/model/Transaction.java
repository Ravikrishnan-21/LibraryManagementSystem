package com.library.management.model;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private Book book;
    private User user;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int id, Book book, User user) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.issueDate = LocalDate.now();
    }

    public int getId() { return id; }
    public Book getBook() { return book; }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        book.setAvailable(true);
    }
}
