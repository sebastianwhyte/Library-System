/** Class that handles HTTP requests (GET, POST, PUT, DELETE / CRUD) for the Patron class.
 *
 * @author Sebastian Whyte
 * @date Jul 23, 2023
 * @version V 1.0
 *
 */

// --- Remember CRUD operations -> CREATE, READ, UPDATE DELETE.
//
//      CREATE --> POST(if we do NOT have id or uuid) / PUT
//      READ ----> GET
//      UPDATE ---> PUT (to replace) or PATCH (to modify)
//      DELETE ---> DELETE
//

package dev.sebastian.library_system.api;

import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.model.Patron;
import dev.sebastian.library_system.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/patrons")       // API endpoint for patrons
public class PatronController
{
    // Instance variable
    private final PatronService patronService;

    // ---------------------------------------------------------------------------------
    /** Constructor
     *
     * @param patronService
     */
    @Autowired
    public PatronController(PatronService patronService)
    {
        this.patronService = patronService;
    }

    // ---------------------------------------------------------------------------------
    /** Inserts the patron into the database.
     *
     * @param patron
     */
    @PostMapping
    public void addPatron(Patron patron)
    {
        patronService.addPatron(patron);
    }
    // ---------------------------------------------------------------------------------
    /** Retrieves all patrons in the database
     *
     * @return  list of all patrons currently in the database
     */
    @GetMapping
    public List<Patron> getAllPatrons()
    {
        return patronService.getAllPatrons();
    }

    // ---------------------------------------------------------------------------------
    /** Retrieves the patron with the given id -- TODO: LOOK UP REPLACING NULL WITH AN EXCEPTION
     *
     * @param patronId      the patron's id
     * @return
     */
    @GetMapping(path = "{patronId}")
    public Patron getPatronByID(@PathVariable("patronId") UUID patronId)
    {
        return patronService.getPatronByID(patronId)
                .orElse(null);
    }
    // ---------------------------------------------------------------------------------
    /** Deletes the patron with the given id
     *
     * @param patronId      the patron's id
     */
    @DeleteMapping(path = "{patronId}")
    public void deletePatronID(@PathVariable("patronId") UUID patronId)
    {
        patronService.deletePatron(patronId);
    }
}
