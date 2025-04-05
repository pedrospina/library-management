package com.devsenior.cdiaz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.devsenior.cdiaz.exception.NotFoundException;
import com.devsenior.cdiaz.model.Book;

public class BookService {
    private static List<Book> books;
    private static BookService instance;

    public BookService() {
        books = new ArrayList<>();
    }

    public static void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookByIsbn(String isbn) throws NotFoundException {
        for (var book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new NotFoundException("No fue encontrado el libro con isbn: "+isbn);
    }

    public void deleteBook(String isbn) throws NotFoundException {
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return;
            }
        }
        throw new NotFoundException("No se puede eliminar el libro con isbn: "+isbn);
    }

    public static BookService getInstancia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstancia'");
    }


  

}
