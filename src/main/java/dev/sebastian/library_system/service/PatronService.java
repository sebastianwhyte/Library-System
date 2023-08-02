/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.PatronDAO;
import dev.sebastian.library_system.dao.PatronDataAccessService;
import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PatronService
{
    // Instance variables
    private final PatronDataAccessService patronDataAccessService;
    // ---------------------------------------------------------------------------------

    @Autowired
    public PatronService(PatronDataAccessService patronDataAccessService)   //(@Qualifier("mysql") PatronDAO patronDAO)
    {
        this.patronDataAccessService = patronDataAccessService;
    }
    // ---------------------------------------------------------------------------------
    public String addPatron(Patron patron)
    {
        return patronDataAccessService.addPatron(patron);
    }
    // ---------------------------------------------------------------------------------
    public Set<Patron> getAllPatrons()
    {
        return patronDataAccessService.selectAllPatrons();
    }
    // ---------------------------------------------------------------------------------
    public Optional<Patron> getPatronByID(UUID patronId)
    {
        return patronDataAccessService.selectPatronByID(patronId);
    }
    // ---------------------------------------------------------------------------------
    public int deletePatron(UUID patronId)
    {
        return patronDataAccessService.deletePatronByID(patronId);
    }
}
