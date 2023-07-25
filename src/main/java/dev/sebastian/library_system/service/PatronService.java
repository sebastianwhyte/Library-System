/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.LibraryDAO;
import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatronService
{
    // Instance variables
    private final LibraryDAO libraryDAO;
    // ---------------------------------------------------------------------------------

    @Autowired
    public PatronService(@Qualifier("mysql") LibraryDAO libraryDAO)
    {
        this.libraryDAO = libraryDAO;
    }
    // ---------------------------------------------------------------------------------
    public int addPatron(Patron patron)
    {
        return libraryDAO.addPatron(patron);
    }
    // ---------------------------------------------------------------------------------
    public List<Patron> getAllPatrons()
    {
        return libraryDAO.selectAllPatrons();
    }
    // ---------------------------------------------------------------------------------
    public Optional<Patron> getPatronByID(UUID patronId)
    {
        return libraryDAO.selectPatronByID(patronId);
    }
    // ---------------------------------------------------------------------------------
    public int deletePatron(UUID patronId)
    {
        return libraryDAO.deletePatronByID(patronId);
    }
}
