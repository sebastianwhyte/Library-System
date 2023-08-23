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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;


@Repository//("mysql")
public class BookDataAccessService implements BookDAO
{
    // Instance variables
    private static List<Book> bookList = new ArrayList<>();     // Using a set so there are no dupliate books

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private final String SQL_INSERT_BOOK = "INSERT INTO Book(book_id, title, author, status) VALUES (?,?,?,?)";
    // ---------------------------------------------------------------------------------
    /** Constructor **/
    @Autowired
    public BookDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
        //jdbcTemplate.setDataSource(dataSource);
    }


    /*
    @Autowired
    public BookDataAccessService(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    */


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

        jdbcTemplate.update(SQL_INSERT_BOOK, book.getBookId(), book.getTitle(), book.getAuthor(), book.getStatus());

        return 1;
    }


    /**
     * Retrieves a book by using its id
     *
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    @Override
    public Optional<Book> selectBookByID(String bookId)
    {
        return bookList.stream()
            .filter(book -> book.getBookId().equals(bookId))
            .findFirst();
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
        // Will implement...
        return 1;
    }

    /*
    @Override
    public int updateBookByID(UUID bookId, Book newBook)
    {
        return selectBookByID(bookId)
                .map(currentBook -> {
                    int indexOfBookToUpdate = bookList.indexOf(currentBook);

                    // If the person to delete is in the database, then get the index of the person we want to replace. And return 1 (successful deletion)
                    if (indexOfBookToUpdate >= 0)
                    {
                        // Create a new person and insert them where the old person was
                        //bookList.set(indexOfBookToUpdate, new Book(bookId, newBook.getTitle(), newBook.getAuthor()));

                        return 1;
                    }

                    return 0;
                })
                .orElse(0);
    }
    */

    /**
     * Deletes the book with the given id, if it is in the database
     *
     * @param bookId
     * @return  1 = successful deletion, 0 = failed deletion
     */
    @Override
    public int deleteBookByID(String bookId)
    {
        Optional<Book> book = selectBookByID(bookId);

        // If optional is empty, then we couldn't find the specified book in the database.
        if (book.isEmpty())
        {
            return 0;
        }

        // Otherwise, get the book object and remove it
        bookList.remove(book.get());


        return 1;

    }

    /*
    @Override
    public int deleteBookByID(UUID bookId)
    {
        Optional<Book> book = selectBookByID(bookId);

        // If optional is empty, then we couldn't find the specified book in the database.
        if (book.isEmpty())
        {
            return 0;
        }

        // Otherwise, get the book object and remove it
        bookList.remove(book.get());


        return 1;

    }

     */


    /** Finds book that is assigned the given id
     *
     * @param bookId
     * @return  book with the specified id
     */
    private Optional<Book> findBookById(String bookId)
    {
        return null;
    }


    /**
     * Returns all books in the database
     *
     * @return list of books currently in the database
     */
    @Override
    public List<Book> selectAllBooks()
    {
        String query = "SELECT book_id, title, author FROM Book";

        return jdbcTemplate.query(query, new BookMapper());

    }
}
