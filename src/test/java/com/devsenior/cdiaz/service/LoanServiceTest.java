package com.devsenior.cdiaz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.devsenior.cdiaz.exception.NotFoundException;
import com.devsenior.cdiaz.model.Book;
import com.devsenior.cdiaz.model.LoanState;
import com.devsenior.cdiaz.model.User;

public class LoanServiceTest {
    private BookService bookService;
    private UserService userService;
    private LoanService service;

    @BeforeEach
    void setup() {
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        service = new LoanService(bookService, userService);
    }

    @DisplayName("Agregar un prestamo con usuario y libro existente")
    @Test
    void testAddLoanWithExistingUserAndExistingBook() throws NotFoundException {
        // GIVEN
        var id = "123";
        var isbn = "1234567890";
        var mockUser = new User(id, "Jhon", "jhon@email.com");
        var mockBook = new Book(isbn, "Aprendiendo Java", "Cesar Diaz");

        Mockito.when(userService.getUserById(id)).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(isbn)).thenReturn(mockBook);


        // WHEN
        service.addLoan(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());

        var loan = loans.get(0);
        assertNotNull(loan.getUser());
        assertNotNull(loan.getBook());
        assertEquals(LoanState.STARTED, loan.getState());

    }


    @Test
    void testAddLoanWithExistingUserAndExistingBook2() {

    }

    @Test
    void testReturnBook() {

    }
}
