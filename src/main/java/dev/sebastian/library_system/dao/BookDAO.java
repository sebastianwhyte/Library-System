package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;

import java.util.List;
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
        String id = generateID();

        // DEBUG
        //System.out.println("UUID ->" + uuid);
        //System.out.println("String UUID ->" + id);

        return insertBook(id, book);
    }

    default String generateID()
    {
        UUID uuid = UUID.randomUUID();

        return uuid.toString();
    }


    /**
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    Book selectBookByID(String bookId) throws BookNotFoundException;


    /** Updates the book currently assigned with the given id
     *
     * @param id    id of book to update
     * @param newBook
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
     * @param title
     * @return
     */
    List<Book> selectBooksWithTitleLike(String title);


    /**
     * @return  list of books currently in the database
     */
    List<Book> selectAllBooks();

}
