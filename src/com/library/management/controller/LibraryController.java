package com.library.management.controller;


import java.util.Scanner;
import com.library.management.service.LibraryService;
import com.library.management.model.Book;
import com.library.management.model.User;

public class LibraryController {

    private LibraryService service;
    private Scanner sc = new Scanner(System.in);

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
        	System.out.println("===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. Search Book");
            System.out.println("7. Exit");
      

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    if (service.addBook(new Book(bid, title, author))) {
                        System.out.println("Book added successfully");
                    } else {
                        System.out.println("Book ID already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    
                    if (service.addUser(new User(uid, name))) {
                        System.out.println("User added successfully");
                    } else {
                        System.out.println("User ID already exists!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    String issueResult = service.issueBook(bookId, userId);
                    System.out.println(issueResult);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    String returnResult = service.returnBook(returnId);
                    System.out.println(returnResult);
                    break;

                case 5:
                    service.displayBooks();
                    break;
                    
                case 6:
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String searchTitle = sc.nextLine();

                    String result = service.searchBook(searchTitle);
                    System.out.println(result);
                    break;


                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

