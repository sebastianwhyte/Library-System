/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.LibraryDAO;
import dev.sebastian.library_system.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService
{
    // Instance variables
    private final LibraryDAO libraryDAO;

    // ---------------------------------------------------------------------------------
    /** Constructor
     *
     * @param libraryDAO
     */
    @Autowired
    public BookService(@Qualifier("mysql") LibraryDAO libraryDAO)
    {
        this.libraryDAO = libraryDAO;

    }
    // ---------------------------------------------------------------------------------
    public int addBook(Book book)
    {
        return libraryDAO.insertBook(book);
    }
    // ---------------------------------------------------------------------------------
    public List<Book> getAllBooks()
    {
        return libraryDAO.selectAllBooks();
    }

    // ---------------------------------------------------------------------------------
    public Optional<Book> getBookByID(UUID bookId)
    {
        return libraryDAO.selectBookByID(bookId);
    }

    // ---------------------------------------------------------------------------------
    public int deleteBook(UUID bookId)
    {
        return libraryDAO.deleteBookByID(bookId);
    }
    // ---------------------------------------------------------------------------------


}
