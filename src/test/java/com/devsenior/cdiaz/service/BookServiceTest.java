package com.devsenior.cdiaz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devsenior.cdiaz.exception.NotFoundException;

public class BookServiceTest {

    private BookService service;

    @BeforeEach
    void setup() {
        service = new BookService();
    }

    @Test
    void testAddBook() throws NotFoundException {
        // GIVEN - Preparar los datos de la prueba
        var isbn = "123456789";
        var title = "Aprendiendo Java";
        var author = "Cesar Diaz";

        // WHEN - Ejecutar el metodo a probar
        service.addBook(isbn, title, author);

        // THEN - Verificaciones que el metodo se ejecutó bien
        var book = service.getBookByIsbn(isbn);
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void testDeleteExistingBook() throws NotFoundException {
        // GIVEN
        var isbn = "123456789";
        var title = "Aprendiendo Java";
        var author = "Cesar Diaz";
        service.addBook(isbn, title, author);

        // WHEN
        service.deleteBook(isbn);

        // THEN
        try {
            service.getBookByIsbn(isbn);
            fail();
        } catch (NotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    void testDeleteNonExistingBook() {
        // GIVEN
        var isbn = "123456789";

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.deleteBook(isbn);
                });
    }

    @Test
    void testGetAllBooks() {

    }

    @Test
    void testGetBookByIsbn() {

    }
}
