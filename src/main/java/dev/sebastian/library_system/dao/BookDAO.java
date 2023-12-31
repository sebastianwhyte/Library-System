package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface BookDAO
{
    /**
     * @param book      book to add to database
     * @return integer  1 = successful insertion, 0 = insertion failed
     */
    int insertBook(String id, Book book);


    /** Randomly generates an id for the specified book that does not have an id
     *
     * @param book    person to generate new id for
     * @return
     */
    default int insertBook(Book book)
    {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return insertBook(id, book);
    }


    /**
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    Book selectBookByID(String bookId) throws BookNotFoundException;


    /** Replaces a book with the given id with another book
     *
     * @param id    id of the book to replace
     * @param newBook   new book to insert into database
     * @return integer      1 = successful insertion, 0 = insertion failed
     */
    int updateBookByID(String id, Book newBook);


    /**
     * @param bookId    id of book to delete
     * @return          1 = successful deletion, 0 = failed to delete
     */
    int deleteBookByID(String bookId) throws BookNotFoundException;


    /** Finds books with titles that contain the given string
     *
     * @param pattern   pattern to match
     * @return  books with titles matching the given pattern
     */
    List<Book> selectBooksWithTitleLike(String pattern);


    /**
     * @return  list of books currently in the database
     */
    List<Map<String, Object>> selectAllBooks();
    //List<Book> selectAllBooks();

}
