package com.library.management.service;

import com.library.management.model.*;
import com.library.management.repository.*;

public class LibraryService {

    private BookRepository bookRepo;
    private UserRepository userRepo;
    private TransactionRepository transactionRepo;

    public LibraryService(BookRepository b, UserRepository u, TransactionRepository t) {
        this.bookRepo = b;
        this.userRepo = u;
        this.transactionRepo = t;
    }

 
    	public boolean addBook(Book book) {

    	    if (bookRepo.findById(book.getId()) != null) {
    	        return false;
    	    }

    	    bookRepo.addBook(book);
    	    return true;
    	}
        
    

   
    	public boolean addUser(User user) {

    	    if (userRepo.findById(user.getId()) != null) {
    	        return false;
    	    }

    	    userRepo.addUser(user);
    	    return true;
    	}    

   
    	public String issueBook(int bookId, int userId) {

    	    Book book = bookRepo.findById(bookId);
    	    if (book == null) return "Book not found";

    	    User user = userRepo.findById(userId);
    	    if (user == null) return "User not found";

    	    if (!book.isAvailable()) return "Book already issued";

    	    book.setAvailable(false);

    	    Transaction t = new Transaction(
    	        transactionRepo.getAllTransactions().size() + 1,
    	        book,
    	        user
    	    );

    	    transactionRepo.addTransaction(t);

    	    return "Book issued successfully";
    	}
    

   
    	public String returnBook(int bookId) {

    	    for (Transaction t : transactionRepo.getAllTransactions()) {

    	        if (t.getBook().getId() == bookId && !t.getBook().isAvailable()) {
    	            t.returnBook();
    	            return "Book returned successfully";
    	        }
    	    }

    	    return "Book not issued or not found";
    	}
    

    public void displayBooks() {
        if (bookRepo.getAllBooks().isEmpty()) {
            System.out.println("No books available");
            return;
        }

        System.out.println("\n--- Book List ---");
        System.out.println("ID | Title | Author | Status");
        for (Book b : bookRepo.getAllBooks()) {
            System.out.println(
                b.getId() + " | " +
                b.getTitle() + " | " +
                b.getAuthor() + " | " +
                (b.isAvailable() ? "Available" : "Issued")
            );
        }
    }
    public String searchBook(String title) {

        Book book = bookRepo.findByTitle(title);

        if (book == null) {
            return "Book not found";
        }

        return "Found: " +
                book.getId() + " | " +
                book.getTitle() + " | " +
                book.getAuthor() + " | " +
                (book.isAvailable() ? "Available" : "Issued");
    }
}