package com.library.management.main;


import com.library.management.controller.LibraryController;
import com.library.management.repository.*;
import com.library.management.service.*;



public class Main {
    public static void main(String[] args) {

        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        TransactionRepository transactionRepo = new TransactionRepository();

        LibraryService service = new LibraryService(bookRepo, userRepo, transactionRepo);

        LibraryController controller = new LibraryController(service);

      
        controller.start();
    }

}
