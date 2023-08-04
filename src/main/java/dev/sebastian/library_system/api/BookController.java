/** Class that handles HTTP requests (GET, POST, PUT, DELETE / CRUD) for the Book class.
 *
 * @author Sebastian Whyte
 * @date Jul 23, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.api;

import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/books")         // API endpoint for books
public class BookController
{
    // Instance variables
    @Autowired
    private final BookService bookService;

    // ---------------------------------------------------------------------------------
    /** Constructor
     *
     * @param bookService   book service object
     */
    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }



    /** Adds a book to the database. @RequestBody reads the JSON response body.
     *
     * @param book      book to add
     */
    @PostMapping(path = "/add")
    public void addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
    }


    /** Retrieves all books currently in the database.
     *
     * @return      list of all books in the database
     */
    @GetMapping(path = "/all")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }


    /** Returns the book associated with the given ID. If no such book exists, it returns null
     *
     *
     * @param bookId    id of the book to search for
     * @return          the book associated with the given id. If it exists in the
     *                  database. If not, then null
     */
    @GetMapping(path = "/{bookId}")
    public Book getBookByID(@PathVariable("bookId") UUID bookId)
    {
        return bookService.getBookByID(bookId)
                .orElse(null);
    }


    @PutMapping(path = "/{bookId}")
    public void updateBookByID(@PathVariable("bookId") UUID bookId, @RequestBody Book bookToUpdate)
    {
        bookService.updateBookByID(bookId, bookToUpdate);
    }


    /** Deletes the book with the given id
     *
     * @param bookId    id of the book to delete
     */
    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBookByID(@PathVariable("bookId") UUID bookId)
    {
        bookService.deleteBook(bookId);
    }

}
