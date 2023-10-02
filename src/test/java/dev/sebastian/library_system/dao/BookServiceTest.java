package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest
{
    @Autowired
    private BookService bookService;

    // First 2 tests work
    @Test
    void bookInsertionShouldPass()
    {
        // First parameter is the expected value, the second parameter is the actual value
        assertEquals(1, bookService.addBook(new Book("123", "My Book", "Me")));

    }

    @Test
    void bookInsertionShouldFail()
    {
        Book book = new Book();

        assertEquals(0, bookService.addBook(book));
    }


    @Test
    void shouldReturnBookAfterSelectingBookByID() throws BookNotFoundException
    {
        /* Call the insert book method from bookService first
         * Then try to select the book by using its id
         * Should expect successful selection
        */

        Book book = new Book();
        book.setTitle("Crash");
        book.setAuthor("Jerry Spinelli");

        bookService.addBook(book);

        Book selectedBook = bookService.getBookByID(book.getBookId());

        // Check if the book was returned
        assertNotNull(selectedBook);
    }


    @Test
    void shouldThrowExceptionIfBookIsNotFound()
    {

    }

    @Test
    void shouldUpdateOldBookWithNewBookWhenGivenID() throws BookNotFoundException
    {

    }


    @Test
    void deleteBookByID()
    {
    }


    @Test
    void selectBooksWithTitleLike()
    {
    }


    @Test
    void selectAllBooks()
    {
    }

}