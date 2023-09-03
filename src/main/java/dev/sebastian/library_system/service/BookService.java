/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;


import dev.sebastian.library_system.dao.BookDataAccessService;
import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BookService
{
    /** Instance variables **/
    private final BookDataAccessService bookDataAccessService;

    // ---------------------------------------------------------------------------------
    /** Constructor
     *
     * @param bookDataAccessService
     */
    @Autowired
    public BookService(BookDataAccessService bookDataAccessService)
    {
        this.bookDataAccessService = bookDataAccessService;

    }

    public int addBook(Book book)
    {
        return bookDataAccessService.insertBook(book);
    }


    public List<Book> getAllBooks()
    {
        return bookDataAccessService.selectAllBooks();
    }


    public Book getBookByID(String bookId) throws BookNotFoundException
    {
        return bookDataAccessService.selectBookByID(bookId);
    }

    public List<Book> getBooksWithTitleLike(String pattern)
    {
        return bookDataAccessService.selectBooksWithTitleLike(pattern);
    }


    public void updateBookByID(String bookId, Book newBook)
    {
        bookDataAccessService.updateBookByID(bookId, newBook);
    }


    public int deleteBook(String bookId) throws BookNotFoundException
    {
        return bookDataAccessService.deleteBookByID(bookId);
    }

}
