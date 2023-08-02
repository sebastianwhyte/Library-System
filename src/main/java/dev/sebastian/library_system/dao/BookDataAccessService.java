/** Provides a means of accessing the database's Book Table.
 *
 * @author Sebastian Whyte
 * @date 08/02/2023
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//("mysql")
public class BookDataAccessService implements BookDAO
{
    // Instance variables
    //private static List<Book> bookList = new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();     // Using a set so there are no dupliate books

    // ---------------------------------------------------------------------------------
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
        //bookList.add(new Book(id, book.getTitle(), book.getAuthor()));

        bookList.add(new Book(id, book.getTitle(), book.getAuthor()));

        return 1;
    }



    /**
     * Retrieves a book by using its id
     *
     * @param bookId id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    @Override
    public Optional<Book> selectBookByID(UUID bookId)  // Optional<Book> selectBookByID(UUID bookId)
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
    @Override
    public int updateBookByID(UUID bookId, Book newBook)
    {
        return selectBookByID(bookId)
                .map(book -> {
                    int indexOfBookToUpdate = bookList.indexOf(book);
                    // If the person to delete is in the database, then get the index of the person we want to replace. And return 1 (successful deletion)
                    if (indexOfBookToUpdate >= 0)
                    {
                        // Create a new person and insert them where the old person was
                        bookList.set(indexOfBookToUpdate, new Book(bookId, newBook.getTitle(), newBook.getAuthor()));

                        return 1;
                    }

                    return 0;
                })
                .orElse(0);

    }


    /**
     * Deletes the book with the given id, if it is in the database
     *
     * @param bookId
     * @return
     */
    @Override
    public int deleteBookByID(UUID bookId)
    {
        Optional<Book> book = selectBookByID(bookId);

        // If optional is empty, then we couldn't find the specified book in the database.
        if (book.isEmpty())
        {
            return 0;
        }


        bookList.remove(book);

        return 1;
    }


    private Optional<Book> findBookById(UUID bookId)
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
        return bookList;
    }
}
