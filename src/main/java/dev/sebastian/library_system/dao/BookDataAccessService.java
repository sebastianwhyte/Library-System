/** Provides a means of accessing the database's Book Table.
 *
 * @author Sebastian Whyte
 * @date 08/02/2023
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.mapper.BookMapper;
import dev.sebastian.library_system.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;


@Repository
public class BookDataAccessService implements BookDAO
{
    /** Instance variables **/
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    //Logger logger = Logger.getLogger("BookDataAccessService");

    // ---------------------------------------------------------------------------------

    /** Constructor **/
    @Autowired
    public BookDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Inserts the given book into the database
     *
     * @param id
     * @param book book to add to database
     * @return integer  1 = successful insertion, 0 = insertion failed
     */
    @Override
    public int insertBook(String id, Book book)
    {
        book.setBookId(id);

        String SQL_INSERT_BOOK = "INSERT INTO Book(book_id, title, author, status) VALUES (?,?,?,?)";

        jdbcTemplate.update(SQL_INSERT_BOOK, book.getBookId(), book.getTitle(), book.getAuthor(), book.getStatus());

        return 1;
    }


    /**
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */

    public Book selectBookByID(String bookId) throws BookNotFoundException
    {
        Book selectedBook;

        try
        {
            String SQL_SELECT_BOOK_BY_ID = "SELECT book_id, title, author FROM Book WHERE book_id = ?";

            selectedBook = jdbcTemplate.queryForObject(SQL_SELECT_BOOK_BY_ID, new BookMapper(), bookId);
        }
        catch (EmptyResultDataAccessException exception)
        {
            //logger.("BookDataAccessService :: selectBookByID() : " + exception);
            throw new BookNotFoundException("Book with id: " + bookId + " not found in database!");
        }

        return selectedBook;
    }


    /**
     * Updates the book currently assigned with the given id
     *
     * @param bookId   id of book to update
     * @param newBook
     * @return integer      1 = successful insertion, 0 = insertion failed
     */
    public int updateBookByID(String bookId, Book newBook)
    {
        String SQL_UPDATE_BOOK_BY_ID = "UPDATE Book SET title = ?, author = ? WHERE book_id = ?";

        jdbcTemplate.update(SQL_UPDATE_BOOK_BY_ID, newBook.getTitle(), newBook.getAuthor(), bookId);

        return 1;
    }


    /**
     * @param bookId
     * @return  1 = successful deletion, 0 = failed deletion
     */
    @Override
    public int deleteBookByID(String bookId) throws BookNotFoundException
    {
        Book book = selectBookByID(bookId);

        if (book == null)
        {
            throw new BookNotFoundException("Book with id: " + bookId + " not found in database!");
        }

        String SQL_DELETE_BOOK_BY_ID = "DELETE FROM Book WHERE book_id = ?";

        jdbcTemplate.update(SQL_DELETE_BOOK_BY_ID, bookId);

        return 1;

    }


    /**
     * Finds books with titles that contain the given string
     *
     * @param title
     * @return
     */
    @Override
    public List<Book> selectBooksWithTitleLike(String title)
    {
        // TODO -  create a GetMapping method in BookController and a service method in BookService -SW 08/29/2023
        // TODO - line below gives a syntax error. Fix it -SW 08/29/2023
        String SQL_BOOKS_WITH_TITLES_LIKE = "SELECT book_id, title, author FROM Book WHERE title LIKE = ?";

        return jdbcTemplate.queryForList(SQL_BOOKS_WITH_TITLES_LIKE, Book.class, title);
    }


    /**
     * Returns all books in the database
     *
     * @return list of books currently in the database
     */
    @Override
    public List<Book> selectAllBooks()
    {
        String SQL_SELECT_ALL_BOOKS = "SELECT book_id, title, author FROM Book";

        return jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper());
    }
}
