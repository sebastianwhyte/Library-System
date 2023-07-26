/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.LibraryDAO;
import dev.sebastian.library_system.dao.PatronDAO;
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
    private final PatronDAO patronDAO;
    // ---------------------------------------------------------------------------------

    @Autowired
    public PatronService(@Qualifier("mysql") PatronDAO patronDAO)
    {
        this.patronDAO = patronDAO;
    }
    // ---------------------------------------------------------------------------------
    public int addPatron(Patron patron)
    {
        return patronDAO.addPatron(patron);
    }
    // ---------------------------------------------------------------------------------
    public List<Patron> getAllPatrons()
    {
        return patronDAO.selectAllPatrons();
    }
    // ---------------------------------------------------------------------------------
    public Optional<Patron> getPatronByID(UUID patronId)
    {
        return patronDAO.selectPatronByID(patronId);
    }
    // ---------------------------------------------------------------------------------
    public int deletePatron(UUID patronId)
    {
        return patronDAO.deletePatronByID(patronId);
    }
}
