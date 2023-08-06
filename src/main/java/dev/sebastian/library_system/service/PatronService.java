/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.PatronDataAccessService;
import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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


    public int addPatron(Patron patron)
    {
        return patronDataAccessService.insertPatron(patron);
    }


    public List<Patron> getAllPatrons()
    {
        return patronDataAccessService.selectAllPatrons();
    }


    public Optional<Patron> getPatronByID(UUID patronId)
    {
        return patronDataAccessService.selectPatronByID(patronId);
    }


    public void updatePatronByID(UUID patronId, Patron newPatron)
    {
        patronDataAccessService.updatePatronByID(patronId, newPatron);
    }


    public int deletePatron(UUID patronId)
    {
        return patronDataAccessService.deletePatronByID(patronId);
    }
}
