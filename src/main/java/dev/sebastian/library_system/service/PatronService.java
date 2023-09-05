/** Contains methods for business logic/operations on Books.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.service;

import dev.sebastian.library_system.dao.PatronDataAccessService;
import dev.sebastian.library_system.exception.PatronNotFoundException;
import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService
{
    /** Instance variables **/
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


    public Patron getPatronByID(String patronId) throws PatronNotFoundException
    {
        return patronDataAccessService.selectPatronByID(patronId);
    }


    public void updatePatronByID(String patronId, Patron newPatron)
    {
        patronDataAccessService.updatePatronByID(patronId, newPatron);
    }


    public int deletePatronByID(String patronId) throws PatronNotFoundException
    {
        return patronDataAccessService.deletePatronByID(patronId);
    }


    public List<Patron> getPatronsWithNameLike(String pattern)
    {
        return patronDataAccessService.selectPatronsWithNameLike(pattern);
    }

}
