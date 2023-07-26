package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class BookDataAccessService implements BookDAO
{
    /**
     * Inserts the given book into the database
     *
     * @param id
     * @param book book to add to database
     * @return integer  1 = successful insertion, 0 = insertion failed
     */
    @Override
    public int insertBook(UUID id, Book book)
    {
        return 0;
    }

    // ---------------------------------------------------------------------------------
    /**
     * Returns all books in the database
     *
     * @return list of books currently in the database
     */
    @Override
    public List<Book> selectAllBooks()
    {
        return null;
    }

    // ---------------------------------------------------------------------------------
    /**
     * Retrieves a book by using its id
     *
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    @Override
    public Optional<Book> selectBookByID(UUID bookId)
    {
        return Optional.empty();
    }

    // ---------------------------------------------------------------------------------
    /**
     * Deletes the book with the given id, if it is in the database
     *
     * @param bookId
     * @return
     */
    @Override
    public int deleteBookByID(UUID bookId)
    {
        return 0;
    }
}
