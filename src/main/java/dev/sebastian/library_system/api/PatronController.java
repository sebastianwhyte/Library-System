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

import dev.sebastian.library_system.model.Patron;
import dev.sebastian.library_system.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/library/v1/patrons")       // API endpoint for patrons
public class PatronController
{
    /** Instance variables **/
    @Autowired
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


    /** Inserts the patron into the database.
     *
     * @param patron
     */
    @PostMapping(path = "/add")
    public void addPatron(@RequestBody Patron patron)
    {
        patronService.addPatron(patron);
    }


    /**
     * @return  list of all patrons currently in the database
     */
    @GetMapping(path = "/all")
    public List<Patron> getAllPatrons()
    {
        return patronService.getAllPatrons();
    }


    /**
     * @param patronId      the patron's id
     * @return              patron with the specified id, if they are currently in database
     */
    @GetMapping(path = "/{patronId}")
    public Patron getPatronByID(@PathVariable("patronId") String patronId)
    {
        return patronService.getPatronByID(patronId);
    }


    @PutMapping(path = "/{patronId}")
    public void updatePatronByID(@PathVariable("patronId") String patronId,
                                 @RequestBody Patron patronToUpdate)
    {
        patronService.updatePatronByID(patronId, patronToUpdate);
    }


    /**
     * @param patronId      the patron's id
     */
    @DeleteMapping(path = "/delete/{patronId}")
    public void deletePatronID(@PathVariable("patronId") String patronId)
    {
        patronService.deletePatron(patronId);
    }
}
