package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface BookDAO
{
    /**
     * @param book      book to add to database
     * @return integer  1 = successful insertion, 0 = insertion failed
     */
    int insertBook(UUID id, Book book);


    /** Randomly generates an id for the specified book that does not have an id
     *
     * @param book    person to generate new id for
     * @return
     */
    default int insertBook(Book book)
    {
        UUID id = UUID.randomUUID();

        // DEBUG
        System.out.println(id);

        return insertBook(id, book);
    }


    /**
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    Optional<Book> selectBookByID(UUID bookId);


    /** Updates the book currently assigned with the given id
     *
     * @param id    id of book to update
     * @param newBook
     * @return integer      1 = successful insertion, 0 = insertion failed
     */
    int updateBookByID(UUID id, Book newBook);


    /**
     * @param bookId    id of book to delete
     * @return          1 = successful deletion, 0 = failed to delete
     */
    int deleteBookByID(UUID bookId);


    /**
     * @return  list of books currently in the database
     */
    List<Book> selectAllBooks();

}
