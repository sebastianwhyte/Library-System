/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;


import dev.sebastian.library_system.dao.BookDataAccessService;
import dev.sebastian.library_system.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public BookService(BookDataAccessService bookDataAccessService)  //(@Qualifier("mysql") BookDataAccessService bookDataAccessService)
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


    public Optional<Book> getBookByID(UUID bookId)
    {
        return bookDataAccessService.selectBookByID(bookId);
    }


    public void updateBookByID(UUID bookId, Book newBook)
    {
        bookDataAccessService.updateBookByID(bookId, newBook);
    }


    public int deleteBook(UUID bookId)
    {
        return bookDataAccessService.deleteBookByID(bookId);
    }

}
