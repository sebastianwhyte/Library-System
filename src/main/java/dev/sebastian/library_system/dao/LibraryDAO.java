/** Data Access Object that communicates with the database layer.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.model.Patron;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibraryDAO
{
    /** Inserts the given book into the database
     *
     * @param book      book to add to database
     * @return integer  1 = successful insertion, 0 = insertion failed
     */
    int insertBook(Book book);

    // ---------------------------------------------------------------------------------

    /** Returns all books in the database
     *
     * @return  list of books currently in the database
     */
    List<Book> selectAllBooks();

    // ---------------------------------------------------------------------------------
    /** Retrieves a book by using its id
     *
     * @param bookId    id of the desired book
     * @return the book with the given id, if it is in the database.
     */
    Optional<Book> selectBookByID(UUID bookId);

    // ---------------------------------------------------------------------------------
    /** Deletes the book with the given id, if it is in the database
     *
     * @param bookId
     * @return
     */
    int deleteBookByID(UUID bookId);

    // ---------------------------------------------------------------------------------
    /** Inserts a patron into the database
     *
     * @param patron
     * @return
     */
    int addPatron(Patron patron);

    // ---------------------------------------------------------------------------------
    /** Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    List<Patron> selectAllPatrons();

    // ---------------------------------------------------------------------------------
    /** Selects a specific patron by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    Optional<Patron> selectPatronByID(UUID patronId);

    // ---------------------------------------------------------------------------------
    /** Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    int deletePatronByID(UUID patronId);
}
