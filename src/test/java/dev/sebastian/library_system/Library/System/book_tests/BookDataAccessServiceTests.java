/** Tests methods in the BookDataAccessService class.
 *
 * @author Sebastian Whyte
 * @date 08/30/2023
 * @version v1.0
 */

package dev.sebastian.library_system.Library.System.book_tests;

import dev.sebastian.library_system.dao.BookDataAccessService;
import dev.sebastian.library_system.exception.BookNotFoundException;
import dev.sebastian.library_system.model.Book;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.jupiter.api.Test;

public class BookDataAccessServiceTests
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

   // @Autowired
    //private BookDataAccessService bookDataAccessService;


    @BeforeEach
    void setUp()
    {

    }


    /*
    @Test
    void givenBookDoesNotExist_404Received()
    {
        // TODO - bookDataAccessService is null. Fix it -SW 08/30/23
        exception.expect(BookNotFoundException.class);
        bookDataAccessService.selectBookByID("12345");
    }
    */

    /*
    @Test
    int test_DeleteBookByID_Success()
    {

    }
     */
}
